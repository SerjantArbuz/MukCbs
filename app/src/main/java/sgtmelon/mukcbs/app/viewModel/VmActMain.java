package sgtmelon.mukcbs.app.viewModel;

import java.util.List;

import androidx.lifecycle.ViewModel;
import retrofit2.Callback;
import sgtmelon.mukcbs.app.model.item.ItemBook;
import sgtmelon.mukcbs.app.model.repo.RepoServer;
import sgtmelon.mukcbs.office.def.DefServer;
import sgtmelon.mukcbs.office.st.StSearch;

public class VmActMain extends ViewModel {

    private StSearch stSearch = new StSearch();
    private RepoServer repoServer = new RepoServer();

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
        repoServer.getApi()
                .getData(DefServer.place_code[stSearch.getPlace()], stSearch.getTextLast())
                .enqueue(serverCallback);
    }

}
