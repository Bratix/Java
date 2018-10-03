import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
  static int sp = 9999;
  
  public static void main (String []args) throws Exception{
    ServerSocket ss = new ServerSocket(sp);
    Socket s = ss.accept();
    PrintWriter out = new PrintWriter ( new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
    BufferedReader in = new BufferedReader ( new InputStreamReader(s.getInputStream()));
      
    out.println("Server ceka na komandu");
    
    System.out.println("Server primio klijenta");
    
    ArrayList <String> fajlovi = new ArrayList<String>();
    File [] files = new File("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke").listFiles();
    
    for(File file : files)
    {
      if(file.isFile())
        fajlovi.add(file.getName());
    }
    
    
    prekid:
    for(int i = 0;i < 100000000; i++)
    {
      String command = in.readLine();
      String response ="";
      
      if(command.equals("AllFiles"))
      {
        response = fajlovi.toString();   
      }
      
      if(command.contains(".txt"))
      {
        File f = new File ("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke/" + command);
        FileReader ff = new FileReader (f);
        BufferedReader read = new BufferedReader(ff);
        
        String line = "";
        String datoteka = "";
        
        while(line!= null)
        {
          line = read.readLine();
          if(line != null)
          datoteka += line + " ";
        }
        
        read.close();
        ff.close();
        
       response = datoteka;
      }
      
      out.println(response);
         
      if( command.equals("Izlaz"))
        break prekid;
      
    }
    
    ss.close();
    s.close();
    in.close();
    out.close();
  }
}