package mx.inigofr.softnextdoor.posts.presenter;

import java.util.List;

import mx.inigofr.softnextdoor.posts.interfaces.IPostDataModel;

/**
 * Created by inigo on 09/06/18.
 */

public interface IPostsPresenter {
    void requestPosts();
    void responsePosts(List<? extends IPostDataModel> posts);
    void responseError(String error);
}