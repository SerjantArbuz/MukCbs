package sgtmelon.mukcbs.office.st;

import android.os.Parcel;
import android.os.Parcelable;

public class StSearch implements Parcelable {

    public StSearch() {

    }

    private StSearch(Parcel in) {
        load = in.readByte() != 0;
        place = in.readInt();
        placeLast = in.readInt();
        text = in.readString();
        textLast = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (load ? 1 : 0));
        parcel.writeInt(place);
        parcel.writeInt(placeLast);
        parcel.writeString(text);
        parcel.writeString(textLast);
    }

    public static final Creator<StSearch> CREATOR = new Creator<StSearch>() {
        @Override
        public StSearch createFromParcel(Parcel in) {
            return new StSearch(in);
        }

        @Override
        public StSearch[] newArray(int size) {
            return new StSearch[size];
        }
    };

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
