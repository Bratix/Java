import java.util.*;
import java.io.*;
public class Test{
  public static void main (String []args)
  {
    Automobili a= new Automobili();
    a.unosulistu();
    a.ispisliste();
    System.out.println("_____________________________");
    Collections.sort(a.Auta,new Proizvodjaci());
    a.ispisliste();
    System.out.println("_____________________________");
//    a.DodajAuto();
    Collections.sort(a.Auta,new IDKomparator());
    a.ispisliste();
    a.unosudatoteku();
  }
}