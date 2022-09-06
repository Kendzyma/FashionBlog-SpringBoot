package FashionBlog.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String postTitle;
    private String postBody;
    private String url;
    private int userId;
}
