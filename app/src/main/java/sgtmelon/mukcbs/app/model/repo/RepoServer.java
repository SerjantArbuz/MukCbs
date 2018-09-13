package sgtmelon.mukcbs.app.model.repo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sgtmelon.mukcbs.office.def.DefServer;
import sgtmelon.mukcbs.office.intf.IntfServer;

public class RepoServer {

    private IntfServer api;

    public RepoServer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DefServer.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(IntfServer.class);

    }

    public IntfServer getApi() {
        return api;
    }

}
