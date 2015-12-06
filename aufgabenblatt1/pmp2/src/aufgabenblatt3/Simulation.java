/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 3 ("Simulation")
 */
package aufgabenblatt3;

/**
 * 
 * @author AlexLoeffel und kafawi
 *
 */
public class Simulation implements Runnable {
  
  public static void main (String [] args){
    Thread sim = new Thread(new Simulation());
    sim.start();
  }
  
  @Override
  public void run() {
    Rangierbahnhof rbf = new Rangierbahnhof(10);
    int i;
    int gleis;
    //alle 500s ein neuer Lokführer
    while (!Thread.interrupted()){
      try {
        Thread.sleep(500);
      }catch (InterruptedException e){
        e.printStackTrace();
        return;
      }
      i = (int)(Math.random()*3);
      gleis = (int)(Math.random()*rbf.getGleisAnzahl());
      boolean richtung = true;
      if ((i%2) == 0){
        richtung = false;
      }
      new Lokfuehrer(rbf, gleis, richtung);
    }
    
  }
}
