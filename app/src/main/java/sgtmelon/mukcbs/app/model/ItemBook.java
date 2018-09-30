package sgtmelon.mukcbs.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sgtmelon.mukcbs.office.def.DefBook;

public class ItemBook implements Parcelable {

    public ItemBook() {

    }

    private ItemBook(Parcel in) {
        id = in.readInt();
        volume = in.readInt();
        title = in.readString();
        place = in.readString();
        pages = in.readString();
        series = in.readString();
        annotation = in.readString();
        author = in.readString();
        coAuthor = in.readString();
        editor = in.readString();
        collective = in.readString();
        storage = in.readString();
        hash = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(volume);
        parcel.writeString(title);
        parcel.writeString(place);
        parcel.writeString(pages);
        parcel.writeString(series);
        parcel.writeString(annotation);
        parcel.writeString(author);
        parcel.writeString(coAuthor);
        parcel.writeString(editor);
        parcel.writeString(collective);
        parcel.writeString(storage);
        parcel.writeString(hash);
    }


    public static final Creator<ItemBook> CREATOR = new Creator<ItemBook>() {
        @Override
        public ItemBook createFromParcel(Parcel in) {
            return new ItemBook(in);
        }

        @Override
        public ItemBook[] newArray(int size) {
            return new ItemBook[size];
        }
    };

    @SerializedName(DefBook.id)
    @Expose
    private int id;
    @SerializedName(DefBook.volume)
    @Expose
    private int volume;
    @SerializedName(DefBook.title)
    @Expose
    private String title;
    @SerializedName(DefBook.place)
    @Expose
    private String place;
    @SerializedName(DefBook.pages)
    @Expose
    private String pages;
    @SerializedName(DefBook.series)
    @Expose
    private String series;
    @SerializedName(DefBook.annotation)
    @Expose
    private String annotation;
    @SerializedName(DefBook.author)
    @Expose
    private String author;
    @SerializedName(DefBook.co_author)
    @Expose
    private String coAuthor;
    @SerializedName(DefBook.editor)
    @Expose
    private String editor;
    @SerializedName(DefBook.collective)
    @Expose
    private String collective;
    @SerializedName(DefBook.storage)
    @Expose
    private String storage;
    @SerializedName(DefBook.hash)
    @Expose
    private String hash;

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public String getTitle() {
        return title;
    }

    public String getPlace() {
        return place;
    }

    public String getPages() {
        return pages;
    }

    public String getSeries() {
        return series;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getAuthor() {
        return author;
    }

    public String getCoAuthor() {
        return coAuthor;
    }

    public String getEditor() {
        return editor;
    }

    public String getCollective() {
        return collective;
    }

    public String getStorage() {
        return storage;
    }

    public String getHash() {
        return hash;
    }

}
