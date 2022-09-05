package FashionBlog.Exception;

import FashionBlog.Exception.CategoryException.CategoryExistException;
import FashionBlog.Exception.CategoryException.CategoryNotFoundException;
import FashionBlog.Exception.LikesException.LikeNotFoundException;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Exception.ProductException.ProductNotFoundException;
import FashionBlog.Exception.UserException.AuthenticationException;
import FashionBlog.Exception.UserException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    // For REST APIs
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> AuthenticationException(AuthenticationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CategoryExistException.class)
    public ResponseEntity<?> CategoryExistException(CategoryExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> CategoryNotFoundException(CategoryNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> PostNotFoundException(PostNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LikeNotFoundException.class)
    public ResponseEntity<?> LikeNotFoundException(LikeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> ProductNotFoundException(ProductNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}