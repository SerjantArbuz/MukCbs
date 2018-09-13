package sgtmelon.mukcbs.app.viewModel;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;
import sgtmelon.mukcbs.app.model.item.ItemBook;

public class VmActBook extends ViewModel {

    public void setValue(Bundle bundle) {
        itemBook = new ItemBook(bundle);
    }

    private ItemBook itemBook;

    public ItemBook getItemBook() {
        return itemBook;
    }

}
