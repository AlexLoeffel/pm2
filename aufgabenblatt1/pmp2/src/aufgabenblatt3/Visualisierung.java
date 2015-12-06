/**
 * Praktikum TIPM2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe 4 ("Visualisierung + Beobachter_Muster")
 */
package aufgabenblatt3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
// import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Diese Klasse erzeugt eine grafische Oberfläche für die Simulation. 
 * 
 * @author AlexLoeffel und kafawi
 *
 */
public class Visualisierung extends Application {
  
  /**
   * MAIN
   * @param args
   */
  public static void main(String[] args){
    launch(args);
  }
  
  @Override
  public void start(Stage stage){
    stage.setTitle("Rangierbahnhof Simulator 2016");
    
    GridPane grid = new GridPane();
    
    StackPane root = new StackPane();
    root.getChildren().add(grid);
    stage.setScene(new Scene(root, 300, 250));
    stage.show();
  }

}
