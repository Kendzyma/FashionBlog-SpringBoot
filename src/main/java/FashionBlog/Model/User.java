package FashionBlog.Model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Database generated id")
    private int userId;
    @ApiModelProperty(notes = "User firstname")
    private @NotNull String firstName;
    private @NotNull String lastName;
    @ApiModelProperty(
            value = "email name of the user",
            name = "email",
            dataType = "String",
            example = "Kendzyma75@gmail.com")
    private @NotNull String email;
    private @NotNull String password;

    @CreationTimestamp
    private @NotNull LocalDateTime accountCreationDate;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
