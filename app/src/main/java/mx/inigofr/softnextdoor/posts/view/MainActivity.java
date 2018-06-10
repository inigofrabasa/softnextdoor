package mx.inigofr.softnextdoor.posts.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import mx.inigofr.softnextdoor.R;
import mx.inigofr.softnextdoor.posts.adapter.PostsAdapter;
import mx.inigofr.softnextdoor.posts.interfaces.IPostDataModel;
import mx.inigofr.softnextdoor.posts.presenter.IPostsPresenter;
import mx.inigofr.softnextdoor.posts.presenter.PostsPresenter;

public class MainActivity extends AppCompatActivity implements IPostsView {

    private IPostsPresenter postsPresenter;
    private RecyclerView postsRecyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsRecyclerView = findViewById(R.id.rv_posts);
        progressBar = findViewById(R.id.indeterminateBar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        postsRecyclerView.setLayoutManager(linearLayoutManager);

        postsPresenter = new PostsPresenter(this);
        postsPresenter.requestPosts();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void responsePosts(List<? extends IPostDataModel> posts) {

        progressBar.setVisibility(View.GONE);

        if(posts != null){
            PostsAdapter postsAdapter
                    = new PostsAdapter(R.layout.post_item, this, posts);
            postsRecyclerView.setAdapter(postsAdapter);
            postsRecyclerView.invalidate();
        }
    }

    @Override
    public void responseError(String error) {

        progressBar.setVisibility(View.GONE);

    }
}
