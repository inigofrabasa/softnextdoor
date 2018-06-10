package mx.inigofr.softnextdoor.comments.interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import mx.inigofr.softnextdoor.comments.presenter.ICommentsPresenter;
import mx.inigofr.softnextdoor.comments.repository.Comment;
import mx.inigofr.softnextdoor.comments.repository.ICommentDataService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by inigo on 09/06/18.
 */

public class CommentsInteractor implements ICommentsInteractor {

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    ICommentsPresenter commentsPresenter;

    public CommentsInteractor(ICommentsPresenter commentsPresenter) {
        this.commentsPresenter = commentsPresenter;
    }

    @Override
    public void requestComments(String params) {
        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ICommentDataService service = retrofit.create(ICommentDataService.class);

        Call<List<Comment>> messagesCall = service.getComments(params);
        if(messagesCall != null){
            messagesCall.enqueue(new Callback<List<Comment>>() {
                @Override
                public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                    if(response.body() != null){
                        commentsPresenter.responsePosts(response.body());
                    }
                    else if(response.body() == null){
                        commentsPresenter.responseError("0");
                    }
                }

                @Override
                public void onFailure(Call<List<Comment>> call, Throwable t) {
                    commentsPresenter.responseError(t.getMessage());
                }
            });
        }
    }
}
