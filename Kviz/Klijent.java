import java.io.*;
import java.util.*;
import java.net.*;

public class Klijent{
   static int ServerPort = 9999;
   static Scanner sc = new Scanner (System.in);
   
  public static void main(String []args) throws IOException{
    
     InetAddress adr = InetAddress.getByName("127.0.0.1");
     
     Socket s = new Socket(adr,ServerPort);
     
     BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
     PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
     
     String odg = "";
     String prijem = "";
     System.out.println("Kviz! Unesite svoje ime: ");
     odg = sc.nextLine();
     out.println(odg);
     int i = 0;
    
     
    first:
     while(true)
    {
      
      
      prijem = in.readLine();
      
      String pitaj = "";
      if(prijem.contains(";"))
      {
      String []pitanje = prijem.split(";");
      pitaj=pitanje[0]+"\n"+pitanje[1]+"\n"+pitanje[2]+"\n"+pitanje[3]+"\n";
      }
      else
      {
       System.out.println(prijem);
       break first;
      }
       
      
      System.out.println(pitaj);
      odg = sc.nextLine();
      out.println(odg);
      
      prijem = in.readLine();
      System.out.println(prijem);
      
    }
     
     
  }
}