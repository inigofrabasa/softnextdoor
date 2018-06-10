package mx.inigofr.softnextdoor.comments.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import mx.inigofr.softnextdoor.R;
import mx.inigofr.softnextdoor.comments.adapter.CommentsAdapter;
import mx.inigofr.softnextdoor.comments.interfaces.ICommentsDataModel;
import mx.inigofr.softnextdoor.comments.presenter.CommentsPresenter;
import mx.inigofr.softnextdoor.comments.presenter.ICommentsPresenter;

public class CommentsActivity extends AppCompatActivity implements ICommentsView{

    private ICommentsPresenter commentsPresenter;
    private RecyclerView commentsRecyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commentsRecyclerView = findViewById(R.id.rv_comments);
        progressBar = findViewById(R.id.indeterminateBarComments);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        commentsRecyclerView.setLayoutManager(linearLayoutManager);

        commentsPresenter = new CommentsPresenter(this);

        String id = getIntent().getStringExtra("id");
        commentsPresenter.requestComments(id);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void responsePosts(List<? extends ICommentsDataModel> comments) {

        progressBar.setVisibility(View.GONE);

        if(comments != null){
            CommentsAdapter postsAdapter
                    = new CommentsAdapter(R.layout.comment_item, this, comments);
            commentsRecyclerView.setAdapter(postsAdapter);
            commentsRecyclerView.invalidate();
        }
    }

    @Override
    public void responseError(String error) {

        progressBar.setVisibility(View.GONE);

    }
}
