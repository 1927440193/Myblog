package com.hu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 自定义异常
 * @Package com.hu
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}