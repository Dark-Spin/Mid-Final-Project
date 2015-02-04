import java.util.ArrayList;
import java.util.Scanner;

public class Rooms extends Introduction
	{
	public static void build(Room[][][] room, final int WIDTH,
			final int HEIGHT, final int LENGTH)
		{

		for (int i = 0; i < WIDTH; i++)
			{
			for (int j = 0; j < HEIGHT; j++)
				{
				for (int k = 0; k < LENGTH; k++)
					{
					room[i][j][k] = new Room(i, "", "", null);
					}

				room[0][0][0].setNumber(1);
				room[0][0][0].setName("Town Square");
				room[0][0][0]
						.setDescription("You are warped to Town Square on Floor 1. Please input up,down,left,right to move and get to aquire items as you see them.");

				room[0][1][0].setNumber(2);
				room[0][1][0].setName("Range");
				room[0][1][0]
						.setDescription("You move to the newbie training arena.");
				room[0][1][0].setItems("sword");
				room[0][1][0].setItems("shield");

				room[1][0][0].setNumber(3);
				room[1][0][0].setName("Shops");
				room[1][0][0].setDescription("You are browsing town wares");
				room[1][0][0].setItems("potions");

				room[1][1][0].setNumber(4);
				room[1][1][0].setName("Random Encounter");
				room[1][1][0]
						.setDescription("You meet a a guide NPC. He is the guide NPC for new players.");
				room[1][1][0].setItems("Newbie Guide book");

				room[2][1][0].setNumber(5);
				room[2][1][0].setName("Field");
				room[2][1][0]
						.setDescription("You are at the outskirts of town.");
				room[2][1][0].setItems("sword");

				room[1][2][0].setNumber(6);
				room[1][2][0].setName("Outer Dungeon");
				room[1][2][0]
						.setDescription("You have found a dungeon. Would you like to enter?");

				room[0][2][0].setNumber(7);
				room[0][2][0].setName("LonLonRanch");
				room[0][2][0].setDescription("You have found Lon Lon Ranch.");
				room[0][2][0].setItems("Lon Lon Milk");

				room[2][2][0].setNumber(8);
				room[2][2][0].setName("Armory");
				room[2][2][0]
						.setDescription("You have entered the hylian armory.");
				room[0][2][0].setItems("Lon Lon Milk");

				room[2][0][0].setNumber(9);
				room[2][0][0].setName("Viewpoint");
				room[2][0][0]
						.setDescription("You see a beautiful view of Hyrule Fields.");
				}
			}
		}

	public static void print(Room[][][] room, int x, int y, int z)
		{
		System.out.println(room[x][y][z].getDescription());
		if (!room[x][y][z].getItems().equals(""))
			{
			System.out.println("You see: " + room[x][y][z].getItems());
			System.out.println();
			}
		}

	public static void removeItem(Room[][][] room, int x, int y, int z,
			String item)
		{

		room[x][y][z].deleteItem(item);
		}
	}

class Room
	{

	private int number;
	private String name;
	private String description;
	public ArrayList<String> items = new ArrayList<>();

	public Room(int number, String name, String description,
			ArrayList<String> items)
		{
		}

	public void setNumber(int number)
		{
		this.number = number;
		}

	public int getNumber()
		{
		return this.number;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public String getName()
		{
		return this.name;
		}

	public void setDescription(String description)
		{
		this.description = description;
		}

	public String getDescription()
		{
		return this.description;
		}

	public void setItems(String item)
		{
		this.items.add(item);
		}

	public void deleteItem(String item)
		{
		this.items.remove(item);
		}

	public ArrayList<String> getItems()
		{
		return this.items;
		}

	}
