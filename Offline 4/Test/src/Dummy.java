import java.util.HashMap;
import java.util.StringTokenizer;

public class Dummy {
    public static void main(String[] args) {
//        String s = "P S1 asd asd as das d asd ";
//        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
//
//        while(stringTokenizer.hasMoreTokens())
//        {
//            System.out.println(stringTokenizer.nextToken());
//        }

        HashMap<String,String>map = new HashMap<>();
        map.put("A","1");
        map.put("B","2");
        map.put("C","3");

        System.out.println(map.get("C"));
        System.out.println(map.get("D"));
    }
}
