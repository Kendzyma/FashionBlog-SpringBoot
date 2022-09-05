package FashionBlog.Service.Interface;

import FashionBlog.Dto.SignUpDto;
import FashionBlog.Dto.signInDto;

import java.security.NoSuchAlgorithmException;

public interface IUserService {
    String signUp(SignUpDto dto) throws NoSuchAlgorithmException;

    String signIn(signInDto dto) throws NoSuchAlgorithmException;
}
