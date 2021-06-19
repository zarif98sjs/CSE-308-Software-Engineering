import java.net.*;

public class Lookup {
	public static void main(String args[]) throws UnknownHostException {
				String hostname = "cse.buet.ac.bd";
				InetAddress a = InetAddress.getByName(hostname);
				System.out.println(hostname + ":" + a.getHostAddress()); 
			}
}