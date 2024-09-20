package uz.cristal.shorturl.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class ResError{

    Integer status;
    String error;
    String message;
    String path;
}

