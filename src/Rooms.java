import java.util.ArrayList;
import java.util.Scanner;

public class Rooms extends Introduction
	{
		public static void town(Room[][] room, final int WIDTH, final int HEIGHT)
			{

			for (int i = 0; i < WIDTH; i++)
				{
				for (int j = 0; j < HEIGHT; j++)
					{
					room[i][j] = new Room(i, "", "", null);
					}
				}

			room[0][0].setNumber(1);
			room[0][0].setName("Town Square");
			room[0][0].setDescription("You are warped to Town Square on Floor 1. Please input up,down,left,right to move and get to aquire items as you see them.");

			room[0][1].setNumber(2);
			room[0][1].setName("Range");
			room[0][1].setDescription("You move to the newbie training arena.");
			room[0][1].setItems("sword");
			room[0][1].setItems("shield");

			room[1][0].setNumber(3);
			room[1][0].setName("Shops");
			room[1][0].setDescription("You are browsing town wares");
			room[1][0].setItems("potions");

			room[1][1].setNumber(4);
			room[1][1].setName("Random Encounter");
			room[1][1].setDescription("You meet a a guide NPC. He is the guide NPC for new players.");
			room[1][1].setItems("Newbie Guide book");

			room[2][1].setNumber(5);
			room[2][1].setName("Field");
			room[2][1].setDescription("You are at the outskirts of town.");
			
			room[1][2].setNumber(6);
			room[1][2].setName("Outer Dungeon");
			room[1][2].setDescription("You have found a dungeon.");
			
			room[0][2].setNumber(7);
			room[0][2].setName("Bridge");
			room[0][2].setDescription("You are on the bridge.");
			room[0][2].setItems("Bottle of Water");
			
			room[2][2].setNumber(8);
			room[2][2].setName("Dungeon Enterance");
			room[2][2].setDescription("You have entered the dungeon.");
			
			room[2][0].setNumber(9);
			room[2][0].setName("View");
			room[2][0].setDescription("You see a beautiful view.");
			}
		

		public static void print(Room[][] room, int x, int y)
			{

			System.out.println(room[x][y].getDescription());
			System.out.println("You see: " + room[x][y].getItems());
			System.out.println();
			}

		public static void removeItem(Room[][] room, int x, int y, String item)
			{

			room[x][y].deleteItem(item);
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
	
