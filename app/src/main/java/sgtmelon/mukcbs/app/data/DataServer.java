package sgtmelon.mukcbs.app.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sgtmelon.mukcbs.office.def.DefSearch;
import sgtmelon.mukcbs.office.intf.IntfServer;

public class DataServer {

    private IntfServer api;

    public DataServer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DefSearch.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(IntfServer.class);

    }

    public IntfServer getApi() {
        return api;
    }

}
