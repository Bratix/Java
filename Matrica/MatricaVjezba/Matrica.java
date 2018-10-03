package MatricaVjezba;
import java.util.*;

import java.io.*;

public class Matrica {
  
  Scanner sc = new Scanner(System.in);
  int a,b;
  int [][]mat = new int [0][0];
  public Matrica(){
    first :for(int i = 0; i < 1000;i++){
        System.out.println("Unesite dimenzije matrice");
        try {
        a = sc.nextInt();
        b = sc.nextInt();
        if(a!=b)
          throw new MatricaIzuzetak();
        
        break first;
        }
        catch(MatricaIzuzetak ex)
        {
          System.out.println("Nekorektne dimenzije pokusajte opet!");
        }
        
    }
    
    int [][]mat1 = new int [a][b];
    System.out.println("Unesite elemente matrice");
      for(int i = 0 ;i < a;i++)
      {
        for(int j=0;j < b;j++)
        {
          mat1[i][j]=sc.nextInt();
        }
      }
      mat = mat1;
  }
  
  public void sortiranje(){
    int []niz = new int [a*b];
    int k=0;
    for(int i = 0 ;i < a;i++)
    {
      for(int j=0;j < b;j++)
      {
        niz[k]=mat[i][j];
        k++;
      }
     }
  Arrays.sort(niz);
  
  System.out.println("Sortiran niz:" + Arrays.toString(niz));
  
  
}
  public void PSB(){
    Random r = new Random();
    int c = r.nextInt(20)+1;
    
    System.out.println("Unesite koliko brojeva zelite pomnoziti slucajnim brojem:" + c);
    int broj = sc.nextInt();
    
    int []niz = new int [broj];
     System.out.println("Unesite brojeve:");
    for(int i = 0;i<broj;i++)
    {
      niz[i]=sc.nextInt();
    }
    
    display(mat);
    int[][] newmat= new int [a][b];
    for(int i = 0 ;i < a;i++)
    {
      for(int j=0;j < b;j++)
      {
        newmat[i][j]=mat[i][j];
      }
    }
    System.out.println("___________");
    for(int i = 0 ;i < a;i++)
    {
      for(int j=0;j < b;j++)
      {
        for(int k =0 ; k<broj;k++)
        {
          if(mat[i][j]==niz[k])
            newmat[i][j] *= c;
       
        }
        
      }
      System.out.println("\n");
    }
    
    display(newmat);
    
    
  }
  
  
  public  void display (int [][]mat){
    for(int i = 0 ;i < a;i++)
    {
      for(int j=0;j < b;j++)
      {
        System.out.print(mat[i][j]+ " " );
      }
      System.out.println();
    }
  }
}
