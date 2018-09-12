package sgtmelon.mukcbs.office.intf;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sgtmelon.mukcbs.app.item.ItemBook;
import sgtmelon.mukcbs.office.def.DefSearch;

public interface IntfServer {

    @GET(DefSearch.extraUrl)
    Call<List<ItemBook>> getData(@Query(DefSearch.place) String place, @Query(DefSearch.text) String text);

}
