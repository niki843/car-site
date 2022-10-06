package com.carsite.carsite.utils;

import com.carsite.carsite.dto.ExceptionResponseDTO;
import com.carsite.carsite.exception.BadRequestException;
import com.carsite.carsite.exception.NotFoundException;
import com.carsite.carsite.exception.UnauthorizedException;
import com.carsite.carsite.exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<ExceptionResponseDTO> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<ExceptionResponseDTO>(
                ExceptionResponseDTO.build("NOT_FOUND", ex.getMessage(), LocalDateTime.now()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<ExceptionResponseDTO> handleBadRequestException(BadRequestException ex) {
        return new ResponseEntity<ExceptionResponseDTO>(
                ExceptionResponseDTO.build("BAD_REQUEST", ex.getMessage(), LocalDateTime.now()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({ UnauthorizedException.class })
    public ResponseEntity<ExceptionResponseDTO> handleUnauthorizedException(UnauthorizedException ex) {
        return new ResponseEntity<ExceptionResponseDTO>(
                ExceptionResponseDTO.build("UNAUTHORIZED", ex.getMessage(), LocalDateTime.now()),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler({ UserExistsException.class })
    public ResponseEntity<ExceptionResponseDTO> handleUserExistsException(UserExistsException ex) {
        return new ResponseEntity<ExceptionResponseDTO>(
                ExceptionResponseDTO.build("USER_EXISTS", ex.getMessage(), LocalDateTime.now()),
                HttpStatus.BAD_REQUEST
        );
    }

}
