package systemMainClasses;

import Main_Classes.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GuildSystem {
	
	 private static ArrayList<Adventurer> adventurers;
	 private static Set<String> names;
	 
	 public static final int MAX_GUILD_SIZE = 50;
	 public static final int MAX_LEVEL = 100;
	 
	 // Constructor
	 public GuildSystem() {
		 adventurers = new ArrayList<>();
	     names = new HashSet<>();
	 }
	 
	// Add Adventurer
	public static boolean addAdventurer(Adventurer a) {
		if (adventurers.size() >= MAX_GUILD_SIZE) {
			return false; // Tells the user that guild is full
		}
		
		if (names.contains(a.getName())) {
			return false; // Tells the user that name is taken
	    }

		adventurers.add(a);
		names.add(a.getName());
		return true;
	}
	
	// Display all adventurers
    public static String displayAll() {
        if (adventurers.isEmpty()) {
            return "No adventurers in guild";
        }

        String result = "";
        
        for (Adventurer a : adventurers) {
            result += a.toString() + "\n";
        }
        
        return result;
    }
	
    // Search Adventurer
    public static Adventurer searchAdventurer(String name) {
        for (Adventurer a : adventurers) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }
    
    // remove Adventurer
    public static String deleteAdventurer(String name) {
        Adventurer found = searchAdventurer(name);

        if (found != null) {
            adventurers.remove(found);
            names.remove(found.getName());
            return name + " removed from guild.";
        } 
     
        return "Adventurer not found.";
    }
    
    // Calculation Level Average
    public static double calculateAverageLevel() {
        if (adventurers.isEmpty()) {
            return 0.0;
        }

        int total = 0;
        int count = 0;
        
        for (Adventurer a : adventurers) {
        	if (a.getJob() != null) {
                total += a.getJob().getLevel();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }
        
        return (double) total / count;
    }
    
    public static boolean isEmpty() {
        return adventurers.isEmpty();
    }
}
