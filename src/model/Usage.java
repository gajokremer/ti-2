package model;

/**
 * Possible usage of Habitat
 * @author gajok
 * {@link #EMPTY}
 * {@link #HEALTHY}
 * {@link #SICK}
 */
public enum Usage {
	
	/**
	 * The Habitat is empty
	 */
	EMPTY, 
	
	/**
	 * The Habitat is occupied, and the Pet inside is Healthy
	 */
	HEALTHY, 
	
	/**
	 * The Habitat is occupied, and the Pet inside is Sick
	 */
	SICK;
}
