import java.util.*;
public class Proizvodjaci implements Comparator <Auto>{
  public int compare(Auto a, Auto b){return a.prv.compareTo(b.prv);}
}