package test09;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("Rand.nextBoolean():" + rand.nextBoolean());
		byte[] bufferBytes = new byte[16];
		System.out.println(Arrays.toString(bufferBytes));
		System.out.println("rand.nextDouble():" + rand.nextDouble());
		System.out.println("rand.nextFloat():" + rand.nextFloat());
		System.out.println("rand.nextGaussian():" + rand.nextGaussian());
		System.out.println("rand.nextInt():" + rand.nextInt());
		System.out.println("rand.nextInt(26):" + rand.nextInt(26));
		System.out.println("rand.nextLong():" + rand.nextLong());
	}
}
