import java.net.*;
import java.io.*;

public class MultiThread extends Thread{
 private Socket s;
 private PrintWriter out;
 private BufferedReader in;
 
 public MultiThread(Socket s) {
   this.s = s;
   try{
   out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
   in = new BufferedReader( new InputStreamReader(s.getInputStream()));
   }
   catch(Exception e){}
   start();
 }
 
 public void run (){
   String prijem ="";
   try{
    prijem = in.readLine();
   }
   catch (IOException e){System.out.println("eeeee");}
   
   System.out.println(prijem);
   out.println("Uspjesno ispisana poruka!");
   try{
   in.close();
   out.close();
   s.close();
   }
   catch (Exception e){}
   
 }
 
}