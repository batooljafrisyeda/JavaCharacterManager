package Main_Classes;

public class Stats {
	private int hp;
	private int mana;
	private int agility;
	private int physicalDamage;
	private int magicDamage;
	private int defense;
	
	private static final int MAX_STAT = 60;
	
	public Stats() {
		this.hp = 10;
		this.mana = 10;
		this.agility = 10;
		this.physicalDamage = 10;
		this.magicDamage = 10;
		this.defense = 10;
	}
	
	public boolean increaseHp(int amount) {	
		if (hp >= MAX_STAT && amount > 0) 
			return false;
		
		int oldhp = hp;
	    hp = Math.min(MAX_STAT, hp + amount);
	    
	    return hp > oldhp; // returns true ONLY if the number actually moved
	}
	
	public boolean increaseMana(int amount) {
		if (mana >= MAX_STAT && amount > 0) 
			return false;
		
		int oldmana = mana;
	    mana = Math.min(MAX_STAT, mana + amount);
	    
	    return mana > oldmana; // returns true ONLY if the number actually moved
	}
	
	public boolean increasePhysicalDamage(int amount) {
		if (physicalDamage >= MAX_STAT && amount > 0) 
			return false;
		
		int oldphy = physicalDamage;
		physicalDamage = Math.min(MAX_STAT, physicalDamage + amount);
		
	    return physicalDamage > oldphy; // returns true ONLY if the number actually moved;
	}
	
	public boolean increaseMagicDamage(int amount) {
		if (magicDamage >= MAX_STAT && amount > 0) 
			return false;
		
		int oldmag = magicDamage;
		magicDamage = Math.min(MAX_STAT, magicDamage + amount);
		
	    return magicDamage > oldmag;// returns true ONLY if the number actually moved
	}
	
	public boolean increaseDefense(int amount) {
		if (defense >= MAX_STAT && amount > 0) 
			return false;
		
		int olddef = defense;
		defense = Math.min(MAX_STAT, defense + amount);
		
	    return defense > olddef;// returns true ONLY if the number actually moved
	}
	
	public boolean increaseAgility(int amount) {
		if (agility >= MAX_STAT && amount > 0) 
			return false;
		
		int oldag = agility;
		agility = Math.min(MAX_STAT, agility + amount);
		
	    return agility > oldag; // returns true ONLY if the number actually moved
	}

	public int getHp() {
		return hp;
	}

	public int getMana() {
		return mana;
	}

	public int getAgility() {
		return agility;
	}

	public int getPhysicalDamage() {
		return physicalDamage;
	}

	public int getMagicDamage() {
		return magicDamage;
	}

	public int getDefense() {
		return defense;
	}

	public static int getMaxStats() {
		return MAX_STAT;
	}
	
	public void displayStats() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "----------------------\nStats\n==========\nHP: " + hp + "\nMana: " + mana + "\nAgility: " + agility + "\nPhysicalDamage: " + physicalDamage
				+ "\nMagicDamage: " + magicDamage + "\nDefense: " + defense + "\n";
	}
}
