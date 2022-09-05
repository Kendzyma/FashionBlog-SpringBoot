package FashionBlog.Service;

import FashionBlog.Dto.CommentDto;
import FashionBlog.Dto.PostDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Exception.UserException.UserNotFoundException;
import FashionBlog.Model.Comment;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import FashionBlog.Repository.CommentRepository;
import FashionBlog.Repository.PostRepository;
import FashionBlog.Repository.UserRepository;
import FashionBlog.Service.Interface.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentService implements ICommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    private CommentRepository commentRepository;
    @Override
    public void createComment(CommentDto commentDto) throws PostNotFoundException {
        Comment comment = new Comment();
        Post post = postRepository.findById(commentDto.getPostId()).orElseThrow(()->new PostNotFoundException("Post not found"));
        User user = userRepository.findById(commentDto.getUserId()).orElseThrow(()-> new UserNotFoundException("user not found"));
        comment.setCommentBody(commentDto.getCommentBody());
        comment.setPost(post);
        comment.setUser(user);
        commentRepository.save(comment);

    }

    @Override
    public void updateComment(CommentDto commentDto, int commentId) throws PostNotFoundException {
        User user = userRepository.findById(commentDto.getUserId()).orElseThrow(()-> new UserNotFoundException("user not found"));
        Post post = postRepository.findById(commentDto.getPostId()).orElseThrow(()->new PostNotFoundException("Post not found"));

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setCommentBody(commentDto.getCommentBody());
        comment.setPost(post);
    }

    @Override
    public void deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> getAllPostComment(int postId) throws PostNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(()->new PostNotFoundException("Post not found"));
        List<Comment> comments = commentRepository.findCommentsByPost(post);
        List<CommentDto> commentDtos = new ArrayList<>();
        comments.forEach((comment)->{
            CommentDto commentDto = new CommentDto();
            commentDto.setCommentBody(comment.getCommentBody());
            commentDto.setPostId(comment.getPost().getPostId());
            commentDto.setUserId(comment.getUser().getUserId());
            commentDtos.add(commentDto);
        });
        return commentDtos;
    }
}
