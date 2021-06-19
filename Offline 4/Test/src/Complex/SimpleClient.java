import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClient
{
	private static Socket s = null;
	private static BufferedReader br = null;
	private static PrintWriter pr = null;
	
	public static void main(String args[])
	{
		try
		{
			s = new Socket("localhost", 5555);
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pr = new PrintWriter(s.getOutputStream());
		}
		catch(Exception e)
		{
			System.err.println("Problem in connecting with the server. Exiting main.");
			System.exit(1);
		}
		
		Scanner input = new Scanner(System.in);
		String strSend = null, strRecv = null;
		
		try
		{
			strRecv = br.readLine();
			if(strRecv != null)
			{
				System.out.println("Server says: " + strRecv);
			}
			else
			{
				System.err.println("Error in reading from the socket. Exiting main.");
				cleanUp();
				System.exit(0);	
			}
		}
		catch(Exception e)
		{
			System.err.println("Error in reading from the socket. Exiting main.");
			cleanUp();
			System.exit(0);
		}
			
		while(true)
		{
			System.out.print("Enter a string: ");
			try
			{
				strSend = input.nextLine();
			}
			catch(Exception e)
			{
				continue;
			}
			
			pr.println(strSend);
			pr.flush();
			if(strSend.equals("BYE"))
			{
				System.out.println("Client wishes to terminate the connection. Exiting main.");
				break;
			}
			if(strSend.equals("DL"))
			{
				
				try
				{
					strRecv = br.readLine();					//These two lines are used to determine
					int filesize=Integer.parseInt(strRecv);		//the size of the receiving file
					byte[] contents = new byte[10000];
        
					FileOutputStream fos = new FileOutputStream("capture1.jpg");
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					InputStream is = s.getInputStream();
				
					int bytesRead = 0; 
					int total=0;			//how many bytes read
					
					while(total!=filesize)	//loop is continued until received byte=totalfilesize
					{
						bytesRead=is.read(contents);
						total+=bytesRead;
						bos.write(contents, 0, bytesRead); 
					}
					bos.flush(); 
				}
				catch(Exception e)
				{
					System.err.println("Could not transfer file.");
				}
								
			}
			try
			{
				strRecv = br.readLine();
				if(strRecv != null)
				{
					System.out.println("Server says: " + strRecv);
				}
				else
				{
					System.err.println("Error in reading from the socket. Exiting main.");
					break;
				}
			}
			catch(Exception e)
			{
				System.err.println("Error in reading from the socket. Exiting main.");
				break;
			}
			
		}
		
		cleanUp();
	}
	
	private static void cleanUp()
	{
		try
		{
			br.close();
			pr.close();
			s.close();
		}
		catch(Exception e)
		{
		
		}
	}
}
