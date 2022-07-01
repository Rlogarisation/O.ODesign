package unsw.automata;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;


/**
 * A JavaFX controller for the Conway's Game of Live Application.
 *
 */
public class GameOfLifeController {
    @FXML
    private Button playButton;
    @FXML
    private GridPane gameGrid;
    @FXML

    private GameOfLife gameOfLife;


    final Timeline timeline = new Timeline();
    final KeyFrame kf1 = new KeyFrame(Duration.millis(500), newevent -> 
    gameOfLife.tick());
    

    public GameOfLifeController(){
        gameOfLife = new GameOfLife();
        timeline.getKeyFrames().add(kf1);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    @FXML
    public void handleTickButton(ActionEvent event){
        gameOfLife.tick();
    }
    @FXML
    public void handlePlayButton(ActionEvent event){
        if(playButton.getText() == "Stop"){
            timeline.stop();
            playButton.setText("Play");
        }
        else{
            timeline.play();
            playButton.setText("Stop");
        }
    }

    @FXML
    public void initialize(){
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                CheckBox checkBox = new CheckBox();
                checkBox.setSelected(false);
                gameGrid.add(checkBox, x, y);
                gameOfLife.cellProperty(x, y).bindBidirectional(checkBox.selectedProperty());
            }   
        }    
    }

}

