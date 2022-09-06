package FashionBlog.Service.Interface;

import FashionBlog.Dto.CommentDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Model.Comment;

import java.util.List;

public interface ICommentService {
    Comment createComment(CommentDto commentDto) throws PostNotFoundException;

    Comment updateComment(CommentDto commentDto, int commentId) throws PostNotFoundException;

    void deleteComment(int commentId);

    List<CommentDto> getAllPostComment(int postId) throws PostNotFoundException;
}
