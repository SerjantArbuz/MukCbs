package sgtmelon.mukcbs.app.viewModel;

import java.util.List;

import androidx.lifecycle.ViewModel;
import retrofit2.Callback;
import sgtmelon.mukcbs.app.model.ItemBook;
import sgtmelon.mukcbs.app.provider.PrvApi;
import sgtmelon.mukcbs.office.def.DefApi;
import sgtmelon.mukcbs.office.st.StSearch;

public class VmActMain extends ViewModel {

    private StSearch stSearch = new StSearch();
    private PrvApi prvApi = new PrvApi();

    public StSearch getStSearch() {
        return stSearch;
    }

    public void setStSearch(StSearch stSearch) {
        this.stSearch = stSearch;
    }

    private Callback<List<ItemBook>> serverCallback;

    public void setServerCallback(Callback<List<ItemBook>> serverCallback) {
        this.serverCallback = serverCallback;
    }

    public void loadData(){
        prvApi.getApi()
                .getData(DefApi.place_code[stSearch.getPlace()], stSearch.getTextLast())
                .enqueue(serverCallback);
    }

}
