package mx.inigofr.softnextdoor.posts.interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import mx.inigofr.softnextdoor.posts.presenter.IPostsPresenter;
import mx.inigofr.softnextdoor.posts.respository.IPostDataService;
import mx.inigofr.softnextdoor.posts.respository.Post;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by inigo on 09/06/18.
 */

public class PostsInteractor implements IPostsInteractor {

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    IPostsPresenter postsPresenter;

    public PostsInteractor(IPostsPresenter postsPresenter) {
        this.postsPresenter = postsPresenter;
    }

    @Override
    public void requestPosts() {
        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IPostDataService service = retrofit.create(IPostDataService.class);

        Call<List<Post>> messagesCall = service.getPosts();
        if(messagesCall != null){
            messagesCall.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if(response.body() != null){
                        postsPresenter.responsePosts(response.body());
                    }
                    else if(response.body() == null){
                        postsPresenter.responseError("0");
                    }
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {
                    postsPresenter.responseError(t.getMessage());
                }
            });
        }
    }
}