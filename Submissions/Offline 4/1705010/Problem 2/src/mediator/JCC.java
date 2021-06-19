package mediator;

import service.JPDC;
import service.JWSA;
import service.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class JCC implements Mediator{

    HashMap<String, Queue<Service> >hashMap;

    public JCC()
    {
        hashMap = new HashMap<>();
        hashMap.put("JPDC",new LinkedList<>());
        hashMap.put("JRTA",new LinkedList<>());
        hashMap.put("JRTC",new LinkedList<>());
        hashMap.put("JWSA",new LinkedList<>());
    }

    @Override
    public void recieveRequest(Service from,String to) {
        Queue queue = hashMap.get(to);
        queue.add(from);
    }

    @Override
    public Service serveRequest(String from) {

        Queue queue = hashMap.get(from);
        Service now = null;

        if(!queue.isEmpty())
        {
            now = (Service) queue.peek();
            queue.remove();
        }

        return now;
    }
}
