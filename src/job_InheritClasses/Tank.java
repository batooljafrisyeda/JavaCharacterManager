package job_InheritClasses;

import Main_Classes.*;

public class Tank extends Job{
	
	public Tank() {
		super("Tank");
		applyBonus(this.stats);
	}
	
	@Override
	public void applyBonus(Stats s) {
		s.increaseHp(4);
		s.increaseDefense(3);
	}
	
	@Override
	public Job evolve() {
		return new Berserker();
	}
	
	@Override
	public boolean applyLevelUpBonus(Stats s) {
	    // Tanks gain high HP and the most Defense per level
	    boolean incHP = s.increaseHp(4);
	    boolean incDef = s.increaseDefense(3);
	    boolean incPhy = s.increasePhysicalDamage(1);
	    
	    return incHP || incDef || incPhy;
	}
}
