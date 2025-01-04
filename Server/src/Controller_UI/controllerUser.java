package Controller_UI;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;

import java.awt.Event;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Controller.ClientHandlerManager;
import Dto.BillHistoryDto;
import Dto.ComputerDto;
import Dto.CustomerDto;
import Dto.DetailBillDto;
import Dto.DetailBillTimeUserDto;
import Dto.PromotionDto;
import Dto.RoleDto;
import Dto.StaffDto;
import Dto.StatusDto;
import Dto.TemporaryDto;
import Dto.TemporaryMoneyDto;
import Dto.TemporaryTimeUserComputerDto;
import Dto.TimeUserComputerDto;
import Dto.productDto;
import Model.BillHistory;
import Model.BillHistoryTableRow;
import Model.ChatMessage;
import Model.Computer;
import Model.Customer;
import Model.CustomerTableRow;
import Model.Order;
import Model.OrderItem;
import Model.Product;
import Model.Status;
import Model.Temporary;
import Model.TemporaryTableRow;
import Model.TemporaryTimeUserComputer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class controllerUser {

	    @FXML
	    private StackPane stackPaneNotificationCustomer;
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
	    private Pane panePayAndChat;
	    
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
	    private Pane paneNotification1;
	    
	    @FXML
	    private Pane paneRecharge;
	    
        @FXML
        private Label lableTime;
        
        @FXML
        private Label lbtTitleStaff;
        
        @FXML
        private Label lableNotification;
        
        @FXML
        private Label lbTitailBillAndCustomer;
        
        @FXML
        private Label lableNotification1;
        
        @FXML
        private Label numberNotification1;
        
        @FXML
        private Label numberNotification2;
        
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
        private Button btDeleteFormProductOrder;
        
        @FXML
        private Button btAddProductOrder;
        
        @FXML 
        private Button btImportMoneyPanePayMoney;
        
        @FXML
        private Button btCashlNotification;
        
        @FXML
        private Button btBankingNotification;
        
        @FXML
        private Button btPrintBillClient;
        
        @FXML
        private Button btExitPaneCustomerRecharge;
        
        @FXML
        private Button btAddpaneCustomerRecharge;
        
        @FXML
        public TextField tfPhoneCustomer;
        
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
        private TextField tfPhoneCustomerPanePayMoney; 
        
        @FXML
        private TextField tfNameCustomerPanePayMoney;  
        
        @FXML
        private TextField tfNameComputerPanePayMoney; 
        
        @FXML
        private TextField tfChatMessageComputer;  
        
        @FXML
        private TextField tfNameComputerOrder;  
        
        @FXML
        private TextField tfNameProductOrder;  
        
        @FXML
        private TextField tfNumberProductOrder;   
        
        @FXML
        private TextField tfSumMoneyProductOrder;   
        
        @FXML
        private TextField tfNameCustomerOrder;   
        
        @FXML
        private TextField tfPhoneCustomerOrder; 
        
        @FXML
        private TextField tfSearchComputer;  
        
        @FXML
        private TextField tfSearchProduct;   
        
        @FXML
        private TextField tfSumBillClient;  
        
        @FXML
        private TextField tfPhoneCustomerRecharge;
        
        @FXML
        private TextField tfNameCustomerRecharge;
        
        @FXML
        private TextField tfNameAccountRecharge;
        
        @FXML
        private TextField tfPasswordAccountRecharge;
        
        @FXML
        private TextField tfRemainMoneyRecharge;
        
        @FXML
        private TextField tfSearchBillHistoryAndInfor;
        
        @FXML
        private ScrollPane scrollPaneCreateComputer; 
        
        @FXML
        private ScrollPane scrollOder;
        
        @FXML
        private ScrollPane scrollPanerecharge;
        
        @FXML
        private FlowPane flowPaneCreateComputer; 
        
        @FXML
        private FlowPane FlowPaneProductOrder;
        
        @FXML 
        private FlowPane flowpaneBillClient;
        
        @FXML
        private FlowPane selectComputer; 
        
        @FXML
        private FlowPane flowPaneWaitingService;
        
        @FXML
        private FlowPane flowPanRecharge;
        
        @FXML
        private TableColumn<TemporaryTableRow, String> tcNameProduct; 
        
        @FXML
        private TableColumn<TemporaryTableRow, String> tcPriceProduct;
        
        @FXML
        private TableColumn<TemporaryTableRow, Integer> tcNumberProduct; 
        
        @FXML
        private TableColumn<TemporaryTableRow, String> tcSumNumberProduct;   
        
        @FXML
        private TableColumn<TemporaryTableRow, Button> tcEditProduct;  
        
        @FXML
        private TableColumn<TemporaryTableRow, String> tcNameStaffOrder;  
        
        @FXML
        private TableColumn<TemporaryTableRow, String> tcTimeOrder;
        
        @FXML
        private TableColumn<TemporaryTableRow, String> tcStatus;
        
        @FXML
        private TableColumn<BillHistoryTableRow, String> tcNameCustomerHistoryBill;
        
        @FXML
        private TableColumn<BillHistoryTableRow, String> tcNameComputerHistoryBill;
        
        @FXML
        private TableColumn<BillHistoryTableRow, String> tcNamePromotionBillHistory;
        
        @FXML
        private TableColumn<BillHistoryTableRow, String> tcDatePayMentBill;
        
        @FXML
        private TableColumn<BillHistoryTableRow, String> tcSumMoneyHistoryBill;
        
        @FXML
        private TableColumn<Customer, String> tcPhoneCustomerHistoryBill;
        
        @FXML
        private TableColumn<CustomerTableRow, String> tcNameCustomer;
        
        @FXML
        private TableColumn<CustomerTableRow, String> tcPhoneCustomer;
        
        @FXML
        private TableColumn<CustomerTableRow, String> tcNameAccountCustomer;
        
        @FXML
        private TableColumn<CustomerTableRow, String> tcPointCustomer;
        
        @FXML
        private TableColumn<CustomerTableRow, String> tcRemainTimeCustomer;
        
        @FXML
        private TableColumn<CustomerTableRow, String> tcRemainMoneyCustomer;
        
        @FXML
        private TableView<TemporaryTableRow> tbBill;
        
        @FXML
        private TableView<BillHistoryTableRow> tvHistoryBill;
        
        @FXML
        private TableView<CustomerTableRow> tvCustomer;
        
        @FXML
        private ComboBox<String> cbbSelectBillAndInfor;
        
        @FXML
        private ComboBox<String> cbbSelectSearchBillHistoryAnd;
        
        @FXML
        private ListView<ChatMessage> chatListViewComputer;
        
        ObservableList<TemporaryTableRow> listTemporary=FXCollections.observableArrayList();
        
        ObservableList<BillHistoryTableRow> listBillHistory=FXCollections.observableArrayList();
        
        ObservableList<CustomerTableRow> listCustomer=FXCollections.observableArrayList();
        private int idProduct=0;
        private int idStaff=0;
        private int idComputerSelect;
        //tin nhắn
        private  Map<Integer,List<ChatMessage>> listComputerMessage = new HashMap<Integer,List<ChatMessage>>();
        private ObservableList<ChatMessage> chatMessagesComputer = FXCollections.observableArrayList();
        //thông báo tin nhắn
        private Map<Integer, Boolean> readingTest=new HashMap<Integer, Boolean>();
        private Map<Integer, FontAwesomeIcon> messageTest=new HashMap<Integer, FontAwesomeIcon>();
        
        private Map<Integer, LocalDateTime> listTimeUser=new HashMap<Integer, LocalDateTime>();
        private Map<Integer, Pane> computerPaneMap = new HashMap<>();
        //lưu thông báo nạp tiền 
        private Map<Integer, Pane> listPanenotificationDeposit=new HashMap<Integer, Pane>();
        //lưu thông báo order
        private Map<Integer, Pane> listPaneNotificationOrder=new HashMap<Integer, Pane>();
        private int turn=0;
        private int checkTurn=0;
        private int checkidTemporaryMoney=0;
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
	        //load toàn bộ sản phẩm lên giao diện
	        loadProdcut();
	        //load thông tin khách hàng lên bảng 
	        loadTableviewCustomer();
	        //thêm dữ liệu vào combobox search
	        ObservableList<String> options1 = FXCollections.observableArrayList(
	        	    "Lịch sử hóa đơn",
	        	    "Thông tin khách hàng"
	        	);
	        ObservableList<String> options2 = FXCollections.observableArrayList(
	        	    "Tên khách hàng",
	        	    "Số điện thoại"
	        	);
	        cbbSelectBillAndInfor.setItems(options1);
	        cbbSelectBillAndInfor.getSelectionModel().select(0);
	        cbbSelectSearchBillHistoryAnd.setItems(options2);

        }
