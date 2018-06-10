package mx.inigofr.softnextdoor.posts.respository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import mx.inigofr.softnextdoor.posts.interfaces.IPostDataModel;

/**
 * Created by inigo on 09/06/18.
 */

public class Post implements IPostDataModel {

    @SerializedName("userId")
    @Expose
    private Integer userId;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;



    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBody() {
        return body;
    }
}
