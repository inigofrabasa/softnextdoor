package mx.inigofr.softnextdoor.comments.presenter;

import java.util.List;

import mx.inigofr.softnextdoor.comments.interfaces.ICommentsDataModel;

/**
 * Created by inigo on 09/06/18.
 */

public interface ICommentsPresenter {
    void requestComments(String params);
    void responsePosts(List<? extends ICommentsDataModel> comments);
    void responseError(String error);
}