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
//@ApiResponses(value = {
//        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
//        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
//        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
//})

public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

   // @ApiOperation(value = "User signup",response = ResponseEntity.class)
    @PostMapping(value = "/signup",produces = "application/json")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpDto dto) throws NoSuchAlgorithmException {
        userService.signUp(dto);
        return new ResponseEntity<>(new APIResponse("Sign up successful",true), HttpStatus.CREATED);
    }
   // @ApiOperation(value = "User signin",response = ResponseEntity.class)
    @PostMapping(value = "/signIn",produces = "application/json")
    public ResponseEntity<APIResponse> signIn(@RequestBody signInDto dto) throws NoSuchAlgorithmException {
        userService.signIn(dto);
        return new ResponseEntity<>(new APIResponse("Sign in successful",true),HttpStatus.OK);
    }

}
