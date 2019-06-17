import java.lang.reflect.Array;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Joshua Dargan
 * @version 0.2
 * A library to help with finding primes.
 */
public class Primes
{

//    //Region: Print methods
//    public static void PrintWelcome()
//    {
//        System.out.println("Welcome to Joshua Dargan's Prime Generator and Finder!");
//        System.out.println("******************************************************");
//    }
//
//    public static void PrintMenu()
//    {
//        System.out.println("What would you like to do?");
//        System.out.println("1. Print out the first N primes");
//        System.out.println("2. Create a .txt file containing the first N primes");
//        System.out.println("3. Find the nth prime");
//
//    }
//
//    public static void PrintNumRequest()
//    {
//        System.out.println("How many primes would you like to be found? (0 < N < " + MAX + ")");
//    }
//
//    public static void PrintNthRequest()
//    {
//        System.out.println("Which nth prime would you like? (0 < N < " + MAX + ")");
//    }
//
//    /*
//        User input menu
//    */
//    public static int GetIntFromUser(int option)
//    {
//        Scanner scnr = new Scanner(System.in);
//        int result = -1;
//        boolean repeat = true;
//        while (repeat)
//        {
//            try
//            {
//                if (option == 0)
//                {
//                    PrintMenu();
//                    result = scnr.nextInt();
//                    if (result >= 1 && result <= 3) // If it is within the valid menu options
//                        repeat = false;
//                }
//                else
//                {
//                    if (option == 1 || option == 2)
//                        PrintNumRequest();
//                    else if (option == 3)
//                        PrintNthRequest();
//                    result = scnr.nextInt();
//                    if (result >= 1 && result < 10000)
//                        repeat = false;
//                }
//            }
//            catch (Exception e)
//            {
//                scnr.nextLine();
//                System.out.println("Please input an integer");
//            }
//        }
//        return result;
//    }

    private static ArrayList<BigInteger> primes = new ArrayList<BigInteger>();

    /*
      A method that uses the fact that all composite numbers are the products of primes.
      Therefore, by creating a list of primes,
      you can find other primes by checking if a number is divisible by a prime.
   */

    /**
     * Only called in instances where the number of primes desired is greater than the number currently found.
     * @param numPrimes - positive numbers only
     */
    private static void FindNPrimes(int numPrimes) throws IndexOutOfBoundsException
    {
        //If empty, add the first prime so that we can do just odd numbered primes
        if (primes.size() == 0)
        {
            primes.add(BigInteger.valueOf(2));
        }

        //Start with 1 if it is empty, otherwise start with the last prime. It will add 2 when it starts to avoid repeats.
        BigInteger start = BigInteger.valueOf(1);
        if (primes.size() > 1)
        {
            start = primes.get(primes.size()-1); //Gets the last i
        }

        //Keeps finding and adding primes until we hit the desired number of primes
        while (primes.size() < numPrimes)
        {
            start = start.add(BigInteger.valueOf(2)); //Adds 2 to keep it an odd number. (2 was already added as a prime)

            boolean prime = true;

            int index = 1;
            BigInteger factorRange = start.sqrt();
            factorRange = factorRange.add(BigInteger.valueOf(1)); //Makes sure the square root is checked

            //Check if it is long as the factors (the previous primes) are less than the square root (factor range)
            while (prime && index < primes.size() && primes.get(index).compareTo(factorRange) < 1)
            {
                //Checks if it is a factor
                if (start.mod(primes.get(index)).longValueExact() == 0)
                    prime = false;
                ++index;
            }
            //If it is prime, add it to the list of primes.
            if (prime)
                primes.add(start);
        }
    }

    /**
     * @param indexN
     * @return BigInteger - The Nth prime. Ex: 2 is the 1st prime.
     */
    public static BigInteger FindNthPrime(int indexN)
    {
        BigInteger nthPrime = BigInteger.valueOf(0);
        try
        {

            if (indexN <= 0)
                throw new IndexOutOfBoundsException("Index was negative");

            //If the prime does not exist inside the list already, finds the primes up to indexN+1.
            if (primes.size() < indexN)
            {
                FindNPrimes(indexN + 1);
            }
            //Gets the nth prime. Ex: 2 is the 1st prime and is stored at 0 in the ArrayList
            nthPrime = primes.get(indexN-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Index passed into \"FindNthPrime\" was less than or equal to 0");
        }
        catch (Exception e)
        {
            System.out.println("A random error has occurred in \"FindNthPrime\"");
        }
        return nthPrime;
    }

    /**
     * Releases the memory held by the ArrayList of primes.
     * It is highly recommended to run this once you have finished looking for primes.
     */
    public static void ReleaseMemory()
    {
        primes.clear();
        primes = new ArrayList<BigInteger>();
        System.gc();
    }

    public static ArrayList<BigInteger> GetPrimeList()
    {
        return primes;
    }
}
