package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private File file = null;

    private Socket clientSocket=null;
    private DataInputStream dis=null;
    private DataOutputStream dos=null;

    public Client() throws IOException {

        try{
            clientSocket = new Socket("localhost", 6788);
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());
        }catch(Exception e){
            System.out.println("Problem in connecting server, Exiting Main");
            System.exit(1);
        }

        Thread listenFromServer = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true)
                {
                    try {
                        String modif = dis.readUTF();
                        System.out.println("From Server => " + modif);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread consoleStream = new Thread(new Runnable() {

            public void run() {
                while (true) {

                    System.out.println("Console Stream : ");
                    Scanner sc = new Scanner(System.in);
                    String msg = sc.nextLine();

                    try {
                        dos.writeUTF(msg);
                        dos.flush();

                        if(msg.equals("exit"))
                        {
                            System.exit(1);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });


        listenFromServer.start();
        consoleStream.start();
    }

    public static void main(String args[]) throws IOException {

        Client client = new Client();
    }
}