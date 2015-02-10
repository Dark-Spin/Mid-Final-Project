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
		@SuppressWarnings("unused")
		int heroClass = 0;
				hero.setHitPointsOfHero(10);
				hero.setAttackBehavior(new AttackWithSword());
				
				if(hero.getHitPointsOfHero() < 5)
					{
					hero.setAttackBehavior(new AttackWithMasterSword());
					}

   

			}
		}
	
