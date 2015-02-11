
public class AttackWithMasterSword implements AttackBehavior
	{
	public int	amountOfDamage;

	public int attack()
		{
		int randomD6Roll = (int) ((Math.random() * 20) + 1);
		amountOfDamage = randomD6Roll;
		System.out.println("Light rips from the sword, devastating the foe.");
		return amountOfDamage;
		}
	}
