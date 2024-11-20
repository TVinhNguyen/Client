package TableRow;

import javafx.scene.control.Button;

public class StaffTableRow {
    private String name;
    private String phone;
    private int dayWork;
    private String role;
    private Button showButton;

    public StaffTableRow(String name, String phone, int dayWork, String role, Button showButton) {
        this.name = name;
        this.phone = phone;
        this.dayWork = dayWork;
        this.role = role;
        this.showButton = showButton;
    }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getDayWork() { return dayWork; }
    public String getRole() { return role; }
    public Button getShowButton() { return showButton; }
}

