package mx.inigofr.softnextdoor.comments.view;

import java.util.List;

import mx.inigofr.softnextdoor.comments.interfaces.ICommentsDataModel;

/**
 * Created by inigo on 09/06/18.
 */

public interface ICommentsView {
    void responsePosts(List<? extends ICommentsDataModel> posts);
    void responseError(String error);
}
