package FashionBlog.Service;

import FashionBlog.Dto.SignUpDto;
import FashionBlog.Dto.signInDto;
import FashionBlog.Exception.UserException.AuthenticationException;
import FashionBlog.Exception.UserException.UserFoundException;
import FashionBlog.Exception.UserException.UserNotFoundException;
import FashionBlog.Model.User;
import FashionBlog.Repository.UserRepository;
import FashionBlog.Service.Interface.IUserService;
import FashionBlog.Util.PasswordHashing;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordHashing passwordHashing;


    @Override
    public String signUp(SignUpDto dto) throws NoSuchAlgorithmException {
        Optional<User> tmpuser = userRepository.findUserByEmail(dto.getEmail());
        if(tmpuser.isPresent()){
            throw new UserFoundException("Email taken");
        }
        String passwordHash = passwordHashing.hashPassword(dto.getPassword());
        User user = new User(dto.getFirstName(),dto.getLastName(),dto.getEmail(),passwordHash);
        userRepository.save(user);
        return "sign up successful";
    }

    @Override
    public String signIn(signInDto dto) throws NoSuchAlgorithmException{
        Optional<User> tmpuser = userRepository.findUserByEmail(dto.getEmail());
        if(tmpuser.isEmpty()) {
            throw new UserNotFoundException("User not found");}
        if(!tmpuser.get().getPassword().equals(passwordHashing.hashPassword(dto.getPassword()))){
            throw new AuthenticationException("Username or Password is not correct");
        }
        return "Sign in successful";
    }
}
