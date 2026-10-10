package race_InheritClasses;

import Main_Classes.*;

public class Elf extends Race {
	
	public Elf() {
		super("Elf");
	}
	
	@Override
	public void initializeStats(Stats s) {
		s.increaseMana(7);
		s.increaseMagicDamage(6);
		s.increaseAgility(5);
		s.increaseDefense(2);
		s.increaseHp(3);
		s.increasePhysicalDamage(1);
	}
	
	@Override
	public void applySpecial(Stats s) {
		// mana + magic build
		s.increaseMagicDamage(2);
		s.increaseMana(1);
	}
	
	@Override
	public String[] getJobOptions() {
		return new String[] { "Mage" };
	}
	
	@Override
	public boolean applyLevelUpBonus(Stats s) {
		boolean increased = false;
		
	    // Elves gain high mana and magic damage, with a boost to agility
	    increased |= s.increaseMana(3);
	    increased |= s.increaseMagicDamage(2);
	    increased |= s.increaseAgility(1);
	    increased |= s.increaseHp(1);
	    
	    return increased; 
	}
}
