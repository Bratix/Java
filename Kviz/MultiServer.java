import java.io.*;
import java.util.*;
import java.net.*;

public class MultiServer extends Thread{

  Socket s;
  BufferedReader in;
  PrintWriter out;
  
  public MultiServer(Socket s){
   this.s=s;
    try{
       in = new BufferedReader(new InputStreamReader(s.getInputStream()));
       out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
    }
    catch(IOException e){};
    
    start();
  }
  
  public void run(){
    String ime = "";
    String prijem = "";
    int tacni = 0;
    
    
    
    try{
    File f = new File("pitanja.txt");
    FileReader ff = new FileReader (f);
    BufferedReader citaj = new BufferedReader (ff);
    String line= "";
    
    ime = in.readLine();
    System.out.println(ime);
    
      first:
    while(line != null)
    {
      line = citaj.readLine();
      if(line==null)
      {
         out.println(ime +" je tacno odgovorio " + tacni + " pitanja.");
         break first;
      }
     
      
      String []pitanje = line.split(";");
      
      out.println(line);
      
      prijem = in.readLine();
      
      
      
      if(prijem.equals(pitanje[4]))
      {
        
        out.println("Tacan odgovor!");
        tacni++;
      }
      else
      {
       
        out.println("Netacan odgovor! Tacan odgovor je: " + pitanje[4]);
      }
      
    }
    
    
    
    
    in.close();
    out.close();
    s.close();
    }
    catch(Exception e){}
    
    
    
  }
  
}