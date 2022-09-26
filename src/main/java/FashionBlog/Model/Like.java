package FashionBlog.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    @JsonBackReference
    @ManyToOne()
    private Post post;
    @JsonBackReference
    @ManyToOne()
    private User user;

    public Like(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}
