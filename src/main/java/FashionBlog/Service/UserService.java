package FashionBlog.Service;

import FashionBlog.Dto.SignUpDto;
import FashionBlog.Dto.signInDto;
import FashionBlog.Exception.UserException.AuthenticationException;
import FashionBlog.Exception.UserException.UserNotFoundException;
import FashionBlog.Model.User;
import FashionBlog.Repository.UserRepository;
import FashionBlog.Service.Interface.IUserService;
import FashionBlog.Util.PasswordHashing;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String signUp(SignUpDto dto) throws NoSuchAlgorithmException {
        Optional<User> tmpuser = userRepository.findUserByEmail(dto.getEmail());
        if(tmpuser.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        String passwordHash = PasswordHashing.hashPassword(dto.getPassword());
        User user = new User(dto.getFirstName(),dto.getLastName(),dto.getEmail(),passwordHash);
        userRepository.save(user);
        return "sign up successful";
    }

    @Override
    public String signIn(signInDto dto) throws NoSuchAlgorithmException {
        Optional<User> tmpuser = userRepository.findUserByEmail("User not found");
        if(tmpuser.isEmpty()) {
            throw new UserNotFoundException(dto.getEmail());
        }
        if(!tmpuser.get().getPassword().equals(PasswordHashing.hashPassword(dto.getPassword()))){
            throw new AuthenticationException("Username or Password is not correct");
        }

        return "Sign in successful";
    }
}
