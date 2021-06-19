package demo;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client {

    public static String UserName;
    private String textToServer;
    private String file_name;
    private long file_size;
    private File file = null;

    private Socket clientSocket=null;
    private DataInputStream dis=null;
    private DataOutputStream dos=null;


    String[] check_ara = new String[10];

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
//                    try {
//                        dos.writeUTF("Hello");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                    try {
                        String modif = dis.readUTF();
                        System.out.println("From Server " + modif);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread ConsoleStream = new Thread(new Runnable() {

            public void run() {
                while (true) {

                    System.out.println("Console Stream");
                    Scanner sc = new Scanner(System.in);
                    String msg = sc.next();

                    try {
                        dos.writeUTF(msg);
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });


        listenFromServer.start();
        ConsoleStream.start();
    }

    public static void main(String args[]) throws IOException {

        Client client = new Client();
    }
}