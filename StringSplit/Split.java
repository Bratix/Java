
public class Split
{
  
  
  public static void main(String[] args)
  {
    String s = "Biraj;odgovor;na;pitanje";
    
    String []a = s.split(";");
    
    System.out.println(a[0] + "- " + a[1] + " - " + a[2] + " - " + a[3]);
    
  }
}