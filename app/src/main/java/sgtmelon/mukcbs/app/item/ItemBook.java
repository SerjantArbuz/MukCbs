package sgtmelon.mukcbs.app.item;

import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sgtmelon.mukcbs.office.def.DefBook;

public class ItemBook {

    //region Keys
    private final String KEY_ID = "BK_ID";
    private final String KEY_VOLUME = "BK_VOLUME";
    private final String KEY_TITLE = "BK_TITLE";
    private final String KEY_PLACE = "BK_PLACE";
    private final String KEY_PAGES = "BK_PAGES";
    private final String KEY_SERIES = "BK_SERIES";
    private final String KEY_ANNOTATION = "BK_ANNOTATION";
    private final String KEY_AUTHOR = "BK_AUTHOR";
    private final String KEY_COAUTHOR = "BK_CO_AUTHOR";
    private final String KEY_EDITOR = "BK_EDITOR";
    private final String KEY_COLLECTIVE = "BK_COLLECTIVE";
    private final String KEY_STORAGE = "BK_STORAGE";
    private final String KEY_HASH = "BK_HASH";
    //endregion

    public ItemBook(Intent intent) {
        id = intent.getIntExtra(DefBook.id, 0);
        volume = intent.getIntExtra(DefBook.volume, 0);

        title = intent.getStringExtra(DefBook.title);
        place = intent.getStringExtra(DefBook.place);
        pages = intent.getStringExtra(DefBook.pages);
        series = intent.getStringExtra(DefBook.series);
        annotation = intent.getStringExtra(DefBook.annotation);

        author = intent.getStringExtra(DefBook.author);
        coAuthor = intent.getStringExtra(DefBook.co_author);
        editor = intent.getStringExtra(DefBook.editor);
        collective = intent.getStringExtra(DefBook.collective);

        storage = intent.getStringExtra(DefBook.storage);
        hash = intent.getStringExtra(DefBook.hash);
    }

    public ItemBook(JSONObject jsonObject) {
        try {
            id = jsonObject.getInt(DefBook.id);
            volume = jsonObject.getInt(DefBook.volume);
            title = jsonObject.getString(DefBook.title);
            place = jsonObject.getString(DefBook.place);
            pages = jsonObject.getString(DefBook.pages);
            series = jsonObject.getString(DefBook.series);
            annotation = jsonObject.getString(DefBook.annotation);
            author = jsonObject.getString(DefBook.author);
            coAuthor = jsonObject.getString(DefBook.co_author);
            editor = jsonObject.getString(DefBook.editor);
            collective = jsonObject.getString(DefBook.collective);
            storage = jsonObject.getString(DefBook.storage);
            hash = jsonObject.getString(DefBook.hash);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
    private String title = null;
    @SerializedName(DefBook.place)
    @Expose
    private String place = null;
    @SerializedName(DefBook.pages)
    @Expose
    private String pages = null;
    @SerializedName(DefBook.series)
    @Expose
    private String series = null;
    @SerializedName(DefBook.annotation)
    @Expose
    private String annotation = null;
    @SerializedName(DefBook.author)
    @Expose
    private String author = null;
    @SerializedName(DefBook.co_author)
    @Expose
    private String coAuthor = null;
    @SerializedName(DefBook.editor)
    @Expose
    private String editor = null;
    @SerializedName(DefBook.collective)
    @Expose
    private String collective = null;
    @SerializedName(DefBook.storage)
    @Expose
    private String storage = null;
    @SerializedName(DefBook.hash)
    @Expose
    private String hash = null;

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
