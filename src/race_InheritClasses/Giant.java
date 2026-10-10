package race_InheritClasses;

import Main_Classes.*;

public class Giant extends Race{
	
	public Giant() {
		super("Giant");
	}
	
	@Override
	public void initializeStats(Stats s) {
		s.increaseHp(8);
		s.increaseDefense(7);
		s.increasePhysicalDamage(5);
		s.increaseAgility(1);
		s.increaseMana(-9);
		s.increaseMagicDamage(-9);
	}
	
	@Override
	public void applySpecial(Stats s) {
		// health + defense build
		s.increaseHp(2);
		s.increaseDefense(3);
	}
	
	@Override
	public String[] getJobOptions() {
		return new String[] { "Warrior", "Tank" };
	}
	
	@Override
	public boolean applyLevelUpBonus(Stats s) {
		boolean increased = false;
		
	    // Giants gain massive health and strong defense, with physical damage
		increased |= s.increaseHp(3);
	    increased |= s.increaseDefense(2);
	    increased |= s.increasePhysicalDamage(1);
	    
	    // If at least one stat successfully increased, the level-up is valid
	    return increased;
	}
}
