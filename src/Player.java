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
				hero.setHitPointsOfHero(20);
				hero.setAttackBehavior(new AttackWithSword());
				
				if(hero.getHitPointsOfHero() < 3)
					{
					hero.setAttackBehavior(new AttackWithMasterSword());
					}

   

			}
		}
	
