/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 1 ("Rangierbahnhof")
 */
package aufgabenblatt3;

/**
 * 
 * @author AlexLoeffel und kafawi
 *
 */
public class Rangierbahnhof {

  /**
   * Beschreibt die Abstellgleise.
   */
  private Zug gleise[];

  /**
   * KONSTRUKTOR
   * 
   * @param gleisAnzahl
   *          Anzahl der Abstellgleise
   */
  public Rangierbahnhof(int gleisAnzahl) {
    gleise = new Zug[gleisAnzahl];
  }
  
  public Rangierbahnhof(Rangierbahnhof rbf) {
    this.gleise = new Zug[rbf.getGleisAnzahl()];
    for (int i = 0; i < gleise.length; i++){
      this.gleise[i] = rbf.getGleise()[i];
    }
  }

  /**
   * 
   * @param zug
   * @param gleis
   * @throws IllegalArgumentException
   */
  public synchronized void zugAbstellen(Zug zug, int gleis)
      throws IllegalArgumentException {
    while (gleise[gleis] != null){
      try {
        wait();
        // damit es schöner wird, könnte man hier eine Thread.sleep(500); 
      } catch (InterruptedException e) {
      }
    }
    if (gleis < 0) {
      throw new IllegalArgumentException("" + gleis
          + "ist zu kleine Gleisnummer");
    } else if (gleis >= gleise.length) {
      throw new IllegalArgumentException("" + gleis + "zu grosse Gleisnummer");
    } 
    gleise[gleis] = zug;
    this.notifyAll();
  }

  /**
   * 
   * @param gleis
   * @throws IllegalArgumentException
   */
  public synchronized void zugAusfahren(int gleis)
      throws IllegalArgumentException {
    while (gleise[gleis] == null){
      try {
        wait();
        // damit es schöner wird, könnte man hier eine Thread.sleep(500); 
      } catch (InterruptedException e) {
      }
    }
    if (gleis < 0) {
      throw new IllegalArgumentException("" + gleis
          + "ist zu kleine Gleisnummer");
    } else if (gleis >= gleise.length) {
      throw new IllegalArgumentException("" + gleis + "zu grosse Gleisnummer");
    } 
    gleise[gleis] = null;
    this.notifyAll();
  }

  /**
   * GETTER
   * 
   * @return Abstellgleis Array
   */
  public Zug[] getGleise() {
    return gleise;
  }

  /**
   * GETTER
   * 
   * @return Anzahl der Abstellgleise
   */
  public int getGleisAnzahl() {
    return gleise.length;
  }

}
