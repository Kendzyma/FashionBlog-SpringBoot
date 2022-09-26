package FashionBlog.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @JsonManagedReference
    @OneToMany(orphanRemoval = true,mappedBy = "post",cascade = CascadeType.ALL)
   private List<Comment> comments;
    @JsonManagedReference
    @OneToMany(mappedBy = "post",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Like> likes;
    public Post(String postTitle, String postBody, String url, User user) {
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.url = url;
        this.user = user;
    }
}
