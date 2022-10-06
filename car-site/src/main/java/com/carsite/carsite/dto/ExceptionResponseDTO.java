package com.carsite.carsite.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponseDTO {

    private String errorMessage;
    private String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ExceptionResponseDTO(String errorMessage, String errorCode, LocalDateTime timestamp){
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }

    public static ExceptionResponseDTO build(String errorMessage, String errorCode, LocalDateTime timestamp){
        return new ExceptionResponseDTO(errorMessage, errorCode, timestamp);
    }
}
