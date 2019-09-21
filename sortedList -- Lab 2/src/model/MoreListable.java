package model;

/**
 * @author cberkstresser
 * @version 1.0
 */
public interface MoreListable extends Listable {
	/**
	 * This method returns the values actually stored in the list.
	 * 
	 * @return An array of values that are contained in this list.
	 * @implNote Only return values that are part of the user's experience and not
	 *           the hidden values that are remnants from the extra size allocation.
	 */
	int[] getValues();
}