import java.util.Arrays;

public class ArrayListMethods 
{
	static int[] a = new int[10];
	static int j = 0;
	public static void main(String[] args) 
	{
		System.out.println("empty array with capacity of 10 elements");
		System.out.println(Arrays.toString(a));

		AddElement(1);
		System.out.println(Arrays.toString(a));

		AddElement(2);
		System.out.println(Arrays.toString(a));

		AddElement(3);
		System.out.println(Arrays.toString(a));

		AddElement(4);
		System.out.println(Arrays.toString(a));

		AddElement(5);
		System.out.println(Arrays.toString(a));

		AddElement(6);
		System.out.println(Arrays.toString(a));

		AddElement(7);
		System.out.println(Arrays.toString(a));

		AddElement(8);
		System.out.println(Arrays.toString(a));

		AddElement(9);
		System.out.println(Arrays.toString(a));

		AddElement(10);
		System.out.println(Arrays.toString(a));


	}


	public static void AddElement(int element)
	{

		System.out.println("insering at position " + j);
		/*
		for(int i = j+1;i < a.length;i++)//1
		{
			a[i] = a[i-1];//
		}
		*/
		a[j] = element;
		j++;

	}
}

