import java.util.*;
import java.io.*;
import java.text.*;
public class Automobili extends Auto{
  Automobili(){super();}
  ArrayList <Auto> Auta = new ArrayList <Auto>();
  Scanner sc = new Scanner(System.in);
  public void unosulistu(){
    try{
    File c = new File ("auta.txt");
    FileReader f = new FileReader (c);
    BufferedReader b = new BufferedReader(f);
    String linija = "0";
    
    while(linija!=null)
    {
      Auto o = new Auto();
      linija = b.readLine();
      o.id = Integer.parseInt(linija);
      linija = b.readLine();
      o.prv = linija;
      linija = b.readLine();
      o.marka = linija;
      linija = b.readLine();
      o.kategorija = linija;
      
        Auta.add(o);
    }
    b.close();
    f.close();
    }
    
    
    catch (FileNotFoundException ex)
    {
      System.out.println(ex.getMessage());
      
    }
    catch (Exception ex)
    {
    }
   
  }
  public void unosudatoteku(){
 
    try{
    File ff = new File ("auta.txt");
    FileWriter piss = new FileWriter (ff,false);
    BufferedWriter pissi = new BufferedWriter(piss);
  
    int i = 0;
    int size = Auta.size();
   
    while(i<size)
    {
      pissi.write(Integer.toString(Auta.get(i).id));
      
      pissi.newLine();
      pissi.write(Auta.get(i).prv);
       pissi.newLine();
      pissi.write(Auta.get(i).marka);
       pissi.newLine();
      pissi.write(Auta.get(i).kategorija);
      pissi.newLine();
      
      i++;
     
    }
    pissi.close();
    piss.close();
    
    }
    catch (FileNotFoundException ex)
    {}
    catch (IOException ex){}
   
  }
    
  void DodajAuto(){
    System.out.println("Dodaj novo auto:");
    String b,c,d;
    int a;
    a = sc.nextInt();
    sc.nextLine();
    b= sc.nextLine();
    c= sc.nextLine();
    d= sc.nextLine();
    Auto o = new Auto(a,b,c,d);
    Auta.add(o);
      
  }
  
  void ispisliste(){
  for(int i = 0 ; i<Auta.size();i++)
    System.out.println(Auta.get(i).toString());
  }
  
  
}