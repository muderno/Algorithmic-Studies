package muderno.net.AlgorithmicStudies;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is a basic study of Fibonacci's sequence and how it impact the
 * time complexity and the space complexity. The basic formula for the
 * Fibonacci's sequence is: 
 * <p>F(n)=F(n-1)+F(n-2);
 * <p> The approaches that I tried are:
 * <ol>
 * <li>Top down;</li>
 * <li>Top down with memoization;</li>
 * <li>Bottom up;</li>
 * </ol>
 * 
 * @author Vinicius Barros
 * 
 */
public class Fibonacci {
	/**
	 * This is the cache of the calculated results of Fibonacci's Sequence. It is a
	 * try to minimize the impact of recursive function.
	 */
	private static Map<Integer, Long> map;

	/**
	 * This method is the basic implementation of Fibonacci's sequence function. 
	 * <p>
	 * Take care for any n greater than 40, it'll take
	 * too long to get a response;
	 * 
	 * @param n
	 *            is the term of the Fibonacci's sequence you want to know the
	 *            value.
	 * @return the value of n term.
	 */
	public static long topDown(long n) {
		if (n < 0)
			throw new IllegalArgumentException("Only positive numbers are allowed!");
		return (n < 2) ? n : topDown(n - 1) + topDown(n - 2);
	}

	/**
	 * This method caches each new result is calculated for Fibonacci's sequence. It
	 * utilize a technique called memoization to minimize the time complexity
	 * that is native of the Fibonacci's function.
	 * 
	 * @param n
	 *            is the term of the Fibonacci's sequence you want to know the
	 *            value.
	 * @return the value of n term.
	 */
	public static long topDownMemoized(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Only positive numbers are allowed!");
		if (n < 2)
			return n;
		if (map.containsKey(n))
			return map.get(n);
		long result = topDownMemoized(n - 1) + topDownMemoized(n - 2);
		map.put(n, result);
		return result;
	}

	/**
	 * This method is another approach to the Fibonacci's sequence problem. Instead
	 * of make a recursive call and sum in the stack all the values, it start from
	 * the first value, that always is 1 and get back summing all the values until
	 * get on the n term value desired.
	 * 
	 * @param n
	 *            is the term of the Fibonacci's sequence you want to know the
	 *            value.
	 * @return the value of n term. 
	 */
	public static long bottomUp(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Only positive numbers are allowed!");
		long n1 = 1;
		long n2 = 1;
		long nTotal = 0;
		for (int i = 0; i < n; i++) {
			n1 = n2;
			n2 = nTotal;
			nTotal = n1 + n2;
		}
		return nTotal;
	}

	public static void main(String[] args) {
		map = new HashMap<>();
		int n = 5;
		System.out.println(bottomUp(n)+"<-- bottomUp");
		System.out.println(topDownMemoized(n)+"<-- topDownMemoized");
		System.out.println(topDown(n)+"<-- topDown");
	}

}
