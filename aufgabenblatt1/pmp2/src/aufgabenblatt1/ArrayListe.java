/**
 * Praktikum TIPR2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 4 ("Generics")
 *
 */
package aufgabenblatt1;

public class ArrayListe<T> {
	int  anzahlElemente;
	private Object[] elemente;
	public ArrayListe(int arrayGroesse){
		anzahlElemente = 0;
		elemente = new Object [arrayGroesse];
	}
	public void hinzufuegen(T item){
		elemente[getAnzahlElemente()] = elemente [getAnzahlElemente()+1];
	}
	public T get(int index){
		T wert = null;
		elemente[index] = wert;
		return wert;
	}
	public void entfernen (T item){
		elemente[getAnzahlElemente()] = elemente [getAnzahlElemente()-1];
	}
	public void entferneElementAnIndex(int index){
		elemente[index] = null;
		anzahlElemente --;
	}
	public int getAnzahlElemente(){
		return anzahlElemente;
	}
	public String toString(){
		
	}
	public T getKleinstesElement(){
		
	}
}
