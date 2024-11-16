package Controller_UI;


import java.text.NumberFormat;
import java.util.Locale;

import Controller.Client;
import Interface.Hover;
import Interface.HoverImp;
import Model.UserAccount;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ControllerHome extends BaseController implements Hover {
	
	private Client client = Client.getInstance();

    @FXML
    private AnchorPane content; 
    @FXML
    private Label remaining_hours;
    @FXML
    private Label remaining_money;
  
	@FXML
	private Label fare;
	@FXML
	private Label nameUser;
	@FXML 
	public void initialize() {
	double a = this.client.getUser().getBalance();
    double b = this.client.getComputer().getHourlyRate();
  
    
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    String remainingMoneyText = currencyFormat.format(a).replace("đ", "").trim(); 
    String hourlyRateText = currencyFormat.format(b).replace("đ", "").trim() + "đ/h"; 
    
    int remainingHours = (int) (a / b);
    String remainingHoursText = String.format("%02d:00", remainingHours); 
    
    this.nameUser.setText(this.client.getUser().getUsername());
    this.remaining_money.setText(remainingMoneyText);
    this.fare.setText(hourlyRateText);
    this.remaining_hours.setText(remainingHoursText);
	}
    @FXML
    public void clickAddMoney(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        String buttonId = clickedButton.getId();
        
        String hourId = buttonId.replace("HM", "H"); 
        Label hourLabel = (Label) content.lookup("#" + hourId);
        int amount = 0 , hours = 0;
        if (hourLabel != null) {
        	switch(buttonId) {
        		case "oneHM":
        			 amount = 10000;  hours = 1;
        			break;
        		case "twoHM":
        			 amount = 20000;  hours = 2;
        			 break;
        		case "fourHM":
       			 amount = 40000;  hours = 4;
       			 break;
        		case "eightHM":
       			 amount = 78000;  hours = 8;
       			 break;
        		case "sixteenHM":
          			 amount = 150000;  hours = 16;
          			 break;
        		case "thirtytwoHM":
          			 amount = 280000;  hours = 32;
          			 break;
        	}
        	System.out.println(buttonId);
        	
        
            if(amount !=0)
            showConfirmExchangePage(amount, hours);
        } else {
            System.out.println("Lỗi thòi gian : " + hourId);
        }
	}
    @FXML
    public void DepositMoney(ActionEvent e) {
        showConfirmDepositMoney();
        System.out.println("run");
    }
    private void showConfirmExchangePage(int amount, int hours) {
	        Stage confirmStage = new Stage();
	        confirmStage.initModality(Modality.APPLICATION_MODAL); 
	        confirmStage.initStyle(StageStyle.UNDECORATED); 

	        ConfirmExchangePage confirmPage = new ConfirmExchangePage(amount, hours);
	        Scene scene = confirmPage.createScene();
	        confirmStage.setScene(scene);
	        confirmStage.setTitle("Xác Nhận Đổi Tiền");
	        confirmStage.showAndWait();
	        try {
				Thread.sleep(1000);
				String kq;
				if((kq=client.receiMessage())!="") {
					String[] parts = kq.split(",");
					String remainingHours = parts[0];
					remaining_hours.setText(remainingHours);
				    String remainingMoney = parts[1];
				    remaining_money.setText(remainingMoney);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
    private void showConfirmDepositMoney() {
    	  	Stage confirmStage = new Stage();
	        confirmStage.initModality(Modality.APPLICATION_MODAL); 
	        confirmStage.initStyle(StageStyle.UNDECORATED); 

	        DepositMoneyPage confirmPage = new DepositMoneyPage();
	        Scene scene = confirmPage.createScene();
	        confirmStage.setScene(scene);
	        confirmStage.setTitle("Nạp tiền");
	        confirmStage.setResizable(false);  
	        confirmStage.showAndWait();
    }
    @FXML
    public void handleNavigateButtonAction(MouseEvent event) {
        		Node clickedNode = (Node) event.getSource();
        	    String elementId = clickedNode.getId();
                String hbox = elementId.length() > 5 ? elementId.substring(0, 5) : elementId;
    	        switch (hbox) {
    	            case "hbox1":
    	                controllerBar.triggerPackageButtonAction();
    	                break;
    	            case "hbox2":
    	                controllerBar.triggerNewButtonAction();
    	                break;
    	            default:
    	                System.out.println("Không có màn hình phù hợp cho HBox với ID: " );
    	                break;
    	        }
   } 
        
    
    @Override
	public void hoverHbox(MouseEvent e) {
		 	HBox hbox = (HBox) e.getSource(); 
		    Button button = (Button) hbox.lookup("#" + hbox.getId() + "button"); 
		    FontAwesomeIcon icon = (FontAwesomeIcon) hbox.lookup("#" + hbox.getId() + "arrowIcon"); 
		    createColorTransition(button, icon, Color.RED);		
	}

	@Override
	public void exitedHBox(MouseEvent e) {
		 HBox hbox = (HBox) e.getSource(); 
		    Button button = (Button) hbox.lookup("#" + hbox.getId() + "button"); 
		    FontAwesomeIcon icon = (FontAwesomeIcon) hbox.lookup("#" + hbox.getId() + "arrowIcon"); 
		    createColorTransition(button, icon, Color.WHITE);
		
	}

	@Override
	public void createColorTransition(Button button, FontAwesomeIcon icon, Color targetColor) {
		 Timeline timeline = new Timeline();

		    int frames = 10; 
		    for (int i = 0; i <= frames; i++) {
		        final double fraction = i / (double) frames; 
		        KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.05), event -> {
		       
		            Color currentTextColor = (Color) button.getTextFill();
		            Color newTextColor = interpolateColor(currentTextColor, targetColor, fraction);
		            button.setTextFill(newTextColor);

		            Color currentIconColor = (Color) icon.getFill();
		            Color newIconColor = interpolateColor(currentIconColor, targetColor, fraction);
		            icon.setFill(newIconColor);
		        });
		        timeline.getKeyFrames().add(keyFrame);
		    }
		    timeline.play();		
	}

	@Override
	public Color interpolateColor(Color startColor, Color endColor, double fraction) {
		 double red = startColor.getRed() + (endColor.getRed() - startColor.getRed()) * fraction;
		    double green = startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * fraction;
		    double blue = startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * fraction;
		    return Color.color(red, green, blue);
	}
}
