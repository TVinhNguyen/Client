package Utils;

import java.util.ArrayList;
import java.util.List;

import Manager.CategoryManager;
import Model.Category;
import javafx.scene.Parent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoadRoot {
    private static FXMLLoader  instance;

    private LoadRoot() {
    }

    public static FXMLLoader  getInstance() {
        if (instance == null) {
            try {
                instance = FXMLLoader.load(LoadRoot.class.getResource("/admin/chat.fxml"));
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
