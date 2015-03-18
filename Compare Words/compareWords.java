import java.util.Scanner;
public class compareWords{
  static Scanner userInput=new Scanner(System.in);
  public static void main (String[] args){
    final long start = System.currentTimeMillis();
    System.out.println("Please introduce the first string.");
    String a=userInput.nextLine();
    System.out.println("Please introduce the second string.");
    String b=userInput.nextLine();
    int g = (compare(a.toLowerCase(),b.toLowerCase()));
    print(g,a,b);
    final long finish = System.currentTimeMillis();
    System.out.println("Runtime: " + (double)(finish - start)/100000 );
  }

    public static int compare(String s1,String s2){
    
      int a=-1;
      int b=1;
      int c=0;
    
    if (s1.length()<s2.length())
    {
        return b;
    }
      else if (s2.length()<s1.length())
      {
        return a;
      }
      else for (int i=0; i<s1.length(); i++)
    {
        if (s1.charAt(i)<s2.charAt(i))
        {
          return b;
        } 
        else if (s1.charAt(i)>s2.charAt(i))
        {
          return a;
        }
      }
      return c;
    }
    
    public static void print(int a, String x, String y)
    {
      if (a==1)
      {
        System.out.println(x+" is smaller than "+y);
      } 
      else if (a==-1)
      {
        System.out.println(x+" is bigger than "+y);
      }
      else 
      {
        System.out.println(x+" is as big as "+y);
      }
    }
}
