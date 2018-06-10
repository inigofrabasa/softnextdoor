package mx.inigofr.softnextdoor.comments.repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by inigo on 09/06/18.
 */

public interface ICommentDataService {
    @GET("comments")
    Call<List<Comment>> getComments(@Query("id") String id);
}
