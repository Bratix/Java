import java.util.*;
public class Test{
  public static void main(String []args){
    PKalkulator p = new PKalkulator();
    p.unesi();
    System.out.println("Zbir:" + p.sabiranje());
    System.out.println("Razlika:"+p.oduzimanje());
    System.out.println("Kosinus prvog:"+p.cos());
  }
}