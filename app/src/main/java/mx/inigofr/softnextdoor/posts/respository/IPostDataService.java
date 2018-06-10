package mx.inigofr.softnextdoor.posts.respository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by inigo on 09/06/18.
 */

public interface IPostDataService {
    @GET("posts")
    Call<List<Post>> getPosts();
}
