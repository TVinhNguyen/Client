package Controller_UI;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import java.util.HashMap;
import java.util.Map;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class controllerUser {

	   @FXML
	    private FontAwesomeIcon bell;

	    @FXML
	    private FontAwesomeIcon minus;

	    @FXML
	    private FontAwesomeIcon close;	
	    	
	    @FXML
	    private FontAwesomeIcon computer;
	    
	    @FXML
	    private FontAwesomeIcon menu;
	    
	    @FXML
	    private FontAwesomeIcon history;
	    
	    @FXML
	    private FontAwesomeIcon client;
	    
	    @FXML
	    private AnchorPane formClient;

	    @FXML
	    private AnchorPane formComputer;

	    @FXML
	    private AnchorPane formHistory;

	    @FXML
	    private AnchorPane formMenu;
	    
	    
	    @FXML
	    private Separator h1;

	    @FXML
	    private Separator h2;

	    @FXML
	    private Separator h3;

	    @FXML
	    private Separator h4;
	    
	    @FXML
	    private Pane computer1;

	    @FXML
	    private Pane computer2;

	    @FXML
	    private Pane computer3;

	    @FXML
	    private Pane computer4;

	    @FXML
	    private Pane computer5;
	    
	    @FXML
	    private Pane selectComputer;
	    
	    @FXML
	    private Pane formTurnOnComputer;
	    
        @FXML
        private Label lableTime;
        
        @FXML
        private Button turnOnComputer;
        
        @FXML
        private Button buttonPay;

        @FXML
        public void initialize()
        {
	     updateTime();
	     setHoverEffect(close);
	     setHoverEffect(minus);
	     setHoverMenu(bell);
	     
	     FontAwesomeIcon[] listMenu= {computer,menu,history,client};
		 Separator[] listRow= {h1,h2,h3,h4};
		 AnchorPane[] listAnchorPane= {formComputer,formMenu,formHistory,formClient};
         Pane[] listPaneComputer= {computer1,computer2,computer3,computer4,computer5};
		 
		 Map<FontAwesomeIcon, Separator> list1=new HashMap<FontAwesomeIcon, Separator>();
	   	    list1.put(computer, h1);
	        list1.put(menu, h2);
	        list1.put(history, h3);
	        list1.put(client, h4);
	        Map<Separator, AnchorPane> list2=new HashMap<Separator, AnchorPane>();
	        list2.put(h1, formComputer);
	        list2.put(h2, formMenu);
	        list2.put(h3, formHistory);
	        list2.put(h4, formClient);
	        
	        listMenu[0].setFill(Color.web("#c4c8cf"));
	        listRow[0].setVisible(true);
	        listAnchorPane[0].setVisible(true);
	        
	        for(int i=1;i<listAnchorPane.length;i++)
	        {
	       	 listAnchorPane[i].setVisible(false);
	        }
	        
	        for (int i=1;i<listRow.length;i++) { 
	            listRow[i].setVisible(false);
	        }
	        for ( Map.Entry<FontAwesomeIcon, Separator> icon : list1.entrySet()) {
	       	 setClickMenu(icon.getKey(),icon.getValue(),listMenu,listRow,list2);
	          setHoverMenu(icon.getKey());   
	        }
	        for(Pane list: listPaneComputer)
	        {
	        	list.setOnMouseEntered(event->{
	        		
	        		double paneX = list.localToScene(list.getBoundsInLocal()).getMinX();
	                double paneY = list.localToScene(list.getBoundsInLocal()).getMinY();
	                selectComputer.setLayoutX(paneX-66);
	                selectComputer.setLayoutY(paneY-13);
	                selectComputer.setVisible(true);
	                list.setStyle("-fx-background-color: red;");
	                selectComputer.setOnMouseEntered(event1->{
	                	 selectComputer.setVisible(true);
	                });
	                selectComputer.setOnMouseExited(event1->{
	                	selectComputer.setVisible(false);
	                });
	                turnOnComputer.setOnMouseClicked((MouseEvent event2)->
	                {
	                	formTurnOnComputer.setLayoutX(paneX-66);
		                formTurnOnComputer.setLayoutY(paneY-13);
		                formTurnOnComputer.setVisible(true);
	                });
	        	});
	        	list.setOnMouseExited(event->{
	        		 selectComputer.setVisible(false);
	        		 list.setStyle("-fx-background-color: #303030;");
	        	});
	        }
        }
        

private void updateTime()
	{
		Timeline timeline=new Timeline(
			new KeyFrame(Duration.seconds(1),event -> {
				lableTime.setText(java.time.LocalDateTime.now().format(
				java.time.format.DateTimeFormatter.ofPattern("HH:mm  dd-MM-yy")	
				));
			})	
		);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play(); 
	  }
//đóng cửa sổ 
@FXML
private void handleClose(MouseEvent event) {
	Stage stage = (Stage) close.getScene().getWindow(); 
   stage.close();  
}
//thu nhỏ cửa sổ
@FXML
private void handleMinus(MouseEvent event) {
    Stage stage = (Stage) minus.getScene().getWindow();
    stage.setIconified(true); 
}
//sự kiện khi di chuột tới
private void setHoverEffect(FontAwesomeIcon icon) {
	icon.setOnMouseEntered(event -> {
  	icon.setFill(Color.WHITE);  
  });
  icon.setOnMouseExited(event -> {
  	icon.setFill(Color.WHITE);
  });
}
private void setHoverMenu(FontAwesomeIcon icon)
{
	icon.setOnMouseEntered(event -> {
    	icon.setScaleX(1.5);                
        icon.setScaleY(1.5);
    });
    icon.setOnMouseExited(event -> {
    	icon.setScaleX(1);                
        icon.setScaleY(1);
    });
}
//sự kiện khi click chuột 
private void setClickMenu(FontAwesomeIcon icon,Separator separator, FontAwesomeIcon[] lisMenu,Separator[] listRow,Map<Separator, AnchorPane> list2) {
  icon.setOnMouseClicked(event -> {
  	for (FontAwesomeIcon x : lisMenu) {
  		if(x==icon)
  		{
  		    x.setFill(Color.RED); 
  		}
  		else
  		{
  	         x.setFill(Color.WHITE);
  		}
 
      }
  	for (Separator x : listRow) {
  		if(x==separator)
  		{
  			  x.setVisible(true);
  		}
  		else
  		{
  			  x.setVisible(false);
  		}
        
      }
  	for(Map.Entry<Separator, AnchorPane> x: list2.entrySet())
  	{
  		if(x.getKey()==separator)
  		{
  			x.getValue().setVisible(true);
  		}
  		else
  		{
  			x.getValue().setVisible(false);
  		}
  	}
      
  });
}
@FXML
public void clickButtonPay(MouseEvent event)
{
	formTurnOnComputer.setVisible(false);
}
}
