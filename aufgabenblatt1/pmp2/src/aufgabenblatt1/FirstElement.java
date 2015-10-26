/**
 * Praktikum TIPR2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 4 ("Generics")
 *
 */
package aufgabenblatt1;

public class FirstElement {
	public static boolean istZahl(ArrayListe<?> list){
		try{
			return list.get(0) instanceof Integer ? true:false;
		}
		catch (IndexOutOfBoundsException error){
			System.out.println("leere Liste");
			return false;
		}
	}
	
}
