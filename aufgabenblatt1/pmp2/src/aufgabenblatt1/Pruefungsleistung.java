/**
 * Praktikum TIPR2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 2 ("Wiederholung PM1/PT")
 *
 */
package aufgabenblatt1;

public class Pruefungsleistung {
	//Variablen
	private String modulName;
	private float note;
	//Konstruktor
	public Pruefungsleistung (String modulName, float note){
		this.modulName = modulName;
		this.note = note;
	}
	//Getter
	public String getModulName() {
		return modulName;
	}
	public float getNote() {
		return note;
	}
	//Setter
	public void setModulName(String modulName) {
		this.modulName = modulName;
	}
	public void setNote(float note) {
		this.note = note;
	}
	

}
