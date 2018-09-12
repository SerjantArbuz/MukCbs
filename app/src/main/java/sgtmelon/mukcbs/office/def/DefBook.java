package sgtmelon.mukcbs.office.def;

import androidx.annotation.StringDef;

@StringDef({DefBook.id,
        DefBook.volume, DefBook.title,
        DefBook.place, DefBook.pages,
        DefBook.series, DefBook.annotation,
        DefBook.author, DefBook.co_author,
        DefBook.editor, DefBook.collective,
        DefBook.storage, DefBook.hash
})
public @interface DefBook {

    String id = "id",
            volume = "volume",
            title = "title",
            place = "place",
            pages = "pages",
            series = "series",
            annotation = "annotation",
            author = "author",
            co_author = "co_author",
            editor = "editor",
            collective = "collective",
            storage = "storage",
            hash = "hash";

}
