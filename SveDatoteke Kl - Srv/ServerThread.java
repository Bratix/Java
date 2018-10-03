import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread{
  private Socket s;
  private int num;
  private BufferedReader in;
  private PrintWriter out;
 
  public ServerThread(Socket s, int num) throws Exception{
    this.s = s;
    this.num = num;
    
    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
     
    start();
  }
  
  public void run(){
    String prijem ="";
    String response ="";
    
    first:
    for(int i = 0; i < 1000000 ; i++)
    {
      
    try{
    prijem = in.readLine();
    }
    catch(IOException e){}
    
    if(prijem.equals("Izlaz"))
      break first;
    
    if(prijem.equals("AllFiles"))
    {
      ArrayList <String> fajlovi = new ArrayList <String> ();
      
      File [] datoteke = new File ("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke").listFiles();
      
      for(File fajl : datoteke)
      {
        if(fajl.isFile())
          fajlovi.add("File " +fajl.getName());
        else
          fajlovi.add("Direktorij " +fajl.getName());
      }
      
      response = fajlovi.toString();
      out.println(response);
    }
    
    if(prijem.contains(".txt"))
    {
      String datoteka = "";
      try{
      File f = new File ("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke/" + prijem);
      FileReader ff = new FileReader (f);
      BufferedReader read = new BufferedReader(ff);
      
      String line = "";
      
      
      while(line != null)
      {
        line = read.readLine();
        if(line != null)
          datoteka += line + " ";
      }
      read.close();
      ff.close();
      response = datoteka;
      }
      catch (IOException e){}
      out.println(response);
    }
    
    if(prijem.equals("KreirajD"))
    {
      response = "Pošaljite direktorij koje zelite kreirati";
      out.println(response);
      try{
      prijem = in.readLine();
      }
      catch(IOException e){}
      
      new File ("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke/" + prijem).mkdirs();
      
    }
    
    if(prijem.equals("KreirajF"))
    {
      response = "Pošaljite ime fajla i putanju gdje ga zelite kreirati(ukoliko u pocetnom direktoriju zelite kreirati datoteku samo stisnite enter)";
      String name="";
      String putanja="";
      out.println(response);
      
      try{
      name = in.readLine();
      putanja = in.readLine();
      }
      catch (IOException e){}
      
      File f = new File("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke/"+putanja+name+".txt");
      try{
      f.createNewFile();
      }
      catch (IOException e){}
      }
    
    if(prijem.equals("ObrisiDF"))
    {
      response = "Pošaljite putanju file-a ili direktorija kojeg zelite obrisati";
      out.println(response);
      String putanja="";
      
      try{
      putanja = in.readLine();
      }
      catch (IOException e){}
      
     File f = new File("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke/"+putanja);
     f.delete();
     
    }
    
    if(prijem.equals("IzmjeniFile"))
    {
        response = "Pošaljite putanju file-a kojeg zelite promijeniti";
        out.println(response);
        String putanja = "";
        try{
      putanja = in.readLine();
      }
      catch (IOException e){}
      
      try{
      File f = new File ("D:/Programiranje/Java/SveDatoteke Kl - Srv/datoteke/"+putanja);
      FileWriter ff = new FileWriter(f);
      BufferedWriter writte = new BufferedWriter(ff);
      
      response = "Sta zelite upisati u file?";
        out.println(response);
        
        try{
      putanja = in.readLine();
      }
      catch (IOException e){}
      
      writte.write(putanja);
      writte.newLine();
      
      writte.close();
      ff.close();
      }
       catch (Exception e){}
    }
       
  
  }
  }
  
  
}