package mx.inigofr.softnextdoor.posts.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.inigofr.softnextdoor.R;
import mx.inigofr.softnextdoor.posts.interfaces.IPostDataModel;
import mx.inigofr.softnextdoor.comments.view.CommentsActivity;

/**
 * Created by inigo on 09/06/18.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private int resource;
    private Activity activity;
    private List<? extends IPostDataModel> posts;

    public PostsAdapter(int resource, Activity activity, List<? extends IPostDataModel> posts) {
        this.resource = resource;
        this.activity = activity;
        this.posts = posts;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        final int pos = getItemViewType(position);

        holder.postTittle.setText(posts.get(pos).getTitle());
        holder.postBody.setText(posts.get(pos).getBody());

        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CommentsActivity.class);
                intent.putExtra("id", String.valueOf(posts.get(pos).getId()));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        private View     content;
        private TextView postTittle;
        private TextView postBody;

        public PostViewHolder(View itemView) {
            super(itemView);

            postTittle  = itemView.findViewById(R.id.tv_post_tittle);
            postBody    = itemView.findViewById(R.id.tv_post_body);
            content     = itemView.findViewById(R.id.ll_content);
        }
    }
}
