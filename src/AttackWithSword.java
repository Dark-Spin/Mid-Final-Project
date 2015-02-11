
public class AttackWithSword implements AttackBehavior
	{
	public int	amountOfDamage;

	public int attack()
		{
		int randomD6Roll = (int) ((Math.random() * 10) + 1);
		amountOfDamage = randomD6Roll;
		System.out.println("It was a hit.");
		return amountOfDamage;
		}
	}
