package job_InheritClasses;

import Main_Classes.*;

public class Mage extends Job{
	
	public Mage() {
		super("Mage");
		applyBonus(this.stats);
	}
	
	@Override
	public void applyBonus(Stats s) {
		s.increaseMagicDamage(6);
		s.increaseMana(5);
	}
	
	@Override
	public Job evolve() {
		return new Archmage();
	}
	
	@Override
	public boolean applyLevelUpBonus(Stats s) {
	    // Mages focus on Mana and Magic Damage
	    boolean incMana = s.increaseMana(4);
	    boolean incMag = s.increaseMagicDamage(3);
	    boolean incAg =s.increaseAgility(1);
	    
	    return incMana || incMag || incAg;
	}
}
