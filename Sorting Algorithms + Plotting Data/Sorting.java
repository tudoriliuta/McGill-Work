public class Sorting {

  //Max size for the test arrays
  static int N_MAX = 100;
  
  
  public static int bubbleCount=0;
  public static int combCount=0;
  public static int cocktailCount=0;
  
  public static void main(String[] args)
  {
    long start = System.nanoTime();
    // Individual algorithms can be tested by removing the comment signs below
    //plotBubbleSortTest(N_MAX);
    //plotCombSortTest(N_MAX);
    //plotCocktailSortTest(N_MAX);
    plotAll();
    
    efficiencyTest(bubbleCount,combCount,cocktailCount);
    System.out.println(bubbleCount);
    System.out.println(combCount);
    System.out.println(cocktailCount);
    long finish = System.nanoTime();
    System.out.println("Runtime: "+(finish - start)/1000000+"ms"); 
  }
  
 public static int compare(String s1, String s2) {
    s1=s1.toLowerCase();
    s2=s2.toLowerCase();
    if (s1.length()<s2.length())
    {
      return -1;
    } 
    else if (s1.length()>s2.length())
    { 
      return 1;
    } 
    else 
    {
     for (int i=0; i<s1.length(); i++)
     {
      if (s1.charAt(i)>s2.charAt(i))
      {
        return 1;
      } 
      else if (s1.charAt(i)<s2.charAt(i)) 
      {
        return -1;
      }
     }
    }
    return 0 ;
  }
  
  // Method - bubble sort 
  public static int bubbleSort(String[] a) {
    int n=a.length;
    Boolean swapped=true;
    while (swapped)
    {
      swapped=false;
      for (int i=1; i<n; i++)
      {
        if (compare(a[i-1],a[i])>0)
        {
          String intermezo=a[i];
          a[i]=a[i-1];
          a[i-1]=intermezo;
          swapped=true;
          bubbleCount++;
        }
      }
    }
    return bubbleCount;
  }
  
  // Method comb sort
  public static int combSort(String[] a) {
    int gap=a.length;
    int shrink=2;
    Boolean swapped=true;
    while (swapped || gap!=1)
    {
      gap=gap/shrink;
      if (gap<1)
      {
        gap=1;
      }
      int i=0; 
      swapped=false;
      while ((gap+i)<a.length)
      {
        if (Sorting.compare(a[i],a[i+gap])>0)
        {
          String intermo=a[i];
          a[i]=a[i+gap];
          a[i+gap]=intermo;
          swapped=true;
          combCount++;
        }
        i++;
      }
    }
    return combCount;
  }
  
  // Method cocktail sort
  public static int cocktailSort(String[] a) {
    int left=0;
    int right=a.length;
    Boolean swapped=true;
    while (left<right || swapped)
    {
      swapped=false;
      for (int mid=left; mid<right-1; mid++)
      {
        if (compare(a[mid],a[mid+1])>0)
        {
          String intermo=a[mid];
          a[mid]=a[mid+1];
          a[mid+1]=intermo;
          swapped=true;
          cocktailCount++;
        }
      }
      right--;
      if (swapped)
      {
        swapped=false;
        for (int mid=right; mid>left; mid--)
        {
          if (compare(a[mid],a[mid-1])<0)
          {
            String in=a[mid];
            a[mid]=a[mid-1];
            a[mid-1]=in;
            swapped=true;
            cocktailCount++;
          }
        }
      }
      left++;
    }  
    return cocktailCount;
  }
  
  // Testing the efficiency of the the three algorithms
  
  public static void efficiencyTest(int a,int b, int c){
    int theOne=Math.min(Math.min(a, b), c);
    if (theOne == a)
    {
      System.out.println("Bubble sort is more efficient");
    } 
    if (theOne == b)
    {
      System.out.println("Comb sort is more efficient");
    } 
   if (theOne == c) 
    {
      System.out.println("Cocktail is more efficient");
    } 
  }
  

  public static void plotBubbleSortTest(int N_MAX) {

    int[] bubble_sort_results = new int[N_MAX];
    
    for (int i = 1; i < N_MAX; i++) {
      String[] test_array = ArrayUtilities.getRandomNamesArray(i);
      bubble_sort_results[i] = bubbleSort(test_array);
    }
    
    // create a plot window
    // The argument passed to  PlotWindow is the title of the window
    PlotWindow pw = new PlotWindow("Bubble Sort!");
    
    // add a plot to the window using our results array
   
    pw.addPlot("BubbleSort", bubble_sort_results);
  }
  
  public static void plotCombSortTest(int N_MAX) {
    // the results array
    int[] comb_sort_results = new int[N_MAX];

    for (int i = 1; i < N_MAX; i++) {
      String[] test_array = ArrayUtilities.getRandomNamesArray(i);
      comb_sort_results[i] = combSort(test_array);
    }
    // create a plot window
    PlotWindow pw = new PlotWindow("Comb Sort!");
  
    pw.addPlot("CombSort", comb_sort_results);
  }   
  
  public static void plotCocktailSortTest(int N_MAX) {
    int[] cocktail_sort_results = new int[N_MAX];


    for (int i = 1; i < N_MAX; i++) {
      String[] test_array = ArrayUtilities.getRandomNamesArray(i);
      cocktail_sort_results[i] = cocktailSort(test_array);
    }
    // create a plot window
    PlotWindow pw = new PlotWindow("Cocktail Sort!");
    // add a plot to the window using our results array
    pw.addPlot("CocktailSort", cocktail_sort_results);
  }   
  
  public static void plotAll() {
    String[] test_array;
    int[] bubble_sort_results = new int[N_MAX];
    int[] comb_sort_results = new int[N_MAX];
    int[] cocktail_sort_results = new int[N_MAX];
    

    for (int i = 1; i < N_MAX; i++) {
      test_array = ArrayUtilities.getRandomNamesArray(i);
      bubble_sort_results[i] = bubbleSort(test_array);
      
      test_array = ArrayUtilities.getRandomNamesArray(i);
      comb_sort_results[i] = combSort(test_array);
      
      test_array = ArrayUtilities.getRandomNamesArray(i);
      cocktail_sort_results[i] = cocktailSort(test_array);
    }
    
    // create a plot window
    PlotWindow pw = new PlotWindow("All Sorts!");
    
    // add a plot to the window using all results array
    pw.addPlot("BubbleSort", bubble_sort_results);
    pw.addPlot("CombSort", comb_sort_results);
    pw.addPlot("CocktailSort", cocktail_sort_results);
  }   
  
  
  
  
}
