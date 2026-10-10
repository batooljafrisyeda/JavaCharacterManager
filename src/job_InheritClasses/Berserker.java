package job_InheritClasses;

import Main_Classes.*;

public class Berserker extends Job{
	
	public Berserker() {
		super("Berserker");
		applyBonus(this.stats);
	}
	
	@Override
	public void applyBonus(Stats s) {
		s.increasePhysicalDamage(6);
		s.increaseHp(5);
		s.increaseAgility(3);
		s.increaseDefense(-5);
	}
	
	@Override
	public boolean isFinalEvolution() {
	    return true; // This job cannot evolve further
	}
	
	@Override
	public boolean canEvolve() {
	    return false;
	}
	
	@Override
	public Job evolve() {
		return this;
	}
	
	@Override
	public boolean applyLevelUpBonus(Stats s) {
	    // Berserkers gain the most Physical Damage but very low Defense
	    boolean incPhy = s.increasePhysicalDamage(4);
	    boolean incHP = s.increaseHp(3);
	    boolean incAg = s.increaseAgility(2);
	    
	    return incPhy || incHP || incAg;
	}
}
