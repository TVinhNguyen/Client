package Utils;


import javafx.fxml.FXMLLoader;

public class LoadRoot {
    private static FXMLLoader  instance;

    private LoadRoot() {
    }

    public static FXMLLoader  getInstance() {
        if (instance == null) {
            try {
                instance = FXMLLoader.load(LoadRoot.class.getResource("/admin/interfaceLogin.fxml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    public static void setInstance(FXMLLoader  pr)
    {
    	instance = pr;
    }
}
