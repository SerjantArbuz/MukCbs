package sgtmelon.mukcbs.office.st;

public class StSearch {

    private boolean load = false;

    private int place = 0;
    private int placeLast = 0;
    private String text = "";
    private String textLast = "";

    public boolean isAccess() {
        return text.length() != 0;
    }

    public boolean isLoad() {
        return load;
    }

    public void setLoad(boolean load) {
        this.load = load;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setPlaceLast() {
        this.placeLast = place;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextLast() {
        return textLast;
    }

    public void setTextLast() {
        this.textLast = text;
    }

    public boolean isEnable() {
        return !text.equals("") && (!text.equals(textLast) || place != placeLast);
    }

}
