package MatricaPaket;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Matrica extends MatricaIzuzetak{
  
  public static Scanner sc = new Scanner(System.in);
  public static int a,b,c,d;
  
    public static void display(int [][]mat)
    {
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < d; j++) {
        System.out.print(mat[i][j] + " ");
      }
    System.out.println();
    }
    }
    
      static public int x=1;
  public Matrica()
  {
    
    System.out.println("Unesite dimenzije prve matrice : ");
    a=sc.nextInt();
    b=sc.nextInt();
    System.out.println("Unesite dimenzije druge matrice : ");
    c=sc.nextInt();
    d=sc.nextInt();
      
  }
  
 static public int [][]mat = new int [10][10];
   

  
  public static void MatUnos(int [][]mat)
    {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j]=sc.nextInt();
      }
    System.out.println();
    }
    }
  
   public static int[][] DeklaracijaMat(int a,int b)
  {
    int [][]mat=new int [a][b];
    MatUnos(mat);
    return mat;
  }
  
  public static int [][] matricaSabiranje(int [][]mat1,int [][]mat2){
    int [][]mat = new int [a][b];
    for(int i = 0; i < a ; i++)
    {
      for(int j = 0; j < d ; j++)
      {
        mat[i][j] = mat1[i][j]+mat2[i][j];
      }
    }
    return mat;
  }
  
  public static int [][] matricaOduzimanje(int [][]mat1,int [][]mat2){
    int [][]mat = new int [a][b];
    for(int i = 0; i < a ; i++)
    {
      for(int j = 0; j < d ; j++)
      {
        mat[i][j] = mat1[i][j]-mat2[i][j];
      }
    }
    return mat;
   }
 
  public static int [][] matricaMnozenje(int [][]mat1,int [][]mat2){
    for(int i = 0; i < a ; i++)
    {
      for(int j = 0; j < d ; j++)
      {
        for(int k = 0; k < b ; k++)
      {
        mat[i][j] += mat1[i][k]*mat2[k][j];
      }
      }
    }
    return mat;
  }
  
  public static void matricaSuma(){
    int suma=0;
    for(int i = 0; i < a ; i++)
    {
      for(int j = 0; j < d ; j++)
      {
        suma += mat[i][j];
      }
    }
    System.out.println("Suma svih elemenata matrice je : " + suma);
  }
  
  public static void matricaSort(){
     System.out.println("Zelite li sortirati matricu od :\n1 - najmanjeg do najveceg\n2 - najveceg do najmanjeg ");
     int izbor=sc.nextInt();
     Integer []newarray = new Integer [a*d];
     
     int k=0;
     for(int i = 0; i < a ; i++)
     {
      for(int j = 0; j < d ; j++)
      {
       
        newarray[k]=mat[i][j];
        k++;
      }
     }

     switch(izbor)
     {
       case 1:
        Arrays.sort(newarray);
          System.out.printf("Sortirani elementi : " + Arrays.toString(newarray)+"\n");
        
       break;
       case 2:
         Arrays.sort(newarray, Collections.reverseOrder());
          System.out.printf("Sortirani elementi : " + Arrays.toString(newarray)+"\n");
       break;
     }
  }
  
  public static void matricaTriangle () {
   int [][] newmat= new int [a][d];
   
   for(int i = 0; i < a ; i++)
   {
      for(int j = 0; j < d ; j++)
      {
        newmat[i][j]=mat[i][j];
      }
    
   }
   System.out.printf("Unesite broj za koji zelite uvecati gornje trougaonu matricu : ");
   int broj = sc.nextInt();
   
   for(int i = 0; i < a ; i++)
   {
      for(int j = 0; j < d ; j++)
      {
        if(i>j)
          newmat[i][j]=0;
        else
          newmat[i][j]=mat[i][j]+broj;
      }
    
   }
   display(mat);
   System.out.println("_____________");
   display(newmat);
  }
  
  public static void matricaParni(){
    int suma=0;
    System.out.printf("Parni brojevi su : \n");
    for(int i = 0; i < a ; i++)
   {
      for(int j = 0; j < d ; j++)
      {
        if(mat[i][j]%2==0&&mat[i][j]!=0)
        {
          System.out.println(mat[i][j]);
          suma ++;
        }
      }
   }
    System.out.println("Parnih brojeva ima : " + suma);
  }
  
  public static void matricaNeparni(){
    int suma=0;
    System.out.println("Neparni brojevi su : ");
    for(int i = 0; i < a ; i++)
   {
      for(int j = 0; j < d ; j++)
      {
        if(mat[i][j]%2!=0)
        {
          System.out.println(mat[i][j]);
          suma ++;
        }
      }
   }
    System.out.println("Nepranih brojeva ima : " + suma);
  }
  
  public static void mnoziSlucajnimBrojem(){
    int [][] newmat= new int [a][d];
   
    for(int i = 0; i < a ; i++)
    {
      for(int j = 0; j < d ; j++)
      {
        newmat[i][j]=mat[i][j];
      }
    }    
    Random rand = new Random();
    int n = rand.nextInt(10) + 1;
    System.out.println("Slucajni  broj je : " + n);
    
    System.out.println("Koliko elemenata zelite pomnoziti slucajnim brojem : ");
    int broj = sc.nextInt();  
    int []array=new int [broj];
    
    System.out.println("Unesite elemente koje zelite pomnoziti slucajnim brojem : ");
    
    for(int i = 0; i < broj ; i++)
    {
      array[i] = sc.nextInt();
    }    
    
     for(int i = 0; i < a ; i++)
    {
      for(int j = 0; j < d ; j++)
      {
        for(int k = 0; k < broj ; k++)
        {
          if(newmat[i][j]==array[k])
            newmat[i][j] *= n;
        } 
      }
    }
     
    display(newmat);
  }
  
  public static void matricaKvadrat(){
    int [][] newmat= new int [a][d];
   
    for(int i = 0; i < a ; i++)
    {
      for(int j = 0; j < d ; j++)
      {
        if(mat[i][j]%2==0)
        newmat[i][j]=mat[i][j]*mat[i][j];
        else
        newmat[i][j]=mat[i][j];
      }
    }
    display(newmat);
  }
  
}