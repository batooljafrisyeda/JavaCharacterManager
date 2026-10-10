package Main_Classes;

import Interface.*;
import job_InheritClasses.*;

public class Adventurer implements Levelable{
	
	private String name;
	private Race race;
	private Job job;
	
	private Job warrior = new Warrior();
	private Job mage = new Mage();
	private Job tank = new Tank();
	
	private static int totalAdventurers = 0;
	
	public Adventurer(String name, Race race) {
		this.name = name;
		this.race = race;
		
		totalAdventurers++;
	}
	
	// switching jobs
	public void chooseJob(String jobName) {
		switch (jobName) {
        case "Warrior": job = warrior; break;
        case "Mage": job = mage; break;
        case "Tank": job = tank; break;
        case "Archmage": job = new Archmage(); break; // only if special rule
        case "Berserker": job = new Berserker(); break;
    }
		
	}
	
	// level up current job ONLY
	public boolean levelUp() {
		if (job != null) {
            return job.levelUp(this.race);
        }
		return false;
	}
	
	// stats = current job stats + race
	public Stats getStats() {
        Stats combined = new Stats();

        race.initializeStats(combined);
        race.applySpecial(combined);

        // apply job stats directly
        if (job != null) {
            combine(combined, job.getStats());
        }

        return combined;
    }

    // simple stat merge helper
    private void combine(Stats base, Stats add) {
        base.increaseHp(add.getHp() - 10);
        base.increaseMana(add.getMana() - 10);
        base.increaseAgility(add.getAgility() - 10);
        base.increasePhysicalDamage(add.getPhysicalDamage() - 10);
        base.increaseMagicDamage(add.getMagicDamage() - 10);
        base.increaseDefense(add.getDefense() - 10);
    }
	
	public Race getRace() {
		return race;
	}
	
	public Job getJob() {
        return job;
    }
	
	public String getName() {
		return name;
	}
	
	public static int getTotalAdventurers() {
		return totalAdventurers;
	}

	@Override
	public String toString() {
	    return "Adventurer\n==========\n" +
	           "Name: " + name +
	           "\nLevel: " + (job != null ? job.getLevel() : 0) +
	           "\nRace: " + race +
	           "\nJob: " + (job != null ? job : "None") +
	           "\n" + getStats() +
	           "----------------------";
	}
}

