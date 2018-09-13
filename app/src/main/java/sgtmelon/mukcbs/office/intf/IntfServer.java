package sgtmelon.mukcbs.office.intf;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sgtmelon.mukcbs.app.model.item.ItemBook;
import sgtmelon.mukcbs.office.def.DefServer;

public interface IntfServer {

    @GET(DefServer.extraUrl)
    Call<List<ItemBook>> getData(@Query(DefServer.place) String place, @Query(DefServer.text) String text);

}
