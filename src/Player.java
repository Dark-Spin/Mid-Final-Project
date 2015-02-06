import java.util.*;

public class Player
	{
	int setHitPointsOfHero;

	public static Hero generateHero()
		{
		Hero hero = new Hero();
		initializeHero(hero);
		return hero;
		}

	public static void initializeHero(Hero hero)
		{
		int heroClass =
			0;
		switch (heroClass)
			{
			case 1:
				int randomD10Roll = (int) ((Math.random() * 9) + 1);
				hero.setHitPointsOfHero(randomD10Roll);
				hero.setAttackBehavior(new AttackWithSword());
				break;
			case 2:
				int randomD6Roll = (int) ((Math.random() * 5) + 1);
				hero.setHitPointsOfHero(randomD6Roll);
				hero.setAttackBehavior(new AttackWithMasterSword());
				break;

			}
		}
	}
