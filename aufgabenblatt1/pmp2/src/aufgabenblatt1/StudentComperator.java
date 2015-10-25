/**
 * Praktikum TIPR2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 2 ("Wiederholung PM1/PT")
 *
 */
package aufgabenblatt1;

import java.util.Comparator;


public class StudentComperator implements Comparator<Student>{

	
  @Override
  public int compare(Student st1, Student st2) {
  int compareValue;
	compareValue = st1.getNachname().compareToIgnoreCase(st2.getNachname());
	  if (compareValue == 0)
	  	    compareValue = st1.getVorname().compareToIgnoreCase(st2.getVorname());
	  return compareValue;			
  }
}	
