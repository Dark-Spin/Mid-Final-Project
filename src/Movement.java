import java.util.ArrayList;

public class Movement
	{

	public static void main(String args[])
		{
		MovementSpace();
		}

	public static void MovementSpace()
		{

		// Build rooms
		final int WIDTH = 3;
		final int HEIGHT = 2;
		final int LENGTH = 2;
		Room[][][] room = new Room[WIDTH][HEIGHT][LENGTH];
		Rooms.build(room, WIDTH, HEIGHT, LENGTH);
		int x = 0;
		int y = 0;
		int z = 0;
		Rooms.print(room, x, y, z);

		// Load inventory
		ArrayList<String> inventory = new ArrayList<>();

		// Start game
		boolean playing = true;
		while (playing)
			{

			String input = Input.getInput();

			// Movement commands
			if (input.equals("down"))
				{
				if (y > 0)
					{
					y--;
					Rooms.print(room, x, y, z);
					} else
					{
					System.out.println("You can't go that way.");
					}
				} else if (input.equals("up"))
				{
				if (y < HEIGHT - 1)
					{
					y++;
					Rooms.print(room, x, y, z);
					} else
					{
					System.out.println("You can't go that way.");
					}
				} else if (input.equals("left"))
				{
				if (x > 0)
					{
					x--;
					Rooms.print(room, x, y, z);
					} else
					{
					System.out.println("You can't go that way.");
					}
				} else if (input.equals("right"))
				{
				if (x < WIDTH - 1)
					{
					x++;
					Rooms.print(room, x, y, z);
					} else
					{
					System.out.println("You can't go that way.");
					}
				} else if (input.equals("inside"))
				{
				if (z > 0)
					{
					z++;
					Rooms.print(room, x, y, z);
					} else
					{
					System.out.println("You can't go that way.");
					}
				} else if (input.equals("outside"))
				{
				if (z < LENGTH - 1)
					{
					z++;
					Rooms.print(room, x, y, z);
					} else
					{
					System.out.println("You can't go that way.");
					}
				}

			// Look commands
			else if (input.equals("look"))
				{
				Rooms.print(room, x, y, z);
				}

			// Get commands
			else if (input.length() > 4 && input.substring(0, 4).equals("get "))
				{
				if (input.substring(0, input.indexOf(' ')).equals("get"))
					{
					if (input.substring(input.indexOf(' ')).length() > 1)
						{
						String item = input.substring(input.indexOf(' ') + 1);
						Inventory.checkItem(x, y, z, item, inventory, room);
						}
					}
				}

			// Inventory commands
			else if (input.equals("i") || input.equals("inv")
					|| input.equals("inventory"))
				{
				Inventory.print(inventory);
				}

			// Quit commands
			else if (input.equals("quit"))
				{
				System.out.println("Goodbye!");
				playing = false;

				} else
				{
				System.out.println("You can't do that.");
				}
			}
		System.exit(0);
		}
	}
