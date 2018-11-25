package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;


public class GUI extends Application {
	
	private AnchorPane root;
	
	private GridPane grid;
	
	public Table table = new Table(10,2);
	
	@Override
	public void start(Stage primaryStage) {
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		root = new AnchorPane();
		root.setId("pane");
		
		/*
		ImageView background = new ImageView(new Image("144.png"));

		
		
		background.setLayoutX(30);
		background.setLayoutY(30);
		background.setFitHeight(640);
		background.setFitWidth(640);
		root.getChildren().add(background);
		*/
		
		root.setLayoutX((Screen.getPrimary().getBounds().getMaxX()/2)-370);
		root.setLayoutY((Screen.getPrimary().getBounds().getMaxY()/2)-370);
		
		Scene scene = new Scene(root,Screen.getPrimary().getBounds().getMaxY(),Screen.getPrimary().getBounds().getMaxY());
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene.setFill(Paint.valueOf("#312E2B"));
		
		Alert cuadroalerta = new Alert(AlertType.CONFIRMATION);
	   	cuadroalerta.setTitle("Pantalla completa");
		cuadroalerta.setHeaderText(null);
		cuadroalerta.initStyle(StageStyle.UTILITY);
		cuadroalerta.setContentText("¿Quiere usar pantalla completa?");

		Optional<ButtonType> result = cuadroalerta.showAndWait();
		if(result.get() == ButtonType.OK){
			primaryStage.setFullScreen(true);
		}
		cuadroalerta.close();
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
