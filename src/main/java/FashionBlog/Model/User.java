package FashionBlog.Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @ApiModelProperty(notes = "Database generated id")
    private int userId;
  //  @ApiModelProperty(notes = "User firstname")
    private  String firstName;
    private  String lastName;
//    @ApiModelProperty(
//            value = "email name of the user",
//            name = "email",
//            dataType = "String",
//            example = "Kendzyma75@gmail.com")
    private String email;
    private String password;

    @CreationTimestamp
    private  LocalDateTime accountCreationDate;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
