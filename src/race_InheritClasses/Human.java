package race_InheritClasses;

import Main_Classes.*;

public class Human extends Race {
	
	public Human() {
		super("Human");
	}
	
	@Override
	public void initializeStats(Stats s) {
		s.increaseHp(5);
		s.increasePhysicalDamage(5);
		s.increaseDefense(3);
		s.increaseAgility(4);
		s.increaseMana(-8);
		s.increaseMagicDamage(-6);
	}
	
	@Override
	public void applySpecial(Stats s) {
		// agility + damage build
		s.increasePhysicalDamage(3);
		s.increaseAgility(4);
	}
	
	@Override
	public String[] getJobOptions() {
		return new String[] { "Warrior", "Tank" };
	}
	
	@Override
	public boolean applyLevelUpBonus(Stats s) {
		boolean increased = false;
		
	    // Humans get a balanced, small stat increase on level up
		increased |= s.increaseHp(2);
        increased |= s.increasePhysicalDamage(1);
        increased |= s.increaseDefense(1);
        increased |= s.increaseAgility(1);
	    
	    return increased;
	}
}
