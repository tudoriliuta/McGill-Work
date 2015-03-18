import java.util.*;

public class Experimentation{
  
   static Scanner userInput = new Scanner(System.in);
  
    public static void main(String[] args){
    boolean valid=false;
    
    
    
    
    
    int x=addNumbers(30,92);
    System.out.println(addNumbers(30,92));
    
    while (!valid){
      System.out.println("Enter a string:");              
      String insert=userInput.nextLine();
      valid=true;
      
      if (insert.length()>25){
            System.out.println("This program has not been optimized for high numbers. Please keep it short!");
            insert=userInput.nextLine();
          }
      
      for (int i=0; i<insert.length(); i++){
        char atNumber = insert.charAt(i);
        boolean isNumber = (atNumber == '0' || atNumber == '1');
        
        if (!isNumber){
          System.out.println("Please introduce a binary number!");
          valid=false;
        } 
      }
      int product=1;
      int sum=0;
      for (int j=0; j<insert.length(); j++){
        char number=insert.charAt(j);
        if (j==insert.length() && number=='1'){
          sum+=1;
          System.out.println("It had a 1");
        }
        
        if (number=='1'){
          product=1;
          for (int m=j; m<insert.length()-1; m++){
            product *= 2;
          }
          
          sum+=product;
        
        
       
          
        }
      }
      System.out.println("The inserted binary is: "+sum+" in base 10");
    } 
        
  }
    
    public static int addNumbers(int a, int b){
      int c=a+b;
      return c;
    }
}