package FashionBlog.Service.Interface;

import FashionBlog.Exception.LikesException.LikeNotFoundException;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Model.Like;

import java.util.List;

public interface ILikesService {
    String LikePost(int postId, String userEmail) throws PostNotFoundException;

    List<Like> getAllPostLikes(int postId) throws PostNotFoundException, LikeNotFoundException;
}
