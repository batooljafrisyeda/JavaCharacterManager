package Main_Classes;

public abstract class Race {
	private String raceName;
	
	private static final int MAX_STAT_BONUS = 5;
	
	//constructors
	public Race(String name) {
		this.raceName = name;
	}
	
	//abstract classes
	public abstract void initializeStats(Stats s);
	
	public abstract void applySpecial(Stats s);
	
	public abstract String[] getJobOptions();
	
	public abstract boolean applyLevelUpBonus(Stats s);
	
	//getters
	public String getRaceName() {
		return raceName;
	}

	public static int getMaxStatBonus() {
		return MAX_STAT_BONUS;
	}

	@Override
	public String toString() {
		return raceName;
	}
}
