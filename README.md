# PrimeFinder
A Java library to calculate primes. Finding primes is useful in cryptography. Documentation can be found in the README. I made this as a personal project after learning about how to find primes in my Discrete Structures class.

Important note: It stores the ArrayList of primes found as a global variable, so that it is easier to search for multiple primes. Call the "ReleaseMemory()" function to delete all the stored primes.

ReleaseMemory() - Resets the global primes ArrayList to make memory available
FindNthPrime() - Finds the nth prime; positive ints only
GetPrimeList() - Returns a reference to the primes ArrayList

Please let me know if there are additional features that I should develop!

I know some current limitations are that you cannot calculate the nth prime beyond 2,147,483,647. However, my computer only has 8GB of RAM, so that is already 2 GB require to store one normal sized int (of size 1 byte), so going beyond that wouldn't really help. I can create another with a LinkedList, but you get O(1) access with an ArrayList.
