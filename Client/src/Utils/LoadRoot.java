package Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LoadRoot {
    private static FXMLLoader instance;

    private LoadRoot() {
    }

    public static FXMLLoader getInstance() {
        if (instance == null) {
            try {
                instance = new FXMLLoader(LoadRoot.class.getResource("/admin/contentHome.fxml")); 
                instance.load(); 
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return instance;
    }

    public static void setInstance(FXMLLoader pr) {
        instance = pr;
    }

    public static Parent getRoot() {
        return instance.getRoot();
    }
}