//nhận thông tin khi máy đăng nhập       
public  void setComputerForUser(int idComputer, int idCustomer, LocalDateTime time) 
{
//	listComputerUser.put(idComputer,idCustomer);
	StatusDto.addStatus(idCustomer, idComputer);
	readingTest.put(idComputer, false);
	listTimeUser.put(idCustomer, time);
	ComputerDto.setStatus(idComputer, 1);
	loadScrollPaneComputer();	
}
//cập nhật thời gian khi đăng xuất
public void setTimeUser(int idCustomer,LocalDateTime time,int idComputer)
{
	//cập nhật thời gian khi máy đăng xuất
	for (Iterator<Map.Entry<Integer, LocalDateTime>> iterator = listTimeUser.entrySet().iterator(); iterator.hasNext(); ) {
	    Map.Entry<Integer, LocalDateTime> entry = iterator.next();
	    if (entry.getKey().equals(idCustomer)) {
	        long timeDifference = ChronoUnit.SECONDS.between(entry.getValue(), time);
	        long timeUser = CustomerDto.checkIDCustomerTakeCustomer(idCustomer).getRemainTime() - timeDifference;	        
	        try {
	        	if(timeUser < 0) timeUser = 0;
	            CustomerDto.updateTime(idCustomer, timeUser);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        iterator.remove();
	    }
	}
	
	for (Status c: StatusDto.getAllStatus()) {
    if (c.getIdCustomer()==idCustomer) {
    	System.out.println("Tắt hoạt động ");
    	ComputerDto.setStatus(c.getIdComputer(), 0);
        StatusDto.deleteStatus(c.getId());
       }
    }
	
	for (Iterator<Map.Entry<Integer, Boolean>> iterator = readingTest.entrySet().iterator(); iterator.hasNext(); ) {
	    Map.Entry<Integer, Boolean> entry = iterator.next();
	    if (entry.getValue().equals(idComputer)) {
	        iterator.remove();
	    }
	}
	//xóa tin nhắn
	for (Iterator<Map.Entry<Integer, List<ChatMessage>>> iterator = listComputerMessage.entrySet().iterator(); iterator.hasNext(); ) {
	    Map.Entry<Integer, List<ChatMessage>> entry = iterator.next();
	    if (entry.getKey().equals(idComputer)) {
	        iterator.remove();
	    }
	}
	loadScrollPaneComputer();	
	//xóa toàn bộ bảng TemporaryMoney
	

}
//hiển thị tên nhân viên lên thanh tiêu đề
public void receiveUserInfo(int idStaff) {
	try {
        if (lbtTitleStaff != null) {
        	for(var staff:StaffDto.getAllStaffs())
        	{
        		if(staff.getIdStaff()==idStaff)
        		{
        			 lbtTitleStaff.setText(RoleDto.checkIDTakeNameRole(staff.getIdRole()).toUpperCase()+"   "+staff.getName().toUpperCase());
        		     this.idStaff=idStaff;
        			 break;
        		}
        	}
        }
        loadTableViewBillHistoryStaff();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//cập nhật thời gian
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
    try {
    	TemporaryMoneyDto.deleteAllTemporaryMoney();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/interfaceLogin.fxml"));
        Parent root = loader.load();
        Stage loginStage = new Stage();
        loginStage.setScene(new Scene(root));
        loginStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
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
  		    flowpaneBillClient.getChildren().clear();
  		    tbBill.getItems().clear();
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
//chuyển từ tiền về double 
private Double convertMoney(String text) {
    Double amount = 0.0;
    try {
        if (text == null || text.trim().isEmpty()) {
            lableNotification.setText("Chưa nhập tiền nạp !!!");
            return null;
        }
        text = text.replaceAll("\\s+", "").trim();
        if (text.toLowerCase().contains("VND".toLowerCase())) {
            text = text.replace("VND", "").trim();
        }
        if (text.matches("\\d+")) {
            amount = Double.parseDouble(text);
            if (amount < 0) {
                lableNotification.setText("Số tiền nhỏ hơn 0 !!!");
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


//chuyển Double về tiền 
private String convertMoneyString(Double number)
{
	if(number==0.0 || number==null)
	{
		return "0 VND";
	}
	else
	{
		 DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	     symbols.setGroupingSeparator(' '); 

	     DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols); 
	     String formattedNumber = decimalFormat.format(number);
	     return formattedNumber+" VND";
	}
	
}
//chuyển đổi thời gian 
private String convertTime(long timeUse)
{
	Long totalSeconds=timeUse;
    long hours = totalSeconds / 3600;
    long minutes = (totalSeconds % 3600) / 60;
    long seconds = totalSeconds % 60;
    String time=hours+"h"+minutes+"m"+seconds+"s";
    return time;
}
//-----------------------------------Computer--------------------------------------------
//Nạp tiền vào tài khoản
@FXML
private void RechargeCustomer(MouseEvent event)
{
	if(paneRecharge.isVisible())
	{
		paneRecharge.setVisible(false);
	}
	else
	{
		paneRecharge.setVisible(true);
	}
	btAddpaneCustomerRecharge.setVisible(true);
	btAddpaneCustomerRecharge.setOnMouseClicked(event1->{
		 boolean check = true;
	        if (tfNameCustomerRecharge.getText().isEmpty()) {
	            lableNotification.setText("Tên khách hàng chưa nhập !!!");
	            check = false;
	        }
	        else if (tfPhoneCustomerRecharge.getText().isEmpty() || !tfPhoneCustomerRecharge.getText().matches("\\d{10,11}")) {
	            lableNotification.setText("Số điện thoại phải có 10-11 chữ số !!!");
	            check = false;
	        }
	        else if (tfNameAccountRecharge.getText().isEmpty()) {
	            lableNotification.setText("Tên tài khoản không được để trống !!!");
	            check = false;
	        }
	        else if (tfPasswordAccountRecharge.getText().isEmpty()) {
	            lableNotification.setText("Mật khẩu không được để trống !!!");
	            check = false;
	        }else if(tfRemainMoneyRecharge.getText().isEmpty() || convertMoney(tfRemainMoneyRecharge.getText())<10000)
	        {
	        	lableNotification.setText("Số tiền phải lớn hơn 10 000 VND !!!");
	            check = false;
	        }
	        if(!check)
	        {
	        	displayNotification();
	            return;
	        }
	        String phoneCustomer = tfPhoneCustomerRecharge.getText();
	        Double remainMoney=convertMoney(tfRemainMoneyRecharge.getText());
	        Customer customer=CustomerDto.checkPhoneTakeCustomer(phoneCustomer);
            CustomerDto.addEndUpdateCustomer(customer.getIdCustomer(), customer.getName(), customer.getPhone(), customer.getNameAccount(), customer.getPasswordAccount(), customer.getPointAccount(), customer.getRemainTime(), customer.getRemainMoney()+remainMoney);
            resetCustomerRecharge();
            lableNotification.setText("Nạp thành Công");
            displayNotification();
	});
	btExitPaneCustomerRecharge.setVisible(true);
	btExitPaneCustomerRecharge.setOnMouseClicked(event1->{
		resetCustomer();
		paneRecharge.setVisible(false);
	});
}
//tìm kiếm khách hàng theo tên 
@FXML
private void SearchCustomerRecharge(KeyEvent event)
{
	if(!tfPhoneCustomerRecharge.getText().isEmpty())
	{
		 Customer customer=CustomerDto.checkPhoneTakeCustomer(tfPhoneCustomerRecharge.getText());
		 if(customer!=null)
		 {
			 tfNameCustomerRecharge.setText(customer.getName());
			 tfNameAccountRecharge.setText(customer.getNameAccount());
			 tfPasswordAccountRecharge.setText(customer.getPasswordAccount());
		 }
	}
}
//tạo tài khoản người dùng
@FXML
private void createAccount(MouseEvent event)
{
	if(paneAddCustomer.isVisible())
	{
		paneAddCustomer.setVisible(false);
	}
	else
	{
		paneAddCustomer.setVisible(true);
	}
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
	        }else if(tfRemainMoney.getText().isEmpty() || convertMoney(tfRemainMoney.getText())<10000)
	        {
	        	lableNotification.setText("Số tiền phải lớn hơn 10 000 VND !!!");
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
	        Double remainMoney=convertMoney(tfRemainMoney.getText())-10000.0;
	        lableNotification.setText("Bạn muốn tạo tài khoản ?");
            setupAddCustomer(0, nameCustomer, phoneCustomer, nameAccount, passwordAccount, 0, 3600, remainMoney);
	        
	});
	btExitPaneCustomer.setVisible(true);
	btExitPaneCustomer.setOnMouseClicked(event1->{
		resetCustomer();
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
	tfNameCustomer.setText("");
	tfPhoneCustomer.setText("");
	tfNameAccount.setText("");
	tfPasswordAccount.setText("");
	tfRemainMoney.setText("");
}
private void resetCustomerRecharge() {
	tfPhoneCustomerRecharge.setText("");
	tfNameCustomerRecharge.setText("");
	tfNameAccountRecharge.setText("");
	tfPasswordAccountRecharge.setText("");
	tfRemainMoneyRecharge.setText("");
}

public static String formatDateTime(LocalDateTime dateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return dateTime.format(formatter);
}

public void addMessageToComputer(int computerId, ChatMessage newMessage) {
    
	listComputerMessage.computeIfAbsent(computerId, k -> new ArrayList<>()).add(newMessage);
    System.out.println(tfNameComputerPanePayMoney); 
    System.out.println(newMessage.getSender());
    for (Map.Entry<Integer, Boolean> lis : readingTest.entrySet()) {
        if(computerId==lis.getKey() && !newMessage.getSender().equals("ADMIN"))
        {
        	readingTest.put(computerId, true);
        	System.out.println(lis.getKey());
        }
    }
    loadScrollPaneComputer();
    if (chatMessagesComputer != null && computerId==idComputerSelect) {
    	Platform.runLater(()->chatMessagesComputer.add(newMessage)); 
    }
    
}

private void sendMessage(int idComputer) {
    String message = tfChatMessageComputer.getText().trim();
    ChatMessage newMessage = new ChatMessage("ADMIN", message, true);
    if (!message.isEmpty()) {
    	addMessageToComputer(idComputer, newMessage);
        tfChatMessageComputer.clear();
        String messagee = "SEND_MESSAGE-"+message; 
        ClientHandlerManager.getInstance().getClientHandlerByComputerId(idComputer).sendMessage(messagee);
    }
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
	
	FontAwesomeIcon bellMessage=new FontAwesomeIcon();
	bellMessage.setGlyphName("COMMENTS");
	bellMessage.setSize("15");
	bellMessage.setLayoutX(120);
	bellMessage.setLayoutY(15);
	bellMessage.setFill(Color.BLACK);

    // Cập nhật màu sắc dựa trên thông tin trong `readingTest`
    for (Map.Entry<Integer, Boolean> cp : readingTest.entrySet()) {
        if (cp.getKey() == computer.getIdComputer() && cp.getValue()) {
            bellMessage.setFill(Color.RED);  // Nếu có thông báo mới thì màu đỏ
        }
    }
    messageTest.put(computer.getIdComputer(), bellMessage);
    Pane pane = new Pane();
	pane.setPrefWidth(138);
	pane.setPrefHeight(117);
	pane.setOnMouseClicked(event->{	
		 
		 paneClick(computer,pane);
		 
		
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
	pane.getChildren().addAll(icon,bellMessage,label);
	computerPaneMap.put(computer.getIdComputer(), pane);
	flowPaneCreateComputer.getChildren().add(pane);
} catch (Exception e) {
	e.printStackTrace();
}
}
//sự kiện lựa chọn trong computer
private void paneClick(Computer computer,Pane pane)
{
	 tfNameComputerPanePayMoney.setText("");
	 tfNameCustomerPanePayMoney.setText("");
	 tfPhoneCustomerPanePayMoney.setText("");
	 tfNameComputerPanePayMoney.setText(computer.getNameComputer());
	 for (Status x:StatusDto.getAllStatus()) {
          if(computer.getIdComputer()==x.getIdComputer())
       {
 	  for(var customer:CustomerDto.getAllCustomers())
 	  {
 		  if(customer.getIdCustomer()==x.getIdCustomer())
 		  {
 			  tfNameCustomerPanePayMoney.setText(customer.getNameAccount());
 			  tfPhoneCustomerPanePayMoney.setText(customer.getPhone());
 			  break;
 		  }
 	  }
 	  break;
   }
} 
	 btMessageComputer.setOnMouseClicked(event1->{
			
		 if(paneChatComputer.isVisible())
		 {
			 paneChatComputer.setVisible(false);	 
			 
		 }
		 else {
			 for (Map.Entry<Integer, Boolean> cp : readingTest.entrySet()) {
			       if(cp.getKey()==computer.getIdComputer() && cp.getValue())
			       {
			    	   Color defaultColor = Color.BLACK;
			    	   messageTest.get(cp.getKey()).setFill(defaultColor);
			    	   readingTest.put(cp.getKey(), false);
			       }
			    }
			 paneChatComputer.setVisible(true);
		     chatMessagesComputer.clear();
			 List<ChatMessage> messages = listComputerMessage.get(computer.getIdComputer());
			 idComputerSelect = computer.getIdComputer();
			 if (messages != null) {
		            chatMessagesComputer.addAll(messages);
		      }
		        chatListViewComputer.setItems(chatMessagesComputer);
		        chatListViewComputer.setCellFactory(lv -> new ListCell<ChatMessage>() {
		            @Override
		            protected void updateItem(ChatMessage item, boolean empty) {
		                super.updateItem(item, empty);
		                if (empty || item == null) {
		                    setText(null);
		                    setGraphic(null);
		                } else {
		                    Label timestampLabel = new Label(formatDateTime(item.getTimestamp()));
		                    timestampLabel.getStyleClass().add("timestamp-label");

		                    Label contentLabel = new Label(item.getContent());
		                    contentLabel.getStyleClass().add("content-label");

		                    VBox messageBox = new VBox(3, timestampLabel, contentLabel);

		                    if (item.isUser()) {
		                        messageBox.getStyleClass().add("client-message");
		                    } else {
		                        messageBox.getStyleClass().add("server-message");
		                    }

		                    setGraphic(messageBox);
		                }
		            }
		        });
		        iconSendMessageComputer.setOnMouseClicked(event12 -> sendMessage(computer.getIdComputer()));
		        tfChatMessageComputer.setOnKeyPressed(event12 -> {
		             if (event12.getCode() == KeyCode.ENTER) {
		                 sendMessage(computer.getIdComputer());
		             }
		         });        

		 }
	 });
	 btImportMoney.setOnMouseClicked(event1->{
		 if(panePayMoney.isVisible())
		 {
			 panePayMoney.setVisible(false);
		 }
		 else
		 {
			 panePayMoney.setVisible(true);
		 }
		 
	 });
	 btOder.setOnMouseClicked(event1->{
		 formComputer.setVisible(false);
		 formMenu.setVisible(true);
		 tfNameComputerOrder.setText(tfNameComputerPanePayMoney.getText());
		 tfPhoneCustomerOrder.setText(tfPhoneCustomerPanePayMoney.getText());
		 tfNameCustomerOrder.setText(tfNameCustomerPanePayMoney.getText());
		 h2.setVisible(true);
	     menu.setFill(Color.RED);
	     h1.setVisible(false);
	     this.computer.setFill(Color.WHITE);
	 }); 
	 if (selectComputer.isVisible()) {
		 selectComputer.setVisible(false); 
	    } else {
	    	selectComputer.setVisible(true);
	    	selectComputer.getChildren().clear();
	    	if(pane.getLayoutX()<600)
	    	{
	    		selectComputer.getChildren().add(selectFucition);
	    		selectComputer.getChildren().add(panePayAndChat);
	    		selectComputer.setLayoutX(pane.getLayoutX()+20);
				selectComputer.setLayoutY(pane.getLayoutY()+100);
	    	}
	    	else
	    	{
	    		selectComputer.getChildren().add(panePayAndChat);
	    		selectComputer.getChildren().add(selectFucition);
	    		selectComputer.setLayoutX(pane.getLayoutX()-433);
				selectComputer.setLayoutY(pane.getLayoutY()+100);
	    	}
	    }
}
//@FXML
//private void PayMoneyTextField(KeyEvent event)
//{
//	checkidTemporaryMoney=-1;
//}
//thanh toán 
@FXML
private void payBill(MouseEvent event)
{
	     checkTurn=0;
		 formClient.setVisible(true);
		 formComputer.setVisible(false);
		 h1.setVisible(false);
	     this.computer.setFill(Color.WHITE);
	     h4.setVisible(true);
	     this.client.setFill(Color.RED);
	     flowpaneBillClient.getChildren().clear();
	     tbBill.getItems().clear();
	     List<TemporaryTimeUserComputer> listTime=new ArrayList<TemporaryTimeUserComputer>();
	     Double sumAllProduct=0.0;
	     for(var customer:CustomerDto.getAllCustomers())
        {
     	if(customer.getPhone().equals(tfPhoneCustomerPanePayMoney.getText()))
     	{
     		 for(var temporary:TemporaryTimeUserComputerDto.getAllTemporaryTimeUsers())
     		 {
     			 if(temporary.getIdCustomer()==customer.getIdCustomer())
     			 {
     				 listTime.add(temporary);
     			 }
     		 }
     		 
     		 for(var temporary:TemporaryDto.getAllTemporary())
              {
             	 if(temporary.getIdCustomer()==customer.getIdCustomer())
             	 {
             		sumAllProduct+=createTableViewBill(temporary);
             	 }
              }
     		 break;
     	}
     } 
	    sumAllProduct+=addDataFlowPaneBill(tfNameCustomerPanePayMoney.getText(), tfPhoneCustomerPanePayMoney.getText(), StaffDto.checkIDTakeNameStaff(idStaff),tfNameComputerPanePayMoney.getText(),listTime);
		tfSumBillClient.setText(convertMoneyString(sumAllProduct));
	     if(btPrintBillClient.getText().equals("Xác nhận"))
	     {
	    	 tfSumBillClient.setText("0 VND");
	     }
}

//thanh toán từ thông báo
private void payBillNotication(int checkTurn)
{
		 formClient.setVisible(true);
		 formComputer.setVisible(false);
		 h1.setVisible(false);
	     this.computer.setFill(Color.WHITE);
	     h4.setVisible(true);
	     this.client.setFill(Color.RED);
	     flowpaneBillClient.getChildren().clear();
	     tbBill.getItems().clear();
	     List<TemporaryTimeUserComputer> listTime=new ArrayList<TemporaryTimeUserComputer>();
	     Double sumAllProduct=0.0;
	     for(var customer:CustomerDto.getAllCustomers())
        {
     	if(customer.getPhone().equals(tfPhoneCustomerPanePayMoney.getText()))
     	{
     		 for(var temporary:TemporaryTimeUserComputerDto.getAllTemporaryTimeUsers())
     		 {
     			 if(temporary.getIdCustomer()==customer.getIdCustomer())
     			 {
     				 listTime.add(temporary);
     			 }
     		 }
     		 
     		 for(var temporary:TemporaryDto.getAllTemporary())
              {
             	 if(temporary.getIdCustomer()==customer.getIdCustomer() && temporary.getTurn()==checkTurn)
             	 {
             		sumAllProduct+=createTableViewBill(temporary);
             	 }
              }
     		 break;
     	}
     } 
	    sumAllProduct+=addDataFlowPaneBill(tfNameCustomerPanePayMoney.getText(), tfPhoneCustomerPanePayMoney.getText(), StaffDto.checkIDTakeNameStaff(idStaff),tfNameComputerPanePayMoney.getText(),listTime);
		tfSumBillClient.setText(convertMoneyString(sumAllProduct));
	     if(btPrintBillClient.getText().equals("Xác nhận"))
	     {
	    	 tfSumBillClient.setText("0 VND");
	     }
}
//load tất cả máy lên giao diện 
private void loadScrollPaneComputer()
{
    Platform.runLater(() -> {
	try {
		flowPaneCreateComputer.getChildren().clear();
		messageTest.clear();
		for(var computer: ComputerDto.getAllComputers())
		{
			createScrollPaneComputer(computer);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
    });
}
//tìm kiếm máy tính 
@FXML
private void SearchComputer(KeyEvent event)
{
	try {
		String textSearch=tfSearchComputer.getText();
		flowPaneCreateComputer.getChildren().clear();
		messageTest.clear();
		for(var computer:ComputerDto.getAllComputers())
		{
			if(computer.getNameComputer().toLowerCase().contains(textSearch.toLowerCase().trim()))
			{
				createScrollPaneComputer(computer);
			}else
			if(textSearch.isEmpty())
			{
				createScrollPaneComputer(computer);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//nạp tiền khóa học 
@FXML
private void importMoneyPanePayMoney(MouseEvent event) {
    if (tfNameCustomerPanePayMoney.getText().isEmpty() || tfPhoneCustomerPanePayMoney.getText().isEmpty()) {
        lableNotification.setText("Máy không có người dùng !");
        displayNotification();
        return;
    }
    
    if (tfPayMoney.getText().isEmpty()) {
        lableNotification.setText("Tiền chưa nhập !");
        displayNotification();
        return;
    }
    
    String text = tfPayMoney.getText().trim();
    if (convertMoney(text)==0.0) {
    	return;
    }else {
        Double number = convertMoney(text);
        
        if (number < 0) {
            lableNotification.setText("Nhập sai mệnh giá tiền !");
            displayNotification();
            return;
        }
        
        if (number < 10000) {
            lableNotification.setText("Tiền nạp vào phải lớn hơn 1000 VND !");
            displayNotification();
            return;
        }
        if (number % 1000 != 0) {
            lableNotification.setText("Tiền nạp vào không lẻ !");
            displayNotification();
            return;
        }
        for (var customer : CustomerDto.getAllCustomers()) {
            if (customer.getPhone().equals(tfPhoneCustomerPanePayMoney.getText().trim())) {
                System.out.println(tfPhoneCustomerPanePayMoney.getText().trim());
            	number += customer.getRemainMoney();
                tfPayMoney.setText("");
                try {
        			tvCustomer.getItems().clear();
        			for(var customer1:CustomerDto.getAllCustomers())
        			{
        				createTableViewCustomer(customer1);
        			}
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
                CustomerDto.addEndUpdateCustomer(
                    customer.getIdCustomer(), customer.getName(), customer.getPhone(),
                    customer.getNameAccount(), customer.getPasswordAccount(),
                    customer.getPointAccount(), customer.getRemainTime(), number
                );
                lableNotification.setText("Nạp tiền thành công");
                String message = "DEPOSIT_MONEY-"+ number;
                
                ClientHandlerManager.getInstance().getClientHandlerByCustomerId(customer.getIdCustomer()).sendMessage(message);
                ClientHandlerManager.getInstance().getClientHandlerByCustomerId(customer.getIdCustomer()).getCustomer().setRemainMoney(number);
                
//                for(Status x:StatusDto.getAllStatus())
//                {
//                	System.out.println(x.getIdCustomer() + customer.getIdCustomer());
//                	if(x.getIdCustomer()==customer.getIdCustomer()) {
//                		System.out.println("vao " +x.getIdCustomer() + customer.getIdCustomer());
//                        ClientHandlerManager.getInstance().getClientHandlerByComputerId(x.getIdComputer()).sendMessage(message);
//                        ClientHandlerManager.getInstance().getClientHandlerByComputerId(x.getIdComputer()).getCustomer().setRemainMoney(number);
//                        break;
//                	}
//                }
                if (checkidTemporaryMoney > 0) {
                    Pane paneToRemove = listPanenotificationDeposit.get(checkidTemporaryMoney);
                    if (paneToRemove != null) {
                        // Xóa khỏi Map và FlowPane
                        listPanenotificationDeposit.remove(checkidTemporaryMoney);
                        int index = flowPanRecharge.getChildren().indexOf(paneToRemove);
                        System.out.println("Index of paneToRemove: " + index); // Kiểm tra xem phần tử có tồn tại không
                        if (index != -1) {
                            flowPanRecharge.getChildren().remove(index);
                        }

                        // Cập nhật giao diện
                        Platform.runLater(() -> {
                            flowPanRecharge.requestLayout();
                            scrollPanerecharge.requestLayout();
                        });
                    }
                }

                displayNotification();
                return;
            }
        }
        lableNotification.setText("Không tìm thấy khách hàng với số điện thoại này !");
        displayNotification();
    }
}

//-----------------------------------Computer--------------------------------------------
//-----------------------------------Menu--------------------------------------------

//tạo sản phẩm thêm vào Flowpane
private void createProduct(Product product)
{
	try {
		Image image=new Image(new ByteArrayInputStream(product.getImageProduct()));
		ImageView imageView=new ImageView(image);
		imageView.setFitWidth(194);
	    imageView.setFitHeight(137);
	    imageView.setLayoutX(0);
	    imageView.setLayoutY(0);
	    
	    Label labelname=new Label(product.getNameProduct());
	    labelname.setStyle(
	    		 "-fx-font-family: 'Arial'; " +
	             "-fx-font-size: 12px; " +
	             "-fx-text-fill: white; " +
	             "-fx-background-color:#000000;");
	     labelname.setPrefWidth(124);  
	     labelname.setPrefHeight(39);
	     labelname.setLayoutX(0);
	     labelname.setLayoutY(141);
	     
	     Label labelPrice=new Label();
	     if(product.getQuantityProduct()==0)
	     {
	    	 labelPrice.setText("Hết sản phẩm");
		     labelPrice.setStyle(
			    		 "-fx-font-family: 'Arial'; " +
			             "-fx-font-size: 12px; " +
			             "-fx-text-fill: white; " +
			             "-fx-background-color:#000000;");
			   labelPrice.setPrefWidth(94);  
			   labelPrice.setPrefHeight(39);
			   labelPrice.setLayoutX(99);
			   labelPrice.setLayoutY(141);
	     }
	     else
	     {
	    	 labelPrice.setText(product.getPriceProduct()+" VND");
		     labelPrice.setStyle(
			    		 "-fx-font-family: 'Arial'; " +
			             "-fx-font-size: 12px; " +
			             "-fx-text-fill: white; " +
			             "-fx-background-color:#000000;");
			   labelPrice.setPrefWidth(94);  
			   labelPrice.setPrefHeight(39);
			   labelPrice.setLayoutX(99);
			   labelPrice.setLayoutY(141);
	     }
		   Pane paneProduct=new Pane();
		   paneProduct.setPrefHeight(181);
		   paneProduct.setPrefWidth(194);
		   paneProduct.setStyle(
			    	"-fx-border-color: black;" + 
		            "-fx-border-width: 1px;");
		   int[] index = {1};
		   paneProduct.setOnMouseClicked(event -> {
			
			   int temporaryNumberProduct=0;
		    	for(var temporary:TemporaryDto.getAllTemporary())
		    	{
		    		if(temporary.getIdProduct()==idProduct)
		    		{
		    			temporaryNumberProduct=temporary.getNumberProduct();
		    			break;
		    		}
		    	}
		       if (tfNameComputerOrder.getText().isEmpty() || tfNameCustomerOrder.getText().isEmpty() ) {
		           lableNotification.setText("Máy không có người dùng !");
		           displayNotification();
		           return;
		       }else if(product.getQuantityProduct()==0)
		       {
		    	   lableNotification.setText("Sản phẩm đã hết !");
		           displayNotification();
		           return;
		       }
		       else {
		    	   idProduct=product.getIdProduct();
		           tfNameProductOrder.setText(product.getNameProduct());
		           tfNumberProductOrder.setText(String.valueOf(index[0]));
		           if(index[0]>product.getQuantityProduct()-temporaryNumberProduct)
		           {
		        	   lableNotification.setText("Số lượng sản phẩm không đủ !");
			           displayNotification();
			           return;
		           }
		           Double sum = product.getPriceProduct() * index[0];
		           tfSumMoneyProductOrder.setText(convertMoneyString(sum));
		           index[0]++;
		       }
		   });
		   paneProduct.getChildren().addAll(imageView,labelname,labelPrice);
		   FlowPaneProductOrder.getChildren().add(paneProduct);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//load toàn bộ sản phẩm lên màn hình 
private void loadProdcut()
{
	try {
		FlowPaneProductOrder.getChildren().clear();
		for(var product:productDto.getAllProducts())
		{
			if(product.isStatusProduct())
			createProduct(product);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//xóa toàn bộ form order
@FXML
private void deleteFormProduct(MouseEvent event)
{
	idProduct=0;
	tfNameComputerOrder.setText("");
	tfNameCustomerOrder.setText("");
	tfPhoneCustomerOrder.setText(null);
	tfNameProductOrder.setText("");
	tfNumberProductOrder.setText("");
	tfSumMoneyProductOrder.setText("");
}
@FXML
private void numberProductOrder(KeyEvent event) throws SQLException {
    try {
        String str = tfNumberProductOrder.getText().trim();
        int temporaryNumberProduct=0;
    	for(var temporary:TemporaryDto.getAllTemporary())
    	{
    		if(temporary.getIdProduct()==idProduct)
    		{
    			temporaryNumberProduct=temporary.getNumberProduct();
    			break;
    		}
    	}
        if (str != null && str.matches("\\d+")) { 
            int number = Integer.parseInt(str);
            
            if (number < 0) {
                return; 
            }
            	else {
                if (idProduct > 0) {
                    for (var product : productDto.getAllProducts()) {
                        if (idProduct == product.getIdProduct()) {
                        	if(number>product.getQuantityProduct()-temporaryNumberProduct)
                        	{
         		        	   lableNotification.setText("Số lượng sản phẩm không đủ !");
         			           displayNotification();
         			           return;
                        	}
                            double sum = product.getPriceProduct() * number;
                            tfSumMoneyProductOrder.setText(convertMoneyString(sum));
                            break;
                        }
                    }
                }
            }
        }
    } catch (NumberFormatException e) {
        e.printStackTrace(); 
    }
}
//thêm sản phẩm 
@FXML
private void AddProductOrder(MouseEvent event)
{
	if(tfNameComputerOrder.getText().isEmpty())
	{
		lableNotification.setText("Máy chưa chọn !");
		displayNotification();
		return;
	}
	if(tfNameCustomerOrder.getText().isEmpty())
	{
		lableNotification.setText("Máy không có người dùng !");
		displayNotification();
		return;
	}
	if(tfNameProductOrder.getText().isEmpty())
	{
		lableNotification.setText("Sản phẩm chưa chọn !");
		displayNotification();
		return;
	}
	if(tfNumberProductOrder.getText().isEmpty())
	{
		lableNotification.setText("Số lượng sản phẩm không được để trống !");
		displayNotification();
		return;
	}
	String str=tfNumberProductOrder.getText();
	int numberProduct=0;
	if (str != null && str.matches("\\d+")) { 
        numberProduct = Integer.parseInt(str);
        if (numberProduct < 0) {
        	lableNotification.setText("Số lượng sản phẩm phải lớn hơn 0 !");
    		displayNotification();
    		return;
        }
	}
	int idCustomer = 0;
	int idProduct = this.idProduct;
	int idStaff = this.idStaff;
	LocalDateTime timeOrder = LocalDateTime.now();
	int idComputer = 0;
	int temporaryNumberProduct=0;
	for(var temporary:TemporaryDto.getAllTemporary())
	{
		if(temporary.getIdProduct()==idProduct)
		{
			temporaryNumberProduct=temporary.getNumberProduct();
			break;
		}
	}
    try {
		for(var product:productDto.getAllProducts())
		{
			if(product.getIdProduct()==idProduct)
			{
				if(numberProduct>(product.getQuantityProduct()-temporaryNumberProduct))
				{
					lableNotification.setText("Số lượng sản phẩm không đủ !");
		    		displayNotification();
		    		return;
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	for (var customer : CustomerDto.getAllCustomers()) {
	    if (customer.getPhone().equals(tfPhoneCustomerOrder.getText())) {
	    	for (Status x:StatusDto.getAllStatus()) {
	            if (x.getIdCustomer() == customer.getIdCustomer()) {
	                idCustomer = x.getIdCustomer();
	                idComputer = x.getIdComputer();
	                break;
	            }
	        }
	        break; 
	    }
	}
	  lableNotification.setText(TemporaryDto.addEndUpdateTemporary(0,0,idCustomer, idProduct, numberProduct, idStaff, timeOrder, idComputer));
	  displayNotification();
	   tfNameProductOrder.setText(null);
	    tfNumberProductOrder.setText(null);
		tfSumMoneyProductOrder.setText(null);
		this.idProduct=0;
	  return;
	
}
//tìm kiếm sản phẩm 
@FXML
private void searchProduct(KeyEvent event)
{
	try {
		String textSearch=tfSearchProduct.getText();
		FlowPaneProductOrder.getChildren().clear();
		for(var product:productDto.getAllProducts())
		{
			if(product.getNameProduct().toLowerCase().contains(textSearch.toLowerCase().trim()))
			{
				createProduct(product);
			}else
			if(textSearch.isEmpty())
			{
				createProduct(product);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//-----------------------------------Menu--------------------------------------------
//-----------------------------------Bill--------------------------------------------
//thêm dữ liệu vào VBOX
private Double addDataFlowPaneBill(String nameCustomer,String phoneCustomer,String nameStaff,String nameComputer,List<TemporaryTimeUserComputer> listTimeUser)
{

	    Label lbNameCustomer = new Label();
	    lbNameCustomer.setText("Khách hàng : " + nameCustomer);
        lbNameCustomer.setPrefWidth(300);
        lbNameCustomer.setPrefHeight(40);
        lbNameCustomer.setStyle( "-fx-font-family: 'Arial'; " +
		             "-fx-font-size: 14px; " +
		             "-fx-text-fill: white; " );
        Label lbNameComputer = new Label();
        lbNameComputer.setText("Máy : " + nameComputer);
        lbNameComputer.setPrefWidth(300);
        lbNameComputer.setPrefHeight(40);
        lbNameComputer.setStyle( "-fx-font-family: 'Arial'; " +
		             "-fx-font-size: 14px; " +
		             "-fx-text-fill: white; " );
        
	    Label lbPhoneCustomer = new Label();
	    lbPhoneCustomer.setText("Số điện thoại : " + phoneCustomer);
	    lbPhoneCustomer.setPrefWidth(300);
        lbPhoneCustomer.setPrefHeight(40);
        lbPhoneCustomer.setStyle( "-fx-font-family: 'Arial'; " +
	             "-fx-font-size: 14px; " +
	             "-fx-text-fill: white; " );

	    Label lbNameStaff = new Label();
	    lbNameStaff.setText("Nhân viên thanh toán : " + nameStaff);
	    lbNameStaff.setPrefWidth(1000);
        lbNameStaff.setPrefHeight(40);
        lbNameStaff.setStyle( "-fx-font-family: 'Arial'; " +
	             "-fx-font-size: 14px; " +
	             "-fx-text-fill: white; " );
        
        Double sumMoneyTime=0.0;
        flowpaneBillClient.getChildren().addAll(lbNameCustomer,lbNameComputer, lbPhoneCustomer, lbNameStaff);
        for(var listtime:listTimeUser)
        {
        	for(var timeUse:TimeUserComputerDto.getAllTimeUserComputers())
        	{
        		if(timeUse.getIdUserComputer()==listtime.getIdTimeUserComputer())
        		{
                	sumMoneyTime+=timeUse.getMoneyUser();
                	Label lbTimeUser1 = new Label();
                	lbTimeUser1.setText("Thời gian sử dụng : " +convertTime(timeUse.getTimeUser())
              	    		);
                	lbTimeUser1.setPrefWidth(300);
                	lbTimeUser1.setPrefHeight(40);
                	lbTimeUser1.setStyle( "-fx-font-family: 'Arial'; " +
              	             "-fx-font-size: 14px; " +
              	             "-fx-text-fill: white; " );
                	Label lbTimeUser2 = new Label();
                	lbTimeUser2.setText("Giá tiền : " + convertMoneyString(timeUse.getMoneyUser()));
                	lbTimeUser2.setPrefWidth(300);
                	lbTimeUser2.setPrefHeight(40);
                	lbTimeUser2.setStyle( "-fx-font-family: 'Arial'; " +
              	             "-fx-font-size: 14px; " +
              	             "-fx-text-fill: white; " );
                	Label lbTimeUser3 = new Label();
                	lbTimeUser3.setText("Thời gian mua : "+listtime.getTimeOrder()
              	    		);
                	lbTimeUser3.setPrefWidth(300);
                	lbTimeUser3.setPrefHeight(40);
                	lbTimeUser3.setStyle( "-fx-font-family: 'Arial'; " +
              	             "-fx-font-size: 14px; " +
              	             "-fx-text-fill: white; " );
                    flowpaneBillClient.getChildren().addAll(lbTimeUser1,lbTimeUser2,lbTimeUser3);
                    break;
        		}
        	}
        }
        LocalDate now= LocalDate.now();
        for(var promotion:PromotionDto.getAllPromotions())
        {
        	Date startDate = promotion.getStartDate(); 
            Date endDate = promotion.getEndDate();
            LocalDate startLocalDate = startDate.toLocalDate(); 
            LocalDate endLocalDate = endDate.toLocalDate();
            if ((now.isEqual(startLocalDate) || now.isAfter(startLocalDate)) && (now.isEqual(endLocalDate) || now.isBefore(endLocalDate))) {
            	Label lbPromotion1 = new Label();
            	lbPromotion1.setText("Mã giảm giá : " + promotion.getNamePromotion());
            	lbPromotion1.setPrefWidth(500);
            	lbPromotion1.setPrefHeight(40);
            	lbPromotion1.setStyle( "-fx-font-family: 'Arial'; " +
         	             "-fx-font-size: 14px; " +
         	             "-fx-text-fill: white; " );
            	
            	Label lbPromotion2 = new Label();
            	lbPromotion2.setText("Tăng : "+promotion.getApplicableLevel()+"% thời gian chơi.");
            	lbPromotion2.setPrefWidth(500);
            	lbPromotion2.setPrefHeight(40);
            	lbPromotion2.setStyle( "-fx-font-family: 'Arial'; " +
         	             "-fx-font-size: 14px; " +
         	             "-fx-text-fill: white; " );
                flowpaneBillClient.getChildren().addAll(lbPromotion1,lbPromotion2);
            }
        }
        Label lbSumMoneyTime = new Label();
        lbSumMoneyTime.setText("Tổng tiền thời gian chơi : " +convertMoneyString(sumMoneyTime));
        lbSumMoneyTime.setPrefWidth(500);
        lbSumMoneyTime.setPrefHeight(40);
        lbSumMoneyTime.setStyle( "-fx-font-family: 'Arial'; " +
 	             "-fx-font-size: 14px; " +
 	             "-fx-text-fill: white; " );
        flowpaneBillClient.getChildren().add(lbSumMoneyTime);
    	return sumMoneyTime;
}
//hiển thị hóa đơn lên table
private Double createTableViewBill(Temporary temporary)
{
	try {
		Button edit=new Button("Xóa");
		edit.setPrefWidth(89.6);
		edit.setMinWidth(50); 
		edit.setMaxWidth(89.6);
		String nameProduct="";
		Double priceProduct=0.0;
		for(var product:productDto.getAllProducts())
		{
			if(product.getIdProduct()==temporary.getIdProduct())
			{
				nameProduct=product.getNameProduct();
				priceProduct=product.getPriceProduct();
				break;
			}
		}
		String nameStaff="";
		for(var staff:StaffDto.getAllStaffs())
		{
			if(staff.getIdStaff()==temporary.getIdStaff())
			{
				nameStaff=staff.getName();
				break;
			}
		}
		LocalDateTime timeOrder=temporary.getTimeOrder();
		String status="";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String timeOrderStr ="";
		 if(timeOrder!=null)
		{
			status="Chưa thanh toán";
			timeOrderStr = timeOrder.format(formatter1);
		}
		 else if(timeOrder==null)
		{
			 LocalDateTime now = LocalDateTime.now();
		     DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		     timeOrderStr = now.format(formatter2);
			 status="Đã thanh toán";
		}
			Double sumNumberProduct=priceProduct*temporary.getNumberProduct();
			TemporaryTableRow tem=new TemporaryTableRow(
					nameProduct,
					convertMoneyString(priceProduct),
					temporary.getNumberProduct(),
					convertMoneyString(sumNumberProduct),
					nameStaff,
					timeOrderStr,
					status,
					edit
					);
			listTemporary.add(tem);
			tcNameProduct.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameProduct()));
			tcPriceProduct.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPriceProduct()));
			tcNumberProduct.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumberProduct()).asObject());
			tcSumNumberProduct.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSumNumberProduct()));
			tcEditProduct.setCellValueFactory(cellData -> new SimpleObjectProperty<Button>(cellData.getValue().getEditProduct()));
			tcNameStaffOrder.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameStaffOrder()));
			tcTimeOrder.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTimeOrder()));
			tcStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));
			tbBill.setItems(listTemporary);
		//xóa hàng này
			edit.setOnMouseClicked(event -> {
			    if (TemporaryDto.deleteTemporary(temporary.getIdTemporary())=="Xóa thông tin thành công !!!") {
			        listTemporary.removeIf(row -> row.getNameProduct().equals(tem.getNameProduct())
			                && row.getNameStaffOrder().equals(tem.getNameStaffOrder())
			                && row.getTimeOrder().equals(tem.getTimeOrder()));
			        tbBill.refresh();
			    }
			});
	    if(timeOrder!=null)
			return sumNumberProduct;
	    else if(timeOrder==null)
		    return 0.0;	
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	return 0.0;
}
//-----------------------------------Bill--------------------------------------------------
//-----------------------------------historyBill--------------------------------------------
//tạo dữ liệu thêm vào bảng historybill
private void createTableViewBillHistory(BillHistory billhistory)
{
	BillHistoryTableRow billData = new BillHistoryTableRow(
	        StaffDto.checkIDTakeNameStaff(billhistory.getIdStaff()),
	        CustomerDto.checkIDCustomerTakeNameCustomer(billhistory.getIdCustomer()),
	        ComputerDto.checkIDComputerTakeNameComputer(billhistory.getIdComputer()),
	        PromotionDto.checkIdPromotionTakeNamePromotion(billhistory.getIdPromotion()),
	        billhistory.getDatePaymentBill(),
	        billhistory.getFormPaymentBill(),
	        convertMoneyString(billhistory.getSumMoneyBill()),
	        null
	    );
	    
	    listBillHistory.add(billData);
	    tcNameCustomerHistoryBill.setCellValueFactory(cellData -> 
	        new SimpleStringProperty(cellData.getValue().getNameCustomer()));
	    tcPhoneCustomerHistoryBill.setCellValueFactory(cellData -> 
	        new SimpleStringProperty(
	            CustomerDto.getAllCustomers().stream()
	                .filter(customer -> customer.getIdCustomer() == billhistory.getIdCustomer())
	                .findFirst()
	                .map(Customer::getPhone)
	                .orElse("")
	        ));
	    tcNameComputerHistoryBill.setCellValueFactory(cellData -> 
	        new SimpleStringProperty(cellData.getValue().getNameComputer()));
	    tcNamePromotionBillHistory.setCellValueFactory(cellData -> 
	        new SimpleStringProperty(cellData.getValue().getNamePromotion()));
	    tcDatePayMentBill.setCellValueFactory(cellData -> 
	        new SimpleStringProperty(cellData.getValue().getDatePaymentBill().toString()));
	    tcSumMoneyHistoryBill.setCellValueFactory(cellData -> 
	        new SimpleStringProperty(cellData.getValue().getSumMoneyBill()));
	    tvHistoryBill.setItems(listBillHistory);
}
//load thông tin lịch sử giao dịch của nhân viên 
private void loadTableViewBillHistoryStaff()
{
	try {
		  tvHistoryBill.getItems().clear();
	        for (var bill : BillHistoryDto.getAllBillHistorys()) {
	            if (bill.getIdStaff() == idStaff) {
	                createTableViewBillHistory(bill);
	            }
	        }
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//thêm thông tin khách hàng vào bảng
private void createTableViewCustomer(Customer customer)
{
	CustomerTableRow rowData=new CustomerTableRow(
			customer.getIdCustomer(),
			customer.getName(),
			customer.getPhone(),
			customer.getNameAccount(),
			customer.getPasswordAccount(),
			customer.getPointAccount(),
			customer.getRemainTime(),
		    customer.getRemainMoney()
		);
	listCustomer.add(rowData);
	tcNameCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameCustomer()));
	tcPhoneCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneCustomer()));
	tcNameAccountCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameAccount()));
	tcPointCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPointAccount()+""));
	tcRemainTimeCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(convertTime(cellData.getValue().getRemainTime())));
	tcRemainMoneyCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(convertMoneyString(cellData.getValue().getRemainMoney())));
	tvCustomer.setItems(listCustomer);
}
//load thông tin khách hàng lên 
private void loadTableviewCustomer()
{
	try {
		tvCustomer.getItems().clear();
		for(var customer:CustomerDto.getAllCustomers())
		{
			createTableViewCustomer(customer);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//tìm kiếm thông tin trong bảng
@FXML
private void searchBillHistoryAndInfor(KeyEvent event) {
    int index1 = cbbSelectBillAndInfor.getSelectionModel().getSelectedIndex();
    int index2 = cbbSelectSearchBillHistoryAnd.getSelectionModel().getSelectedIndex();
    String text = tfSearchBillHistoryAndInfor.getText().trim();
    
    boolean check = false;

    if (index1 == 0) { 
        tvHistoryBill.getItems().clear();
        for (var bill : BillHistoryDto.getAllBillHistorys()) {
            if (bill.getIdStaff() == idStaff) {
                if (index2 == 0) { 
                    String customerName = CustomerDto.checkIDCustomerTakeNameCustomer(bill.getIdCustomer());
                    check = text.isEmpty() || customerName.toLowerCase().contains(text.toLowerCase());
                } else if (index2 == 1) { 
                    String customerPhone = CustomerDto.checkIDCustomerTakePhoneCustomer(bill.getIdCustomer());
                    check = text.isEmpty() || customerPhone.contains(text);
                }
                
                if (check) {
                    createTableViewBillHistory(bill);
                }
                if (cbbSelectSearchBillHistoryAnd.getSelectionModel().getSelectedItem() == null) {
                	createTableViewBillHistory(bill);
               }
            }
        }
    } else if (index1 == 1) { 
        tvCustomer.getItems().clear();
        for (var customer : CustomerDto.getAllCustomers()) {
            if (index2 == 0) { 
                check = text.isEmpty() || customer.getName().toLowerCase().contains(text.toLowerCase());
            } else if (index2 == 1) { 
                check = text.isEmpty() || customer.getPhone().contains(text);
            }
            if (check) {
                createTableViewCustomer(customer);
            }
            if (cbbSelectSearchBillHistoryAnd.getSelectionModel().getSelectedItem() == null) {
            	 createTableViewCustomer(customer);
            }
        }
    }
}
//chọn table hiển thị 
@FXML
private void selectBillAndInfor(ActionEvent event)
{
	int index=cbbSelectBillAndInfor.getSelectionModel().getSelectedIndex();
	if(index==0)
	{
		tvHistoryBill.setVisible(true);
		tvCustomer.setVisible(false);
		loadTableViewBillHistoryStaff();
		lbTitailBillAndCustomer.setText("Lich sử giao dịch");
	}else if(index==1)
	{
		tvHistoryBill.setVisible(false);
		tvCustomer.setVisible(true);
		loadTableviewCustomer();
		lbTitailBillAndCustomer.setText("Danh sách khách hàng");
	}
}
private String formPaymentBill="";
//thanh toán hóa đơn 
@FXML
private void PrintPayBillClient(MouseEvent event) {
    try {
        if (tbBill.getItems().isEmpty() && flowpaneBillClient.getChildren().isEmpty()) {
            lableNotification.setText("Không có dữ liệu thanh toán");
            displayNotification();
            return;
        }
        if(tfSumBillClient.getText().isEmpty() || (convertMoney(tfSumBillClient.getText())==0 && btPrintBillClient.getText().equals("Thanh toán")))
        {
            lableNotification.setText("Không có dữ liệu thanh toán");
            displayNotification();
            return;
        }
        if(btPrintBillClient.getText().equals("Thanh toán"))
        {
        	paneNotification1.setVisible(true);
            lableNotification1.setText("Chọn hình thức thanh toán ?");

            btBankingNotification.setOnMouseClicked(event1 -> {
                formPaymentBill = "Chuyển khoản";
                handlePayment(checkTurn);
            });

            btCashlNotification.setOnMouseClicked(event1 -> {
                formPaymentBill = "Tiền mặt";
                handlePayment(checkTurn);  
            });
        }
        else if(btPrintBillClient.getText().equals("Xác nhận"))
        {
        	 formPaymentBill = "Tài khoản";
        	 handlePayment(checkTurn);
        }
        paneNotification1.setOnMouseClicked(event1 -> {
            paneNotification1.setVisible(false); 
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
}
// thanh toán hóa đơn chi tiết 
private void handlePayment(int turn) {
    try {
        if (formPaymentBill.isEmpty()) {
            return; 
        }
    		  int idCustomer = 0;
    	        for (var customer : CustomerDto.getAllCustomers()) {
    	            if (customer.getPhone().equals(tfPhoneCustomerPanePayMoney.getText())) {
    	                idCustomer = customer.getIdCustomer();
    	                break;
    	            }
    	        } 
    	        int idStaff = this.idStaff;
    	        int idComputer = 0;
    	        int idPromotion = 0;
    	        int applicableLevel=0;
    	        LocalDate currentDate = LocalDate.now();
    	        Date datePaymentBill = Date.valueOf(currentDate);
    	        Double sumMoneyBill = convertMoney(tfSumBillClient.getText());
    	        for(Status x:StatusDto.getAllStatus())
    	        {
    	        	if(x.getIdCustomer()==idCustomer)
    	        	{
    	        		idComputer=x.getIdComputer();
    	        		break;
    	        	}
    	        }
    	        LocalDate now = LocalDate.now();
    	        for (var promotion : PromotionDto.getAllPromotions()) {
    	            Date startDate = promotion.getStartDate();
    	            Date endDate = promotion.getEndDate();
    	            LocalDate startLocalDate = startDate.toLocalDate();
    	            LocalDate endLocalDate = endDate.toLocalDate();
    	            if ((now.isEqual(startLocalDate) || now.isAfter(startLocalDate)) && (now.isEqual(endLocalDate) || now.isBefore(endLocalDate))) {
    	                idPromotion = promotion.getIdPromotion();
    	                applicableLevel=promotion.getApplicableLevel();
    	                break;
    	            }
    	        }
    	        int idLastBillHistory = BillHistoryDto.getLastBillHistoryId();
    	        BillHistoryDto.addEndUpdateBillHistory(0, idCustomer, idStaff, idComputer, idPromotion, datePaymentBill, formPaymentBill, sumMoneyBill);
    	        if (idLastBillHistory > 0) {
    	            idLastBillHistory++;
    	            for (var temporary : TemporaryDto.getAllTemporary()) {
    	                if (temporary.getIdCustomer() == idCustomer && (temporary.getTurn()==turn || turn==0 || temporary.getTurn()==0)) {
    	                    if(btPrintBillClient.getText().equals("Thanh toán"))
    	                    {
    	                    	idProduct=temporary.getIdProduct();
    	                    	Double sumMoneyProduct = temporary.getNumberProduct() * productDto.checkIdProductTakePriceProduct(temporary.getIdProduct());
    	                        DetailBillDto.addEndUpdateDetailBill(0, idLastBillHistory, temporary.getIdProduct(), temporary.getNumberProduct(), sumMoneyProduct);
    	                        productDto.updateProductQuantity(temporary.getIdProduct(), temporary.getNumberProduct());
    	                    }
    	                    TemporaryDto.deleteTemporary(temporary.getIdTemporary());
    	                }
    	            }
    	            for(var temporaryTime:TemporaryTimeUserComputerDto.getAllTemporaryTimeUsers())
    	            {
    	            	if(temporaryTime.getIdCustomer()==idCustomer)
    	            	{
    	            		if(btPrintBillClient.getText().equals("Thanh toán"))
    	            		{
    	            			long timeuser=TimeUserComputerDto.checkIdTakeTimeUserComputer(temporaryTime.getIdTimeUserComputer()).getTimeUser();
    	                	    if(applicableLevel!=0)
    	                	    {
    	                	    	timeuser=timeuser*(100+applicableLevel)/100;
    	                	    }
    	                	    timeuser+=CustomerDto.checkIDCustomerTakeCustomer(idCustomer).getRemainTime();
    	                		CustomerDto.updateTime(idCustomer, timeuser);
    	                		DetailBillTimeUserDto.addEndUpdateDetailBillTimeUser(0, idLastBillHistory, temporaryTime.getIdTimeUserComputer());
    	            		}            		
    	            		TemporaryTimeUserComputerDto.deleteTemporaryTimeUserComputer(temporaryTime.getId());
    	            	}
    	            }
    	        }
        flowpaneBillClient.getChildren().clear();
        tbBill.getItems().clear();
        tfSumBillClient.setText("");
        if(btPrintBillClient.getText().equals("Thanh toán"))
        {
        	lableNotification.setText("Thanh toán thành công .");
        }else
        {
        	lableNotification.setText("Đã xác nhận .");
        }
        if(checkTurn>0)
        {
        	Pane paneToRemove = listPaneNotificationOrder.get(checkTurn);
            if (paneToRemove != null) {
                // Xóa khỏi Map và FlowPane
            	listPaneNotificationOrder.remove(checkTurn);
                int index = flowPaneWaitingService.getChildren().indexOf(paneToRemove);
                System.out.println("Index of paneToRemove: " + index); 
                if (index != -1) {
                	flowPaneWaitingService.getChildren().remove(index);
                }
                // Cập nhật giao diện
                Platform.runLater(() -> {
                	flowPaneWaitingService.requestLayout();
                	scrollOder.requestLayout();
                });
            }
        }
        displayNotification();
        formPaymentBill = "";
        paneNotification1.setVisible(false);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//-----------------------------------historyBill--------------------------------------------
//-----------------------------------Thông báo--------------------------------------------
@FXML
public void clickBell(MouseEvent event)
{
       if(stackPaneNotificationCustomer.isVisible())
       {
    	   stackPaneNotificationCustomer.setVisible(false);
    	  
       }
       else
       {
    	   stackPaneNotificationCustomer.setVisible(true);
       } 
       Color defaultColor = Color.WHITE;
       bell.setFill(defaultColor);
}
public static String calculateTimeDifference(String inputDateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime givenDateTime = LocalDateTime.parse(inputDateTime, formatter);
    LocalDateTime currentDateTime = LocalDateTime.now();
    java.time.Duration duration =  java.time.Duration.between(currentDateTime, givenDateTime);
    long totalSeconds = duration.getSeconds();
    if (totalSeconds < 0) {
        return "Thời điểm đã qua.";
    }

    long hours = totalSeconds / 3600;
    long days = hours / 24;

    if (hours < 24) {
        return hours + " giờ";
    } else {
        return days + " ngày";
    }
}
private int index1=0;
private int index2=0;
//Thông báo Order
//private Label labelStatus;
public void notificationOrder(int idcomputer,boolean isPaid, LocalDateTime time , Order order)
{
	Platform.runLater(() -> {
    Label labelTitle=new Label();
    if(isPaid)
    {
    	labelTitle.setText("Gọi Đồ (Đã thanh toán)");
    }
    else
    {
    	labelTitle.setText("Gọi Đồ (Chưa thanh toán)");
    }
    labelTitle.setStyle(
    	    "-fx-font-family: 'Arial'; " +
    	    "-fx-font-size: 14px; " +
    	    "-fx-font-weight: bold; " +
    	    "-fx-text-fill: white;"
    	    +
    	    "-fx-smoothing-type: lcd;"
    	);
    labelTitle.setLayoutX(5); 
    labelTitle.setLayoutY(5);
    Label labelNameComputer=new Label();
    String nameComputer=ComputerDto.checkIDComputerTakeNameComputer(idcomputer);
    labelNameComputer.setText(nameComputer);
    labelNameComputer.setStyle(
    	    "-fx-font-family: 'Arial'; " +
    	    "-fx-font-size: 14px; " +
    	    "-fx-text-fill: white;"
    	);
    labelNameComputer.setLayoutX(350); 
    labelNameComputer.setLayoutY(5);
    Label labelTime=new Label();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    labelTime.setText(time.format(formatter));
    labelTime.setStyle(
        "-fx-font-family: 'Arial'; " +
        "-fx-font-size: 12px; " +
        "-fx-text-fill: white;"
    );
    labelTime.setLayoutX(5); 
    labelTime.setLayoutY(30);
    Label labelStatus=new Label();
    labelStatus.setText("Mới");
    labelStatus.setStyle(
        "-fx-font-family: 'Arial'; " +
        "-fx-font-size: 12px; " +
        "-fx-text-fill: white;"
    );
    labelStatus.setLayoutX(350); 
    labelStatus.setLayoutY(30);
    
    Pane underline = new Pane();
    underline.setPrefWidth(450); 
    underline.setPrefHeight(1);
    underline.setStyle("-fx-background-color: #ffffff;");
    underline.setLayoutX(5); 
    underline.setLayoutY(50);
    
    Pane pane = new Pane();
    pane.setPrefWidth(460);
    pane.setPrefHeight(60);
    pane.getChildren().addAll(labelTitle, labelNameComputer, labelTime, labelStatus,underline);
    int idcustomer1=0;
    for(Status x:StatusDto.getAllStatus())
    {
    	if(x.getIdComputer()== idcomputer)
    	{
    		idcustomer1=x.getIdCustomer();
    	}
    }
    Timestamp timestamp = Timestamp.valueOf(time);
    Date date = new Date(timestamp.getTime());
    int idBillHistory=BillHistoryDto.getLastBillHistoryId();
    if(isPaid)//đã thanh toán
    {
    	BillHistoryDto.addEndUpdateBillHistory(
    			0, 
    			idcustomer1,
    			idStaff,
    			idcomputer,
    			0,
    			date, 
    			"Tài khoản",
    			order.getTotalCost());
    	
    }
    idBillHistory++;
    for(Map.Entry<Product, OrderItem> y:order.getItems().entrySet())
    {
    	 if(isPaid)//đã thanh toán
         {
         	DetailBillDto.addEndUpdateDetailBill(0,idBillHistory, y.getValue().getItem().getIdProduct(), y.getValue().getQuantity(), y.getValue().getTotalPrice());
         }

    }
    turn++;
    if(labelStatus.getText().equals("Mới"))
    {
    	for(Map.Entry<Product, OrderItem> x:order.getItems().entrySet())
        {
    		if(isPaid)
    		{
    			TemporaryDto.addEndUpdateTemporary(0,turn, idcustomer1, x.getValue().getItem().getIdProduct(), x.getValue().getQuantity(), idStaff, null, idcomputer);
    		}else
    		{
    			TemporaryDto.addEndUpdateTemporary(0,turn, idcustomer1, x.getValue().getItem().getIdProduct(), x.getValue().getQuantity(), idStaff, time, idcomputer);
    		}              
        }
    }
    pane.setUserData(turn);
    listPaneNotificationOrder.put(turn, pane);
    pane.setOnMouseClicked(event->{
    	stackPaneNotificationCustomer.setVisible(false);
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
        for(Map.Entry<FontAwesomeIcon, Separator> x:list1.entrySet())
        {
        	x.getKey().setFill(Color.WHITE);
        	x.getValue().setVisible(false);
        }
        for(Map.Entry<Separator, AnchorPane> x:list2.entrySet())
        {
        	x.getKey().setVisible(false);
        	x.getValue().setVisible(false);
        }
        h4.setVisible(true);
        formClient.setVisible(true);
        client.setFill(Color.RED);
        int idcustomer2=0;
        for(Status x:StatusDto.getAllStatus())
        {
        	if(x.getIdComputer()== idcomputer)
        	{
        		idcustomer2=x.getIdCustomer();
        	}
        }
        if(isPaid)
        {
        	btPrintBillClient.setText("Xác nhận");
        }else
        {
        	btPrintBillClient.setText("Thanh toán");
        }
        tfNameComputerPanePayMoney.setText(nameComputer);
        tfNameCustomerPanePayMoney.setText(CustomerDto.checkIDCustomerTakeNameCustomer(idcustomer2));
        tfPhoneCustomerPanePayMoney.setText(CustomerDto.checkIDCustomerTakePhoneCustomer(idcustomer2));
        int storedTurn = (int) pane.getUserData();
        checkTurn=storedTurn;
        payBillNotication(checkTurn);
        labelStatus.setText("Đã xem");
    });
    
    pane.setOnMouseEntered(event -> {
        pane.setStyle("-fx-border-color: white; -fx-border-width: 1;");
        pane.setEffect(new DropShadow(10, Color.web("#303030")));
    });
    pane.setOnMouseExited(event -> {
        pane.setStyle("-fx-border-color: white; -fx-border-width: 0;");
        pane.setEffect(null);
    });
    Color red = Color.RED;  
    Color defaultColor = Color.WHITE;
    bell.setFill(red);
    String index = numberNotification1.getText().substring(1, numberNotification1.getText().length() - 1);
    index1=Integer.parseInt(index)+1;
    numberNotification1.setText("("+index1+")");
    flowPaneWaitingService.getChildren().add(pane);
    scrollOder.layout();
	});
	}
//Thông báo nạp tiền 
public void notificationDeposit(int idcomputer, LocalDateTime time,Double number) {
    Platform.runLater(() -> {
    	TemporaryMoneyDto.addTemporaryMoney(idcomputer, time, number);
        Label labelTitle = new Label("Nạp tiền");
        labelTitle.setStyle(
        		 "-fx-font-family: 'Arial'; " +
        		    	    "-fx-font-size: 14px; " +
        		    	    "-fx-font-weight: bold; " +
        		    	    "-fx-text-fill: white;"
        );
        labelTitle.setLayoutX(5); 
        labelTitle.setLayoutY(5);

        Label labelNameComputer = new Label(ComputerDto.checkIDComputerTakeNameComputer(TemporaryMoneyDto.getTemporaryMoneyById(TemporaryMoneyDto.getLastTemporaryMoneyId()).getidComputer()));
        labelNameComputer.setStyle(
            "-fx-font-family: 'Arial'; " +
            "-fx-font-size: 14px; " +
            "-fx-text-fill: white;"
        );
        labelNameComputer.setLayoutX(5); 
        labelNameComputer.setLayoutY(30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        Label labelTime = new Label(TemporaryMoneyDto.getTemporaryMoneyById(TemporaryMoneyDto.getLastTemporaryMoneyId()).getTimeOrder().format(formatter));
        labelTime.setStyle(
            "-fx-font-family: 'Arial'; " +
            "-fx-font-size: 12px; " +
            "-fx-text-fill: white;"
        );
        labelTime.setLayoutX(150); 
        labelTime.setLayoutY(5);

        Label labelStatus = new Label("Mới");
        labelStatus.setStyle(
            "-fx-font-family: 'Arial'; " +
            "-fx-font-size: 12px; " +
            "-fx-text-fill: white;"
        );
        labelStatus.setLayoutX(150); 
        labelStatus.setLayoutY(30);
        
        Label labelMoney = new Label(convertMoneyString(TemporaryMoneyDto.getTemporaryMoneyById(TemporaryMoneyDto.getLastTemporaryMoneyId()).getMoney()));
        labelMoney.setStyle(
            "-fx-font-family: 'Arial'; " +
            "-fx-font-size: 12px; " +
            "-fx-text-fill: white;"
            +
    	    "-fx-font-weight: bold; "
        );
        labelMoney.setLayoutX(350); 
        labelMoney.setLayoutY(20);

        Pane underline = new Pane();
        underline.setPrefWidth(450); 
        underline.setPrefHeight(1);
        underline.setStyle("-fx-background-color: #ffffff;");
        underline.setLayoutX(5); 
        underline.setLayoutY(50);
        
        Pane pane = new Pane();
        pane.setPrefWidth(460);
        pane.setPrefHeight(60);
        pane.getChildren().addAll(labelTitle, labelNameComputer, labelTime, labelStatus,labelMoney,underline);
        pane.setUserData(TemporaryMoneyDto.getLastTemporaryMoneyId());
        listPanenotificationDeposit.put(TemporaryMoneyDto.getLastTemporaryMoneyId(), pane);
        pane.setOnMouseClicked(event->{
        	int storedTurn = (int) pane.getUserData();
        	stackPaneNotificationCustomer.setVisible(false);
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
	        for(Map.Entry<FontAwesomeIcon, Separator> x:list1.entrySet())
	        {
	        	x.getKey().setFill(Color.WHITE);
	        	x.getValue().setVisible(false);
	        }
	        for(Map.Entry<Separator, AnchorPane> x:list2.entrySet())
	        {
	        	x.getKey().setVisible(false);
	        	x.getValue().setVisible(false);
	        }
	        h1.setVisible(true);
	        formComputer.setVisible(true);
	        computer.setFill(Color.RED);
		    tfPayMoney.setText(convertMoneyString(TemporaryMoneyDto.getTemporaryMoneyById(storedTurn).getMoney()));
	        for(Map.Entry<Integer, Pane> x:computerPaneMap.entrySet())
	        {
	        	if(x.getKey()== TemporaryMoneyDto.getTemporaryMoneyById(storedTurn).getidComputer())
	        	{
	        		x.getValue().setOnMouseClicked(event1->{
	    		    	paneClick(ComputerDto.getComputer(TemporaryMoneyDto.getTemporaryMoneyById(storedTurn).getidComputer()),x.getValue());
	    		    	btImportMoney.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, false, false, null));
	        		});
	        		x.getValue().fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, false, false, null));
	        	}
	        }
	        checkidTemporaryMoney=storedTurn;
	        labelStatus.setText("Đã xem");
        });
        pane.setOnMouseEntered(event -> {
            pane.setStyle("-fx-border-color: white; -fx-border-width: 1;");
            pane.setEffect(new DropShadow(10, Color.web("#303030")));
        });
        pane.setOnMouseExited(event -> {
            pane.setStyle("-fx-border-color: white; -fx-border-width: 0;");
            pane.setEffect(null);
        });
        Color red = Color.RED;  
        Color defaultColor = Color.WHITE;
        bell.setFill(red);
        String index = numberNotification2.getText().substring(1, numberNotification2.getText().length() - 1);
        index2=Integer.parseInt(index)+1;
        numberNotification2.setText("("+index2+")");
        flowPanRecharge.getChildren().add(pane);
        scrollPanerecharge.layout();
    });
}

}