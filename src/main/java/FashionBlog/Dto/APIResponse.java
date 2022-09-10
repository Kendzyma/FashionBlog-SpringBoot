package FashionBlog.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor

public class APIResponse<T> implements Serializable {
    private String message;
    private boolean success;
    private T payLoad;

    public APIResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
