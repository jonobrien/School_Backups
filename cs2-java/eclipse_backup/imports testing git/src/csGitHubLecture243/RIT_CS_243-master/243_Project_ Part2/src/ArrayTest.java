public class ArrayTest
{
	public static void main(String[] args)
	{
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] newconfig = new int[a.length];
		System.arraycopy(a, 0, newconfig, 0, a.length);
		newconfig[2] = 1;
		int [] b = newconfig;
		newconfig[2] = 0;

		for (int i : a)
			System.out.println(i);
	}
}