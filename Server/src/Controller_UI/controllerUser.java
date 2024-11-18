package Controller_UI;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import java.util.HashMap;
import java.util.Map;

import Dto.ComputerDto;
import Dto.CustomerDto;
import Model.Computer;
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
	    private FontAwesomeIcon iconSendMessageComputer;
	    
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
	    private Pane selectComputer;
	    
	    @FXML
	    private Pane paneShowCustomer;
	    
	    @FXML
	    private Pane paneAddCustomer;
	    
	    @FXML
	    private Pane paneNotification;
	    
	    @FXML
	    private Pane selectFucition;
	    
	    @FXML 
	    private Pane paneChatComputer;
	    
	    @FXML
	    private Pane panePayMoney;
	    
        @FXML
        private Label lableTime;
      
        @FXML
        private Button btAddpaneCustomer;
        
        @FXML
        private Button btExitPaneCustomer;
        
        @FXML
        private Button btCancelNotification;
        
        @FXML
        private Button btOkNotification;
        
        @FXML
        private Button btMessageComputer;
        
        @FXML
        private Button btImportMoney;
        
        @FXML
        private Button btOder;
        
        @FXML
        private Button btPayBill;
        
        @FXML 
        private Button btImportMoneyPanePayMoney;
        
        @FXML
        private TextField tfPhoneCustomer;
        
        @FXML
        private TextField tfNameAccount;
        
        @FXML
        private TextField tfPasswordAccount;
        
        @FXML
        private TextField tfRemainMoney;
        
        @FXML 
        private TextField tfNameCustomer;
        
        @FXML
        private TextField tfPayMoney;
        
        @FXML
        private TextField tfTimeUserPanePayMoney;
        
        @FXML
        private TextField tfNameCustomerPanePayMoney;
        
        @FXML
        private TextField tfNameComputerPanePayMoney;
        
        @FXML
        private TextField tfChatMessageComputer;
        
        @FXML
        private Label lableNotification;
        
        @FXML
        private ScrollPane scrollPaneCreateComputer;
        
        @FXML
        private FlowPane flowPaneCreateComputer;
        
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
	        
	        listMenu[0].setFill(Color.RED);
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
	        //load giao diện máy tính 
	        loadScrollPaneComputer();
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
//hiển thị thông báo
private void displayNotification() {
    paneNotification.setVisible(true);
    btCancelNotification.setVisible(true);
    btCancelNotification.setOnMouseClicked(event -> {
        paneNotification.setVisible(false);
    });
    btOkNotification.setVisible(false);
}
//chuyển chuỗi VND về Double
private Double convertMoney(String text) {
		 Double amount = 0.0;
		    try {
		        if (text == null || text.trim().isEmpty()) {
		        	lableNotification.setText("Chưa nhập tiền nạp !!!");
		        	return null;
		        }
		        if (text.toLowerCase().contains("VND".toLowerCase())) {
		            text = text.replace("VND", "").trim();
		        }
		        if (text.matches("\\d+")) {
		            amount = Double.parseDouble(text);
		            if (amount< 0) {
		                lableNotification.setText("Số tiến nhỏ hơn 0 !!!");
		                return null;
		            }
		        } else {
		            lableNotification.setText("Nhập sai định dạng tiền !!!");
		            return null;
		        }
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		        lableNotification.setText("Đã xảy ra lỗi khi chuyển đổi chuỗi thành số tiền!");
		    }
		    return amount;
	}
