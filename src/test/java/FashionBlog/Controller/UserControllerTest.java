package FashionBlog.Controller;

import FashionBlog.Dto.SignUpDto;
import FashionBlog.Dto.signInDto;
import FashionBlog.Service.Interface.IUserService;
import FashionBlog.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(UserController.class)
class UserControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private IUserService userService;
static SignUpDto signUpDto;
static signInDto signIn;
    @BeforeEach
    void setUp() {
         signUpDto = SignUpDto.builder()
                .email("Kendzyma75@gmail.com")
                .lastName("Tiamiyu")
                .firstName("kehinde")
                .password("kehinde").build();

     signIn = signInDto.builder()
            .email("Kendzyma75@gmail.com")
            .password("1234").build();


    }

    @Test
    void signUp() throws Exception {
        Mockito.when(userService.signUp(signUpDto)).thenReturn("sign up successful");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users/signup")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "  \"email\": \"admin@gmail\",\n" +
                        "  \"firstName\": \"Kehinde\",\n" +
                        "  \"lastName\": \"Tiamiyu\",\n" +
                        "  \"password\": \"1234\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    void signIn() throws Exception {
        Mockito.when(userService.signIn(signIn)).thenReturn("Sign in successful");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users/signIn")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}