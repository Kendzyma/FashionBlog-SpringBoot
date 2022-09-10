package FashionBlog.Dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommentDto implements Serializable {

    private @NotNull String commentBody;
    private int userId;
    private int postId;
}
