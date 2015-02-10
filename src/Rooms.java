import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Scanner;

public class Rooms extends Introduction
	{
	static Vector<Location> map;
	private static Hero hero;
	static Location currentLocation;
	static Location bossLocation;
	static Location location1 = new Location("your house.",
			"You see doors to the north and east.");
	static Location location2 = new Location("Hyrulian Fields.",
			"You see doors to the north and west.");
	static Location location3 = new Location("Faron Woods",
			"You see doors to the south and east.");
	static Location location4 = new Location("Temple of Time",
			"You see doors to the south and west.");
	static Location location5 = new Location("Sacred Grove.",
			"You see doors to the south.");
	static Location location6 = new Location("Deep Woods.",
			"You see doors to the west.");

	public static void main(String[] args)
		{
		createMap();
		populateMonsters();
		hero = Player.generateHero();

		while (true)
			{
			System.out.println("You're in " + currentLocation.getTitle());
			System.out.println(currentLocation.getDescription());
			System.out.println();

			if (currentLocation.getLair() != null)
				{
				System.out.println("You also see "
						+ currentLocation.getLair().getNameOfMonster());
				resolveCombat(hero, currentLocation.getLair());
				}

			System.out.println();
			System.out.println("Which direction would you like to go?");

			for (Exit exit : currentLocation.getExits())
				{
				System.out.println(exit.getDirection());
				}

			Scanner scanner = new Scanner(System.in);
			String choice = scanner.nextLine();

			for (Exit exit : currentLocation.getExits())
				{
				if (exit.getDirection().equals(choice))
					{
					currentLocation = exit.getLeadsTo();
					}
				}
			}
		}

	public static void populateMonsters()
		{
		location6.lair = new Ganondorf();
		}

	public static void createMap()
		{

		map = new Vector<Location>(6);

		map.addElement(location1);
		map.addElement(location2);
		map.addElement(location3);
		map.addElement(location4);
		map.addElement(location5);
		map.addElement(location6);

		// This section defines the exits found in each location and the
		// locations to which they lead.
		location1.addExit(new Exit(Exit.north, location3));
		location1.addExit(new Exit(Exit.east, location2));
		location2.addExit(new Exit(Exit.north, location4));
		location2.addExit(new Exit(Exit.west, location1));
		location3.addExit(new Exit(Exit.south, location1));
		location3.addExit(new Exit(Exit.east, location4));
		location4.addExit(new Exit(Exit.west, location3));
		location4.addExit(new Exit(Exit.south, location2));
		location4.addExit(new Exit(Exit.north, location5));
		location5.addExit(new Exit(Exit.south, location4));
		location5.addExit(new Exit(Exit.east, location6));
		location6.addExit(new Exit(Exit.west, location5));

		currentLocation = location1;
		bossLocation = location6;

		}

	public static void resolveCombat(Hero heroCombatant,
			Monster monsterCombatant)
		{
		while (monsterCombatant.getHitPointsOfMonster() > 0)
			{
			System.out.println("The monster's HP = "
					+ monsterCombatant.getHitPointsOfMonster());
			monsterCombatant.setHitPointsOfMonster(monsterCombatant
					.getHitPointsOfMonster() - heroCombatant.performAttack());
			heroCombatant.setHitPointsOfHero(heroCombatant.getHitPointsOfHero()
					- monsterCombatant.performAttack());
			if (hero.getHitPointsOfHero() < 5)
				{
				System.out
						.println("You hold up your sword to the sky transforming it into the Master Sword.");
				hero.setAttackBehavior(new AttackWithMasterSword());
				hero.setHitPointsOfHero(50);
				}
			System.out.println("The monster now has "
					+ monsterCombatant.getHitPointsOfMonster() + " HP.");
			System.out.println("You now have "
					+ heroCombatant.getHitPointsOfHero() + " HP.");

			if (monsterCombatant.getHitPointsOfMonster() <= 0)
				{
				System.out.println("You have defeated the boss.");
				try
					{
					GifRunner.main();
					} catch (MalformedURLException e)
					{

					e.printStackTrace();
					}
				}

			if (heroCombatant.getHitPointsOfHero() <= 0)
				{
				System.out
						.println("You must not have been the hero of Hyrule.");
				System.exit(0);
				}

			}
		}
	}
