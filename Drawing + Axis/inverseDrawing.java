import java.util.*;
public class inverseDrawing{
    
    static Scanner userInput = new Scanner(System.in);//scanner
    
     public static void main(String []args)
      {
        int oy=-2; 
        int ox=0; 
        //oy and ox - a wax of drawing rows
        //replacement of *number[0]
     int m=15;   
     //minimum y,x dimension
        int[] number = new int[3]; 
        // 3 integer inputs - space isolates each one of them
        System.out.println("Introduce side, y and x");
        for(int n = 0; n < number.length; n++)  
         // asks for input until there are 3 integers
         {
            number [n] = userInput.nextInt();
         } 
        if (number[0]>15)
         {
            m=number[0]+1;
         } 
        if (number[1]+number[0]>m)
          {
       m=number[1]+number[0]+1;
          }
  
        if (number[2]+number[0]>m)
          {
          m=number[2]+number[0]+1;
          }
        
        for (int y=-1; y<m-1; y++)
         { 
         
         if (y==-1)
          { 
          System.out.println();
          System.out.print("+");
          
          for (int b=0; b<m; b++)
           {
           
           System.out.print("- ");
           }
          System.out.print(">");
          }
         System.out.println();
            
         for (int x=-1; x<m-1; x++)    
          // drawing the canvas
          { 
          
          if (y==m-2 && x==-1)
          {
          System.out.print("V");
          }
             
             if (y-1==number[1]+oy && x==number[2])
                  {
                  for (int i=0; i<number[0]; i++)  
                   // drawing the square
                   {
                   System.out.print("#");
                   }
                  if (oy<number[0] && ox<number[0]-1){
                   oy++; 
                   ox++;
                         }
                } else if (x==-1 && y<m-2)
                  {
                     System.out.print("|");
                } else 
                 {
                  System.out.print(" ");
                 }
                 
          }
                
         }
        }  
    } 
     
