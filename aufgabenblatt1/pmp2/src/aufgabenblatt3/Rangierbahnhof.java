/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 1 ("Rangierbahnhof")
 */
package aufgabenblatt3;

/**
 * 
 * @author kallotti
 *
 */
public class Rangierbahnhof {

  /** 
   * Beschreibt die Abstellgleise.
   */
  private Zug gleise[];

  /**
   * KONSTRUKTOR
   * @param gleisAnzahl Anzahl der Abstellgleise
   */
  public Rangierbahnhof(int gleisAnzahl) {
    gleise = new Zug[gleisAnzahl];
  }

  
 /**
  * 
  * @param zug
  * @param gleis
  * @throws IllegalArgumentException
  */
  public synchronized void zugAbstellen(Zug zug, int gleis) throws IllegalArgumentException {
    if (gleis < 0) {
      throw new IllegalArgumentException("zu kleine Gleisnummer");
    } else if (gleis >= gleise.length) {
      throw new IllegalArgumentException("zu grosse Gleisnummer");
    } 
    gleise[gleis]= zug;
    return;
  }
  
  /**
   * 
   * @param gleis
   * @throws IllegalArgumentException
   */
  public synchronized void zugAusfahren(int gleis) throws IllegalArgumentException {
    if (gleis < 0) {
      throw new IllegalArgumentException("zu kleine Gleisnummer");
    } else if (gleis >= gleise.length) {
      throw new IllegalArgumentException("zu grosse Gleisnummer");
    } 
    gleise[gleis]= null;
    return;
  }
  
  /**
   * brauchen wir die? 
   * mal ab davon kann mein (NEUES) remoterepo nicht auf das pushen
   * muss an die einfahrt und ausfahrt methoden nicht an den anfang:
   * while (gleise[getGleisAnzahl()] != null){   (bzw == für ausfahrt)
   *  try {
   *    this.wait();
   *} catch (InterruptedException e) {
   *e.printStackTrace();   
   *}
   * }
   * und ans ende ein 
   * this.notifyAll();
   * @param zug Zug, der Raus gefahren werden soll
   */
  public synchronized void zugAusfahren(Zug zug){
    for (int i=0;i < gleise.length; i++){
      if (gleise[i] == zug){
        gleise[i] = null;
        return;
      }
    }
    return;
  }

  /**
   * GETTER
   * @return Abstellgleis Array
   */
  public Zug[] getGleise() {
    return gleise;
  }


  /**
   * GETTER
   * @return Anzahl der Abstellgleise
   */
  public int getGleisAnzahl() {
    return gleise.length;
  }

  
  public static void main(String[] args) {
    Rangierbahnhof rbf = new Rangierbahnhof(10);
    for (Zug zug : rbf.getGleise()) {
      System.out.println(zug);
    }
  }
}
