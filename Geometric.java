import java.util.Date;

public class Geometric {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public Geometric () {
        color = "none";
        filled = false;
        dateCreated = new Date();
    }

    public Geometric(String colour, boolean fill) {
        color = colour;
        filled = fill;
        dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String colour) {
        color = colour;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean fill) {
        filled = fill;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "Color is " + color + "\nDate created is: " + dateCreated;
    }

}
