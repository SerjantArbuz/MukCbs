package sgtmelon.mukcbs.office.intf;

import android.view.View;

public interface IntfItem {

    interface Click {
        void onItemClick(View view, int p);
    }

    interface LongClick {
        void onItemLongClick(View view, int p);
    }

}
