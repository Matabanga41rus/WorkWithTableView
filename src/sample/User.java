package sample;

public class User {
    private String firstCell;
    private String secondCell;

    public String getSecondCell() {
        return secondCell;
    }

    public void setSecondCell(String secondCell) {
        this.secondCell = secondCell;
    }

    public User(String firstCell, String secondCell){
        this.firstCell = firstCell;
        this.secondCell = secondCell;
    }

    public String getFirstCell() {
        return firstCell;
    }

    public void setFirstCell(String firstCell) {
        this.firstCell = firstCell;
    }
}
