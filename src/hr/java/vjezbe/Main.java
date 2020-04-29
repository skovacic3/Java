package hr.java.vjezbe;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import java.math.BigDecimal;



public class Main extends Application {
	public static Stage stage = new Stage();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Oglasnik.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static void setCenterPane(BorderPane root) {
		 Scene scene = new Scene(root, 600, 500);
		 stage.setScene(scene);
		 stage.show();
		
	}
	
	public static boolean BDcompare(BigDecimal a, String b) {
		try {
			if(a.compareTo(new BigDecimal(Integer.parseUnsignedInt(b))) == 0) {
				return true;
			}
			else
				return false;
		}
		catch(Exception e) {
			return true;
		}
	}
	
	public static boolean intCompare(int a, String b) {
		try {
			if(a == Integer.parseUnsignedInt(b)) {
				return true;
			}
			else
				return false;
		}
		catch(Exception e) {
			return true;
		}
	}
}
