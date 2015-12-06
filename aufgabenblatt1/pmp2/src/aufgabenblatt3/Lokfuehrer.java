/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 2 ("Lokfuehrer")
 */
package aufgabenblatt3;

/**
 * 
 * @author AlexLoeffel und kafawi
 *
 */
public class Lokfuehrer extends Thread{
   
  private Rangierbahnhof rbf;  

  private int gleis;
  
  private boolean richtung; //true = einfahrt, false = ausfahrt
  
  public Lokfuehrer(Rangierbahnhof rbf,int gleis, boolean richtung){
    this.rbf = rbf;
    this.gleis = gleis;
    this.richtung = richtung;
    start();
  }
  @Override
  public void run(){
    if (!isInterrupted()){
      if (richtung == false) {
        try{
          rbf.zugAusfahren(gleis);
          System.err.println("Lockfuehrer " + Thread.currentThread().getId() + " fährt Zug aus Gleis " + gleis + " heraus.");
        } catch (IllegalArgumentException e){
          e.printStackTrace();
        }
        
      } else {
        try{
          rbf.zugAbstellen(new Zug(),gleis);
          System.err.println("Lockfuehrer " + Thread.currentThread().getId() + " fährt Zug auf Gleis " + gleis + ".");
        } catch (IllegalArgumentException e){
          e.printStackTrace();
        }
      }
    }
  }
}