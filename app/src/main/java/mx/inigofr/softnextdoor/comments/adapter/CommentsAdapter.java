package mx.inigofr.softnextdoor.comments.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.inigofr.softnextdoor.R;
import mx.inigofr.softnextdoor.comments.interfaces.ICommentsDataModel;

/**
 * Created by inigo on 09/06/18.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>{

    private int resource;
    private Activity activity;
    private List<? extends ICommentsDataModel> comments;

    public CommentsAdapter(int resource, Activity activity, List<? extends ICommentsDataModel> comments) {
        this.resource = resource;
        this.activity = activity;
        this.comments = comments;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        final int pos = getItemViewType(position);

        holder.commentName.setText(comments.get(pos).getName());
        holder.commentEmail.setText(comments.get(pos).getEmail());
        holder.commentBody.setText(comments.get(pos).getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder{

        private TextView commentName;
        private TextView commentEmail;
        private TextView commentBody;

        public CommentsViewHolder(View itemView) {
            super(itemView);

            commentName  = itemView.findViewById(R.id.tv_comment_name);
            commentEmail    = itemView.findViewById(R.id.tv_comment_email);
            commentBody    = itemView.findViewById(R.id.tv_comment_body);
        }
    }
}
