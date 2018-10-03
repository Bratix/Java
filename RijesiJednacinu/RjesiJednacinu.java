import java.util.*;

class RijesiJednacinu{
  public static void main(String []args){
   while(true)
    {
    Scanner in = new Scanner(System.in);
    String jednacina = in.nextLine();
    
    ArrayList <Integer> var = new ArrayList <Integer>();
    ArrayList <Integer> slcl = new ArrayList <Integer>();
    
    int size = jednacina.length();
    int IndexJednako = jednacina.indexOf("=");
    char [] jednacinaniz = jednacina.toCharArray();
    
    for(int i = 0;i < size;i++)
    {
      
      String broj = "";
      first:
      while(Character.isDigit(jednacinaniz[i]))
      {
        broj += jednacinaniz[i];
        if(i==size-1)
          break first;
        i++;
        
      }
      
      if(broj != "")
      {
       
         StringBuilder brojj = new StringBuilder(broj);
        if(i-broj.length()!=0)
        {
          if(jednacinaniz[i-broj.length()-1]=='-')
            brojj.insert(0,"-");
          if(i==size-1&&jednacinaniz[i-broj.length()]=='-')
            brojj.insert(0,"-");
        }
        
          if(jednacinaniz[i]=='x' && i-brojj.length() <  IndexJednako)
          var.add(Integer.parseInt(brojj.toString()));
            
          if(jednacinaniz[i]=='x' && i-brojj.length() >  IndexJednako)
          {
            int br = Integer.parseInt(brojj.toString());
            
            if(br>0)
              var.add(br-2*br);
            if(br<0)
              var.add(Math.abs(br));
          }
          
          if(jednacinaniz[i]!='x' && i-brojj.length()  < IndexJednako)
            slcl.add(Integer.parseInt(brojj.toString()));
          
          if(jednacinaniz[i]!='x' && i-brojj.length() +1 > IndexJednako)
          {
            int br = Integer.parseInt(brojj.toString());
            
            if(br>0)
              slcl.add(br-2*br);
            if(br<0)
              slcl.add(Math.abs(br));
          }
          
        }
      
      }
    
    int xx=0,sc=0;
    System.out.println(var.size() + " " + slcl.size());
    for(int i = 0;i<var.size();i++)
    {xx+=var.get(i);}
      
    for(int i = 0;i<slcl.size();i++)
    {sc+=slcl.get(i);}
      
    
    int rez = 0;
    
    if(sc<0)
      rez = Math.abs(sc)/xx;
    else
      rez = (sc-2*sc)/xx;
    
    System.out.println(rez);
      
    }
  }
  }
