package job_InheritClasses;

import Main_Classes.*;

public class Archmage extends Job{
	
	public Archmage() {
		super("Archmage");
		applyBonus(this.stats);
	}
	
	@Override
	public void applyBonus(Stats s) {
		s.increaseMagicDamage(6);
		s.increaseMana(4);
		s.increaseHp(3);
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
	    // Archmages gain massive Mana and Magic Damage growth
	    boolean incMana = s.increaseMana(6);
	    boolean incMag = s.increaseMagicDamage(4);
	    boolean incAg = s.increaseAgility(2);
	    boolean incHP = s.increaseHp(1);
	    
	    return incMana || incMag || incAg || incHP;
	}
}