package FashionBlog.Service.Interface;

import FashionBlog.Dto.PostDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Model.Post;

import java.util.List;

public interface IPostService {
    Post createPost(PostDto postDto);

    Post updatePost(PostDto postDto, int postId) throws PostNotFoundException;

    List<PostDto> getAllPost();

    PostDto getPost(int postId) throws PostNotFoundException;

    void deletePost(int postId);
}
