package networking;

import observer.User;
import subject.Stock;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class Server {

    HashMap<String, Stock>stocks = null;
    Vector<User>users = new Vector<>();

    Server() throws IOException {

        FileHandler fileHandler = new FileHandler();

        stocks = fileHandler.readFile();

        System.out.println("Stock Details : "+stocks);

        Thread consoleStream = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {

                    System.out.println("Console Stream : ");
                    Scanner sc = new Scanner(System.in);
                    String msg = sc.nextLine();

                    System.out.println("You typed : " + msg);

                    StringTokenizer stringTokenizer = new StringTokenizer(msg, " ");
                    Vector<String> tokens = new Vector<>();

                    while (stringTokenizer.hasMoreTokens()) {
                        tokens.add(stringTokenizer.nextToken());
                    }

                    String stockName = tokens.elementAt(1);
                    String changeAmount = tokens.elementAt(2);
                    String updateText = new String();

                    if (tokens.elementAt(0).equals("I")) {

                        Stock cur = stocks.get(stockName);
                        cur.increasePrice(Float.parseFloat(changeAmount));
                        stocks.put(stockName,cur);

                        updateText = "Price of "+stockName+" increased by "+changeAmount;

                    } else if (tokens.elementAt(0).equals("D")) {

                        Stock cur = stocks.get(stockName);
                        cur.decreasePrice(Float.parseFloat(changeAmount));
                        stocks.put(stockName,cur);

                        updateText = "Price of "+stockName+" decreased by "+changeAmount;

                    } else if (tokens.elementAt(0).equals("C")) {

                        Stock cur = stocks.get(stockName);
                        cur.changeCount(Integer.parseInt(changeAmount));
                        stocks.put(stockName,cur);

                        updateText = "Count of "+stockName+" changed to "+changeAmount;
                    }

                    System.out.println("Updated Stock Details : "+stocks);

                    for(Map.Entry m:stocks.entrySet())
                    {
                        String name = (String) m.getKey();
                        Stock stock = stocks.get(name);

                        if(stock.getName().equals(stockName))
                        {
                            stock.notifyObservers(updateText);
                        }
                    }
                }
            }
        });

        consoleStream.start();

        ServerSocket welcomeSocket = new ServerSocket(6788);
        int id = 0;

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();

            DataInputStream dis = new DataInputStream(connectionSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(connectionSocket.getOutputStream());

            User curUser = new User(id,dis,dos);
            users.add(curUser);

            int finalId = id;
            Thread workerThread = new Thread(new Runnable() {

                @Override
                public void run() {

                    try {
                        dos.writeUTF("Stock Details : "+stocks.toString());
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    while (true) {
                        String textFromClient;
                        try {

                            textFromClient = dis.readUTF();
                            System.out.println("Text from client "+ finalId +" : "+textFromClient);

                            StringTokenizer stringTokenizer = new StringTokenizer(textFromClient," ");
                            Vector<String>tokens = new Vector<>();

                            while (stringTokenizer.hasMoreTokens())
                            {
                                tokens.add(stringTokenizer.nextToken());
                            }

                            if(tokens.elementAt(0).equals("S"))
                            {
                                String stockName = tokens.elementAt(1);
                                dos.writeUTF("Subscribed to " + stockName);
                                dos.flush();

                                for(Map.Entry m:stocks.entrySet())
                                {
                                    String name = (String) m.getKey();
                                    Stock stock = stocks.get(name);

                                    if(stock.getName().equals(stockName))
                                    {
                                        stock.registerObserver(curUser);
                                    }
                                }
                            }
                            else if(tokens.elementAt(0).equals("U"))
                            {
                                String stockName = tokens.elementAt(1);
                                dos.writeUTF("Unsubscribed from " + tokens.elementAt(1));
                                dos.flush();


                                for(Map.Entry m:stocks.entrySet())
                                {
                                    String name = (String) m.getKey();
                                    Stock stock = stocks.get(name);

                                    if(stock.getName().equals(stockName))
                                    {
                                        stock.removeObserver(curUser);
                                    }
                                }
                            }
                            else if(tokens.elementAt(0).equals("N"))
                            {
                                dos.writeUTF(stocks.toString());
                                dos.flush();
                            }
                            else if (tokens.elementAt(0).equals("exit"))
                            {
                                System.out.println("Client "+finalId+" exited");
                                Thread.currentThread().interrupt();//preserve the message

                                for(Map.Entry m:stocks.entrySet())
                                {
                                    String name = (String) m.getKey();
                                    Stock stock = stocks.get(name);
                                    stock.removeObserver(curUser);
                                }
                                return;
                            }


                        } catch (Exception e) {
//                            e.printStackTrace();
                            System.out.println("Client "+finalId+" exited");
                            Thread.currentThread().interrupt();

                            for(Map.Entry m:stocks.entrySet())
                            {
                                String name = (String) m.getKey();
                                Stock stock = stocks.get(name);
                                stock.removeObserver(curUser);
                            }
                            return;
                        }
                    }
                }
            });

            workerThread.start();

            int count = id+1;
            System.out.println("Client [" + id + "] is now connected. No. of worker threads = " + count);
            id++;
        }
    }

    public static void main(String argv[]) throws Exception {

        Server server = new Server();
    }
}