package aufgabenblatt3;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.layout.GridPane;

public class SimulationTask extends Task<Boolean> {
  
  /**
   * Reference to the gridPane in the scene graph
   */
  private GridPane grid;
  
  /**
   * KONSTRUKTOR
   */
  public SimulationTask(GridPane grid){
    this.grid = grid;
  }

  @Override
  protected Boolean call() throws Exception {

    updateProgress(0, numberOfSteps -1);
    for (int i = 0; i < numberOfSteps; i++){
      
      
    }
    return null;
  }
  
  
  private void updateLable() {
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        grid.
      }
    });
  }
}
