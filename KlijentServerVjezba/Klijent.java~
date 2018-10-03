import java.io.*;
import java.net.*;

public class Klijent{
  static int ServerPort = 9999;
  
  public static void main (String []args) throws IOException{
    InetAddress adr = InetAddress.getByName("127.0.0.1");
      Socket s = new Socket ( adr, ServerPort);
    
    BufferedReader in = (new BufferedReader(new InputStreamReader(s.getInputStream())));
    PrintWriter out = new PrintWriter((new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))),true);  
    
    out.println("Amar");
    String odg = in.readLine();
    System.out.println("Odgovor servera: "+odg);
    
    out.close();
    in.close();
    s.close();
      
  }
  
}