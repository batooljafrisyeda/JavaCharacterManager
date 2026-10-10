package job_InheritClasses;

import Main_Classes.*;

public class Warrior extends Job{
	
	public Warrior() {
		super("Warrior");
		applyBonus(this.stats);
	}
	
	@Override
	public void applyBonus(Stats s) {
		s.increasePhysicalDamage(5);
		s.increaseHp(3);
	}
	
	@Override
	public Job evolve() {
		return new Berserker();
	}
	
	@Override
	public boolean applyLevelUpBonus(Stats s) {
	    // Warriors get more physical stats on level up
	    boolean incPhy = s.increasePhysicalDamage(3);
	    boolean incDef = s.increaseDefense(2);
	    boolean incHP = s.increaseHp(1);
	    
	    return incPhy || incDef || incHP;
	}
}
