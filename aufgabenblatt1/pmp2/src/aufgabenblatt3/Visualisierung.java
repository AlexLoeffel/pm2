/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 4 ("Visualisierung + Beobachter_Muster")
 */
package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;

/**
 * Diese Klasse erzeugt eine grafische Oberfläche für die Simulation.
 * 
 * @author AlexLoeffel und kafawi
 *
 */
public class Visualisierung extends Application implements Observer {

  /**
   * Referenz zu dem Beobachteten Objekt
   */
  private Simulation sim;

  /**
   * REferenz auf das GridPane auf dem alles isualisiert wird
   */
  private GridPane   grid;

  /**
   * Dies ist die alles umschliessende Stage.
   */
  private Stage      stage = null;

  
  
  
  public Visualisierung(Simulation sim) {
    this.sim = sim;
    sim.addObserver(this);
  }

  public Simulation getSim() {
    return sim;
  }

  public static void main (String [] args){
    Application.launch(args);
  }
  

  @Override
  public void start(Stage stage) {

    this.stage = stage;
    initialisiereGUI(stage);
    initialisiereSimulation();

  }

  public void initialisiereGui(Stage stage) {

    stage.setTitle("Rangierbahnhof Simulator 2016");
    int breite = 50;
    int hoehe = 50;
    // GridPane grid = new GridPane();
    grid = new GridPane();
    grid.setPadding(new Insets(5));

    for (int i = 0; i < sim.getRangierbahnhof().getGleisAnzahl(); i++) {

      Text gleisName = new Text(" " + i);
      gleisName.setFont(new Font(20));
      grid.add(gleisName, i, 0);
      if (sim.getRangierbahnhof().getGleise()[i] == null) {
        grid.add(drawSchuppen(breite, hoehe), i, 1);
      } else if (sim.getRangierbahnhof().getGleise()[i] != null) {
        grid.add(drawLokSchuppen(breite, hoehe), i, 1);
      }
    }

    // Anwendung beenden, wenn das Fenster geschlossen wurde.
    stage.setOnCloseRequest((WindowEvent we) -> {
      spielBeenden();
    });

    StackPane root = new StackPane();
    root.getChildren().add(grid);
    stage.setScene(new Scene(root));
    stage.show();
  }

  private Path drawSchuppen(int breite, int hoehe) {
    Path path = new Path();
    MoveTo moveTo = new MoveTo();
    moveTo.setX(0);
    moveTo.setY(hoehe);
    LineTo[] schuppen = new LineTo[3];
    for (int i = 0; i < schuppen.length; i++) {
      schuppen[i] = new LineTo();
    }
    schuppen[0].setX(0);
    schuppen[0].setY(0);

    schuppen[1].setX(breite);
    schuppen[1].setY(0);

    schuppen[2].setX(breite);
    schuppen[2].setY(hoehe);

    path.getElements().add(moveTo);
    for (LineTo wand : schuppen) {
      path.getElements().add(wand);
    }
    return path;
  }

  private Path drawLok(int breite, int hoehe) {
    Path path = new Path();
    int offset = 10;
    // drawSchuppen(path);
    MoveTo moveTo = new MoveTo();
    moveTo.setX(0 + offset);
    moveTo.setY(0 + offset);

    LineTo[] lok = new LineTo[4];
    for (int i = 0; i < lok.length; i++) {
      lok[i] = new LineTo();
    }

    lok[0].setX(0 + offset);
    lok[0].setY(hoehe - offset);

    lok[1].setX(breite - offset);
    lok[1].setY(hoehe - offset);

    lok[2].setX(breite - offset);
    lok[2].setY(0 + offset);

    lok[3].setX(0 + offset);
    lok[3].setY(0 + offset);

    path.getElements().add(moveTo);
    for (LineTo wand : lok) {
      path.getElements().add(wand);
    }
    return path;
  }

  private Shape drawLokSchuppen(int breite, int hoehe) {
    Shape lokSchuppen = Shape.union(drawLok(breite, hoehe),
        drawSchuppen(breite, hoehe));
    return lokSchuppen;
  }

  private void zeichneBahnhof() {
    int breite = 50;
    int hoehe = 50;
    // GridPane grid = new GridPane();
    grid = new GridPane();
    grid.setPadding(new Insets(5));

    for (int i = 0; i < sim.getRangierbahnhof().getGleisAnzahl(); i++) {

      Text gleisName = new Text(" " + i);
      gleisName.setFont(new Font(20));
      grid.add(gleisName, i, 0);
      if (sim.getRangierbahnhof().getGleise()[i] == null) {
        grid.add(drawSchuppen(breite, hoehe), i, 1);
      } else if (sim.getRangierbahnhof().getGleise()[i] != null) {
        grid.add(drawLokSchuppen(breite, hoehe), i, 1);
      }
    }
  }

  @Override
  public void update(Observable observable, Object arg) {
    Platform.runLater(() -> zeichneBahnhof());
  }
}
