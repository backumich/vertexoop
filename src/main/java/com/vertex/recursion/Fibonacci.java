package com.vertex.recursion;

public class Fibonacci {

    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static long f4(int k, int fibonah1, int fibonah2) {
        if (k > 2) {
            return f4(k - 1, fibonah2, fibonah2 + fibonah1);
        } else {
            return fibonah2;
        }
    }

    public long fib(int n) {
        return f4(n, 1, 1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
//        System.out.println(fibonacci.fibonacci(5));
//        System.out.println(fibonacci.fibonacci(50));
//        System.out.println(fibonacci.fibonacci(100));
//        System.out.println(fibonacci.fibonacci(200));
//        System.out.println(fibonacci.fibonacci(500));
//        System.out.println(fibonacci.fibonacci(1000));

        System.out.println(fibonacci.fib(5));
        System.out.println(fibonacci.fib(50));
        System.out.println(fibonacci.fib(100));
    }
}
