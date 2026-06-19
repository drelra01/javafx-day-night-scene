import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

public class DayAndNight extends Application {
    private Slider xSlider;
    
    public void start(Stage primaryStage) {
        xSlider = new Slider(0, 200, 150);
        xSlider.setPadding(new Insets(20, 200, 20, 200));
        
        BorderPane pane = new BorderPane();
        pane.setTop(xSlider);
        pane.setStyle("-fx-background-color: skyblue");
        Scene scene = new Scene(pane, 500, 300);
        
        Rectangle ground = new Rectangle(0, 250, 500, 100);
        ground.setFill(Color.DARKGREEN);
        pane.getChildren().add(ground);
        
        Rectangle House_Body = new Rectangle(180, 150, 150, 100);
        House_Body.setFill(Color.BROWN);
        pane.getChildren().add(House_Body);
        
        Polygon roof = new Polygon(180, 150, 255, 90, 330, 150);
        roof.setFill(Color.BLANCHEDALMOND);
        pane.getChildren().add(roof);
        
        Rectangle Door = new Rectangle(240, 200, 30, 50);
        Door.setFill(Color.CHOCOLATE);
        pane.getChildren().add(Door);
        
        Circle handle = new Circle(265, 225, 5);
        handle.setFill(Color.GOLD);
        pane.getChildren().add(handle);
        
        Rectangle Window_1 = new Rectangle(190, 170, 40, 40);
        Window_1.setFill(Color.AQUA);
        pane.getChildren().add(Window_1);
        
        Rectangle Window_2 = new Rectangle(280, 170, 40, 40);
        Window_2.setFill(Color.AQUA);
        pane.getChildren().add(Window_2);
        
        xSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double sliderValue = newValue.doubleValue();
            double halfMaxValue = xSlider.getMax() / 2;
            
            if (sliderValue <= halfMaxValue) {
                pane.setStyle("-fx-background-color: skyblue");
            }
            else {
                pane.setStyle("-fx-background-color: darkblue");
            }
            
            if (sliderValue >= halfMaxValue) {
                Window_1.setFill(Color.YELLOW);
                Window_2.setFill(Color.YELLOW);
            }
            else {
                Window_1.setFill(Color.AQUA);
                Window_2.setFill(Color.AQUA);
            }
        });
                
        primaryStage.setTitle("DayAndNight");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}
