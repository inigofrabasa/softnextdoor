package mx.inigofr.softnextdoor.posts.presenter;

import java.util.List;

import mx.inigofr.softnextdoor.posts.interactor.IPostsInteractor;
import mx.inigofr.softnextdoor.posts.interactor.PostsInteractor;
import mx.inigofr.softnextdoor.posts.interfaces.IPostDataModel;
import mx.inigofr.softnextdoor.posts.view.IPostsView;

/**
 * Created by inigo on 09/06/18.
 */

public class PostsPresenter implements IPostsPresenter {

    IPostsView postsView;
    IPostsInteractor postsInteractor;

    public PostsPresenter(IPostsView postsView){
        this.postsView = postsView;
        postsInteractor = new PostsInteractor(this);
    }

    @Override
    public void requestPosts() {
        postsInteractor.requestPosts();
    }

    @Override
    public void responsePosts(List<? extends IPostDataModel> posts) {
        postsView.responsePosts(posts);
    }

    @Override
    public void responseError(String error) {
        postsView.responseError(error);
    }
}
