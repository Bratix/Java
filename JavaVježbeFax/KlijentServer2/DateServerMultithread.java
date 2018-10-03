import java.net.*;
public class DateServerMultithread{
  static int SERVER_PORT = 9999;
  static int count = 0;
  
  
  public static void main(String[] args){
    try{
      ServerSocket ss = new ServerSocket (SERVER_PORT);
      System.out.println("Server osluskuje na portu " + SERVER_PORT);
      while(true){
        Socket sock = ss.accept();
        System.out.println("Prihvacen klijent broj " + ++count);
        new DateServerThread(sock,count);
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  
  }

}