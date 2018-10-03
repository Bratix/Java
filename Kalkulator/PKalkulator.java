import java.util.*;
public class PKalkulator extends Kalkulator implements inf1{
  PKalkulator(){
    super();
  }
  void unesi(){
    Scanner sc = new Scanner(System.in);
    a = sc.nextDouble();
    b = sc.nextDouble();
  }
  @Override
  double sabiranje(){return 2*a+b;};
  double mnozenje(){return a*b;}
  double dijeljenje() {return a/b;};
  @Override
  public double cos(){return Math.cos(a);}
}