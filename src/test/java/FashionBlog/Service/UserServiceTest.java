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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @MockBean
   private UserRepository userRepository;
    @MockBean
   private PasswordHashing passwordHashing;
    @Autowired
    private IUserService userService;
    static  SignUpDto signUpDto;
    static signInDto signin;
    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        Optional<User> user = Optional.ofNullable(User.builder()
                .firstName("Kehinde")
                .lastName("Tiamiyu")
                .password("1234")
                .email("admin@gmail.com").build());

         signUpDto = SignUpDto.builder()
                .firstName("Kenny")
                .password("1234")
                .email("admin@gmail.com")
                .lastName("Tiamiyu").build();
          signin = signInDto.builder()
                 .email("admin@gmail.com")
                 .password("1234").build();
         Mockito.when(userRepository.findUserByEmail(signin.getEmail()))
                 .thenReturn(user);
         Mockito.when(passwordHashing.hashPassword(signin.getPassword())).thenReturn("1234");

        Mockito.when(userRepository.findUserByEmail(signUpDto.getEmail())).thenReturn(user);
    }
    @Test
    void signUpShouldSucceed() throws NoSuchAlgorithmException {
        Mockito.when(userRepository.findUserByEmail(signUpDto.getEmail())).thenReturn(Optional.empty());
        String actual = userService.signUp(signUpDto);
        assertEquals("sign up successful",actual);
    }

    @Test
    void signUp_Should_Throw_UserNotFoundException() throws NoSuchAlgorithmException {
      Exception message = assertThrows(UserFoundException.class,()->userService.signUp(signUpDto));
        assertEquals("Email taken",message.getMessage());
    }

    @Test
    void signInShouldSucceed() throws NoSuchAlgorithmException {
       String actual = userService.signIn(signin);
       assertEquals(actual,"Sign in successful");
    }
    @Test
  void signInShouldThrowAuthenticationException() throws NoSuchAlgorithmException {
        Mockito.when(passwordHashing.hashPassword(signin.getPassword())).thenReturn("123");
        Exception message = assertThrows(AuthenticationException.class,()->userService.signIn(signin));
        assertEquals("Username or Password is not correct",message.getMessage());

    }
    @Test
    void signInShouldThrowUserNotFoundException(){
        Mockito.when(userRepository.findUserByEmail(signUpDto.getEmail())).thenReturn(Optional.empty());
        Exception message = assertThrows(UserNotFoundException.class,()->userService.signIn(signin));
        assertEquals("User not found",message.getMessage());
    }
}