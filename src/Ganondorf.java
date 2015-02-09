
public class Ganondorf extends Monster
	{
		public Ganondorf()
			{
			setNameOfMonster("Ganondorf");
			myAttackBehavior = (AttackBehavior) new AttackWithSword();
			setHitPointsOfMonster(50);
			}

	}
