package Controller_UI;

import java.text.NumberFormat;
import java.util.Locale;

import Controller.Client;
import Model.Session;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class ControllerBar {
	
		@FXML
		private AnchorPane mainContainer;
		
		private Node currentContent;

		private Node btnCurrent;
		@FXML
		private  Button homeButton;
		@FXML
		private  Button gamesButton;
		@FXML
		private  Button packageButton;
		@FXML
		private  Button shopButton;
		@FXML
		private  Button newsButton;
		
		public void triggerHomeButtonAction() {
		    homeButton.fire();  
		}
		public void triggerGameButtonAction() {
		    gamesButton.fire();  
		}
		public void triggerPackageButtonAction() {
			packageButton.fire();  
		}
		public void triggerShopButtonAction() {
			shopButton.fire();  
		}
		public void triggerNewButtonAction() {
			newsButton.fire();  
		}
	    
		/*
		 * @FXML private Slider x-pSlider;
		 * 
		 * @FXML private Label xpLabel;
		 */
		private Client client;
		public ControllerBar() {
			client = Client.getInstance();
			
		}
	    @FXML
	    public void initialize() {
	        currentContent = mainContainer.lookup("#content");  
	        btnCurrent = mainContainer.lookup("#homeButton");
	        triggerHomeButtonAction();
	    }
	    @FXML
	    public void handleButtonClick(ActionEvent event) {
	        Button clickedButton = (Button) event.getSource(); 
	        clearSelected();
	        btnCurrent = clickedButton;
	        String buttonId = clickedButton.getId();
	        switch(buttonId) {
	        	case "homeButton":
	                loadContent("../application/contentHome.fxml");
	        		break;
	        	case "gamesButton":
	        		loadContent("../application/contentGame.fxml");
	        		break;
	        	case "shopButton":
	        		loadContent("../application/contentShop.fxml");
	        		break;
	        	case "packageButton":
	        		loadContent("../application/contentCombo.fxml");
	        		break;
	        	case "newsButton":
	        		loadContent("../application/contentNew.fxml");
	        		break;
	        	
	        	default: break;
	        }

	        clickedButton.getStyleClass().add("selected");
	    }
	    public void loadContent(String fxmlFile) {	
	    	System.out.println(fxmlFile);
	        try {
	            if (currentContent != null) {
	                mainContainer.getChildren().remove(currentContent);
	            }

	            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
	            Node content = loader.load();

	            BaseController controller = loader.getController();
	            if (controller != null) {
	                controller.setMainController(this);
	            }
	            
	            content.setId("content");

	            mainContainer.getChildren().add(content);
	            currentContent = content;  
	           

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public Node getNodeById(String id) {
	        return mainContainer.lookup("#" + id);
	    }
		/*
		 * @FXML public void initialize() { xpSlider.valueProperty().addListener((obs,
		 * oldVal, newVal) -> { int value = newVal.intValue(); int percentage = (int)
		 * Math.round((value - 0) / 2.0); xpLabel.setText(value + "XP"); });
		 * updateLabelPosition((int) xpSlider.getValue());
		 * 
		 * }
		 * 
		 * private void updateLabelPosition(int value) { double percent = value / 200.0;
		 * xpLabel.setLayoutX(50 + (xpSlider.getWidth() - 100) * percent); }
		 */
	    private void clearSelected() {
	    	btnCurrent.getStyleClass().remove("selected");
	    }
	 
}
