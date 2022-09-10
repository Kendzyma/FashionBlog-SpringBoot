package FashionBlog.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
