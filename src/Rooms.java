import java.util.ArrayList;
import java.util.Vector;
import java.util.Scanner;

public class Rooms extends Introduction
	{
	static Vector<Location> map;
	private static Hero hero;
	static Location currentLocation;

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
				System.out.println("You also see a "
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
		for (Location nextRoom : get(map.size()))
			{

					nextRoom.lair = new Ganondorf();
				// case 2:
				// location.lair = new SpecificMonster2();
				// break;
				}
			}

		

	public static void createMap()
		{

		map = new Vector<Location>(6);

		Location location1 = new Location("your house.",
				"You see doors to the north and east.");
		Location location2 = new Location("Hyrulian Fields.",
				"You see doors to the north and west.");
		Location location3 = new Location("Faron Woods",
				"You see doors to the south and east.");
		Location location4 = new Location("Temple of Time",
				"You see doors to the south and west.");
		Location location5 = new Location("Sacred Grove.",
				"You see doors to the south.");
		Location location6 = new Location("Deep Woods.",
				"You see doors to the west.");

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
			System.out.println("The monster now has "
					+ monsterCombatant.getHitPointsOfMonster() + " HP.");
			System.out.println("You now have "
					+ heroCombatant.getHitPointsOfHero() + " HP.");

			if (monsterCombatant.getHitPointsOfMonster() <= 0)
				{
				System.out.println("The monster dies.");
				}

			if (heroCombatant.getHitPointsOfHero() <= 0)
				{
				System.out.println("You die a failure.");
				System.exit(0);
				}

			}
		}
	}
