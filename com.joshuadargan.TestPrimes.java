import java.math.BigInteger;

class TestPrimes
{
    public static void main(String[] args)
    {
        boolean allPass = true;
        allPass = allPass && TestNegativeNumber();
        allPass = allPass && TestZero();
        allPass = allPass && TestFirstPrime();
        allPass = allPass && TestSecondPrime();
        allPass = allPass && TestThirdPrime();
        allPass = allPass && Test100thPrime();
        allPass = allPass && TestMillonthPrime();
        allPass = allPass && TestMillonthPrime();

        allPass = allPass && TestReleaseMemory();
        allPass = allPass && TestBillonthPrime();
        allPass = allPass && TestMillonthPrime();
        allPass = allPass && Test100thPrime();
        allPass = allPass && TestThirdPrime();
        allPass = allPass && TestSecondPrime();
        allPass = allPass && TestFirstPrime();

        if (allPass)
            System.out.println("All tests were successful");
    }

    public static boolean TestNegativeNumber()
    {
        //If it returns a zero
        if (Primes.FindNthPrime(-1).compareTo(BigInteger.ZERO) == 0)
        {
            System.out.println("TestNegativeNumbers successful");
            return true;
        }
        else
            System.out.println("TestNegativeNumber failed");
        return false;
    }

    public static boolean TestZero()
    {
        //If it returns a zero
        if (Primes.FindNthPrime(0).compareTo(BigInteger.ZERO) == 0)
        {
            System.out.println("TestZero successful");
            return true;
        }
        else
            System.out.println("TestZero failed");
        return false;
    }

    public static boolean TestFirstPrime()
    {
        if (Primes.FindNthPrime(1).compareTo(BigInteger.TWO) == 0)
        {
            System.out.println("TestFirstPrime successful");
            return true;
        }
        else
            System.out.println("TestFirstPrime failed");
        return false;
    }

    public static boolean TestSecondPrime()
    {
        if (Primes.FindNthPrime(2).compareTo(BigInteger.valueOf(3)) == 0)
        {
            System.out.println("TestSecondPrime successful");
            return true;
        }
        else
            System.out.println("TestSecondPrime failed");
        return false;
    }

    public static boolean TestThirdPrime()
    {
        if (Primes.FindNthPrime(3).compareTo(BigInteger.valueOf(5)) == 0)
        {
            System.out.println("TestThirdPrime successful");
            return true;
        }
        else
            System.out.println("TestThirdPrime failed");
        return false;
    }

    public static boolean Test100thPrime()
    {
        BigInteger prime100th = BigInteger.valueOf(541);
        if (Primes.FindNthPrime(100).compareTo(prime100th) == 0)
        {
            System.out.println("Test100thPrime successful");
            return true;
        }
        else
            System.out.println("Test100thPrime failed");
        return false;
    }

    public static boolean TestMillonthPrime()
    {
        BigInteger primeMillionth = new BigInteger("15485863");
        if (Primes.FindNthPrime(1000000).compareTo(primeMillionth) == 0)
        {
            System.out.println("TestMillionthPrime successful");
            return true;
        }
        else
            System.out.println("TestMillionthPrime failed");
        return false;
    }

    public static boolean TestBillonthPrime()
    {
        BigInteger primeMillionth = new BigInteger("22801763489");
        if (Primes.FindNthPrime(1000000000).compareTo(primeMillionth) == 0)
        {
            System.out.println("TestBillionthPrime successful");
            return true;
        }
        else
            System.out.println("TestBillionthPrime failed");
        return false;
    }

    public static boolean TestReleaseMemory()
    {
        Primes.ReleaseMemory();
        if (Primes.GetPrimeList().size() == 0)
        {
            System.out.println("TestReleaseMemory successful");
            return true;
        }
        else
            System.out.println("TestReleaseMemory failed");
        return false;
    }
}
