package Manager;

import java.util.List;

import Model.Computer;

public class ComputerManager {
    private List<Computer> computers;

    public void addComputer(Computer computer) { computers.add(computer); }
    public void deleteComputer(long id) { /* logic */ }
    public void toggleComputer(long id, boolean on) { /* logic */ }
}
