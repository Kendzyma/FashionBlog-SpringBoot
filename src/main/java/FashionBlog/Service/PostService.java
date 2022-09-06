package FashionBlog.Service;

import FashionBlog.Dto.PostDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Exception.UserException.UserNotFoundException;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import FashionBlog.Repository.PostRepository;
import FashionBlog.Repository.UserRepository;
import FashionBlog.Service.Interface.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PostService implements IPostService {
   private final UserRepository userRepository;
   private final PostRepository postRepository;
    @Override
    public Post createPost(PostDto postDto) {
        User user = userRepository.findById(postDto.getUserId()).orElseThrow(()-> new UserNotFoundException("User does not exist"));
        Post post = new Post();
        post.setPostBody(postDto.getPostBody());
        post.setPostTitle(postDto.getPostTitle());
        post.setUrl(postDto.getUrl());
        post.setUser(user);
       return postRepository.save(post);
    }

    @Override
    public Post updatePost(PostDto postDto, int postId) throws PostNotFoundException {
        User user = userRepository.findById(postDto.getUserId()).orElseThrow(()-> new UserNotFoundException("User does not exist"));
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostNotFoundException("Post not found"));

        post.setPostTitle(postDto.getPostTitle());
        post.setPostBody(postDto.getPostBody());
        post.setUrl(postDto.getUrl());
        post.setUser(user);

      return postRepository.save(post);

    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach((post1)->{
            PostDto postDto = new PostDto();
            postDto.setPostBody(post1.getPostBody());
            postDto.setPostTitle(post1.getPostTitle());
            postDto.setUrl(post1.getUrl());
            postDto.setUserId(post1.getUser().getUserId());
            postDtos.add(postDto);
        });
        return postDtos;
    }

    @Override
    public PostDto getPost(int postId) throws PostNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostNotFoundException("Post not found"));
        PostDto postDto = new PostDto();
        postDto.setPostTitle(post.getPostTitle());
        postDto.setPostBody(post.getPostBody());
        postDto.setUrl(post.getUrl());
        postDto.setUserId(post.getUser().getUserId());
        return postDto;

    }

    @Override
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }
}
