package sgtmelon.mukcbs.app.model.item;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sgtmelon.mukcbs.office.def.DefBook;

public class ItemBook {

    public ItemBook(Bundle bundle) {
        id = bundle.getInt(DefBook.id, 0);
        volume = bundle.getInt(DefBook.volume, 0);

        title = bundle.getString(DefBook.title);
        place = bundle.getString(DefBook.place);
        pages = bundle.getString(DefBook.pages);
        series = bundle.getString(DefBook.series);
        annotation = bundle.getString(DefBook.annotation);

        author = bundle.getString(DefBook.author);
        coAuthor = bundle.getString(DefBook.co_author);
        editor = bundle.getString(DefBook.editor);
        collective = bundle.getString(DefBook.collective);

        storage = bundle.getString(DefBook.storage);
        hash = bundle.getString(DefBook.hash);
    }

    public void fillBundle(Bundle bundle){
        bundle.putInt(DefBook.id, id);
        bundle.putInt(DefBook.volume, volume);

        bundle.putString(DefBook.title, title);
        bundle.putString(DefBook.place, place);
        bundle.putString(DefBook.pages, pages);
        bundle.putString(DefBook.series, series);
        bundle.putString(DefBook.annotation, annotation);

        bundle.putString(DefBook.author, author);
        bundle.putString(DefBook.co_author, coAuthor);
        bundle.putString(DefBook.editor, editor);
        bundle.putString(DefBook.collective, collective);

        bundle.putString(DefBook.storage, storage);
        bundle.putString(DefBook.hash, hash);
    }

    public Intent fillIntent(Intent intent) {
        intent.putExtra(DefBook.id, id);
        intent.putExtra(DefBook.volume, volume);

        intent.putExtra(DefBook.title, title);
        intent.putExtra(DefBook.place, place);
        intent.putExtra(DefBook.pages, pages);
        intent.putExtra(DefBook.series, series);
        intent.putExtra(DefBook.annotation, annotation);

        intent.putExtra(DefBook.author, author);
        intent.putExtra(DefBook.co_author, coAuthor);
        intent.putExtra(DefBook.editor, editor);
        intent.putExtra(DefBook.collective, collective);

        intent.putExtra(DefBook.storage, storage);
        intent.putExtra(DefBook.hash, hash);

        return intent;
    }

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
