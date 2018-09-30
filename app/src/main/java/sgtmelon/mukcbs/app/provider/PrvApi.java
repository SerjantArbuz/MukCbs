package sgtmelon.mukcbs.app.provider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sgtmelon.mukcbs.office.def.DefApi;
import sgtmelon.mukcbs.office.intf.IntfApi;

public class PrvApi {

    private IntfApi api;

    public PrvApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DefApi.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(IntfApi.class);

    }

    public IntfApi getApi() {
        return api;
    }

}
