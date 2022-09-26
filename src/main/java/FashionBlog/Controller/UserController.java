package FashionBlog.Controller;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Dto.SignUpDto;
import FashionBlog.Dto.signInDto;
import FashionBlog.Service.Interface.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
@Validated
@RestController
@RequestMapping("/api/v1/users")

public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/signup",produces = "application/json")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpDto dto) throws NoSuchAlgorithmException {
        userService.signUp(dto);
        return new ResponseEntity<>(new APIResponse("Sign up successful",true), HttpStatus.CREATED);
    }

    @PostMapping(value = "/signIn",produces = "application/json")
    public ResponseEntity<APIResponse> signIn(@RequestBody signInDto dto) throws NoSuchAlgorithmException {
        userService.signIn(dto);
        return new ResponseEntity<>(new APIResponse("Sign in successful",true),HttpStatus.OK);
    }

}
