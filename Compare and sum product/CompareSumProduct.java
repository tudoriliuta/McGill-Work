import java.util.Random;

public class CompareSumProduct{
  public static void main(String[] args){
    //int number=10000;
    //System.out.print("Array a: ");
    int[] a=new int[10000];
      for (int i=0;i<a.length;i++){
      Random ran1=new Random();
      int random1=ran1.nextInt(10000);
      //System.out.print(random1+" ");
      a[i]=random1;
    }
    //System.out.println();
    //System.out.print("Array b: ");
    int[] b=new int[10000];
    for (int i=0;i<a.length;i++){
      Random ran2=new Random();
      int random2=ran2.nextInt(4568);
      //System.out.print(random2+" ");
      b[i]=random2;
    }
    System.out.println(generate(a,b));
  }
    
  public static int generate(int[] x,int[] y){ 
    System.out.println();
    int count=0;
    int sum=0;
    //System.out.println(x.length);
    for (int j=0; j<x.length;j++){
      for (int m=0; m<x.length;m++){
        if (x[j]==y[m]){
          count++;
        }

        if (m==x.length-1){
          sum+=count*x[j];
          count=0;
       }
     }
   }
    return sum;
  }
}