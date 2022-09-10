package FashionBlog.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private String postTitle;
    private String postBody;
    private String url;
    private int userId;

    public PostDto(String postTitle, String postBody, String url) {
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.url = url;
    }
}
