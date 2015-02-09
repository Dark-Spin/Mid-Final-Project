import java.util.Scanner;

public class Introduction
	{
	static String name;

	public static void main(String[] args)
		{
		Introduction1();
		Rooms.main(args);

		}

	static void Introduction1()
		{
		Scanner input1 = new Scanner(System.in);
		System.out.println("Welcome Stranger, Please Enter Your Name");
		name = input1.nextLine();
		System.out
				.println("Welcome to the world of Hyrule, you have just woken up from a deep sleep."
						+ " " + name + ".");

		}
	}
