import java.net.*;
import java.io.*;

public class MultiThreadMain{
  static int ServerPort = 9999;
  
  public static void main(String []args) throws IOException{
    ServerSocket ss = new ServerSocket (ServerPort);
    while(true)
    {
      Socket s = ss.accept();
      new MultiThread(s);
    }
    
  
  }
}