import MatricaPaket.*;
public class TestMatrica extends Matrica{
  
  public static void main (String []args){
    
    System.out.println("Da biste radili programom za poèetak odaberite jednu od tri opcije\n1 - Množenje matrica\n2 - Sabiranje matrica\n3 - Oduzimanje matrica");
    int izbor;
    izbor = sc.nextInt();
    int [][]mat1=new int [1][1];
    int [][]mat2=new int [1][1];
    
    x=1;
    switch(izbor)
    {
      case 2:
        do{
    
        try
        {
          Matrica m = new Matrica();
         
          if(a!=c||b!=d)
            throw new MatricaIzuzetak("Nekorektne dimenzije!!");
          x=2;
        }
        catch (MatricaIzuzetak ex)
        {
      System.out.println(ex.getMessage());
        }
      }while(x==1);
      
        System.out.println("Unesite elemente prve matrice:");
        mat1=DeklaracijaMat(a,b);
        System.out.println("Unesite elemente druge matrice:");
        mat2=DeklaracijaMat(c,d);
        
        
        display(mat1);
        System.out.println("_____________");
        
        display(mat2);
        System.out.println("_____________");
        
        mat=matricaSabiranje(mat1,mat2);
        break;
      case 3:
         do{
    
        try
        {
          Matrica m = new Matrica();
          
          if(a!=c||b!=d)
            throw new MatricaIzuzetak("Nekorektne dimenzije!!");
          x=2;
        }
        catch (MatricaIzuzetak ex)
        {
      System.out.println(ex.getMessage());
        }
      }while(x==1);
       
        System.out.println("Unesite elemente prve matrice:");
        mat1=DeklaracijaMat(a,b);
        System.out.println("Unesite elemente druge matrice:");
        mat2=DeklaracijaMat(c,d);
        
         display(mat1);
        System.out.println("_____________");
        
        display(mat2);
        System.out.println("_____________");
        
        mat=matricaOduzimanje(mat1,mat2);
        break;
      case 1:
         do{
    
        try
        {
          Matrica m = new Matrica();
         
          if(b!=c)
            throw new MatricaIzuzetak("Nekorektne dimenzije!!");
          x=2;
        }
        catch (MatricaIzuzetak ex)
        {
      System.out.println(ex.getMessage());
        }
      }while(x==1);
        
       System.out.println("Unesite elemente prve matrice:");
        mat1=DeklaracijaMat(a,b);
        System.out.println("Unesite elemente druge matrice:");
        mat2=DeklaracijaMat(c,d);
        
        for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        System.out.print(mat1[i][j] + " ");
      }
      System.out.println();
        }
        System.out.println("_____________");
        
        for (int i = 0; i < c; i++) {
      for (int j = 0; j < d; j++) {
        System.out.print(mat2[i][j] + " ");
      }
      System.out.println();
        }
        System.out.println("_____________");
        
        mat=matricaMnozenje(mat1,mat2);
        break;
    }
    
    display(mat);
    System.out.println("_____________");
    System.out.println("Da li zelite izvrsiti neku od ostalih opcija nad rezultantnom matricom? (Unesite 'da' ili 'ne')");
    sc.nextLine();
    String s = sc.nextLine();
   
    if(s.equals("da")==true){
      izbor = -1;
      while(izbor!=8)
      {
      System.out.println("Izaberite opciju\n1 - Suma svih elemenata matrice\n2 - Sortiranje elemenata\n3 - Gornjetrougaona sabrana datim brojem\n4 - Parni brojevi u matrici i njihov broj\n5 - Neparni brojevi u matrici i njihov broj\n6 - Mnozenje odreðenih brojeva matrice slucajnim brojem\n7 - Matrica sa kvadratom svih parnih brojeva\n8 - Izlaz");
      izbor=sc.nextInt();
      
        switch(izbor){
      case 1:
        display(mat);
        System.out.println("_____________");
         matricaSuma();
      break;
      
      case 2:
        display(mat);
        System.out.println("_____________");
        matricaSort();
      break;
      
      case 3:
        try{
        if(a==d)
          matricaTriangle();
        else
          throw new MatricaIzuzetak("Za ovu opciju matrica mora biti kvadratna!");
        }
        catch (MatricaIzuzetak ex)
        {
           System.out.println(ex.getMessage());
        }
        
      break;
      
      case 4:
        display(mat);
        System.out.println("_____________");
        matricaParni();
      break;
      
      case 5:
        display(mat);
        matricaNeparni();
      break;
      
      case 6:
        display(mat);
        System.out.println("_____________");
        mnoziSlucajnimBrojem();
      break;
      
      case 7:
        display(mat);
        System.out.println("_____________");
        matricaKvadrat();
      break;
      }
        
    }
      
    }
    
  }
  
}