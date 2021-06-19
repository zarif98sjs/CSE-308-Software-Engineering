package observer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class User implements Observer {

    int id;
    private DataInputStream dis;
    private DataOutputStream dos;

    public User(int id,DataInputStream dis, DataOutputStream dos){
        this.id = id;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void update(String text) throws IOException {
        dos.writeUTF(text);
        dos.flush();
    }
}
