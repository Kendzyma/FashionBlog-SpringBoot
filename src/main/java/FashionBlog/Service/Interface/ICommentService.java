package FashionBlog.Service.Interface;

import FashionBlog.Dto.CommentDto;
import FashionBlog.Exception.PostException.PostNotFoundException;

import java.util.List;

public interface ICommentService {
    void createComment(CommentDto commentDto) throws PostNotFoundException;

    void updateComment(CommentDto commentDto, int commentId) throws PostNotFoundException;

    void deleteComment(int commentId);

    List<CommentDto> getAllPostComment(int postId) throws PostNotFoundException;
}
