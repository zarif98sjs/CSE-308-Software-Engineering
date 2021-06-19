package demo;

import java.io.*;
import java.net.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;



public class Server {

    static Vector<WorkerThread> track = new Vector<>();
    public static int workerThreadCount = 0;

    public static void main(String argv[]) throws Exception {

//        FileWriter fww = new FileWriter("src/LoggedUser.txt");
//        fww.close();

        ConsoleStream consoleStream = new ConsoleStream();
        Thread t_1 = new Thread(consoleStream);
        t_1.start();


        ServerSocket welcomeSocket = new ServerSocket(6788);
        int id = 1;
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();

            DataInputStream dis = new DataInputStream(connectionSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(connectionSocket.getOutputStream());

            WorkerThread wt = new WorkerThread(connectionSocket, id, dis, dos);
//            ConsoleStream consoleStream = new ConsoleStream(connectionSocket,dis,dos);
            Thread t = new Thread(wt);
//            Thread t2 = new Thread(consoleStream);
            track.add(wt);
            t.start();
//            t2.start();
            workerThreadCount++;
            System.out.println("Client [" + id + "] is now connected. No. of worker threads = " + workerThreadCount);
            id++;
        }
    }
}

class ConsoleStream implements Runnable {

    public void run() {
        while (true) {

            System.out.println("Console Stream");
            Scanner sc = new Scanner(System.in);
            String msg = sc.next();

            System.out.println("You typed : "+msg);

//            try {
//                dos.writeUTF(msg);
//                dos.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }
    }
}




class WorkerThread implements Runnable {
    private Socket connectionSocket;
    private int id = 0;
    private String UserName;
    private boolean isLoggedin;
    private boolean isAdmin;
    final DataInputStream dis;
    final DataOutputStream dos;

    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }

    public boolean isLoggedin() {
        return isLoggedin;
    }

    public void setLoggedin(boolean loggedin) {
        isLoggedin = loggedin;
    }

    public Socket getConnectionSocket() {
        return connectionSocket;
    }

    public void setConnectionSocket(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    public WorkerThread(Socket s, int id, DataInputStream dis, DataOutputStream dos) {
        this.connectionSocket = s;
        this.id = id;
        this.dis = dis;
        this.dos = dos;
        this.isLoggedin = false;
        this.isAdmin = false;
    }

    public void run() {

        while (true) {
            String textFromClient;
            String textFromServer;
            String c_msg=null;
            try {

                textFromClient = dis.readUTF();
                System.out.println("Text from client : "+textFromClient);

                if(textFromClient.equals("goru"))
                {
                    dos.writeUTF("tui GORU");
                    dos.flush();
                }

//                if(textFromClient.equals("Hello"))
//                {
//                    dos.writeUTF("Yolo");
//                }

//                dos.writeUTF("Hello there");
//                dos.flush();

            } catch (Exception e) {
                System.out.println("noooooooooooooo");
            }
        }

    }
}