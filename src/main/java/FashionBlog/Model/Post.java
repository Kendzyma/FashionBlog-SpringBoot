package FashionBlog.Model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String postTitle;
    private String postBody;
    private String url;
    @CreationTimestamp
    private LocalDateTime postCreationdate;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    public Post(String postTitle, String postBody, String url, User user) {
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.url = url;
        this.user = user;
    }
}
