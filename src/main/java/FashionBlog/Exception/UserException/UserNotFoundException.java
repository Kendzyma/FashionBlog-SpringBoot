package FashionBlog.Exception.UserException;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(String.format("User with email %s not found", message));
    }
}
