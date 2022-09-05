package FashionBlog.Service.Interface;

import FashionBlog.Dto.PostDto;
import FashionBlog.Exception.PostException.PostNotFoundException;

import java.util.List;

public interface IPostService {
    void createPost(PostDto postDto);

    void updatePost(PostDto postDto, int postId) throws PostNotFoundException;

    List<PostDto> getAllPost();

    PostDto getPost(int postId) throws PostNotFoundException;

    void deletePost(int postId);
}
