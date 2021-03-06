import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServer{
  static int SERVER_PORT=9999;
  
  public static void main(String[] args) throws IOException{
    ServerSocket ss = new ServerSocket(SERVER_PORT);
    System.out.println("Server osluskuje na portu" + SERVER_PORT);
    for(int i=0;i<5;i++)
    {
      Socket sc = ss.accept();
      System.out.println("Klijent prihvacen...");
        BufferedReader in =
          new BufferedReader(
            new InputStreamReader(
                sc.getInputStream()));
     
        PrintWriter out=
          new PrintWriter(
              new BufferedWriter(
                  new OutputStreamWriter(
                      sc.getOutputStream())),true);
        
        String request = in.readLine();
        String response;
        
        if(request.equals("DATE"))
          response = new Date().toString();
        else
          response = "Protocol Error...";
        
        out.println(response);
    
    in.close();
    out.close();
    sc.close();
    }
  ss.close();
  }

}