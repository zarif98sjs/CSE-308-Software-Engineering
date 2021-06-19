import java.io.*;
import java.net.*;


public class TestServer
{
	public static int workerThreadCount = 0;
	
	public static void main(String args[])
	{
		int id = 1;
		
		try
		{
			ServerSocket ss = new ServerSocket(5555);
			System.out.println("Server has been started successfully.");
			
			while(true)
			{
				Socket s = ss.accept();		//TCP Connection
				WorkerThread wt = new WorkerThread(s, id);
				Thread t = new Thread(wt);
				t.start();
				workerThreadCount++;
				System.out.println("Client [" + id + "] is now connected. No. of worker threads = " + workerThreadCount);
				id++;
			}
		}
		catch(Exception e)
		{
			System.err.println("Problem in ServerSocket operation. Exiting main.");
		}
	}
}

class WorkerThread implements Runnable
{
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	private int id = 0;
	
	public WorkerThread(Socket s, int id)
	{
		this.socket = s;
		
		try
		{
			this.is = this.socket.getInputStream();
			this.os = this.socket.getOutputStream();
		}
		catch(Exception e)
		{
			System.err.println("Sorry. Cannot manage client [" + id + "] properly.");
		}
		
		this.id = id;
	}
	
	public void run()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
		PrintWriter pr = new PrintWriter(this.os);
		
		pr.println("Your id is: " + this.id);
		pr.flush();
		
		String str;
		
		while(true)
		{
			try
			{
				if( (str = br.readLine()) != null )
				{
					if(str.equals("BYE"))
					{
						System.out.println("[" + id + "] says: BYE. Worker thread will terminate now.");
						break; // terminate the loop; it will terminate the thread also
					}
					else if(str.equals("DL"))
					{
						try
						{
							File file = new File("capture.jpg");
							FileInputStream fis = new FileInputStream(file);
							BufferedInputStream bis = new BufferedInputStream(fis);
							OutputStream os = socket.getOutputStream();
							byte[] contents;
							long fileLength = file.length();
							pr.println(String.valueOf(fileLength));		//These two lines are used
							pr.flush();									//to send the file size in bytes.
							
							long current = 0;
							 
							while(current!=fileLength){ 
								int size = 10000;
								if(fileLength - current >= size)
									current += size;    
								else{ 
									size = (int)(fileLength - current); 
									current = fileLength;
								} 
								contents = new byte[size]; 
								bis.read(contents, 0, size); 
								os.write(contents);
								//System.out.println("Sending file ... "+(current*100)/fileLength+"% complete!");
							}   
							os.flush(); 
							System.out.println("File sent successfully!");
						}
						catch(Exception e)
						{
							System.err.println("Could not transfer file.");
						}
						pr.println("Downloaded.");
						pr.flush();

					}
					else
					{
						System.out.println("[" + id + "] says: " + str);
						pr.println("Got it. You sent \"" + str + "\"");
						pr.flush();
					}
				}
				else
				{
					System.out.println("[" + id + "] terminated connection. Worker thread will terminate now.");
					break;
				}
			}
			catch(Exception e)
			{
				System.err.println("Problem in communicating with the client [" + id + "]. Terminating worker thread.");
				break;
			}
		}
		
		try
		{
			this.is.close();
			this.os.close();
			this.socket.close();
		}
		catch(Exception e)
		{
		
		}
		
		TestServer.workerThreadCount--;
		System.out.println("Client [" + id + "] is now terminating. No. of worker threads = " 
				+ TestServer.workerThreadCount);
	}
}
