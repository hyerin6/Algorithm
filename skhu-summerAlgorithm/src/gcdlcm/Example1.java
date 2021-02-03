package gcdlcm;

public class Example1 {

	// 최대공약수 
	static long gcd(long a, long b) {
		// return b!=0 ? gcd(b, a%b) : a;

		while(b!=0) {
			long t = a%b;
			a = b;
			b = t;
		}
		return a;
	}


	// 최소공배수 
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	static long lcm(int... a) { 
		long result = a[0]; 
		for (int i = 1; i < a.length; ++i) {
			result = lcm(result, a[i]);
		}
		return result; 
	}

	static long gcd(int... a) { 
		long result = a[0]; 
		for (int i = 1; i < a.length; ++i) {
			result = gcd(result, a[i]); 
		}
		return result; 
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(gcd(12, 8));
		System.out.println(gcd(14, 12, 8));
		System.out.println(gcd(264, 780, 636, 200)); 
		System.out.println(lcm(12, 8));
		System.out.println(lcm(14, 12, 8));
		System.out.println(lcm(14, 12, 8, 13));
	}

}
