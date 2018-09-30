package sgtmelon.mukcbs.office.def;

import androidx.annotation.StringDef;

@StringDef({
        DefIntent.BOOK,
        DefIntent.SEARCH
})
public @interface DefIntent {

    String BOOK = "INTENT_BOOK",
            SEARCH = "INTENT_SEARCH";

}
