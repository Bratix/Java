import java.io.*;
import java.net.*;
import java.util.*;
  
public class Klijent {
 static int sp = 9999;
 
 public static void main(String  []args)throws IOException{
   InetAddress ad = InetAddress.getByName("127.0.0.1");
   Socket s = new Socket (ad, sp);
   Scanner sc = new Scanner(System.in);
     
   PrintWriter out = new PrintWriter ( new BufferedWriter (new OutputStreamWriter(s.getOutputStream())),true);
   BufferedReader in = new BufferedReader (new InputStreamReader (s.getInputStream()));
   
   String posta = "";
   String prijem = "";
   
   prekid:
     for(int i = 0;i<1000 ; i++)
   {
     System.out.println("''AllFiles'' - komanda za ispis svih datoteki na serveru");
     System.out.println("''*ime datoteke*'' - komanda za citanje iz date datoteke");
     System.out.println("''Izlaz'' - Izlaz iz programa");
     System.out.println("''KreirajF'' - Kreiraj datoteku u datoj putanji");
     System.out.println("''KreirajD'' - Kreiraj direktorij");
     System.out.println("''IzmjeniFile'' - izmjeni sadrzaj file-a");
     System.out.println("''ObrisiDF'' - obrisi direktorij ili file\n");
     posta = sc.nextLine();
     out.println(posta);
     
     if(posta.equals("Izlaz"))
          break prekid;
     
     if(posta.equals("AllFiles"))
     {
        prijem = in.readLine();
       System.out.println(prijem);
     }
     
     if(posta.contains(".txt"))
     {
       prijem = in.readLine();
       System.out.println(prijem);
     }
     
     if(posta.equals("KreirajD"))
     {
       prijem = in.readLine();
       System.out.println(prijem);
       posta = sc.nextLine();
       out.println(posta);
     }
     
     if(posta.equals("KreirajF"))
     {
       prijem = in.readLine();
       System.out.println(prijem);
       
       posta = sc.nextLine();
       out.println(posta);
       posta = sc.nextLine();
       out.println(posta);
     }
     
     if(posta.equals("ObrisiDF"))
     {
       prijem = in.readLine();
       System.out.println(prijem);
       posta = sc.nextLine();
       out.println(posta);
       
     }
     
     if(posta.equals("IzmjeniFile"))
     {
       prijem = in.readLine();
       System.out.println(prijem);
       posta = sc.nextLine();
       out.println(posta);
       prijem = in.readLine();
       System.out.println(prijem);
       posta = sc.nextLine();
       out.println(posta);
       
     }
     
  
   }
   
   s.close();
   in.close();
   out.close();
   sc.close();
 }
}