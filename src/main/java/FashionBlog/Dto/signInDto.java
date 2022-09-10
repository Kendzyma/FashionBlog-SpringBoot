package FashionBlog.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class signInDto {
    private String email;
    private String password;
}
