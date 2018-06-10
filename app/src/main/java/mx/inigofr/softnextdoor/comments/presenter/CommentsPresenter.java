package mx.inigofr.softnextdoor.comments.presenter;

import java.util.List;

import mx.inigofr.softnextdoor.comments.interactor.CommentsInteractor;
import mx.inigofr.softnextdoor.comments.interactor.ICommentsInteractor;
import mx.inigofr.softnextdoor.comments.interfaces.ICommentsDataModel;
import mx.inigofr.softnextdoor.comments.view.ICommentsView;

/**
 * Created by inigo on 09/06/18.
 */

public class CommentsPresenter implements ICommentsPresenter {

    ICommentsView commentsView;
    ICommentsInteractor commentsInteractor;

    public CommentsPresenter(ICommentsView commentsView) {
        this.commentsView = commentsView;
        commentsInteractor = new CommentsInteractor(this);
    }

    @Override
    public void requestComments(String params) {
        commentsInteractor.requestComments(params);
    }

    @Override
    public void responsePosts(List<? extends ICommentsDataModel> comments) {
        commentsView.responsePosts(comments);
    }

    @Override
    public void responseError(String error) {
        commentsView.responseError(error);
    }
}
