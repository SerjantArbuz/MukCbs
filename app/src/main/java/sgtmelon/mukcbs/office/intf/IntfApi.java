package sgtmelon.mukcbs.office.intf;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sgtmelon.mukcbs.app.model.ItemBook;
import sgtmelon.mukcbs.office.def.DefApi;

public interface IntfApi {

    @GET(DefApi.extraUrl)
    Call<List<ItemBook>> getData(@Query(DefApi.place) String place, @Query(DefApi.text) String text);

}
