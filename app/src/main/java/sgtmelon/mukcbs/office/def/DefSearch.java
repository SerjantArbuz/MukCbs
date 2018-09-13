package sgtmelon.mukcbs.office.def;

import androidx.annotation.StringDef;

@StringDef({DefSearch.load,
        DefSearch.place, DefSearch.place_last,
        DefSearch.text, DefSearch.text_last})
public @interface DefSearch {

    String load = "SH_LOAD",
            place = "SH_PLACE",
            place_last = "SH_PLACE_LAST",
            text = "SH_TEXT",
            text_last = "SH_TEXT_LAST";

}
