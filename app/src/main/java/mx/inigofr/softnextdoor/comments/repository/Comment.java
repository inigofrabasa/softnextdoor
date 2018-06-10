package mx.inigofr.softnextdoor.comments.repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import mx.inigofr.softnextdoor.comments.interfaces.ICommentsDataModel;

/**
 * Created by inigo on 09/06/18.
 */

public class Comment implements ICommentsDataModel {
    @SerializedName("postId")
    @Expose
    private Integer postId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("body")
    @Expose
    private String body;

    @Override
    public Integer getPostId() {
        return postId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getBody() {
        return body;
    }
}
