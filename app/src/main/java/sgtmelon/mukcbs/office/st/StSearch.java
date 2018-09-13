package sgtmelon.mukcbs.office.st;

import android.os.Bundle;

import sgtmelon.mukcbs.office.def.DefSearch;

public class StSearch {

    public StSearch() {

    }

    public StSearch(Bundle bundle) {
        load = bundle.getBoolean(DefSearch.load);

        place = bundle.getInt(DefSearch.place);
        placeLast = bundle.getInt(DefSearch.place_last);

        text = bundle.getString(DefSearch.text);
        textLast = bundle.getString(DefSearch.text_last);
    }

    public void fillBundle(Bundle outState) {
        outState.putBoolean(DefSearch.load, load);
        outState.putInt(DefSearch.place, place);
        outState.putInt(DefSearch.place_last, placeLast);
        outState.putString(DefSearch.text, text);
        outState.putString(DefSearch.text_last, textLast);
    }

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
