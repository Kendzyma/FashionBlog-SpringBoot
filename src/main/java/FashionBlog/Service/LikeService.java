package FashionBlog.Service;

import FashionBlog.Exception.LikesException.LikeNotFoundException;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Exception.UserException.UserNotFoundException;
import FashionBlog.Model.Like;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import FashionBlog.Repository.LikesRepository;
import FashionBlog.Repository.PostRepository;
import FashionBlog.Repository.UserRepository;
import FashionBlog.Service.Interface.ILikesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LikeService implements ILikesService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikesRepository likesRepository;

    public LikeService(UserRepository userRepository, PostRepository postRepository, LikesRepository likesRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.likesRepository = likesRepository;
    }

    @Override
    public String LikePost(int postId, int userId) throws PostNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(()->new PostNotFoundException("Post not found"));
       Optional<Like> likes = likesRepository.findLikeByPostAndUser(post,user);
       if(likes.isPresent()){
         likesRepository.delete(likes.get());
         return "Like Removed";
       }
       Like like = new Like(post,user);
       likesRepository.save(like);
        return "Like successfully added";
    }

    @Override
    public List<Like> getAllPostLikes(int postId) throws PostNotFoundException, LikeNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(()->new PostNotFoundException("Post not found"));
        return likesRepository.findLikesByPost(post).orElseThrow(()->new LikeNotFoundException("Likes not found"));


    }
}
