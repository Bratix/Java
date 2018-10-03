import java.io.*;
import java.net.*;

public class DateClient{
  static int SERVER_PORT=9999;
  
  public static void main(String[] args) throws IOException{
    InetAddress addr = InetAddress.getByName("127.0.0.1");
     Socket sock = new Socket (addr, SERVER_PORT);
     
       BufferedReader in =
         new BufferedReader(
             new InputStreamReader(
                 sock.getInputStream()));
       
       PrintWriter out = 
         new PrintWriter(
             new BufferedWriter(
                 new OutputStreamWriter(
                     sock.getOutputStream())),true);
       
       out.println("DATE");
       String response = in.readLine();
       System.out.println("Server date: " + response);
       
       
    in.close();
    out.close();
    sock.close();
  }

}