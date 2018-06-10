package mx.inigofr.softnextdoor.posts.view;

import java.util.List;

import mx.inigofr.softnextdoor.posts.interfaces.IPostDataModel;

/**
 * Created by inigo on 09/06/18.
 */

public interface IPostsView {
    void responsePosts(List<? extends IPostDataModel> posts);
    void responseError(String error);
}
