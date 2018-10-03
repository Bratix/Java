import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServerThread extends Thread{
  
  private Socket sock;
  private BufferedReader in;
  private PrintWriter out;
  private int num;
  
  public DateServerThread(Socket sock, int num){
    this.sock = sock;
    this.num = num;
    try{
      in = new BufferedReader(
               new InputStreamReader(
                   sock.getInputStream()));
      
      out = new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        sock.getOutputStream())),true);
    } catch (Exception ex){
       ex.printStackTrace();
    }
    start();
  }
  public void run(){
    try{
      String request = in.readLine();
      String response ;
      if(request.equals ("DATE"))
        response = new Date().toString();
      else
        response = "Protocol Error...";
      
      out.println(response);
      System.out.println("Poslat odgovor klijentu broj: " + num);
      
      in.close();
      out.close();
      sock.close();
    }catch (IOException e){
      e.printStackTrace();
    }
    
  }
}