//-----------------------------------Menu--------------------------------------------
//tạo tài khoản ngyười dùng
@FXML
private void createAccount(MouseEvent event)
{
	paneAddCustomer.setVisible(true);
	btAddpaneCustomer.setVisible(true);
	btAddpaneCustomer.setOnMouseClicked(event1->{
		 boolean check = true;
	        if (tfNameCustomer.getText().isEmpty()) {
	            lableNotification.setText("Tên khách hàng chưa nhập !!!");
	            check = false;
	        }
	        else if (tfPhoneCustomer.getText().isEmpty() || !tfPhoneCustomer.getText().matches("\\d{10,11}")) {
	            lableNotification.setText("Số điện thoại phải có 10-11 chữ số !!!");
	            check = false;
	        }
	        else if (tfNameAccount.getText().isEmpty()) {
	            lableNotification.setText("Tên tài khoản không được để trống !!!");
	            check = false;
	        }
	        else if (tfPasswordAccount.getText().isEmpty()) {
	            lableNotification.setText("Mật khẩu không được để trống !!!");
	            check = false;
	        }
	        if(!check)
	        {
	        	displayNotification();
	            return;
	        }
	        for(var customer: CustomerDto.getAllCustomers())
	        {
	        	if (customer.getNameAccount().equals(tfNameAccount.getText())) {
	        	    lableNotification.setText("Tên tài khoản đã tồn tại !!!");
	        	    displayNotification();
	        	    return;
	        	} else if (customer.getPhone().equals(tfPhoneCustomer.getText())) {
	        	    lableNotification.setText("Số điện thoại đã đăng ký !!!");
	        	    displayNotification();
	        	    return;
	        	}
	        }
	        String nameCustomer = tfNameCustomer.getText();
	        String phoneCustomer = tfPhoneCustomer.getText();
	        String nameAccount = tfNameAccount.getText();
	        String passwordAccount = tfPasswordAccount.getText();
	        Double remainMoney=convertMoney(tfRemainMoney.getText());
	        if (remainMoney == null) {
	        	displayNotification();
	            return;
	        }
	        lableNotification.setText("Bạn muốn tạo tài khoản ?");
            setupAddCustomer(0, nameCustomer, phoneCustomer, nameAccount, passwordAccount, 0, 0, remainMoney);
	        
	});
	btExitPaneCustomer.setVisible(true);
	btExitPaneCustomer.setOnMouseClicked(event1->{
		paneAddCustomer.setVisible(false);
	});
}
//hiển thị thông báo thêm thành công
private void setupAddCustomer(int idCustomer, String nameCustomer, String phoneCustomer, String nameAccount, String passwordAccount, int pointAccount, long remainTime, Double remainMoney)
{
	paneNotification.setVisible(true);
	btCancelNotification.setVisible(true);
	btCancelNotification.setOnMouseClicked(event->{
		paneNotification.setVisible(false);
	});
	btOkNotification.setVisible(true);
	btOkNotification.setOnMouseClicked(event->{
		lableNotification.setText(CustomerDto.addEndUpdateCustomer(idCustomer, nameCustomer, phoneCustomer, nameAccount, passwordAccount, pointAccount, remainTime, remainMoney));
		btOkNotification.setVisible(false);
		btCancelNotification.setVisible(true);
		btCancelNotification.setOnMouseClicked(event1->{
			paneNotification.setVisible(false);
			resetCustomer();
		});
	});
}
//xóa thông tin form thêm tài khoản người dùng
private void resetCustomer() {
	tfNameCustomer.setText(null);
	tfPhoneCustomer.setText(null);
	tfNameAccount.setText(null);
	tfPasswordAccount.setText(null);
	tfRemainMoney.setText(null);
}
//thêm máy vào giao diện  
private void createScrollPaneComputer(Computer computer)
{	try {
	FontAwesomeIcon icon =new FontAwesomeIcon();
	icon.setSize("45px");
	icon.setGlyphName("DESKTOP");
	icon.setLayoutX(40);
	icon.setLayoutY(60);
	
	Label label=new Label();
	label.setStyle("-fx-font-family:\"Arial\"; "+
	               "-fx-font-size:14px; "+
			       "-fx-text-fill:white; ");
	label.setText(computer.getNameComputer());
	label.setLayoutX(30);
	label.setLayoutY(92);
	
	Pane pane=new Pane();
	pane.setPrefWidth(138);
	pane.setPrefHeight(117);
	
	pane.setOnMouseClicked(event->{		
		 if (selectComputer.isVisible()) {
			 selectComputer.setVisible(false); 
		    } else {
		    	selectComputer.setVisible(true);
		    	selectComputer.setLayoutX(pane.getLayoutX()+20);
				selectComputer.setLayoutY(pane.getLayoutY()+100);
		    }
		 btMessageComputer.setOnMouseClicked(event1->{
			 
		 });
	});	
	if(computer.getStatusComputer()==0)
	{
		pane.setStyle("-fx-border-color: red; "+" -fx-border-width: 1px; ");
	}
	else
	if(computer.getStatusComputer()==1)
	{
		pane.setStyle("-fx-border-color: green; "+" -fx-border-width: 1px; ");
	}
	else
	if(computer.getStatusComputer()==2)
	{
			pane.setStyle("-fx-border-color: black; "+" -fx-border-width: 1px; ");
	}
	pane.getChildren().addAll(icon,label);
	flowPaneCreateComputer.getChildren().add(pane);
} catch (Exception e) {
	e.printStackTrace();
}
}
//load tất cả máy lên giao diện 
private void loadScrollPaneComputer()
{
	try {
		flowPaneCreateComputer.getChildren().clear();
		for(var computer: ComputerDto.getAllComputers())
		{
			createScrollPaneComputer(computer);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
