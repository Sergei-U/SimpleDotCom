import java.util.ArrayList;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;


    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public void setName(String n) {
        name = n;
    }

    public String checkYourSelf(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
        }
        if (locationCells.isEmpty()) {
            result = "Потопил";
        } else {
            result = "Попал";
        }
        return result;
    }
}
