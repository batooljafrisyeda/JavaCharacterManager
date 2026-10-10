package Main_Classes;

public abstract class Job {
	
	private String jobName;
	protected int level = 1;
    protected Stats stats = new Stats();
    
	private static final int BASE_EVOLVE_LVL = 10;
	
	// level cap
    private static final int MAX_LEVEL = 20;
	
	//constructor
	public Job(String name) {
		this.jobName = name;
	}
	
	//abstract
	public abstract void applyBonus(Stats s);
	public abstract Job evolve();
	public abstract boolean applyLevelUpBonus(Stats s);
	
	// LEVEL UP THIS JOB ONLY
    public boolean levelUp(Race race) {
    	if (this.level >= MAX_LEVEL) {
    		return false; // stop if level 50 reached
    	}
    	
    	race.applyLevelUpBonus(this.stats);
        this.applyLevelUpBonus(this.stats);
        
        level++;
        return true;
    }
    
    public boolean isMaxLevel() {
        return level >= MAX_LEVEL;
    }
    
    public int getLevel() {
        return level;
    }

    public Stats getStats() {
        return stats;
    }
    
	//class methods
	public String getJobName() {
		return jobName;
	}
	
	public static int getBaseEvolutionLevel() {
		return BASE_EVOLVE_LVL;
	}
	
	public boolean canEvolve() {
        return level >= BASE_EVOLVE_LVL;
    }
	
	public boolean isFinalEvolution() {
	    return false; // most jobs are NOT final evolutions
	}
	
	@Override
	public String toString() {
		return jobName;
	}
}
