import java.io.*;
import java.net.*;
import java.util.*;

public class ServerZaVise{
  static int SERVER_PORT = 9999;
  static int num = 0;
  
  
  public static void main (String [] args){
    try{
    ServerSocket ss = new ServerSocket(SERVER_PORT);
    while(true){
      Socket s = ss.accept();
      new ServerThread(s,num++);
    }
    }
    catch(Exception e){}
  }
}