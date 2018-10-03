import java.util.*;

class RandomSifra{
  public static void main(String []args){
    ArrayList <Character> znakovi = new ArrayList <Character>();
   for(char q = ' '; q <= '~';q++)
     znakovi.add(q);
   
   Random r = new Random();
   int size = znakovi.size();
   String sifra = "";
   
    first:
   while(true)
   {
      boolean flag0 = false, flag1 = false, flag2 = false;
   
   for(int i = 0 ; i < 8; i++)
     sifra += znakovi.get(r.nextInt(size));
   
   System.out.println(sifra);
    
   
   if(sifra.matches(".*[0-9].*"))
     flag0 = true;
   if(sifra.matches(".*[a-zA-Z].*"))
     flag1 = true;
   if(sifra.matches(".*[^a-zA-Z0-9].*"))
     flag2 = true;  
   
   if(flag1==true&&flag0==true&&flag2==true)
     break first;
   else
      sifra = "";
   
   }
  
   int a,b;
   Scanner in = new Scanner(System.in);
   
    
    
    String odg = "ne";
    
    first:
    while(true)
    {
      System.out.println("Da li ste zadovoljni sifrom:");
      odg = in.nextLine();
      if(odg.equals("ne")!=true)
        break first;
      
     
      
       System.out.println("S kojim dijelom sifre niste zadovoljni!");
       a = in.nextInt();
       b = in.nextInt();
      
       System.out.println("Sta zelite izmjeniti:\n1 - Brojeve\n2 - Slova\n3 - Specijalne znakove");
      int izbor = in.nextInt();
       String garbage = in.nextLine();
      char [] siifra = sifra.toCharArray();
      
      switch(izbor)
      {
        case 1:
          
          for(int i = a-1 ; i < b ; i++)
          {
             if(Character.isDigit(siifra[i]))
             {
               char q = ' ';
               while(Character.isDigit(q)==false)
               {
                 q = znakovi.get(r.nextInt(size));
               }
              siifra[i]=q;
             }
           }
          sifra = String.valueOf(siifra);
          System.out.println(sifra);
        break;
        
        case 2:
          
          for(int i = a-1 ; i < b ; i++)
          {
             if(Character.isLetter(siifra[i]))
             {
               char q = ' ';
               while(Character.isLetter(q)==false)
               {
                 q = znakovi.get(r.nextInt(size));
               }
              siifra[i]=q;
             }
           }
          sifra = String.valueOf(siifra);
          System.out.println(sifra);
        break;
        
        case 3:
          
          for(int i = a-1 ; i < b ; i++)
          {
             if(Character.isLetter(siifra[i])==false&&Character.isDigit(siifra[i])==false)
             {
               char q = '1';
               while(Character.isLetter(q)==true||Character.isDigit(q)==true)
               {
                 q = znakovi.get(r.nextInt(size));
               }
              siifra[i]=q;
             }
           }
          sifra = String.valueOf(siifra);
          System.out.println(sifra);
          
        break;
      }
    }
  }
}
