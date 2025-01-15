package demo.zjm._05常用类._10BigInteger;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        //public class BigInteger extends Number implements Comparable<BigInteger> {
        //final int signum;
        BigInteger bigInteger = new BigInteger("1");

        System.out.println(bigInteger.add(new BigInteger("2")));//3
    }
}
