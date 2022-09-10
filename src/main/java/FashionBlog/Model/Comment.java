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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    @CreationTimestamp
    private  LocalDateTime commentDate;
    private String commentBody;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="userId",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="postId",nullable = false)
    private Post post;

    public Comment(String commentBody, User user, Post post) {
        this.commentBody = commentBody;
        this.user = user;
        this.post = post;
    }
}
