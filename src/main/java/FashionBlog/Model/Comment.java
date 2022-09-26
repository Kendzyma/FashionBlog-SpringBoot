package FashionBlog.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    public Comment(String commentBody, User user, Post post) {
        this.commentBody = commentBody;
        this.user = user;
        this.post = post;
    }
}
