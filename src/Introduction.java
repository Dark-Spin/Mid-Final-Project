import java.util.Scanner;

public class Introduction
	{
	static String name;
	private static int hp, maxhp, level, exp, nextLevel, attack, defense,
			potions, gold, floor, weapon, armor;
	private static int monhp, monmaxhp, monAttack, monDefense;
	protected static GameState state;

	public static void main(String[] args)
		{
		Introduction1();
		}

	public enum GameState
		{
		TOWN, DUNGEON, BATTLE
		}

	static void Introduction1()
		{
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome Stranger, Please Enter Your Name");
		name = input.nextLine();
		System.out.println("Welcome to Sword Art Online" + " " + name + ".");
		name = input.nextLine();
		hp = 10;
		maxhp = 5;
		level = 1;
		nextLevel = 15;
		exp = 1;
		attack = 5;
		defense = 3;
		potions = 0;
		gold = 110;
		weapon = 1;
		armor = 1;
		printStats();
		state = GameState.TOWN;
		
		switch (state)
	      {
	         case TOWN:
	            Rooms.town(null, armor, armor);
	            break;
	              
	      } 
	   } 

		

	static void printStats()
		{

		String format = "Name: %s  \n" + "HP:%9s  ATT: %7s  DEF: %7s \n"
				+ "LVL: %7s  EXP: %7s  NXT: %7s\n" + "POTION: %4s  GOLD:%7s\n";
		System.out.printf(format, name, hp + "/" + maxhp, attack, defense,
				level, exp, nextLevel, potions, gold);
		}

	}

