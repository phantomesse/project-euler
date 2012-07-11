import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class projectEuler
{
  private static Scanner in = new Scanner(System.in);
  private static boolean isValid = false;
  private static String instr = "";
  
  public static void main(String[] args)
  {
    System.out.println("PROJECT EULER");
  }
  
  public static void prob1()
  {
    System.out.println("Problem 1: Find the sum of all the multiples of 3 or 5 below n.");
    int n = getInt();
    int sum = 0;
    for (int i = 0; i < n; i+=3)
      if (i%5 != 0)
        sum += i;
    for (int i = 0; i < n; i+=5)
      if (i%3 != 0)
        sum += i;
    for (int i = 0; i < n; i+=15)
      sum += i;
    System.out.println("Sum of all multiples of 3 or 5 below " + n + ": " + sum);
  }
  
  public static void prob2()
  {
    System.out.println("Problem 2: Find the sum of the first n even-valued terms.");
    long n = getLong();
    long index=2, curr=0, sum=0;
    while (curr < n)
    {
      curr = prob2_helper(index);
      if (curr < n && curr%2 == 0)
        sum += curr;
      index++;
    }
    System.out.println("Sum of first " + n + " even-valued terms: " + sum);
  }
  
  private static long prob2_helper(long n)
  {
    if (n<=1) return n;
    return prob2_helper(n-1) + prob2_helper(n-2);
  }
  
  public static void prob3()
  {
    System.out.println("Problem 3: Find largest prime factor of n.");
    long n = getLong();
    long num = n;
    ArrayList<Long> factors = new ArrayList<Long>();
    for (long i = 2; i < n; i++)
    {
      while (n > 0 && n%i==0)
      {
        n = n/i;
        if (!factors.contains(i))
          factors.add(i);
      }
    }
    System.out.println("Largest prime factor of " + num + ": " + n);
  }
  
  public static void prob4()
  {
    System.out.println("Problem 4: Find largest palindrome made from product of two 3-digit numbers.");
    int largest = 0;
    for (long i = 999; i > 99; i--)
    {
      for (long j = i; j > 99; j--)
      {
        boolean isPal = true;
        String n = i*j + "";
        for (int k = 0; k < n.length()/2; k++)
        {
          if (n.charAt(k) != n.charAt(n.length()-1-k))
          {
            isPal = false;
            break;
          }
        }
        if (isPal && Integer.parseInt(n) > largest)
          largest = Integer.parseInt(n);
      }
    }
    System.out.println("Largest palindrome made from product of two 3-digit numbers: " + largest);
  }
  
  public static void prob5()
  {
    System.out.println("Problem 5: Smallest number divisible by all numbers from 1 to n");
    int n = getInt();
    ArrayList<Integer> primes = new ArrayList<Integer>();
    ArrayList<Integer> num_primes = new ArrayList<Integer>();
    for (int i = 2; i <= n; i++)
    {
      int num = i;
      for (int j = 2; j <= i; j++)
      {
        int count = 0;
        while (num%j==0)
        {
          count++;
          num = num/j;
        }
        if (count > 0)
        {
          if (!primes.contains(j))
          {
            primes.add(j);
            num_primes.add(count);
          }
          else if (num_primes.get(primes.indexOf(j)) < count)
              num_primes.set(primes.indexOf(j), count);
        }
      }
    }
    int sum = 1;
    for (int i = 0; i < primes.size(); i++)
      sum *= Math.pow(primes.get(i), num_primes.get(i));
    System.out.println("Smallest number divisible by all from 1 to " + n + ": " + sum);
  }
  
  public static void prob6()
  {
    System.out.println("Problem 6: Find the difference between the sum of squares of first n numbers and the square of the sum.");
    int n = getInt();
    int sumsquares = 0, squaresums = 0;
    for (int i = 1; i <= n; i++)
    {
      sumsquares += i*i;
      squaresums += i;
    }
    squaresums = squaresums*squaresums;
    System.out.println("Sum of squares: " + sumsquares);
    System.out.println("Square of sums: " + squaresums);
    System.out.println("Difference in first " + n + " numbers: " + (squaresums - sumsquares));
  }
  
  public static void prob7()
  {
    System.out.println("Problem 7: Find nth prime number");
    int n = getInt();
    int count = 0;
    long index = 2;
    while (count < n)
    {
      boolean isPrime = true;
      for (int i = 2; i < index; i++)
        if (index%i==0)
          isPrime = false;
      if (isPrime)
      {
        count++;
      }
      index++;
    }
    index--;
    System.out.println("The " + n + "th prime number: " + index);
  }
  
  public static void prob8()
  {
    System.out.println("Problem 8: Find largest product of 5 consecutive digits.");
    String digit = "";
    try
    {
      Scanner fileReader = new Scanner(new File("projectEuler_prob8.txt"));
      while (fileReader.hasNext())
        digit += fileReader.next();
    }
    catch (Exception e) { }
    
    int largest = 0;
    for (int i = 0; i < digit.length()-5; i++)
    {
      String temp = digit.substring(i,i+5);
      if (temp.indexOf("0") == -1)
      {
        int product = 1;
        for (int j = 0; j < temp.length(); j++)
          product *= Integer.parseInt(temp.substring(j,j+1));
        if (product > largest)
          largest = product;
      }
    }
    System.out.println("Largest Product: " + largest);
  }
  
  public static void prob9()
  {
    System.out.println("Problem 9: Find the product abc in a Pythagorean triplet where a+b+c=1000");
    for (int b = 1; b < 1000; b++)
    {
      for (int a = 1; a < b; a++)
      {
        if (Math.pow(1000-b-a,2) == a*a + b*b)
        {
          int c = (int)Math.sqrt(a*a+b*b);
          System.out.println("a = " + a);
          System.out.println("b = " + b);
          System.out.println("c = " + c);
          System.out.println("a + b + c = " + (a+b+c));
          System.out.println("abc = " + a*b*c);
        }
      }
    }
  }
  
  public static void prob10()
  {
    System.out.println("Problem 10: Find the sum of all the primes below n");
    int n = getInt();
    int[] primes = new int[n];
    primes[0] = 0;
    primes[1] = 0;
    for (int i = 2; i < primes.length; i++)
      primes[i] = 1;
    for (int i = 2; i*i < n; i++)
      for (int j = i*i; j < n; j+=i)
        primes[j] = 0;
    
    long sum = 0;
    for (int i = 0; i < primes.length; i++)
    {
      if (primes[i] == 1)
      {
        System.out.print(i + " ");
        sum += i;
      }
    }
    System.out.println("\nSum of primes below " + n + ": " + sum);
  }
  
  public static void prob11()
  {
    System.out.println("Problem 11: Find greatest product of four adjacent numbers in any direction");
    int[][] grid = new int[20][20];
    
    try
    {
      Scanner fileReader = new Scanner(new File("projectEuler_prob11.txt"));
      int index = 0;
      while (fileReader.hasNextLine())
      {
        String line = fileReader.nextLine();
        String[] temp = line.split(" ");
        for (int i = 0; i < temp.length; i++)
          grid[index][i] = Integer.parseInt(temp[i]);
        index++;
      }
    }
    catch (Exception e) { }
    
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
        System.out.print(grid[i][j] + " ");
      System.out.println();
    }
    
    int largest = 0;
    
    // Horizontal
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length-3; j++)
      {
        int product = 1;
        for (int k = 0; k < 4; k++)
          product *= grid[i][j+k];
        if (product > largest)
          largest = product;
      }
    }
    
    // Vertical
    for (int i = 0; i < grid.length-3; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        int product = 1;
        for (int k = 0; k < 4; k++)
          product *= grid[i+k][j];
        if (product > largest)
          largest = product;
      }
    }
    
    // Diagonal Right
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        int k = 0, product = 1;
        while (k < 4 && i+k < grid.length && j+k < grid[i].length)
        {
          product *= grid[i+k][j+k];
          k++;
        }
        if (k == 4 && product > largest)
          largest = product;
      }
    }
    
    // Diagonal Left
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        int k = 0, product = 1;
        while (k < 4 && i+k < grid.length && j-k >= 0)
        {
          product *= grid[i+k][j-k];
          k++;
        }
        if (k == 4 && product > largest)
          largest = product;
      }
    }
    System.out.println("Largest Product of 4 Adjacent Numbers: " + largest);
  }
  
  public static void prob12()
  {
    System.out.println("Problem 12: Find value of the first triangle number to have over five hundred divisors");
    int i = 1, numDivisors = 0;
    while (numDivisors < 500)
    {
      long tri = i*(i+1)/2;
      numDivisors = 0;
      for (int j = 1; j <= Math.sqrt(tri); j++)
      {
        if (tri%j==0)
        {
        	if (j == Math.sqrt(tri))
        		numDivisors++;
        	else
        		numDivisors+=2;
        }
      }
      System.out.println("Triangle: " + tri + "\tDivisors: " + numDivisors);
      i++;
    }
  }
  
  public static void prob13()
  {
	  System.out.println("Problem 13: Find first 10 digits of sum of one-hundred 50-digit numbers");
	  ArrayList<BigInteger> nums = new ArrayList<BigInteger>();
	  try
	  {
	    Scanner fileReader = new Scanner(new File("projectEuler_prob13.txt"));
	    while (fileReader.hasNextLine())
	      nums.add(new BigInteger(fileReader.nextLine()));
	  }
	  catch (Exception e) { e.printStackTrace(); }
	  
	  BigInteger sum = new BigInteger("1");
	  for (int i = 0; i < nums.size(); i++)
	    sum = sum.add(nums.get(i));
	  System.out.println("Sum: " + sum.toString().substring(0,10));
  }
  
  public static void prob14()
  {
    System.out.println("Problem 14: Find starting number < 1,000,000 that produces longest chain");
    int seed = 2, chainLength = 0, longestSeed = 0, longest = 0;
    while (seed < 1000000)
    {
      long n = seed;
      chainLength = 0;
      while ( n > 0)
      {
        chainLength++;
        if (n == 1) break;
        if (n%2 == 0) n = n/2;
        else n = 3*n + 1;
      }
      if (chainLength > longest)
      {
        System.out.println("\nSeed: " + seed + "\nChain Length: " + chainLength);
        longest = chainLength;
        longestSeed = seed;
      }
      seed++;
    }
    System.out.println("\nSeed: " + longestSeed);
    System.out.println("Longest Chain: " + longest);
  }
  
  public static void prob15()
  {
    System.out.println("Problem 15: Find routes through a n x n grid");
    int dim = getInt();
    BigInteger numerator = new BigInteger("1"), denominator = new BigInteger("1");
    for (int i = 1; i <= dim+dim; i++)
      numerator = numerator.multiply(new BigInteger(i + ""));
    System.out.println(numerator);
    for (int i = 1; i <= dim; i++)
      denominator = denominator.multiply(new BigInteger(i + ""));
    System.out.println(denominator.multiply(denominator));
    BigInteger paths = numerator.divide(denominator.multiply(denominator));
    System.out.println("Routes: " + paths);
  }

  public static void prob16()
  {
    System.out.println("Problem 16: Sum of the digits of the 2^n");
    int exp = getInt();
    BigInteger n = new BigInteger("2");
    n = n.pow(exp);
    long sum = 0;
    String num = n.toString();
    for (int i = 0; i < num.length(); i++)
      sum += Integer.parseInt(num.substring(i,i+1));
    System.out.println("Sum: " + sum);
  }
  
  public static void prob17()
  {
    System.out.println("Problem 17: Number of letters in word forms of 1-1000");
    String[] onesPlace = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    String[] tensPlace = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
    String[] teensPlace = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    
    int totalLength = 0;
    for (int n = 1; n <= 1000; n++)
    {
      String word = "";
      if (n == 1000) word = "onethousand";
      else if (n < 10) word = onesPlace[n];
      else if (n%10 == 0 && n < 100) word = tensPlace[n/10];
      else if (n < 20) word = teensPlace[n%10];
      else if (n < 100) word = tensPlace[n/10] + onesPlace[n%10];
      else if (n%100 == 0 && n < 1000) word = onesPlace[n/100] + "hundred";
      else if (n%10 == 0 && n < 1000) word = onesPlace[n/100] + "hundredand" + tensPlace[(n/10)%10];
      else if (n%100 < 10) word = onesPlace[n/100] + "hundredand" + onesPlace[n%10];
      else if (n%100 < 20) word = onesPlace[n/100] + "hundredand" + teensPlace[n%10];
      else if (n < 1000) word = onesPlace[n/100] + "hundredand" + tensPlace[(n/10)%10] + onesPlace[n%10];
      int length = word.length();
      totalLength += length;
    }
    System.out.println("Total Length: " + totalLength);
  }
  
  public static void prob18()
  { // Also solves Problem 67
    System.out.println("Problem 18: Find the maximum total from top to bottom of the triangle.");
    ArrayList<int[]> array = new ArrayList<int[]>();
    try
    {
      //Scanner fileReader = new Scanner(new File("projectEuler_prob18.txt"));
      Scanner fileReader = new Scanner(new File("projectEuler_prob67.txt"));
      while (fileReader.hasNextLine())
      {
        String[] temp = fileReader.nextLine().split(" ");
        int[] tempIntArr = new int[temp.length];
        for (int i = 0; i < tempIntArr.length; i++)
          tempIntArr[i] = Integer.parseInt(temp[i]);
        array.add(tempIntArr);
      }
    }
    catch (Exception e) { }
    for (int i = array.size()-1; i > 0; i--)
    {    
      for (int j = 0; j < array.get(i).length-1; j++)
        array.get(i-1)[j] += (array.get(i)[j]>array.get(i)[j+1]? array.get(i)[j]:array.get(i)[j+1]);
      
    }
    System.out.println("Largest sum: " + array.get(0)[0]);
  }
  
  public static void prob19()
  {
    System.out.println("Problem 19: Find number of Sundays that fall on the first of the month during 20th century");
    SimpleDateFormat informat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat outformat = new SimpleDateFormat("E");
    int numSuns = 0;
    for (int y = 1901; y <= 2000; y++)
    {
      for (int m = 1; m <= 12; m++)
      {
        Date day = new Date();
        try
        { day = informat.parse(y + "-" + (m<10?("0"+m):m) + "-01"); }
        catch (Exception e) { }
        if ("Sun".equals(outformat.format(day)))
        {
          System.out.println(informat.format(day) + "\t" + outformat.format(day));
          numSuns++;
        }
      }
    }
    System.out.println("Number of Sundays: " + numSuns);
  }
  
  public static void prob20()
  {
    System.out.println("Problem 20: Find sum of digits in n!");
    int n = getInt();
    BigInteger bi = new BigInteger(n+"");
    for (int i = 1; i < n; i++)
      bi = bi.multiply(new BigInteger(i+""));
    String bistr = bi.toString();
    long sum = 0;
    for (int i = 0; i < bistr.length(); i++)
      sum += Integer.parseInt(bistr.substring(i,i+1));
    System.out.println(n + "! = " + bi);
    System.out.println("Sum of digits: " + sum);
  }
  
  public static int getInt()
  {
    int n = 0;
    isValid = false;
    while (!isValid)
    {
      System.out.print("Enter an integer: ");
      instr = in.nextLine();
      try
      {
        n = Integer.parseInt(instr);
        isValid = true;
      }
      catch (NumberFormatException e)
      { isValid = false; }
    }
    return n;
  }
  
  public static long getLong()
  {
    long n = 0;
    isValid = false;
    while (!isValid)
    {
      System.out.print("Enter a long: ");
      instr = in.nextLine();
      try
      {
        n = Long.parseLong(instr);
        isValid = true;
      }
      catch (NumberFormatException e)
      { isValid = false; }
    }
    return n;
  }
}