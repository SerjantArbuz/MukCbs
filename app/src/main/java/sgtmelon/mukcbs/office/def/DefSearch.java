package sgtmelon.mukcbs.office.def;

import androidx.annotation.StringDef;

@StringDef({DefSearch.place, DefSearch.text})
public @interface DefSearch {

    String baseUrl = "http://katalog.arhlib.ru";
    String extraUrl = "/app/search.php";

    String place = "shPlace", text = "shText";

    String[] place_code = new String[]{
            "TITLE",
            "PLACE",
            "SERIES",
            "ANNOTATION",
            "AUTHOR",
    };

}
