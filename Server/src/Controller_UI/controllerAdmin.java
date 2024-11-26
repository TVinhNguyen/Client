package Controller_UI;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import Controller.Server;
import Dto.BillHistoryDto;
import Dto.CategoryDto;
import Dto.ComputerDto;
import Dto.CustomerDto;
import Dto.DetailBillDto;
import Dto.NewDto;
import Dto.PayMentDto;
import Dto.PromotionDto;
import Dto.RoleDto;
import Dto.StaffDto;
import Dto.TimeUserComputerDto;
import Dto.productDto;
import Model.BillHistory;
import Model.BillHistoryTableRow;
import Model.Category;
import Model.Computer;
import Model.Customer;
import Model.CustomerTableRow;
import Model.DetailBillTableRow;
import Model.New;
import Model.PayMent;
import Model.PayMentTableRow;
import Model.Product;
import Model.Promotion;
import Model.PromotionTableRow;
import Model.Staff;
import Model.StaffTableRow;
import Model.TimeUserComputer;
import Model.TimeUserComputerTableRow;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class controllerAdmin {
@FXML
private Label lableTime;
@FXML
private Label lableNotification;
@FXML
private Label lbNameCustomer;
@FXML
private Label lbNameComputer;
@FXML
private Label lbTimeUserComputer;
@FXML
private Label lbSumBillHistory;
@FXML
private Label lbViewSaleEndView;
@FXML
private Label lbSumPayMent;
@FXML
private Label lbtTitleStaff;
@FXML
private VBox vboxNodeChartCOmputer;
@FXML
private FontAwesomeIcon close;
@FXML
private FontAwesomeIcon minus;
@FXML
private FontAwesomeIcon menu;
@FXML
private FontAwesomeIcon computer;
@FXML
private FontAwesomeIcon history;
@FXML
private FontAwesomeIcon client;
@FXML
private FontAwesomeIcon staff;
@FXML
private FontAwesomeIcon sale;
@FXML
private FontAwesomeIcon revenue;
@FXML
private FontAwesomeIcon bell;
@FXML
private FontAwesomeIcon setting;
@FXML 
private Separator h1;
@FXML 
private Separator h2;
@FXML 
private Separator h3;
@FXML 
private Separator h4;
@FXML 
private Separator h5;
@FXML
private Separator h6;
@FXML 
private Separator h7;
@FXML
private AnchorPane formClient;

@FXML
private AnchorPane formComputer;

@FXML
private AnchorPane formHistory;

@FXML
private AnchorPane formMenu;

@FXML
private AnchorPane formRevenue;

@FXML
private AnchorPane formSale;

@FXML
private AnchorPane formStaff;

@FXML
private AnchorPane chartComputer;

@FXML
private AnchorPane chartPayMent;

@FXML
private AnchorPane chartGuest;

@FXML
private AnchorPane chartRevenue;

@FXML
private AnchorPane payment;

@FXML
private AnchorPane paneShowProduct;

@FXML
private ComboBox<String> comboboxSelectChart;

@FXML
private ComboBox<String> comboboxSelectRevenue;

@FXML
private ComboBox<String> cbbCategoryMenuProduct;

@FXML
private ComboBox<String> cbbCategoryMenuProduct1;

@FXML
private ComboBox<String> cbbnameRole;

@FXML
private ComboBox<String> cbbStatusPromotion;

@FXML
private ComboBox<String> cbbSelectPromotion;

@FXML
private ComboBox<String> cbbSelectCustomer;

@FXML
private ComboBox<String> cbbSelectBillHistory;

@FXML
private ComboBox<String> comboboxSelectGuest;

@FXML
private ComboBox<String> comboboxShowSaleEndNew;

@FXML
private ComboBox<String> comboboxSelectPayMent;

@FXML
private ComboBox<String> comboboxSearchStaff;

@FXML
private ComboBox<String> comboboxSelectComputerAndTimeUser;

@FXML
private FlowPane flowPaneProduct;

@FXML
private FlowPane flowPaneComputer;

@FXML
private FlowPane flowpaneViewNew;
@FXML
private Pane imageMenuProduct;

@FXML
private Pane paneAddEndUpdatePromotion;

@FXML
private Pane paneAddEndUpdateCustomer;

@FXML
private Pane paneShowBillHistory;

@FXML
private Pane paneImageNew;

@FXML
private Pane paneAddEndUpdateNew;

@FXML
private Pane paneNotification;

@FXML
private TextField idMenuProduct;

@FXML
private TextField priceMenuProduct;

@FXML
private TextField nameMenuProduct;

@FXML
private TextField quantityMenuProduct;

@FXML
private TextField searchMenuProduct;

@FXML 
private TextField tfIdComputer;

@FXML
private TextField tfNameComputer;

@FXML
private TextField searchComputer;

@FXML
private TextField tfidStaff;

@FXML
private TextField tfnameStaff;

@FXML
private TextField tfphoneStaff;

@FXML
private TextField tfaddressStaff;

@FXML
private TextField tfaccountStaff;

@FXML
private TextField tfpasswordStaff;

@FXML
private TextField tfdayWork;

@FXML 
private TextField searchStaff;

@FXML
private TextField tfIdPromotion;

@FXML
private TextField tfNamePromotion;

@FXML 
private TextField tfApplicablePromotion;

@FXML
private TextField tfNodePromotion;

@FXML 
private TextField searchPromotion;

@FXML
private TextField searchCustomer;

@FXML
private TextField tfIdCustomer;

@FXML
private TextField tfNameCustomer;

@FXML
private TextField tfPhoneCustomer;

@FXML 
private TextField tfPointCustomer;

@FXML
private TextField tfNameAccount;

@FXML
private TextField tfPasswordAccount;

@FXML
private TextField tfHourRemainTime;

@FXML
private TextField tfMinuteRemainTime;

@FXML
private TextField tfSecondRemainTime;

@FXML
private TextField tfSearchBillHistory;

@FXML
private TextField tfSumMoneyBill;

@FXML
private TextField tfRemainMoney;

@FXML
private TextField tfTatleNew;

@FXML
private TextField tfTimeNew;

@FXML
private TextField tfContentNew;

@FXML
private TextField tfNamePayMent;

@FXML
private TextField tfValuePayMent;

@FXML
private TextField tfNodePayment;

@FXML
private TextField tfSearchPayMent;

@FXML
private TextField tfHouseTimeUser;

@FXML
private TextField tfMinuteTimeUser;

@FXML
private TextField tfSecondTimeUser;

@FXML
private TextField tfMoneyTimeUser;

@FXML
private Button btCancelNotification;

@FXML
private Button btOkNotification;

@FXML
private Button btExitPromotion;

@FXML
private Button btOkPromotion;

@FXML
private Button btExitCustomer;

@FXML
private Button btOkCustomer;

@FXML
private Button addCustomer;

@FXML
private Button btExitBillHistory;

@FXML
private Button searchLineCharRevenue;

@FXML
private Button btSearchBarCharGuest;

@FXML
private Button btsearchpieChartComputer;

@FXML
private Button btAddImageNew;

@FXML
private Button btExitNew;

@FXML
private Button btOkNew;

@FXML 
private Button resrtComputer;

@FXML
private Button resetTimeUser;

@FXML
private RadioButton rbOn;

@FXML
private RadioButton rbOff;

@FXML
private RadioButton rbMaintenance;

@FXML
private TableColumn<StaffTableRow, String> nameRole;

@FXML
private TableColumn<StaffTableRow, String> nameStaff;

@FXML
private TableColumn<StaffTableRow, String> phoneStaff;

@FXML
private TableColumn<StaffTableRow, Integer> dayWork;

@FXML
private TableColumn<StaffTableRow, Button> show;

@FXML
private TableColumn<PromotionTableRow,Integer> idPromotion;

@FXML
private TableColumn<PromotionTableRow, String> namePromotion;

@FXML
private TableColumn<PromotionTableRow, String> applicableLevel;

@FXML
private TableColumn<PromotionTableRow, Date> startDate;

@FXML
private TableColumn<PromotionTableRow, Date> endDate;

@FXML
private TableColumn<PromotionTableRow, String> statusPromotion;

@FXML
private TableColumn<PromotionTableRow, Button> showPromotion;

@FXML
private TableColumn<CustomerTableRow,Integer> idCustomer;

@FXML
private TableColumn<CustomerTableRow,String> nameCustomer;

@FXML
private TableColumn<CustomerTableRow, String> phoneCustomer;

@FXML
private TableColumn<CustomerTableRow, String> nameAccount;

@FXML
private TableColumn<CustomerTableRow, String> passwordAccount;

@FXML
private TableColumn<CustomerTableRow, Integer> pointAccount;

@FXML
private TableColumn<CustomerTableRow, Long> remainTime;

@FXML
private TableColumn<CustomerTableRow, Button> showCustomer;

@FXML
private TableColumn<BillHistoryTableRow, String> nameStaffBillHistory;

@FXML
private TableColumn<BillHistoryTableRow, String> nameCustomerBillHistory;

@FXML
private TableColumn<BillHistoryTableRow, String> nameComputerbillHistory;

@FXML
private TableColumn<BillHistoryTableRow, String> namePromotionBillHistory;

@FXML
private TableColumn<BillHistoryTableRow, Date> datePaymentBill;

@FXML
private TableColumn<BillHistoryTableRow, String> formPaymentBill;

@FXML
private TableColumn<BillHistoryTableRow, String> sumMoneyBull;

@FXML
private TableColumn<BillHistoryTableRow, Button> showBillHistory;

@FXML
private TableColumn<DetailBillTableRow, Integer> numberProductDetailBill;

@FXML
private TableColumn<DetailBillTableRow, String> nameProductDetailBill;

@FXML
private TableColumn<DetailBillTableRow, Integer> quantityProductDetailBill;

@FXML
private TableColumn<DetailBillTableRow, String> sumMoneyProductDetailBill;

@FXML
private TableColumn<TimeUserComputerTableRow, Integer> indexTimeUser;

@FXML
private TableColumn<TimeUserComputerTableRow, String> timeUser;

@FXML
private TableColumn<TimeUserComputerTableRow, String> moneyUser;

@FXML
private TableColumn<TimeUserComputerTableRow, Button> showThimeUser;

@FXML
private TableColumn<TimeUserComputerTableRow, Button> deleteTimeUser;

@FXML
private TableColumn<PayMentTableRow, String> namePayMent;

@FXML
private TableColumn<PayMentTableRow, String> valuePayMent;

@FXML
private TableColumn<PayMentTableRow, String>  nodePayMent;

@FXML
private TableColumn<PayMentTableRow, Button> buttonPayMent;

@FXML
private TableView<StaffTableRow> tableViewStaff;

@FXML
private TableView<PromotionTableRow> tableViewPromotion;

@FXML
private TableView<CustomerTableRow> tableViewCustomer;

@FXML
private TableView<BillHistoryTableRow> tableViewBillHistory;

@FXML 
private TableView<DetailBillTableRow> tableViewDetailBill;

@FXML
private TableView<PayMentTableRow> tablePayMent;

@FXML
private TableView<TimeUserComputerTableRow> tableViewTimeUserComputer;

@FXML
private DatePicker dptimeStartWork;

@FXML
private DatePicker dpStartDate;

@FXML 
private DatePicker dpEndDate;

@FXML 
private DatePicker dpStartBillHistory;

@FXML 
private DatePicker dpEndBillHistory;

@FXML
private DatePicker dpStartLineChartRevenue;

@FXML
private DatePicker dpEndLineChartRevenue;

@FXML
private DatePicker dpStartBarChartGuest;

@FXML
private DatePicker dpEndBarChartGuest;

@FXML
private DatePicker dpStartpieChartComputer;

@FXML
private DatePicker dpEndPieChartComputer;

@FXML
private DatePicker dpImportDate;

@FXML
private DatePicker dpStartPayMent;

@FXML
private DatePicker dpEndPayMent;

@FXML
private LineChart<String, Number> lineChartRevenue;

@FXML
private BarChart<String, Integer> barChartGuest;

@FXML
private PieChart PieChartComputer;

@FXML
private LineChart<String, Number> lineChartPayMent;

@FXML
private ScrollPane scrollPaneViewNew;

@FXML
private ScrollPane scrollPaneViewSale;

@FXML
private ScrollPane scrollPaneComputer;

private byte[] imagePromotion=null;

private byte[] imageNew=null;

//private Server server;

private int idNew=0;

private int idPayMent=0;

private int idTimeUser=0;

ObservableList<StaffTableRow> staffList=FXCollections.observableArrayList();

ObservableList<PromotionTableRow> promotionList=FXCollections.observableArrayList();

ObservableList<CustomerTableRow> customerList=FXCollections.observableArrayList();

ObservableList<BillHistoryTableRow> billHistoryList=FXCollections.observableArrayList();

ObservableList<DetailBillTableRow> detailBillList=FXCollections.observableArrayList();

ObservableList<PayMentTableRow> payMentList=FXCollections.observableArrayList();

ObservableList<TimeUserComputerTableRow> timeUserList=FXCollections.observableArrayList();

//public controllerAdmin() {
//	this.server = new Server(this);
//	new Thread(server).start();
//}

@FXML
public void initialize()
{
	 updateTime();
	 setHoverEffect(close);//chức năng đóng cửa sổ
     setHoverEffect(minus);//chức năng thu nhỏ cửa sổ
     setHoverMenu(bell);
     setHoverMenu(setting);
     
     FontAwesomeIcon[] listMenu= {menu,computer,history,client,sale,staff,revenue};
	 Separator[] listRow= {h1,h2,h3,h4,h5,h6,h7};
	 AnchorPane[] listAnchorPane= {formMenu,formComputer,formHistory,formClient,formSale,formStaff,formRevenue};
	 
	 Map<FontAwesomeIcon, Separator> list1=new HashMap<FontAwesomeIcon, Separator>();
	 list1.put(menu, h1);
     list1.put(computer, h2);
     list1.put(history, h3);
     list1.put(client, h4);
     list1.put(sale, h5);
     list1.put(staff, h6);
     list1.put(revenue, h7);
     Map<Separator, AnchorPane> list2=new HashMap<Separator, AnchorPane>();
     list2.put(h1, formMenu);
     list2.put(h2, formComputer);
     list2.put(h3, formHistory);
     list2.put(h4, formClient);
     list2.put(h5, formSale);
     list2.put(h6, formStaff);
     list2.put(h7,formRevenue);
     
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
     comboboxChart(comboboxSelectChart,
    		       comboboxSelectPayMent,
    		       comboboxSelectRevenue,
    		       comboboxSelectGuest);
     //sự kiện combobox hiện màn hình thống kê
     AnchorPane[] listChart= {chartRevenue,chartGuest,chartPayMent,chartComputer,payment};
     listChart[0].setVisible(true);
     comboboxSelectChart.setOnAction(event -> {
    		for(AnchorPane x: listChart)
    		{
    			x.setVisible(false);
    		}
    		String value=comboboxSelectChart.getValue();
    		try {
    			int i=comboboxSelectChart.getItems().indexOf(value);
    			listChart[i].setVisible(true);
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}	
     });
     
     //thêm pane cho flowpane của menu
     loadProductToFlowPane();
     //thêm phân loại sản phẩm vào combobox menu
     loadComboboxCategory(cbbCategoryMenuProduct1);
     loadComboboxCategory(cbbCategoryMenuProduct);
     //thêm pane cho flowpane của computer
     loadComputerAndLable();
     //load bảng nhân viên
     loadTableStaff();
     //load bảng khuyến mãi
     loadTablePromotion();
     //load bảng khách hàng
     loadTableCustomer();
     //load bảng lịch sử mua hàng
     loadTableBillHistory();   
     //load biểu đồ thu nhập theo ngày 
     createLineChartRevenueDay();
     //load biểu đồ lượng người theo ngày
     createBarChartGuest(BillHistoryDto.getTotalCustomersByDate(), "Lượng khách trong ngày");
     //load biểu đồ thông số sử dụng máy
     showPieChartComputer();
     //load combobbox của sale
     createDataComboboxSaleAndNew();
     //thêm lựa chọn cho khuyến mãi 
 	ObservableList<String> listSelectPromtion=FXCollections.observableArrayList();
     listSelectPromtion.addAll("Mã khuyến mãi","Tên khuyến mãi","Mức áp dụng","Trạng thái");
     cbbSelectPromotion.setItems(listSelectPromtion);
     //load Thông báo
     loadViewNew();
     //load thông tin lên bảng payment
     loadTablePayMent();
     //load biểu đồ chi tiêu 
     createLineChartPayMent(PayMentDto.getTotalValueByDate(),"Chi tiêu ngày");
     //load bảng tính tiền thời gian sử dụng máy 
     loadTableTimeUserComputer();
     //xóa form computer và timeuser
     resetFormCOmputerAndTimeUser();
}
//hiển thị tên admin lên thanh tiêu đề
public void receiveAdminInfo(int idStaff) {
	try {
      if (lbtTitleStaff != null) {
      	for(var staff:StaffDto.getAllStaffs())
      	{
      		if(staff.getIdStaff()==idStaff)
      		{
      			 lbtTitleStaff.setText(RoleDto.checkIDTakeNameRole(staff.getIdRole()).toUpperCase()+"   "+staff.getName().toUpperCase());
      		     break;
      		}
      	}
          
      }
  } catch (Exception e) {
      e.printStackTrace();
  }
}
private void comboboxChart(ComboBox<String> comboboxSelectChart,
		                   ComboBox<String> comboboxSelectPayMent,
		                   ComboBox<String> comboboxSelectRevenue,
		                   ComboBox<String>  comboboxSelectGuest)
{
    
	 //Thêm các tùy chọn danh sách thống kê 
        ObservableList<String> chartTypes = FXCollections.observableArrayList(
            "Thống kê thu", "Thông số khách", "Thống kê chi", "Tỉ lệ chọn máy"
        );
        comboboxSelectChart.setItems(chartTypes);
        comboboxSelectChart.setValue("Thống kê thu");
        
        ObservableList<String> x = FXCollections.observableArrayList(
                "Ngày", "Tháng"
            );
        comboboxSelectRevenue.setItems(x);
        comboboxSelectPayMent.setItems(x);  
        comboboxSelectGuest.setItems(x);
        comboboxSelectRevenue.getSelectionModel().select(0);
        comboboxSelectPayMent.getSelectionModel().select(0);
        comboboxSelectGuest.getSelectionModel().select(0);
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
//sự kiện khi di chuột tới 
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
private void showForm(MouseEvent event)
{
	 AnchorPane[] listChart= {chartRevenue,chartGuest,chartPayMent,chartComputer};
	 for(AnchorPane chart:listChart)
	 {
		 chart.setVisible(false);
	 }
	 comboboxSelectChart.setValue(null);
	 payment.setVisible(true);
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
//chuyển từ mã khuyến mãi về số 
private int convertInt(String text) {
    int applicableLevel = 0;
    try {
        boolean check = true;
        if (text.contains("%")) {
            text = text.replace("%", "").trim();
        }
        if (text.matches("\\d+")) {
            applicableLevel = Integer.parseInt(text);
            if (applicableLevel > 100 || applicableLevel < 0) {
                lableNotification.setText("Nhập sai số liệu mức áp dụng !!!");
                check = false;
            }
        } else {
            lableNotification.setText("Nhập sai số liệu mức áp dụng !!!");
            check = false;
        }
        if (!check) {
            paneNotification.setVisible(true);
            btCancelNotification.setVisible(true);
            btCancelNotification.setOnMouseClicked(event -> {
                paneNotification.setVisible(false);
            });
            btOkNotification.setVisible(false);
        }
    } catch (NumberFormatException e) {
        e.printStackTrace();
        lableNotification.setText("Đã xảy ra lỗi khi chuyển đổi chuỗi !!!");
        paneNotification.setVisible(true);
        btCancelNotification.setVisible(true);
        btCancelNotification.setOnMouseClicked(event -> {
            paneNotification.setVisible(false);
        });
        btOkNotification.setVisible(false);
    }
    return applicableLevel;
}

//----------------------------------MeNu---------------------------
//load giao diện sản phẩm
private void loadProductToFlowPane()
{
	flowPaneProduct.getChildren().clear();
	try {
		List<Product> products=Dto.productDto.getAllProducts();
		for(var product:products)
		{
			if(product.isStatusProduct())
			createImage(product.getNameProduct(), product.getImageProduct(),flowPaneProduct,product.getIdProduct());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//tạo ra giao diện chức sản phẩm 
private void createImage(String nameProduct, byte[] imageProduct,FlowPane flowPane , int idProduct)
{
	
	try {
		 Image image = new Image(new ByteArrayInputStream(imageProduct));
	     ImageView imageView = new ImageView(image);
	     imageView.setFitWidth(197);
	     imageView.setFitHeight(113);
	     
	     Label label=new Label(nameProduct);
	     label.setStyle(
	    		 "-fx-font-family: 'Arial'; " +
	             "-fx-font-size: 14px; " +
	             "-fx-text-fill: white; " +
	             "-fx-alignment: center;");
	     label.setPrefWidth(190);  
	     label.setPrefHeight(25);
	     label.setAlignment(Pos.CENTER);
	     
	     Pane productPane=new Pane();
	     productPane.setStyle(
	    	"-fx-border-color: black;" + 
            "-fx-border-width: 1px;");
	     productPane.setPrefHeight(195);
	     productPane.setPrefWidth(240);
	     
	     imageView.setLayoutX(23);
	     imageView.setLayoutY(25);
	     label.setLayoutX(28);
	     label.setLayoutY(161);
	     
	     productPane.getChildren().addAll(imageView,label);
	     //sự kiện khi click vào pane
	     productPane.setOnMouseClicked(event ->{
	    	List<Product> products;
			try {
				paneShowProduct.setVisible(true);
				products = Dto.productDto.getAllProducts();
				for(var product:products)
		 		{
		 			if(product.getIdProduct()==idProduct && product.isStatusProduct())
		 			{
		 				idMenuProduct.setText(product.getIdProduct()+"");
		 				nameMenuProduct.setText(product.getNameProduct());
		 				priceMenuProduct.setText(convertMoneyString(product.getPriceProduct()));
		 				quantityMenuProduct.setText(product.getQuantityProduct()+"");
		 				cbbCategoryMenuProduct.setValue(CategoryDto.getNameCategoryProduct(product.getIdCategory()));
		 			    loadImage(product.getImageProduct());
		 				break;
		 			}
		 		}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	     });
	     flowPane.getChildren().add(productPane);
	} catch (Exception e) {
		e.printStackTrace();
	}  
}
//Thêm hình ảnh khi click vào pane
private void loadImage(byte[] image)
{
	    imagePromotion=image;
	    Image image1=new Image(new ByteArrayInputStream(image));
	    ImageView imageMenu = new ImageView(image1);
	    imageMenu.setFitWidth(284);
	    imageMenu.setFitHeight(150);
	    imageMenu.setLayoutX(76);
	    imageMenu.setLayoutY(12);
	    imageMenuProduct.getChildren().add(imageMenu);
}
//tạo combobox phân loại sản phẩm 
private void loadComboboxCategory(ComboBox<String> x)
{
	try {
		if(x == cbbCategoryMenuProduct1)
		{
			cbbCategoryMenuProduct1.getItems().add("All");
			if (!cbbCategoryMenuProduct1.getItems().isEmpty()) {
                cbbCategoryMenuProduct1.setValue(cbbCategoryMenuProduct1.getItems().get(0));
            }
		}
		List<Category> categorys=CategoryDto.getALLCategorys();
		for(var name:categorys)
		{
			x.getItems().add(name.getNameCategory());
		} 
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//tạo sự kiện tìm kiếm menu
@FXML
private void searchMenu(KeyEvent event) {
	try {
       
        List<Product> products = productDto.getAllProducts();
        String searchText = searchMenuProduct.getText().toLowerCase();
        flowPaneProduct.getChildren().clear();
        for (Product product : products) {
            if (product.getNameProduct().toLowerCase().contains(searchText) && product.isStatusProduct()) {
                createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct()); 
            }else
            if(searchText=="" && product.isStatusProduct())
            {
            	 createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct());
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}
//sự kiện chọn combobox menu 
@FXML
private void cbbSearchMenu(ActionEvent event) {
try {
	List<Product> products=productDto.getAllProducts();
	String nameCombobox=cbbCategoryMenuProduct1.getSelectionModel().getSelectedItem();
	int idCategory=CategoryDto.getIdCategoryProduct(nameCombobox);
	flowPaneProduct.getChildren().clear();
	for(Product product:products)
	{
		if(product.getIdCategory()== idCategory && product.isStatusProduct())
		{
			createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct());
		}
		else if(nameCombobox=="All" && product.isStatusProduct())
		{
			createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct());
		}
	}
} catch (Exception e) {
	e.printStackTrace();
}
}
//Thêm hình ảnh từ máy tính lên 
@FXML
private void addImageMenu(MouseEvent event) {
 JFileChooser filechooser=new JFileChooser();
 filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
 
 int result=filechooser.showOpenDialog(null);
 if(result==JFileChooser.APPROVE_OPTION)
 {
	 File imageFile=filechooser.getSelectedFile();
	 try(FileInputStream fileInputStream=new FileInputStream(imageFile)) {
		imagePromotion =new byte[(int) imageFile.length()];
		fileInputStream.read(imagePromotion);
		loadImage(imagePromotion);
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
//xóa sản phẩm 
@FXML
private void deleteMenuProduct(MouseEvent event) {
   try {
	   paneShowProduct.setVisible(false);
	   if(idMenuProduct.getText()=="")
	    {
	    	paneNotification.setVisible(true);
	    	lableNotification.setText("Bạn chưa chọn sản phẩm");
	    	btCancelNotification.setOnMouseClicked(even ->{
	    		paneNotification.setVisible(false);
	    		paneShowProduct.setVisible(true);
	    	});
	    	btOkNotification.setVisible(false);
	    }
	    else
	    {
	    	paneNotification.setVisible(true);
	    	lableNotification.setText("Ban Có muốn xóa sản phẩm : "+nameMenuProduct.getText()+" ?");
	    	try {
	    		btOkNotification.setOnMouseClicked(even ->{
	    			String notification=productDto.setStatusProduct(Integer.parseInt(idMenuProduct.getText()),false);
	    			if(notification=="Loại bỏ sản phẩm thành công !!!")
	    			{
	    				lableNotification.setStyle(
	    						"-fx-border-color: green; " +
	    				        "-fx-text-fill: green; "
	    						);
	    			}
	    			else if(notification=="Loại bỏ không thành công !!!")
	    			{
	    				lableNotification.setStyle(
	    						"-fx-border-color: red; "+
	    				         "-fx-text-fill: red; "
	    						);
	    			}
		    		lableNotification.setText(notification);
		    		btOkNotification.setOnMouseClicked(even1 ->{
		        		paneNotification.setVisible(false);
		        		paneShowProduct.setVisible(false);
		        		loadProductToFlowPane();
		        		loadAfterDelete();
		        	    lableNotification.setStyle(
	    						"-fx-border-color: black; " +
	    				        "-fx-text-fill: white; "
	    						);
		        	});
		    		btCancelNotification.setVisible(false);
		    	});
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	btCancelNotification.setVisible(true);
	    	btCancelNotification.setOnMouseClicked(even -> {
	    		paneNotification.setVisible(false);
	    		paneShowProduct.setVisible(true);
	    	});
	    }
  } catch (Exception e) {
	e.printStackTrace();
  }	
}
//load sản phẩm sau khi xóa
private void loadAfterDelete()
{
	imageMenuProduct.getChildren().clear();
	imagePromotion=null;
	idMenuProduct.setText("");
	nameMenuProduct.setText("");
	priceMenuProduct.setText("");
	quantityMenuProduct.setText("");
	cbbCategoryMenuProduct.getItems().get(0);
}
//thêm sản phẩm 
@FXML
private void addMenuProduct(MouseEvent event) {
    try {
    	paneShowProduct.setVisible(false);
        paneNotification.setVisible(true);
        lableNotification.setText("Bạn muốn thêm sản phẩm: " + nameMenuProduct.getText());
        btOkNotification.setOnMouseClicked(even -> {
            try {
                int idProduct = -1;
                if (!idMenuProduct.getText().isEmpty()) {
                    idProduct = Integer.parseInt(idMenuProduct.getText());
                }
                String nameProduct = nameMenuProduct.getText();
                boolean isProductExist = false;

                for (var product : productDto.getAllProducts()) {
                    if (idProduct == product.getIdProduct()) {
                        lableNotification.setText("Bạn muốn cập nhật thông tin");
                        btCancelNotification.setVisible(true);
                        btCancelNotification.setOnMouseClicked(even1 -> {
                            paneNotification.setVisible(false); 
                            paneShowProduct.setVisible(true);
                        });

                        btOkNotification.setVisible(true);
                        btOkNotification.setOnMouseClicked(even1 -> {
                            addEndUpdateProduct(nameProduct);
                        });
                        isProductExist = true;
                        break;
                    } else if (nameProduct.equalsIgnoreCase(product.getNameProduct())) {
                        lableNotification.setText("Tên sản phẩm đã trùng. Bạn có muốn tiếp tục?");
                        btOkNotification.setVisible(true);
                        btOkNotification.setOnMouseClicked(even1 -> {
                            addEndUpdateProduct(nameProduct);
                        });
                        btCancelNotification.setVisible(true);
                        btCancelNotification.setOnMouseClicked(even1 -> {
                            paneNotification.setVisible(false);  
                            paneShowProduct.setVisible(true);
                        });
                        isProductExist = true;
                        break;
                    }
                }
                if (!isProductExist) {
                    addEndUpdateProduct(nameProduct);
                }
            } catch (NumberFormatException e) {
                lableNotification.setText("Nhập sai dữ liệu! Vui lòng kiểm tra lại các trường số.");
               
            } catch (Exception e) {
                lableNotification.setText("Có lỗi xảy ra khi thêm sản phẩm.");
                e.printStackTrace();
            }  
        });

        btCancelNotification.setVisible(true);
        btCancelNotification.setOnMouseClicked(even -> {
            paneNotification.setVisible(false);
            paneShowProduct.setVisible(true);
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
    loadProductToFlowPane();
    btOkNotification.setVisible(true);
}

// thêm và cập nhật sản phẩm
private void addEndUpdateProduct(String nameProduct) {
    try {
    	btOkNotification.setVisible(false);
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            lableNotification.setText("Tên sản phẩm không được để trống.");
            return;
        }
        Double priceProduct;
        try {
            priceProduct = convertMoney(priceMenuProduct.getText().trim());
            if (priceProduct <= 0) {
                lableNotification.setText("Giá sản phẩm phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lableNotification.setText("Giá sản phẩm không hợp lệ! Vui lòng nhập số.");
            return;
        }
        byte[] imageProduct = imagePromotion;
        if (imageProduct == null) {
            lableNotification.setText("Bạn chưa chọn hình ảnh!");
            return;
        }
        int quantityProduct;
        try {
            quantityProduct = Integer.parseInt(quantityMenuProduct.getText().trim());
            if (quantityProduct <= 0) {
                lableNotification.setText("Số lượng sản phẩm phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lableNotification.setText("Số lượng sản phẩm không hợp lệ! Vui lòng nhập số.");
            return;
        }
        String selectedCategory = cbbCategoryMenuProduct.getSelectionModel().getSelectedItem();
        if (selectedCategory == null) {
            lableNotification.setText("Bạn chưa chọn danh mục sản phẩm!");
            return;
        }
        int idProduct=0;
        if(!idMenuProduct.getText().isEmpty())
        {
        	idProduct=Integer.parseInt(idMenuProduct.getText());
        }
        int idCategory = CategoryDto.getIdCategoryProduct(selectedCategory);
        if (idCategory == -1) {
            lableNotification.setText("Danh mục sản phẩm không hợp lệ.");
            return;
        }
        String result = productDto.addEndUpdateProduct(idProduct,nameProduct, priceProduct, imageProduct, quantityProduct, true, idCategory);
        lableNotification.setText(result);
        loadProductToFlowPane();
        loadAfterDelete();
        btOkNotification.setVisible(true);
        btOkNotification.setOnMouseClicked(even1 ->
        paneNotification.setVisible(false)
        );
        btCancelNotification.setVisible(false);

    } catch (Exception e) {
        lableNotification.setText("Có lỗi xảy ra khi thêm sản phẩm.");
        e.printStackTrace();
    }
}
//hiển thị form thêm sản phẩm 
@FXML
private void addProduct(MouseEvent event)
{
	loadAfterDelete();
	paneShowProduct.setVisible(true);
}
//thoát khỏi bảng sản phẩm
@FXML
private void exitProduct()
{
	paneShowProduct.setVisible(false);
	loadAfterDelete();
}

//---------------------------------------MeNu-----------------------------
//-------------------------------------Computer---------------------------
//tạo giao diện computer
private void createComputerAndLabel(int idComputer,String nameComputer,int statusComputer,FlowPane flowPane)
{
	try {
		FontAwesomeIcon icon =new FontAwesomeIcon();
		icon.setSize("70px");
		icon.setGlyphName("DESKTOP");
		icon.setLayoutX(29);
		icon.setLayoutY(74);
		
		Label label=new Label();
		label.setStyle("-fx-font-family:\"Arial\"; "+
		               "-fx-font-size:14px; "+
				       "-fx-text-fill:white; ");
		label.setText(nameComputer);
		label.setLayoutX(30);
		label.setLayoutY(92);
		
		Pane pane=new Pane();
		pane.setPrefWidth(138);
		pane.setPrefHeight(117);
		if(statusComputer==0)
		{
			pane.setStyle("-fx-border-color: red; "+" -fx-border-width: 1px; ");
		}
		else
		if(statusComputer==1)
		{
			pane.setStyle("-fx-border-color: green; "+" -fx-border-width: 1px; ");
		}
		else
		if(statusComputer==2)
		{
				pane.setStyle("-fx-border-color: black; "+" -fx-border-width: 1px; ");
		}
		pane.getChildren().addAll(icon,label);
		pane.setOnMouseClicked(even->{
			tfIdComputer.setText(idComputer+"");
			tfNameComputer.setText(nameComputer);
			rbOff.setSelected(false);
			rbOn.setSelected(false);
			rbMaintenance.setSelected(false);
			if (statusComputer == 0) {
			    rbOff.setSelected(true);
			} else if (statusComputer == 1) {
			    rbOn.setSelected(true);
			} else if (statusComputer == 2) {
			    rbMaintenance.setSelected(true);
			}
		});
		flowPane.getChildren().add(pane);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//load máy tính
private void loadComputerAndLable()
{
	flowPaneComputer.getChildren().clear();
	try {
		List<Computer> computers=ComputerDto.getAllComputers();
		for(var computer:computers)
		{
			createComputerAndLabel(computer.getIdComputer(), computer.getNameComputer(),computer.getStatusComputer() ,flowPaneComputer);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//tìm kiếm máy tính 
@FXML
private void searchComputer(KeyEvent event) {
    try {
    	String text= searchComputer.getText().toLowerCase();
    	flowPaneComputer.getChildren().clear();
		for(var computer:ComputerDto.getAllComputers())
		{
			if(computer.getNameComputer().toLowerCase().contains(text.toLowerCase()))
			{
				createComputerAndLabel(computer.getIdComputer(), computer.getNameComputer(), computer.getStatusComputer(), flowPaneComputer);
			}
			else if(text=="")
			{
				createComputerAndLabel(computer.getIdComputer(), computer.getNameComputer(), computer.getStatusComputer(), flowPaneComputer);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
}

//load bảng thông tin thời gian chơi
private void createTableTimeUserComputer(TimeUserComputer user,int index)
{
	try {
		Button show=new Button("Xem");
		Button delete=new Button("Xóa");
		show.setPrefWidth(89.6);
		show.setMinWidth(50); 
		show.setMaxWidth(89.6);
		delete.setPrefWidth(89.6);
		delete.setMinWidth(50); 
		delete.setMaxWidth(89.6);
		Long  milliseconds=user.getTimeUser();
		long hours =  milliseconds / 3600;
		long minutes = ( milliseconds % 3600) / 60;
		long seconds =  milliseconds % 60;
		show.setOnMouseClicked(event->{
			idPayMent=user.getIdUserComputer();
			tfHouseTimeUser.setText(hours+"");
			tfMinuteTimeUser.setText(minutes+"");
			tfSecondTimeUser.setText(seconds+"");
			tfMoneyTimeUser.setText(convertMoneyString(user.getMoneyUser()));
		});
		delete.setOnMouseClicked(event->{
			paneNotification.setVisible(true);
			lableNotification.setText("Bạn muốn xóa thông tin ?");
			btOkNotification.setVisible(true);
			btOkNotification.setOnMouseClicked(event1->{
				lableNotification.setText(TimeUserComputerDto.deleteTimeUserComputerById(idTimeUser));
				btCancelNotification.setVisible(true);
				btCancelNotification.setOnMouseClicked(event2->{
					paneNotification.setVisible(false);
				});
			});
			btCancelNotification.setVisible(true);
			btCancelNotification.setOnMouseClicked(event1->{
				paneNotification.setVisible(false);
			});
		});
		
		TimeUserComputerTableRow dataRow=new TimeUserComputerTableRow(
				index,
				hours+"h"+minutes+"m"+seconds+"s",
				convertMoneyString(user.getMoneyUser()),
				show,
				delete
				);
		timeUserList.add(dataRow);
		indexTimeUser.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIndex()).asObject());
		timeUser.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTimeUser()));
		moneyUser.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMoneyUser()));
		showThimeUser.setCellValueFactory(cellData -> new SimpleObjectProperty<Button>(cellData.getValue().getShow()));
		deleteTimeUser.setCellValueFactory(cellData -> new SimpleObjectProperty<Button>(cellData.getValue().getDelete()));
		tableViewTimeUserComputer.setItems(timeUserList);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

//load thông tin thời gian chơi lên máy tính 
private void loadTableTimeUserComputer()
{
	try {
		ObservableList<String> listComputerAndTimeUser=FXCollections.observableArrayList();
		tableViewTimeUserComputer.getItems().clear();
		comboboxSelectComputerAndTimeUser.getItems().clear();
		int index=1;
		for(var timeUser: TimeUserComputerDto.getAllTimeUserComputers())
		{
			createTableTimeUserComputer(timeUser, index);
			index++;
		}
		listComputerAndTimeUser.setAll("Máy tính","Thời gian sử dụng máy");
		comboboxSelectComputerAndTimeUser.setItems(listComputerAndTimeUser);
		comboboxSelectComputerAndTimeUser.getSelectionModel().select(0);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//lựa chọn hiển thị 
@FXML
private void showComputerAndTimeUser(ActionEvent event)
{
	int index=comboboxSelectComputerAndTimeUser.getSelectionModel().getSelectedIndex();
	if(index==0)
	{
		scrollPaneComputer.setVisible(true);
		tableViewTimeUserComputer.setVisible(false);
	}else if(index==1)
	{
		scrollPaneComputer.setVisible(false);
		tableViewTimeUserComputer.setVisible(true);
	}
}
//reset thông tin 
private void resetFormCOmputerAndTimeUser()
{
	int index=comboboxSelectComputerAndTimeUser.getSelectionModel().getSelectedIndex();
	if(index==0)
	{
		resrtComputer.setOnMouseClicked(event->{
			tfIdComputer.setText("");
			tfNameComputer.setText("");
			rbOn.setSelected(false);
			rbOff.setSelected(false);
			rbMaintenance.setSelected(false);
		});
	}
	if(index==1)
	{
		resetTimeUser.setOnMouseClicked(event->{
			idTimeUser=0;
			tfHouseTimeUser.setText("");
			tfMinuteTimeUser.setText("");
			tfSecondTimeUser.setText("");
			tfMoneyTimeUser.setText("");
		});
	}
}

//-------------------------------------Computer---------------------------
//-------------------------------------Staff-------------------------------
//load danh sách nhân viên
private void loadTableStaff()
{
	try {
		ObservableList<String> listRole = FXCollections.observableArrayList();
		ObservableList<String> listSearchStaff=FXCollections.observableArrayList();
		cbbnameRole.getItems().clear();
		tableViewStaff.getItems().clear();
		comboboxSearchStaff.getItems().clear();
		for(var staff:StaffDto.getAllStaffs())
		{
			createTableStaff(staff);
		}
		//thêm vào combox chức năng 
	   for(var role: RoleDto.getAllRoles())
		{
				listRole.add(RoleDto.checkIDTakeNameRole(role.getIdRole()));
		}
	   //them chức năng tìm kiếm combobox
	   listSearchStaff.addAll("Tên nhân viên","Số điện thoại","Chức vụ");
	   comboboxSearchStaff.setItems(listSearchStaff);
	   cbbnameRole.setItems(listRole);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//thêm nhân viên vào hàng
private void createTableStaff(Staff staff)
{
	String role = RoleDto.checkIDTakeNameRole(staff.getIdRole());
	Button showButton = new Button("Xem");
	showButton.setPrefWidth(88.79998779296875);
	showButton.setMinWidth(50); 
	showButton.setMaxWidth(88.79998779296875);
	showButton.setOnAction(event -> {
	        	tfidStaff.setText(staff.getIdStaff()+"");
	        	tfnameStaff.setText(staff.getName());
	        	tfphoneStaff.setText(staff.getPhone());
	        	tfaddressStaff.setText(staff.getAddressStaff());
	        	tfaccountStaff.setText(staff.getNameAccount());
	        	tfpasswordStaff.setText(staff.getPasswordAccount());
	        	cbbnameRole.getSelectionModel().select(RoleDto.checkIDTakeNameRole(staff.getIdRole()));
	        	dptimeStartWork.setValue(staff.getTimeStartWork().toLocalDate());
	        	tfdayWork.setText(staff.getDayWork()+"");
	 });
	  StaffTableRow rowData = new StaffTableRow(
	            staff.getName(),
	            staff.getPhone(),
	            staff.getDayWork(),
	            role,
	            showButton
	  );
		    staffList.add(rowData);
		    nameStaff.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		    phoneStaff.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
		    dayWork.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getDayWork()).asObject());	   
		    nameRole.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRole()));
		    show.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getShowButton()));
		    tableViewStaff.setItems(staffList);
		
}
//xóa thông tin nhân viên hiện trên màn hình 
@FXML
private void resetStaff(MouseEvent even)
{
	tfidStaff.setText("");
	tfnameStaff.setText("");
	tfphoneStaff.setText("");
	tfaddressStaff.setText("");
	tfaccountStaff.setText("");
	tfpasswordStaff.setText("");
	cbbnameRole.getSelectionModel().clearSelection();
	dptimeStartWork.setValue(null);
	tfdayWork.setText("");
}
//tìm kiếm nhân viên
@FXML
private void searchStaff(KeyEvent event)
{
	try {
		String text=searchStaff.getText();
		tableViewStaff.getItems().clear();
		staffList.clear();
		int index=comboboxSearchStaff.getSelectionModel().getSelectedIndex();
		boolean check=false;
		for(var staff:StaffDto.getAllStaffs())
		{
			if(index==0)
			{
				check=text.isEmpty() || staff.getName().toLowerCase().contains(text.toLowerCase());
			}
			else if(index==1)
			{
				check=text.isEmpty() ||staff.getPhone().toLowerCase().contains(text.toLowerCase());
			}
			else if(index==2)
			{
				check=text.isEmpty() || RoleDto.checkIDTakeNameRole(staff.getIdRole()).toLowerCase().contains(text.toLowerCase());
			}
			if(check)
			{
				createTableStaff(staff);
			}
			if(comboboxSearchStaff.getValue()==null)
			{
				createTableStaff(staff);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
 
//thêm và cập nhật nhân viên
@FXML
private void addEndUpdateStaff(MouseEvent event) {
    try {
        paneNotification.setVisible(true);
        boolean check = true;

        // Kiểm tra các điều kiện
        if (tfnameStaff.getText().isEmpty()) {
            lableNotification.setText("Tên nhân viên không được để trống !!!");
            check = false;
        } else if (cbbnameRole.getValue() == null || cbbnameRole.getValue().trim().isEmpty()) {
            lableNotification.setText("Chức vụ không được để trống !!!");
            check = false;
        } else if (tfdayWork.getText().isEmpty() || !tfdayWork.getText().matches("\\d+")) {
            lableNotification.setText("Số ngày làm việc phải là số và không được để trống !!!");
            check = false;
        } else if (tfphoneStaff.getText().isEmpty() || !tfphoneStaff.getText().matches("\\d{10,11}")) {
            lableNotification.setText("Số điện thoại phải có 10-11 chữ số !!!");
            check = false;
        } else if (tfaddressStaff.getText().isEmpty()) {
            lableNotification.setText("Địa chỉ không được để trống !!!");
            check = false;
        } else if (dptimeStartWork.getValue() == null) {
            lableNotification.setText("Ngày bắt đầu làm việc không được để trống !!!");
            check = false;
        } else if (tfaccountStaff.getText().isEmpty()) {
            lableNotification.setText("Tên tài khoản không được để trống !!!");
            check = false;
        } else if (tfpasswordStaff.getText().isEmpty()) {
            lableNotification.setText("Mật khẩu không được để trống !!!");
            check = false;
        }
        if (!check) {
            btOkNotification.setVisible(false);
            btCancelNotification.setOnMouseClicked(event1 -> paneNotification.setVisible(false));
            return;
        }
        int dayWork=0;
        if(!tfdayWork.getText().isEmpty())
        {
        	 String dayWorkStr = tfdayWork.getText();
             dayWork = Integer.parseInt(dayWorkStr);
             if(dayWork<0)
             {
            	 lableNotification.setText("Ngày nhập nhỏ hơn 0 !!!");
            	 check=false;
             }
        }
        if (!check) {
            btOkNotification.setVisible(false);
            btCancelNotification.setOnMouseClicked(event1 -> paneNotification.setVisible(false));
            return;
        }
        String selectedRole = cbbnameRole.getValue().trim();
        int idRole = RoleDto.checkNameRoleTakeIDRole(selectedRole);
        String idStaffStr = tfidStaff.getText();
        if (idStaffStr.isEmpty()) {
            idStaffStr="0";
        }
        int idStaff = Integer.parseInt(idStaffStr);
        String nameStaff = tfnameStaff.getText();
        String phoneStaff = tfphoneStaff.getText();
        String nameAccount = tfaccountStaff.getText();
        String passwordAccount = tfpasswordStaff.getText();
        String addressStaff = tfaddressStaff.getText();
        LocalDate localDate = dptimeStartWork.getValue();
        Date timeStartWork = java.sql.Date.valueOf(localDate);
        boolean isStaffExist = false;
        for (var staff : StaffDto.getAllStaffs()) {
            if (staff.getIdStaff() == idStaff) {
                isStaffExist = true;
                break;
            }
        }
        if (isStaffExist) {
            lableNotification.setText("Bạn có muốn cập nhật thông tin nhân viên không ?");
            setupAddEndUpdateStaff(idStaff, nameStaff, phoneStaff, nameAccount, passwordAccount, addressStaff, timeStartWork, dayWork, idRole, "cập nhật");
        } else {
            lableNotification.setText("Bạn có muốn thêm thông tin nhân viên không ?");
            setupAddEndUpdateStaff(idStaff, nameStaff, phoneStaff, nameAccount, passwordAccount, addressStaff, timeStartWork, dayWork, idRole, "thêm");
        }
      
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//hiển thị thông báo thêm và cập nhật nhân viên 
private void setupAddEndUpdateStaff(int idStaff, String nameStaff, String phoneStaff, String nameAccount,
                                      String passwordAccount, String addressStaff, Date timeStartWork,
                                      int dayWork, int idRole, String action) {
    btCancelNotification.setVisible(true);
    btCancelNotification.setOnMouseClicked(event -> paneNotification.setVisible(false));
    btOkNotification.setVisible(true);
    btOkNotification.setOnMouseClicked(event -> {
        lableNotification.setText(StaffDto.addEndUpdateStaff(idStaff, nameStaff, phoneStaff, nameAccount,
                                                                  passwordAccount, addressStaff, timeStartWork, dayWork, idRole));
        btOkNotification.setVisible(false);
        btCancelNotification.setVisible(true);
        btCancelNotification.setOnMouseClicked(event2 -> {
            paneNotification.setVisible(false);
            loadTableStaff();
            resetStaff(event2);
        });
    });
}
//-------------------------------------Staff-------------------------------
//-------------------------------------Sale--------------------------------
//load thông tin bảng khuyến mãi 
private void loadTablePromotion()
{
	try {
		ObservableList<String> listStatusPromotion=FXCollections.observableArrayList();
		cbbStatusPromotion.getItems().clear();
		tableViewPromotion.getItems().clear();
		for(var promotion:PromotionDto.getAllPromotions())
		{
			createTablePromotion(promotion);
		}
		listStatusPromotion.addAll("Còn hạn","Hết hạn");
		cbbStatusPromotion.setItems(listStatusPromotion);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
//thêm khuyến mãi vào bảng
private void createTablePromotion(Promotion promotion)
{
	Button button=new Button("Xem");
	button.setPrefWidth(84.8);
	button.setMinWidth(50); 
	button.setMaxWidth(84.8);
	String status="";
    if(promotion.isStatusPromotion())
    {
    	status="Còn hạn";
    }
    else
    {
    	status="Hết hạn";
    }
    button.setOnMouseClicked(event->{
    	resetPromotion();
    	paneAddEndUpdatePromotion.setVisible(true);
    	tfIdPromotion.setText(promotion.getIdPromotion()+"");
    	tfNamePromotion.setText(promotion.getNamePromotion());
    	tfApplicablePromotion.setText(promotion.getApplicableLevel()+"%");
    	if(promotion.isStatusPromotion())
    	{
    		cbbStatusPromotion.getSelectionModel().select(0);
    	}else
    	{
    		cbbStatusPromotion.getSelectionModel().select(1);
    	}
    	dpStartDate.setValue(promotion.getStartDate().toLocalDate());
    	dpEndDate.setValue(promotion.getEndDate().toLocalDate());
    	tfNodePromotion.setText(promotion.getNodePromotion());
    	btExitPromotion.setVisible(true);
    	btExitPromotion.setOnMouseClicked(event1->{
    		paneAddEndUpdatePromotion.setVisible(false);
    	});
    	btOkPromotion.setVisible(true);
    });
    String applicable=promotion.getApplicableLevel()+"%";
	PromotionTableRow rowData=new PromotionTableRow(
			promotion.getIdPromotion(),
			promotion.getNamePromotion(),
			applicable,
			promotion.getStartDate(),
			promotion.getEndDate(),
			status,
			button
	);
	promotionList.add(rowData);
	idPromotion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdPromotion()).asObject());
	namePromotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNamePromotion()));
	applicableLevel.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicableLevel()));
	startDate.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getStartDate()));
	endDate.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEndDate()));
	statusPromotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatusPromotion()));
	showPromotion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getShowPromotion()));
	tableViewPromotion.setItems(promotionList);
}
//tìm kiếm khuyến mãi 
@FXML
private void searchPromotion(KeyEvent event) {
    try {
    	if(comboboxShowSaleEndNew.getSelectionModel().getSelectedIndex()==0)
    	{
    		 tableViewPromotion.getItems().clear();
    	        String text = searchPromotion.getText().toLowerCase();
    	        int selectedIndex = cbbSelectPromotion.getSelectionModel().getSelectedIndex();
    	        for (var promotion : PromotionDto.getAllPromotions()) {
    	            boolean match = false;
    	            if (selectedIndex == 0) {
    	                match = text.isEmpty() || (promotion.getIdPromotion() + "").toLowerCase().contains(text);
    	            } else if (selectedIndex == 1) {
    	                match = text.isEmpty() || promotion.getNamePromotion().toLowerCase().contains(text);
    	            } else if (selectedIndex == 2) {
    	                match = text.isEmpty() || (promotion.getApplicableLevel() + "").toLowerCase().contains(text);
    	            } else if (selectedIndex == 3) {
    	                if (text.isEmpty() || ("Còn hạn").toLowerCase().contains(text)) {
    	                    match = promotion.isStatusPromotion();
    	                } else if (("Hết hạn").toLowerCase().contains(text)) {
    	                    match = !promotion.isStatusPromotion();
    	                }
    	            }
    	            if(cbbSelectPromotion.getValue()==null)
    	            {
    	            	 createTablePromotion(promotion);
    	            }
    	            if (match) {
    	                createTablePromotion(promotion);
    	            }
    	        }
    	}else
    	if(comboboxShowSaleEndNew.getSelectionModel().getSelectedIndex()==1)
    	{
    		 flowpaneViewNew.getChildren().clear();
    		 String text = searchPromotion.getText().toLowerCase();
    		 int selectedIndex = cbbSelectPromotion.getSelectionModel().getSelectedIndex();
    		 for(var news:NewDto.getAllNews())
    		 {
    			 boolean check=false;
    			 if(selectedIndex==0)
    			 {
    				 check=text.isEmpty() || news.getTitleNew().trim().toLowerCase().contains(text);
    			 }else if(selectedIndex==1)
    			 {
    				 check=text.isEmpty() || news.getContentNew().trim().toLowerCase().contains(text);
    			 }
    			 if(cbbSelectPromotion.getValue()==null)
 	            {
    				 createViewNew(news);
 	            }
    			 if(check)
    			 {
    				 createViewNew(news);
    			 }
    		 }
    	}
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//click nút add trong promotion
@FXML
private void addPromotion(MouseEvent event) {
	int index=comboboxShowSaleEndNew.getSelectionModel().getSelectedIndex();
	if(index==0)
	{
		resetPromotion();
		paneAddEndUpdatePromotion.setVisible(true);
		btExitPromotion.setVisible(true);
		btExitPromotion.setOnMouseClicked(event1->{
			paneAddEndUpdatePromotion.setVisible(false);
		});
		btOkPromotion.setVisible(true);
	}else if(index==1)
	{
		resetNew();
		paneAddEndUpdateNew.setVisible(true);
		btExitNew.setVisible(true);
		btExitNew.setOnMouseClicked(event1->{
			paneAddEndUpdateNew.setVisible(false);
		});
		btOkNew.setVisible(true);
	}
}
//thêm và cập nhật khuyến mãi 
@FXML
private void addEndUpdatePromotion(MouseEvent event) {
    paneAddEndUpdatePromotion.setVisible(false);
    try {
        boolean check = true;
        
        if (tfNamePromotion.getText().isEmpty()) {
            lableNotification.setText("Tên khuyến mãi chưa nhập !!!");
            check = false;
        } else if (tfApplicablePromotion.getText().isEmpty()) {
            lableNotification.setText("Mức áp dụng chưa nhập !!!");
            check = false;
        } else if (cbbStatusPromotion.getValue() == null) {
            lableNotification.setText("Trạng thái sử dụng chưa chọn !!!");
            check = false;
        } else if (dpStartDate.getValue() == null) {
            lableNotification.setText("Ngày bắt đầu chưa chọn !!!");
            check = false;
        } else if (dpEndDate.getValue() == null) {
            lableNotification.setText("Ngày kết thúc chưa chọn !!!");
            check = false;
        } else if (tfNodePromotion.getText().isEmpty()) {
            lableNotification.setText("Ghi chú không được để trống !!!");
            check = false;
        }
        int idPromotion = 0;
        if (!tfIdPromotion.getText().isEmpty()) {
            idPromotion = Integer.parseInt(tfIdPromotion.getText());
        }
        String namePromotion = tfNamePromotion.getText();
        int applicableLevel=convertInt(tfApplicablePromotion.getText());
        boolean statusPromotion = cbbStatusPromotion.getSelectionModel().getSelectedIndex() == 0;
        LocalDate localDateStart = dpStartDate.getValue();
        Date startDate = java.sql.Date.valueOf(localDateStart);
        LocalDate localDateEnd = dpEndDate.getValue();
        Date endDate = java.sql.Date.valueOf(localDateEnd);

        if (!check) {
            paneNotification.setVisible(true);
            btCancelNotification.setVisible(true);
            btCancelNotification.setOnMouseClicked(event1 -> {
                paneNotification.setVisible(false);
                paneAddEndUpdatePromotion.setVisible(true);
            });
            btOkNotification.setVisible(false);
            return;
        }
        boolean checkid=false;
		for(var promotion:PromotionDto.getAllPromotions())
		{
			if(promotion.getIdPromotion()==idPromotion)
			{
				checkid=true;
				break;
			}
		}

        String nodePromotion = tfNodePromotion.getText();
        lableNotification.setText(
            checkid ? "Bạn muốn cập nhật thông tin khuyến mãi ?" : "Bạn muốn thêm thông tin khuyến mãi ?"
        );
        setupAddEndUpdatePromotion(idPromotion, namePromotion, applicableLevel, startDate, endDate, statusPromotion, nodePromotion);
    } catch (NumberFormatException e) {
        lableNotification.setText("Lỗi định dạng số! Vui lòng kiểm tra lại các trường số.");
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Hiển thị thông báo thêm và cập nhật thành công
private void setupAddEndUpdatePromotion(int idPromotion, String namePromotion, int applicableLevel, Date startDate, Date endDate, Boolean statusPromotion, String nodePromotion) {
    paneNotification.setVisible(true);
    btCancelNotification.setVisible(true);
    btCancelNotification.setOnMouseClicked(event -> {
        paneNotification.setVisible(false);
        paneAddEndUpdatePromotion.setVisible(true);
    });
    btOkNotification.setVisible(true);
    btOkNotification.setOnMouseClicked(event -> {
        lableNotification.setText(PromotionDto.addEndUpdatePromotion(idPromotion, namePromotion, applicableLevel, startDate, endDate, statusPromotion, nodePromotion));
        btCancelNotification.setOnMouseClicked(event1 -> {
            paneNotification.setVisible(false);
            loadTablePromotion();
            resetPromotion();
            paneAddEndUpdatePromotion.setVisible(true);
        });
        btOkNotification.setVisible(false);
    });
}

//xóa toàn bộ thông tin trong bảng paneAddEndUpdateCustomer
private void resetPromotion()
{
	tfIdPromotion.setText("");
	tfNamePromotion.setText("");
	tfApplicablePromotion.setText("");
	cbbStatusPromotion.getSelectionModel().clearSelection();
	dpEndDate.setValue(null);
	dpStartDate.setValue(null);
	tfNodePromotion.setText("");
}
//tạo dữ liệu cho combobox
private void createDataComboboxSaleAndNew()
{
	  ObservableList<String> x = FXCollections.observableArrayList(
            "Khuyến mãi", "Thông tin"
        );
       comboboxShowSaleEndNew.setItems(x);
	   comboboxShowSaleEndNew.getSelectionModel().select(0);
	   
}

//chọn hiển thị khuyến mãi và thông báo
@FXML
private void showSaleEndNew(ActionEvent event)
{
	ObservableList<String> listSelectPromtion=FXCollections.observableArrayList();
	cbbSelectPromotion.getItems().clear();
	int index=comboboxShowSaleEndNew.getSelectionModel().getSelectedIndex();
	if(index==0)
	{
		scrollPaneViewSale.setVisible(true);
		scrollPaneViewNew.setVisible(false);
		listSelectPromtion.addAll("Mã khuyến mãi","Tên khuyến mãi","Mức áp dụng","Trạng thái");
		cbbSelectPromotion.setItems(listSelectPromtion);
		lbViewSaleEndView.setText("Khuyến mãi");
		loadTablePromotion();
	}
	else if(index==1)
	{
		scrollPaneViewSale.setVisible(false);
		scrollPaneViewNew.setVisible(true);
		listSelectPromtion.addAll("Tiêu đề","Nội dung");
		cbbSelectPromotion.setItems(listSelectPromtion);
		lbViewSaleEndView.setText("Thông tin");
		loadViewNew();
	}

}
private void loadViewNew()
{
	try {
		flowpaneViewNew.getChildren().clear();
		for(var newView: NewDto.getAllNews())
		{
			createViewNew(newView);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
private void createViewNew(New newView)
{
	try {
		Pane paneNew=new Pane();
		paneNew.setPrefWidth(990);
		paneNew.setPrefHeight(363);
		paneNew.setStyle(" -fx-border-color: black;" +
		" -fx-border-width: 1px;");
		
		Label labelTitleNew=new Label();
		labelTitleNew.setPrefWidth(975);
		labelTitleNew.setPrefHeight(33);
		labelTitleNew.setLayoutX(14);
		labelTitleNew.setLayoutY(14);
		labelTitleNew.setText(newView.getTitleNew());
		labelTitleNew.setStyle( "-fx-font-family: 'Arial'; " +
	             "-fx-font-size: 20px; " +
	             "-fx-text-fill: white; ");
		
		Image image=new Image(new ByteArrayInputStream(newView.getImageNew()));
		ImageView imageViewNew=new ImageView(image);
		imageViewNew.setFitWidth(300);
		imageViewNew.setFitHeight(147);
		imageViewNew.setLayoutX(15);
		imageViewNew.setLayoutY(53);
			
		Label contentNew=new Label();
		contentNew.setPrefWidth(975);
		contentNew.setPrefHeight(135);
		contentNew.setLayoutX(14);
		contentNew.setLayoutY(206);
		contentNew.setText(newView.getContentNew());
		contentNew.setStyle( 
				"-fx-font-family: 'Arial'; " +
	             "-fx-font-size: 14px; " +
	             "-fx-text-fill: white; ");
		paneNew.getChildren().addAll(labelTitleNew,imageViewNew,contentNew);
		paneNew.setOnMouseClicked(event->{
			paneAddEndUpdateNew.setVisible(true);
			idNew=newView.getIdNew();
			tfTatleNew.setText(newView.getTitleNew());
			tfTimeNew.setText(newView.getDateNew().toString());
			loadImageNew(newView.getImageNew());
			tfContentNew.setText(newView.getContentNew());
			btExitNew.setVisible(true);
			btExitNew.setOnMouseClicked(event1->{
				paneAddEndUpdateNew.setVisible(false);
			});
			btOkNew.setVisible(true);
		});
		flowpaneViewNew.getChildren().add(paneNew);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//xóa toàn bộ thông tin bảng Thông báo
private void resetNew()
{
	idNew=0;
	tfTatleNew.setText("");
	tfTimeNew.setText("");
	paneImageNew.getChildren().clear();
	tfContentNew.setText("");
}
//thêm hình ảnh vào 
private void loadImageNew(byte[] image)
{
	    imageNew=image;
	    Image image1=new Image(new ByteArrayInputStream(image));
	    ImageView imageMenu = new ImageView(image1);
	    imageMenu.setFitWidth(386);
	    imageMenu.setFitHeight(184);
	    imageMenu.setLayoutX(14);
	    imageMenu.setLayoutY(13);
	    paneImageNew.getChildren().add(imageMenu);
}
//lấy hình ảnh từ máy tính
@FXML
private void addImageNew(MouseEvent event) {
 JFileChooser filechooser=new JFileChooser();
 filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
 
 int result=filechooser.showOpenDialog(null);
 if(result==JFileChooser.APPROVE_OPTION)
 {
	 File imageFile=filechooser.getSelectedFile();
	 try(FileInputStream fileInputStream=new FileInputStream(imageFile)) {
		imageNew =new byte[(int) imageFile.length()];
		fileInputStream.read(imageNew);
		loadImageNew(imageNew);
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
@FXML
private void addNew(MouseEvent event) {
    try {
        paneAddEndUpdateNew.setVisible(false);
        boolean check=true;
        if(tfTatleNew.getText().isEmpty())
		{
			lableNotification.setText("Chưa nhập tiêu đề !!!");
			check=false;
		}else if(imageNew==null)
		{
			lableNotification.setText("Chưa thêm hình ảnh !!!");
			check=false;
		}else if(tfContentNew.getText().isEmpty())
		{
			lableNotification.setText("Nội dụng chưa nhập !!!");
		    check=false;
		}
        if(!check)
        {
        	paneNotification.setVisible(true);
            btCancelNotification.setVisible(true);
            btCancelNotification.setOnMouseClicked(event1 -> {
                paneNotification.setVisible(false);
                paneAddEndUpdateNew.setVisible(true);
            });
            btOkNotification.setVisible(false);
            return;
        }
		String tatleNew=tfTatleNew.getText();
		String contentNew=tfContentNew.getText();
		LocalDateTime time=LocalDateTime.now();
		boolean checkId=false;
		for(var news:NewDto.getAllNews())
		{
		  if(news.getIdNew()==idNew)
		  {
			  checkId=true;
		  }
		}
		lableNotification.setText(
	            checkId ? "Bạn muốn cập nhật thông tin ?" : "Bạn muốn thêm thông tin ?"
	        );
		addEndUpdateNew(idNew, tatleNew, contentNew, time, imageNew);
        } catch (NumberFormatException e) {
            lableNotification.setText("Nhập sai dữ liệu! Vui lòng kiểm tra lại các trường số.");
        } catch (Exception e) {
             lableNotification.setText("Có lỗi xảy ra khi thêm thông báo.");
             e.printStackTrace();
       }
}
//
private void addEndUpdateNew(int idNew,String tatleNew,String comtentNew,LocalDateTime time,byte[] image)
{
	paneNotification.setVisible(true);
    btCancelNotification.setVisible(true);
    btCancelNotification.setOnMouseClicked(event -> {
        paneNotification.setVisible(false);
        paneAddEndUpdateNew.setVisible(true);
    });
    btOkNotification.setVisible(true);
    btOkNotification.setOnMouseClicked(event -> {
        lableNotification.setText(NewDto.addEndUpdateNew(idNew, tatleNew, comtentNew, time, image));
        btCancelNotification.setOnMouseClicked(event1 -> {
            paneNotification.setVisible(false);
            loadViewNew();
            resetNew();
            paneAddEndUpdateNew.setVisible(true);
        });
        btOkNotification.setVisible(false);
    });
}
//-------------------------------------Sale------------------------------------
//-------------------------------------customer--------------------------------
//load thông tin khách hàng lên table
private void loadTableCustomer()
{
	try {
		ObservableList<String> listSelectCustomer=FXCollections.observableArrayList();
		tableViewCustomer.getItems().clear();
		cbbSelectCustomer.getItems().clear();
		for(var customer: CustomerDto.getAllCustomers())
		{
			createTableCustomer(customer);
		}
		listSelectCustomer.addAll("Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Tên tài khoản", "Mật khẩu","Điểm");
		cbbSelectCustomer.setItems(listSelectCustomer);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//thêm khách hàng vào bảng table
private void createTableCustomer(Customer customer)
{
	Button button =new Button("Xem");
	button.setPrefWidth(98);
	button.setMinWidth(50); 
	button.setMaxWidth(98);
	button.setOnMouseClicked(event->{
		resetCustomer();
		tfIdCustomer.setText(customer.getIdCustomer()+"");
	    tfNameCustomer.setText(customer.getName());
	    tfPhoneCustomer.setText(customer.getPhone());
	    tfPointCustomer.setText(customer.getPointAccount()+"");
	    tfNameAccount.setText(customer.getNameAccount());
	    tfPasswordAccount.setText(customer.getPasswordAccount());
	    java.time.Duration remainTime=java.time.Duration.ofSeconds(customer.getRemainTime());
	    tfHourRemainTime.setText(remainTime.toHours()+"");
	    tfSecondRemainTime.setText(remainTime.toMinutes()%60+"");
	    tfMinuteRemainTime.setText(remainTime.getSeconds()%60+""); 
	    tfRemainMoney.setText(convertMoneyString(customer.getRemainMoney()));
		paneAddEndUpdateCustomer.setVisible(true);
		btExitCustomer.setVisible(true);
		btExitCustomer.setOnMouseClicked(event1->{
			paneAddEndUpdateCustomer.setVisible(false);
		});
		btOkCustomer.setVisible(true);
		btOkCustomer.setOnMouseClicked(event1->{
			addEndUpdateCustomer(event1);
			});
	});
	CustomerTableRow rowData=new CustomerTableRow(
		customer.getIdCustomer(),
		customer.getName(),
		customer.getPhone(),
		customer.getNameAccount(),
		customer.getPasswordAccount(),
		customer.getPointAccount(),
		customer.getRemainTime(),
		button
	);
	customerList.add(rowData);
	idCustomer.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdCustomer()).asObject());
	nameCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameCustomer()));
	phoneCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneCustomer()));
	nameAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameAccount()));
	passwordAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPasswordAccount()));
	pointAccount.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPointAccount()).asObject());
	remainTime.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getRemainTime()).asObject());
	showCustomer.setCellValueFactory(cellData -> new SimpleObjectProperty<Button>(cellData.getValue().getShowCustomer()));
	tableViewCustomer.setItems(customerList);
}
//tìm kiếm khách hàng
@FXML
private void searchCustomer(KeyEvent event)
{
	try {
		tableViewCustomer.getItems().clear();
		String text=searchCustomer.getText().toLowerCase();
		int selectIndex=cbbSelectCustomer.getSelectionModel().getSelectedIndex();
	
		for(var customer: CustomerDto.getAllCustomers())
		{
			boolean check=false;
			if(selectIndex==0)
			{
				check=text.isEmpty() || (customer.getIdCustomer()+"").toLowerCase().contains(text);
			}
			else if(selectIndex==1)
			{
			     check=text.isEmpty() || customer.getName().toLowerCase().contains(text);
			}
			else if( selectIndex==2)
			{
				check=text.isEmpty() || customer.getPhone().toLowerCase().contains(text);
			}
			else if( selectIndex==3)
			{
				check=text.isEmpty() || customer.getNameAccount().toLowerCase().contains(text);
			}
			else if(selectIndex ==4)
			{
				check=text.isEmpty() || customer.getPasswordAccount().toLowerCase().contains(text);
			}
			else if(selectIndex==5)
			{
				check=text.isEmpty() || (customer.getPointAccount()+"").toLowerCase().contains(text);
			}
			if(cbbSelectCustomer.getValue()==null)
			{
				createTableCustomer(customer);
			}
		    if(check)
		    {
		    	createTableCustomer(customer);
		    }
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//thêm và cập nhật khách hàng
@FXML
private void addEndUpdateCustomer(MouseEvent event) {
    paneAddEndUpdateCustomer.setVisible(false);
    try {
        boolean check = true;
        if (tfNameCustomer.getText().isEmpty()) {
            lableNotification.setText("Tên khách hàng chưa nhập !!!");
            check = false;
        }
        else if (tfPhoneCustomer.getText().isEmpty() || !tfPhoneCustomer.getText().matches("\\d{10,11}")) {
            lableNotification.setText("Số điện thoại phải có 10-11 chữ số !!!");
            check = false;
        }
        else if (tfPointCustomer.getText().isEmpty() || !tfPointCustomer.getText().matches("\\d+")) {
            lableNotification.setText("Số điểm chưa nhập và phải là số !!!");
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
        if (!check) {
            displayNotification();
            return;
        }
        int idCustomer = 0;
        if (!tfIdCustomer.getText().isEmpty()) {
            idCustomer = Integer.parseInt(tfIdCustomer.getText());
        }
        Double remainMoney=convertMoney(tfRemainMoney.getText().trim());
        String nameCustomer = tfNameCustomer.getText();
        int pointCustomer = Integer.parseInt(tfPointCustomer.getText());
        if (pointCustomer < 0) {
            lableNotification.setText("Điểm không được nhỏ hơn 0 !!!");
            displayNotification();
            return;
        }
        String phoneCustomer = tfPhoneCustomer.getText();
        String nameAccount = tfNameAccount.getText();
        String passwordAccount = tfPasswordAccount.getText();
        int time=0;
        try {
        	 int hourRemainTime = Integer.parseInt(tfHourRemainTime.getText());
             int minuteRemainTime = Integer.parseInt(tfMinuteRemainTime.getText());
             int secondRemainTime = Integer.parseInt(tfSecondRemainTime.getText());
		     if(hourRemainTime<0 || minuteRemainTime<0 || secondRemainTime<0)
		     {
		    	 lableNotification.setText("Thời gian nhập không hợp lệ");
				 displayNotification();
				 return;
		     }
		     time = (hourRemainTime * 3600) + (minuteRemainTime * 60) + secondRemainTime;
        } catch (Exception e) {
			 lableNotification.setText("Thời gian nhập không hợp lệ");
			 displayNotification();
			 return;
		}

        boolean checkId = false;
        for(var customer: CustomerDto.getAllCustomers())
        {
        	if(customer.getIdCustomer()==idCustomer)
        	{
        		checkId=true;
        		break;
        	}
        }
        lableNotification.setText(
                checkId ? "Bạn muốn cập nhật thông tin khách hàng ?" : "Bạn muốn thêm thông tin khách hàng ?"
        );

        setupAddEndUpdateCustomer(idCustomer, nameCustomer, phoneCustomer, nameAccount, passwordAccount, pointCustomer, time,remainMoney);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void displayNotification() {
    paneNotification.setVisible(true);
    btCancelNotification.setVisible(true);
    btCancelNotification.setOnMouseClicked(event -> {
        paneNotification.setVisible(false);
        paneAddEndUpdateCustomer.setVisible(true);
    });
    btOkNotification.setVisible(false);
}

//hiển thị thông báo cập nhật và thêm thành công
private void setupAddEndUpdateCustomer(int idCustomer, String nameCustomer, String phoneCustomer, String nameAccount, String passwordAccount, int pointAccount, long remainTime, Double remainMoney)
{
	paneNotification.setVisible(true);
	btCancelNotification.setVisible(true);
	btCancelNotification.setOnMouseClicked(event->{
		paneNotification.setVisible(false);
		paneAddEndUpdateCustomer.setVisible(true);
	});
	btOkNotification.setVisible(true);
	btOkNotification.setOnMouseClicked(event->{
		lableNotification.setText(CustomerDto.addEndUpdateCustomer(idCustomer, nameCustomer, phoneCustomer, nameAccount, passwordAccount, pointAccount, remainTime, remainMoney));
		btOkNotification.setVisible(false);
		btCancelNotification.setVisible(true);
		btCancelNotification.setOnMouseClicked(event1->{
			paneNotification.setVisible(false);
			loadTableCustomer();
			resetCustomer();
			paneAddEndUpdateCustomer.setVisible(true);
		});
	});
}
//click nút add trong customer
@FXML
private void addCustomer(MouseEvent event)
{
	resetCustomer();
	paneAddEndUpdateCustomer.setVisible(true);
	btExitCustomer.setVisible(true);
	btExitCustomer.setOnMouseClicked(event1->{
		paneAddEndUpdateCustomer.setVisible(false);
	});
	btOkCustomer.setVisible(true);
}
//xóa toàn bộ thông tin của paneAddEndUpdateCustomer
private void resetCustomer()
{
	tfIdCustomer.setText("");
	tfNameCustomer.setText("");
	tfPhoneCustomer.setText("");
	tfNameAccount.setText("");
	tfPasswordAccount.setText("");
	tfPointCustomer.setText("");
	tfMinuteRemainTime.setText("");
	tfSecondRemainTime.setText("");
	tfHourRemainTime.setText("");
	tfRemainMoney.setText("");
}

//-------------------------------------customer--------------------------------
//-------------------------------------BillHistory--------------------------------
//load thông tin hóa đơn lên bảng
private void loadTableBillHistory()
{
	try {
		ObservableList<String> lisstSelectBillHistory=FXCollections.observableArrayList();
		tableViewBillHistory.getItems().clear();
		tableViewBillHistory.setPrefHeight(550);
		tableViewBillHistory.setPrefWidth(1014);
		cbbSelectBillHistory.getItems().clear();
		for(var billHistory:BillHistoryDto.getAllBillHistorys())
		{
			createTableBillHistory(billHistory);
		}
		lisstSelectBillHistory.addAll("Nhân viên","Khách hàng","Máy","Mã giảm giá","hình thức thanh toán");
		cbbSelectBillHistory.setItems(lisstSelectBillHistory);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//Thêm hóa đơn vào bảng table
private void createTableBillHistory(BillHistory billhistory)
{
	Button button=new Button("Xem");
	button.setPrefWidth(97);
	button.setMinWidth(50); 
	button.setMaxWidth(97);
	button.setOnMouseClicked(event->{
		paneShowBillHistory.setVisible(true);
		int index=1;
		tableViewDetailBill.getItems().clear();
		for(var detailBill:DetailBillDto.getAllDetailBills())
		{ 
			if(detailBill.getIdBillHistory()==billhistory.getIdBillHistory())
			{
				DetailBillTableRow dataRow=new DetailBillTableRow(
					index,
				    productDto.checkIdProductTakeNameProduct(detailBill.getIdProduct()),
				    detailBill.getQuantityProduct(),
				    convertMoneyString(detailBill.getSumMoneyProduct())
			       );
				index++;
				detailBillList.add(dataRow);
				numberProductDetailBill.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumberProduct()).asObject());
				nameProductDetailBill.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameProduct()));
				quantityProductDetailBill.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantityProduct()).asObject());
				sumMoneyProductDetailBill.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSumMoneyproduct()));
				tableViewDetailBill.setItems(detailBillList);
				
			}
		}
		lbNameCustomer.setText(CustomerDto.checkIDCustomerTakeNameCustomer(billhistory.getIdCustomer()));
		lbNameComputer.setText(ComputerDto.checkIDComputerTakeNameComputer(billhistory.getIdComputer()));
		java.time.Duration remainTime=java.time.Duration.ofSeconds(billhistory.getTimeUserComputer());
		lbTimeUserComputer.setText(remainTime.toHours()+"h"+remainTime.toMinutes()%60+"m"+remainTime.getSeconds()%60+"s");
	    tfSumMoneyBill.setText(convertMoneyString(billhistory.getSumMoneyBill()));
		btExitBillHistory.setOnMouseClicked(event1->{
	    		paneShowBillHistory.setVisible(false);
	     })	;
	});
 
	BillHistoryTableRow dataRow=new BillHistoryTableRow(
			StaffDto.checkIDTakeNameStaff(billhistory.getIdStaff()),
			CustomerDto.checkIDCustomerTakeNameCustomer(billhistory.getIdCustomer()),
			ComputerDto.checkIDComputerTakeNameComputer(billhistory.getIdComputer()),
			PromotionDto.checkIdPromotionTakeNamePromotion(billhistory.getIdPromotion()),
			billhistory.getDatePaymentBill(),
			billhistory.getFormPaymentBill(),
			convertMoneyString(billhistory.getSumMoneyBill()),
			button
			);
	billHistoryList.add(dataRow);
	nameStaffBillHistory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameStaff()));
	nameCustomerBillHistory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameCustomer()));
	nameComputerbillHistory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameComputer()));
    namePromotionBillHistory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNamePromotion()));
    datePaymentBill.setCellValueFactory(cellData -> new SimpleObjectProperty<Date>(cellData.getValue().getDatePaymentBill()));
    formPaymentBill.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormPaymentBill()));
    sumMoneyBull.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSumMoneyBill()));
    showBillHistory.setCellValueFactory(cellData -> new SimpleObjectProperty<Button>(cellData.getValue().getShow()));
    tableViewBillHistory.setItems(billHistoryList);
}
//time kiếm hóa đơn
@FXML
private void searchBillHistory(KeyEvent event)
{
	try {
		tableViewBillHistory.getItems().clear();
		String text=tfSearchBillHistory.getText().toLowerCase();
		int selectIndex=cbbSelectBillHistory.getSelectionModel().getSelectedIndex();
		for(var billHistory: BillHistoryDto.getAllBillHistorys())
		{
			boolean check=false;
			if(selectIndex==0)
			{
				check=text.isEmpty() || (StaffDto.checkIDTakeNameStaff(billHistory.getIdStaff())).toLowerCase().contains(text);
			}
			else if(selectIndex==1)
			{
			     check=text.isEmpty() || CustomerDto.checkIDCustomerTakeNameCustomer(billHistory.getIdCustomer()).toLowerCase().contains(text);
			}
			else if( selectIndex==2)
			{
				check=text.isEmpty() || ComputerDto.checkIDComputerTakeNameComputer(billHistory.getIdComputer()).toLowerCase().contains(text);
			}
			else if( selectIndex==3)
			{
				check=text.isEmpty() || PromotionDto.checkIdPromotionTakeNamePromotion(billHistory.getIdPromotion()).toLowerCase().contains(text);
			}
			else if(selectIndex ==4)
			{
				check=text.isEmpty() || billHistory.getFormPaymentBill().toLowerCase().contains(text);
			}
		    if(check)
		    {
		    	createTableBillHistory(billHistory);
		    }
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//-------------------------------------BillHistory--------------------------------
//-------------------------------------Revenue------------------------------------
//Tạo biểu đồ doanh thu
private void createLineChartRevenue(Map<?, Double> data, String seriesName) {
    lineChartRevenue.getData().clear();
    lineChartRevenue.getData().clear();
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName(seriesName);
    Double sum = 0.0;
    for (Map.Entry<?, Double> entry : data.entrySet()) {
        String date = entry.getKey().toString();
        Double amount = entry.getValue();
        series.getData().add(new XYChart.Data<>(date, amount));
        sum += amount;
    }
    lbSumBillHistory.setText(convertMoneyString(sum));

    lineChartRevenue.getData().add(series);
}
//Tạo biểu đồ doanh thu theo ngày
private void createLineChartRevenueDay() {
createLineChartRevenue(BillHistoryDto.getTotalAmountByDate(), "Doanh thu ngày");
}
//Tạo biểu đồ doanh thu theo tháng
private void createLineChartRevenueMonth() {
createLineChartRevenue(BillHistoryDto.getTotalAmountByMonthYear(), "Doanh thu tháng");
}
//click combobox show doanh thu theo ngày và theo tháng
@FXML
private void cbbShowLineChartRevenue(ActionEvent event) {
int index = comboboxSelectRevenue.getSelectionModel().getSelectedIndex();
if (index == 0) {
   createLineChartRevenueDay();
} else if (index == 1) {
   createLineChartRevenueMonth();
}
}
//tìm kiếm thu nhập theo thời gian đã cho
@FXML
private void btShowLineChartRevenue(MouseEvent event) {
    if(dpStartLineChartRevenue.getValue() == null && dpEndLineChartRevenue.getValue() == null)
    {
    	 if (comboboxSelectRevenue.getSelectionModel().getSelectedIndex() == 0) {
          	 createLineChartRevenue(BillHistoryDto.getTotalAmountByDate(), "Doanh thu ngày");
          }
    	 else
         if(comboboxSelectRevenue.getSelectionModel().getSelectedIndex() == 1)
         {
        		 createLineChartRevenue(BillHistoryDto.getTotalAmountByMonthYear(), "Doanh thu tháng");
         }
    	 return;
    }else
	if (dpStartLineChartRevenue.getValue() == null) {
        showNotification("Thời gian bắt đầu chưa chọn !!!");
        return;
    }else
    if (dpEndLineChartRevenue.getValue() == null) {
        showNotification("Thời gian kết thúc chưa chọn !!!");
        return;
    }else
    if (dpStartLineChartRevenue.getValue().isAfter(dpEndLineChartRevenue.getValue())) {
        showNotification("Thời gian bắt đầu không được sau thời gian kết thúc !!!");
        return;
    }
   
    LocalDate localDateStart = dpStartLineChartRevenue.getValue();
    LocalDate localDateEnd = dpEndLineChartRevenue.getValue();
    if (localDateStart != null && localDateEnd != null) {  
     try {
           Instant instantStart = localDateStart.atStartOfDay(ZoneId.systemDefault()).toInstant();
           Instant instantEnd = localDateEnd.atStartOfDay(ZoneId.systemDefault()).toInstant();
           java.util.Date startUtilDate = Date.from(instantStart);
           java.util.Date endUtilDate = Date.from(instantEnd);
           java.sql.Date startSqlDate = new java.sql.Date(startUtilDate.getTime());
           java.sql.Date endSqlDate = new java.sql.Date(endUtilDate.getTime());
           if (comboboxSelectRevenue.getSelectionModel().getSelectedIndex() == 0) {
          	 createLineChartRevenue(BillHistoryDto.getTotalAmountByDateSearch(startSqlDate, endSqlDate), "Doanh thu ngày");
             }
           else
           if(comboboxSelectRevenue.getSelectionModel().getSelectedIndex() == 1)
           {
        		 createLineChartRevenue(BillHistoryDto.getTotalAmountByMonthYearSearch(startSqlDate, endSqlDate), "Doanh thu tháng");
           }
           return;
        } catch (Exception e) {
                e.printStackTrace();
                showNotification("Có lỗi xảy ra khi xử lý thời gian. Vui lòng thử lại!");
         }
      }  
}
//hiển thị lỗi khi tìm kiếm 
private void showNotification(String message) {
    paneNotification.setVisible(true);
    lableNotification.setText(message);
    btCancelNotification.setVisible(true);
    btCancelNotification.setOnMouseClicked(event -> paneNotification.setVisible(false));
    btOkNotification.setVisible(false);
}
//tạo biểu đồ thống kê khách hàng
private void createBarChartGuest(Map<?, Integer> data,String seriesName)
{
	barChartGuest.getData().clear();
	barChartGuest.getData().clear();
	XYChart.Series<String, Integer> series=new XYChart.Series<>();
	series.setName(seriesName);
	for (Map.Entry<?, Integer> entry : data.entrySet()) {
        String date = entry.getKey().toString();
        Integer amount = entry.getValue();
        series.getData().add(new XYChart.Data<>(date, amount));
    }
	barChartGuest.getData().add(series);
}
//click combobox hiển thị biểu đồ theo lựa chọn
@FXML
private void cbbShowBarChartGuest(ActionEvent event)
{
	int index = comboboxSelectGuest.getSelectionModel().getSelectedIndex();
	if (index == 0) {
	   createBarChartGuest(BillHistoryDto.getTotalCustomersByDate(), "Lượng khách trong ngày");
	} else if (index == 1) {
	   createBarChartGuest(BillHistoryDto.getTotalCustomersByMonth(), "Lượng khách trong tháng");
	}
}
//tìm kiếm thông thông tin lượng người cho biết thời gian
@FXML
private void btShowBarCharGuest(MouseEvent event)
{
	if(dpStartBarChartGuest.getValue() == null && dpEndBarChartGuest.getValue() == null)
    {
    	 if (comboboxSelectGuest.getSelectionModel().getSelectedIndex() == 0) {
    		 createBarChartGuest(BillHistoryDto.getTotalCustomersByDate(), "Lượng người của ngày");
          }
    	 else
         if(comboboxSelectGuest.getSelectionModel().getSelectedIndex() == 1)
         {
        	 createBarChartGuest(BillHistoryDto.getTotalCustomersByMonth(), "Lượng người của tháng");
         }
    	 return;
    }else
	if (dpStartBarChartGuest.getValue() == null) {
        showNotification("Thời gian bắt đầu chưa chọn !!!");
        return;
    }else
    if (dpEndBarChartGuest.getValue() == null) {
        showNotification("Thời gian kết thúc chưa chọn !!!");
        return;
    }else
    if (dpStartBarChartGuest.getValue().isAfter(dpEndBarChartGuest.getValue())) {
        showNotification("Thời gian bắt đầu không được sau thời gian kết thúc !!!");
        return;
    }
   
    LocalDate localDateStart = dpStartBarChartGuest.getValue();
    LocalDate localDateEnd = dpEndBarChartGuest.getValue();
    if (localDateStart != null && localDateEnd != null) {  
     try {
           Instant instantStart = localDateStart.atStartOfDay(ZoneId.systemDefault()).toInstant();
           Instant instantEnd = localDateEnd.atStartOfDay(ZoneId.systemDefault()).toInstant();
           java.util.Date startUtilDate = Date.from(instantStart);
           java.util.Date endUtilDate = Date.from(instantEnd);
           java.sql.Date startSqlDate = new java.sql.Date(startUtilDate.getTime());
           java.sql.Date endSqlDate = new java.sql.Date(endUtilDate.getTime());
           if (comboboxSelectGuest.getSelectionModel().getSelectedIndex() == 0) {
          	 createBarChartGuest(BillHistoryDto.getTotalCustomersByDate(startSqlDate, endSqlDate), "Lượng người của ngày");
             }
           else
           if(comboboxSelectGuest.getSelectionModel().getSelectedIndex() == 1)
           {
        	   createBarChartGuest(BillHistoryDto.getTotalCustomersByMonth(startSqlDate, endSqlDate), "Lượng người của tháng");
           }
           return;
        } catch (Exception e) {
                e.printStackTrace();
                showNotification("Có lỗi xảy ra khi xử lý thời gian. Vui lòng thử lại!");
         }
      }  
}
//tạo biểu đồ tròn xem thống kê máy tính
private void createPieChartComputer(Map<Integer, Integer> data)
{
	PieChartComputer.getData().clear();
	PieChartComputer.getData().clear();
	vboxNodeChartCOmputer.getChildren().clear();
	for(Map.Entry<Integer, Integer> entry : data.entrySet())
	{
		String nameComputer=ComputerDto.checkIDComputerTakeNameComputer(entry.getKey());
		PieChart.Data slice=new PieChart.Data(nameComputer, entry.getValue());
		PieChartComputer.getData().add(slice);
		String node=nameComputer+" số lần sử dụng : "+entry.getValue();
		createVboxNodePieChartCompute(node);
	}
}
//thêm chú thích
private void createVboxNodePieChartCompute(String text)
{
	Label lable=new Label();
	lable.setPrefWidth(284);
	lable.setPrefHeight(28);
	lable.setStyle("-fx-font-family:'Arial';" +
	                 "-fx-font-size:14px;" +
			         "-fx-text-fill:white;"
			);
	lable.setText(text);
	vboxNodeChartCOmputer.getChildren().add(lable);
}
//hiển thị biểu đồ lên mà hình
private void showPieChartComputer()
{
	createPieChartComputer(BillHistoryDto.getComputerUsageCount());
}
//tìm kiếm thông số máy sử dụng theo thời gian
@FXML
private void searchpieChartComputer(MouseEvent event)
{
	if(dpStartpieChartComputer.getValue() == null && dpEndPieChartComputer.getValue() == null)
    {
		showPieChartComputer();
    }else
	if (dpStartpieChartComputer.getValue() == null) {
        showNotification("Thời gian bắt đầu chưa chọn !!!");
        return;
    }else
    if (dpEndPieChartComputer.getValue() == null) {
        showNotification("Thời gian kết thúc chưa chọn !!!");
        return;
    }else
    if (dpStartpieChartComputer.getValue().isAfter(dpEndPieChartComputer.getValue())) {
        showNotification("Thời gian bắt đầu không được sau thời gian kết thúc !!!");
        return;
    }
   
    LocalDate localDateStart = dpStartpieChartComputer.getValue();
    LocalDate localDateEnd = dpEndPieChartComputer.getValue();
    if (localDateStart != null && localDateEnd != null) {  
     try {
           Instant instantStart = localDateStart.atStartOfDay(ZoneId.systemDefault()).toInstant();
           Instant instantEnd = localDateEnd.atStartOfDay(ZoneId.systemDefault()).toInstant();
           java.util.Date startUtilDate = Date.from(instantStart);
           java.util.Date endUtilDate = Date.from(instantEnd);
           java.sql.Date startSqlDate = new java.sql.Date(startUtilDate.getTime());
           java.sql.Date endSqlDate = new java.sql.Date(endUtilDate.getTime());
           createPieChartComputer(BillHistoryDto.getComputerUsageCount(startSqlDate,endSqlDate));
           return;
        } catch (Exception e) {
                e.printStackTrace();
                showNotification("Có lỗi xảy ra khi xử lý thời gian. Vui lòng thử lại!");
         }
      }  
}
//-------------------------------------Revenue------------------------------------
//-------------------------------------payment------------------------------------
//load thông tin lên bảng payment
private void loadTablePayMent()
{
	try {
		tablePayMent.getItems().clear();
		for(var payment: PayMentDto.getAllPayMents())
		{
			createTablePayMent(payment);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//thêm thông tin vào bảng
private void createTablePayMent(PayMent payment)
{
	Button button=new Button("Xem");
	button.setPrefWidth(82.3);
	button.setMinWidth(50); 
	button.setMaxWidth(82.4);
	button.setOnMouseClicked(event->{
		idPayMent=payment.getIdPayMent();
		tfNamePayMent.setText(payment.getNameProduct());
		tfValuePayMent.setText(convertMoneyString(payment.getValue()));
		java.sql.Date sqlDate = (java.sql.Date) payment.getImportDate();
		if (sqlDate != null) {
		    LocalDate localDate = sqlDate.toLocalDate();
		    dpImportDate.setValue(localDate);
		}
		tfNodePayment.setText(payment.getNode());
	});
	PayMentTableRow dataRow=new PayMentTableRow(
			payment.getNameProduct(),
			convertMoneyString(payment.getValue()),
			payment.getNode(),
			button
			);
	payMentList.add(dataRow);
	namePayMent.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameProduct()));
	valuePayMent.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getValue()));
	nodePayMent.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNode()));
	buttonPayMent.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getButton()));
	tablePayMent.setItems(payMentList);
}
//Tìm kiếm thông tin
@FXML
private void searchNameProductPayMent(KeyEvent event)
{
	String text=tfSearchPayMent.getText();
	tablePayMent.getItems().clear();
	for(var payment: PayMentDto.getAllPayMents())
	{
		if(payment.getNameProduct().toLowerCase().contains(text.toLowerCase()))
		{
			createTablePayMent(payment);
		}
	}
}
@FXML
private void AddPayment(MouseEvent event) {
    try {
    	
        boolean check = true;
        if (tfNamePayMent.getText().isEmpty()) {
            lableNotification.setText("Tên sản phẩm chưa nhập !!!");
            check = false;
        } 
        else if (tfValuePayMent.getText().isEmpty()) {
            lableNotification.setText("Giá sản phẩm chưa nhập !!!");
            check = false;
        } 
        else if (dpImportDate.getValue() == null) {
            lableNotification.setText("Ngày mua chưa nhập !!!");
            check = false;
        } 
        else if (tfNodePayment.getText().isEmpty()) {
            lableNotification.setText("Ghi chú chưa nhập !!!");
            check = false;
        }
        if (!check) {
            paneNotification.setVisible(true);
            btCancelNotification.setVisible(true);
            btCancelNotification.setOnMouseClicked(event1 -> {
                paneNotification.setVisible(false);
            });
            btOkNotification.setVisible(false);
            return; 
        }
        String namePayment = tfNamePayMent.getText().trim();
        Double value =convertMoney( tfValuePayMent.getText().trim());
        if(value==null)
         {
    	   check=false;
        }
        if (!check) {
            paneNotification.setVisible(true);
            btCancelNotification.setVisible(true);
            btCancelNotification.setOnMouseClicked(event1 -> {
                paneNotification.setVisible(false);
            });
            btOkNotification.setVisible(false);
            return;
        }

        Date importDate = Date.valueOf(dpImportDate.getValue());
        String node = tfNodePayment.getText();

        boolean checkId = false;
        for (var payment : PayMentDto.getAllPayMents()) {
            if (payment.getIdPayMent() == idPayMent) {
                checkId = true;
                break;
            }
        }

        lableNotification.setText(checkId ? "Bạn muốn cập nhật thông tin ?" : "Bạn muốn thêm thông tin ?");
        addEndUpdatepayment(idPayMent, namePayment, value, node, importDate);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Cập nhật và thêm thông tin cho payment
private void addEndUpdatepayment(int idPayMent, String nameProduct, double value, String node, Date importDate) {
    paneNotification.setVisible(true);
    btCancelNotification.setVisible(true);
    btCancelNotification.setOnMouseClicked(event -> {
        paneNotification.setVisible(false);
    });

    btOkNotification.setVisible(true);
    btOkNotification.setOnMouseClicked(event -> {
    	 lableNotification.setText(PayMentDto.addEndUpdatePayment(idPayMent, nameProduct, value, node, importDate));
        deleteFormPayMent();
        loadTablePayMent();
        btCancelNotification.setVisible(true);
        btCancelNotification.setOnMouseClicked(event1 -> {
            paneNotification.setVisible(false);
        });
        btOkNotification.setVisible(false);
    });
}

//xóa toàn bộ thông tin bảng payMent
private void deleteFormPayMent()
{
	idPayMent=0;
	tfNamePayMent.setText("");
	tfValuePayMent.setText("");
	dpImportDate.setValue(null);
	tfNodePayment.setText("");
}
//Xóa thông tin PayMent
@FXML
private void deletePayMent(MouseEvent event)
{
	paneNotification.setVisible(true);
	boolean chechId=false;
	for(var payment: PayMentDto.getAllPayMents())
	{
		if(payment.getIdPayMent()==idPayMent)
		{
			chechId=true;
			break;
		}
	}
	lableNotification.setText(
			chechId?"Bạn muốn xóa sản phẩm "+tfNamePayMent.getText()+" ?":"Bạn chưa chọn sản phẩm xóa ?"
			);
	btOkNotification.setVisible(true);
	btOkNotification.setOnMouseClicked(event1->{
		lableNotification.setText(PayMentDto.deletePaymentById(idPayMent));
		paneNotification.setVisible(false);
		deleteFormPayMent();
		loadTablePayMent();
	});
	btCancelNotification.setVisible(true);
	btCancelNotification.setOnMouseClicked(event1->{
		paneNotification.setVisible(false);
	});
}
//-------------------------------------payment------------------------------------
//-------------------------------------LineChartpayment------------------------------------
//tạo biểu đồ thống kê chi tiêu
private void createLineChartPayMent(Map<?, Double> data,String seriesName)
{
	lineChartPayMent.getData().clear();
	lineChartPayMent.getData().clear();
	XYChart.Series<String, Number> series=new XYChart.Series<>();
	series.setName(seriesName);
	Double sum=0.0;
	for (Map.Entry<?, Double> entry : data.entrySet()) {
        String date = entry.getKey().toString();
        Number amount = entry.getValue();
        sum+=entry.getValue();
        series.getData().add(new XYChart.Data<>(date, amount));
    }
	lbSumPayMent.setText(sum+" VND");
	lineChartPayMent.getData().add(series);
}
//click combobox hiển thị biểu đồ theo lựa chọn
@FXML
private void comboboxShowSelectPayMent(ActionEvent event)
{
	int index = comboboxSelectPayMent.getSelectionModel().getSelectedIndex();
	if (index == 0) {
		createLineChartPayMent(PayMentDto.getTotalValueByDate(),"Chi tiêu trong ngày");
	} else if (index == 1) {
		createLineChartPayMent(PayMentDto.getTotalValueByMonth(), "Chi tiêu trong tháng");
	}
}
@FXML
private void searchLineChartPayMent(MouseEvent event)
{
	 if(dpStartPayMent.getValue() == null && dpEndPayMent.getValue() == null)
	    {
		 int index = comboboxSelectPayMent.getSelectionModel().getSelectedIndex();
			if (index == 0) {
				createLineChartPayMent(PayMentDto.getTotalValueByDate(),"Chi tiêu trong ngày");
			} else if (index == 1) {
				createLineChartPayMent(PayMentDto.getTotalValueByMonth(), "Chi tiêu trong tháng");
			}
	    	 return;
	    }else
		if (dpStartPayMent.getValue() == null) {
			showNotificationPayMent("Thời gian bắt đầu chưa chọn !!!");
	        return;
	    }else
	    if (dpEndPayMent.getValue() == null) {
	    	showNotificationPayMent("Thời gian kết thúc chưa chọn !!!");
	        return;
	    }else
	    if (dpStartPayMent.getValue().isAfter(dpEndPayMent.getValue())) {
	    	showNotificationPayMent("Thời gian bắt đầu không được sau thời gian kết thúc !!!");
	        return;
	    }
	    LocalDate localDateStart = dpStartPayMent.getValue();
	    LocalDate localDateEnd = dpEndPayMent.getValue();
	    if (localDateStart != null && localDateEnd != null) {  
	     try {
	           Instant instantStart = localDateStart.atStartOfDay(ZoneId.systemDefault()).toInstant();
	           Instant instantEnd = localDateEnd.atStartOfDay(ZoneId.systemDefault()).toInstant();
	           java.util.Date startUtilDate = Date.from(instantStart);
	           java.util.Date endUtilDate = Date.from(instantEnd);
	           java.sql.Date startSqlDate = new java.sql.Date(startUtilDate.getTime());
	           java.sql.Date endSqlDate = new java.sql.Date(endUtilDate.getTime());
	            int index = comboboxSelectPayMent.getSelectionModel().getSelectedIndex();
				if (index == 0) {
					createLineChartPayMent(PayMentDto.getTotalValueByDate(startSqlDate,endSqlDate),"Chi tiêu trong ngày");
				} else if (index == 1) {
					createLineChartPayMent(PayMentDto.getTotalValueByMonth(startSqlDate,endSqlDate), "Chi tiêu trong tháng");
				}
	           return;
	        } catch (Exception e) {
	              e.printStackTrace();
	              showNotificationPayMent("Có lỗi xảy ra khi xử lý thời gian. Vui lòng thử lại!");
	    }
	}  
}
//hiển thị lỗi 
private void showNotificationPayMent(String text)
{
	paneNotification.setVisible(true);
	lableNotification.setText(text);
	btCancelNotification.setVisible(true);
	btCancelNotification.setOnMouseClicked(event->{
		paneNotification.setVisible(false);
	});
	btOkNotification.setVisible(false);
}
}

