package uz.cristal.shorturl.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto<T> {
    // code: 1 = yaxshi, 2 = datase eror, 0 = null;
    //success: true = hammasi yaxshi, false = responseda muamo bor,
    //message: response haqida xabarnoma
    //data: responseda obyekt qaytarish;
    private int code;
    private boolean success;
    private String message;
    private T data;


}
