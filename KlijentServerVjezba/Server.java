import java.io.*;
import java.net.*;
import java.util.Date;

public class Server{
static int ServerPort = 9999;

public static void main(String []args) throws IOException{
  ServerSocket ss = new ServerSocket (ServerPort);
     
  Socket s = ss.accept();
  
  System.out.println("Prihvacen klijent");
  
  BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
  PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);

 String komanda = in.readLine();
 String odg;
 
 if(komanda.equals("Amar"))
   odg = "Dobar";
 else
   odg = "Nije Dobar";
 
 out.println(odg);
 
 out.close();
 in.close();
 s.close();
 ss.close();
}
  


}