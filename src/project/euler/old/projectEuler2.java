import java.util.*;
import java.io.*;
import java.math.*;

public class projectEuler2
{
  private static Scanner in = new Scanner(System.in);
  private static boolean isValid = false;
  private static String instr = "";
  
  public static void main(String[] args)
  {
    System.out.println("PROJECT EULER");
    prob25();
  }
  
  public static void prob21()
  {
    System.out.println("Problem 21: Evaluate sum of all amicable numbers under 1000");
    ArrayList<Long> amiNums = new ArrayList<Long>();
    for (long i = 1; i < 10000; i++)
    {
      long j = prob21_helper(i);
      if (i != j && i == prob21_helper(j))
      {
        if (!amiNums.contains(j)) amiNums.add(j);
        if (!amiNums.contains(i)) amiNums.add(i);
      }
    }
    long sum = 0;
    for (int i = 0; i < amiNums.size(); i++)
      sum += amiNums.get(i);
    System.out.println("Sum: " + sum);
  }
  
  private static long prob21_helper(long n)
  {
    long divisorSum = 0;
    for (int i = 1; i <= (int)(n/2); i++)
      if (n%i == 0)
        divisorSum += i;
    return divisorSum;
  }
  
  public static void prob22()
  {
    System.out.println("Problem 22: Find total of all the name scores in the file");
    ArrayList<String> names = new ArrayList<String>();
    try
    {
      Scanner fileReader = new Scanner(new File("projectEuler_prob22.txt"));
      String fileStr = "";
      while (fileReader.hasNext())
        fileStr += fileReader.next();
      String[] fileArr = fileStr.split(",");
      for (int i = 0; i < fileArr.length; i++)
        names.add(fileArr[i].substring(1,fileArr[i].length()-1));
    }
    catch (Exception e) { }
    Collections.sort(names);
    long totalNameScore = 0;
    for (int i = 0; i < names.size(); i++)
    {
      String name = names.get(i);
      int index = names.indexOf(name)+1;
      int sum = 0;
      for (int j = 0; j < name.length(); j++)
        sum +=  (int)(name.charAt(j)) - 64;;
      totalNameScore += index*sum;
    }
    System.out.println("Total Score: " + totalNameScore);
  }
  
  public static void prob23()
  {
    System.out.println("Problem 23: Find sum of all the positive integers which cannot be written as the sum of two abundant numbers");
    int[] nums = new int[28124];
    ArrayList<Integer> abundants = new ArrayList<Integer>();
    for (int i = 12; i < 28123; i++)
    {
      int sum = 0;
      for (int j = 1; j <= i/2; j++)
        if (i%j==0) sum += j;
      if (sum > i)
      {
        abundants.add(i);
        for (int j = 0; j < abundants.size(); j++)
        {
          int num = i + abundants.get(j);
          if (num < nums.length) nums[num] = 1;
        }
      }
    }
    int sum = 0;
    for (int i = 0; i < nums.length; i++)
      if (nums[i]==0) sum += i;
    System.out.println("Sum: " + sum);
  }
  
  public static void prob24()
  {
    System.out.println("Problem 24: Millionth lexicographic permutation of the digits 0-9");
  }
  
  public static void prob25()
  {
    long n = 1, fib = 0;
    int length = 0;
    while (length < 1000)
    {
      fib = prob25_helper(n);
      length = (fib + "").length();
      System.out.println(fib + "\t" + length);
      n++;
    }
  }
  
  private static long prob25_helper(long n)
  {
    if (n <= 1) return n;
    return prob25_helper(n-1) + prob25_helper(n-2);
  }
}