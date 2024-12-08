package Controller_UI;

import java.text.NumberFormat;
import java.util.Locale;

import Controller.Client;
import Model.Session;
import Utils.LoadRoot;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
 
public class ControllerBar {
	

		@FXML
		private FXMLLoader currentLoader;
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
	    private Timeline countdownTimeline;
	    private String currentFXML;
	    private volatile boolean running = true; 

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
	    
	
		private Client client;
		public ControllerBar() {
			client = Client.getInstance();
			
		}	
	    @FXML
	    public void initialize() {
	        currentContent = mainContainer.lookup("#content");  
	        btnCurrent = mainContainer.lookup("#homeButton");
	        triggerHomeButtonAction();
	        startRemainingTimeCountdown();
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
	           
                LoadRoot.setInstance(loader);
	            BaseController controller = loader.getController();
	            if (controller != null) {
	                controller.setMainController(this);
	               
	            }
	            
	            content.setId("content");

	            mainContainer.getChildren().add(content);
	            currentContent = content;  
	            currentFXML = fxmlFile;
	            currentLoader = loader;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public Node getNodeById(String id) {
	        return mainContainer.lookup("#" + id);
	    }

		
		 
	    private void clearSelected() {
	    	btnCurrent.getStyleClass().remove("selected");
	    }

	    public void startRemainingTimeCountdown() {
	        if (countdownTimeline == null) {
	            countdownTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
	                if (client.getUser() != null) {
	                    long remainingTime = client.getUser().getTimeRemain();
	                    
	                    if (remainingTime > 0) {
	                        remainingTime -= 1;
	                        client.getUser().setTimeRemain(remainingTime);

	                        // Update the UI
	                        if ("../application/contentHome.fxml".equals(currentFXML)) {
	                            try {
	                                ControllerHome homeController = (ControllerHome) currentLoader.getController();
	                                if (homeController != null) {
	                                    homeController.setRemainHour(String.valueOf(remainingTime));
	                                }
	                            } catch (Exception e) {
	                                e.printStackTrace();
	                            }
	                        } else if ("../application/contentGame.fxml".equals(currentFXML)) {
	                            try {
	                                ControllerGame gameController = (ControllerGame) currentLoader.getController();
	                                if (gameController != null) {
	                                    gameController.setRemainHour(String.valueOf(remainingTime));
	                                }
	                            } catch (Exception e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    } else {
	                        countdownTimeline.stop();
	                    }
	                }
	            }));

	            countdownTimeline.setCycleCount(Timeline.INDEFINITE);
	            countdownTimeline.play();
	        }
	    }

	    public void stopRemainingTimeCountdown() {
	        if (countdownTimeline != null) {
	            countdownTimeline.stop(); // Stop the timeline animation
	            countdownTimeline = null; // Optionally reset the timeline
	        }
	    }

	    public void stopCountdown() {
	        running = false; // Dừng luồng
	    }

//	    private void playVoiceNotification(String message) {
//	        new Thread(() -> {
//	            try {
//	                Voice voice = VoiceManager.getInstance().getVoice("kevin16"); // Sử dụng giọng chuẩn.
//	                if (voice != null) {
//	                    voice.allocate(); // Chuẩn bị giọng.
//	                    voice.speak(message); // Phát thông báo.
//	                    voice.deallocate(); // Giải phóng giọng.
//	                } else {
//	                    System.err.println("Giọng nói không được tìm thấy!");
//	                }
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        }).start();
//	    }
}
