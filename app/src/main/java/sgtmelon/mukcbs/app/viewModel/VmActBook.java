package sgtmelon.mukcbs.app.viewModel;

import androidx.lifecycle.ViewModel;
import sgtmelon.mukcbs.app.model.ItemBook;

public class VmActBook extends ViewModel {

    private ItemBook itemBook;

    public ItemBook getItemBook() {
        return itemBook;
    }

    public void setItemBook(ItemBook itemBook) {
        this.itemBook = itemBook;
    }

}
