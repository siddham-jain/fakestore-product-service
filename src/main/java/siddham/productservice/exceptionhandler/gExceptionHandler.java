package siddham.productservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import siddham.productservice.dtos.ExceptionDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class gExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(RuntimeException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(e.getMessage());
        exceptionDTO.setResolution("RuntimeException occurred");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDTO> handleNullPointerException(NullPointerException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(e.getMessage());
        exceptionDTO.setResolution("Check for null values");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmeticPointerException(ArithmeticException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(e.getMessage());
        exceptionDTO.setResolution("Check for division by zero or other arithmetic operations");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleException(Exception e){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(e.getMessage());
        exceptionDTO.setResolution("Something went wrong! Check the logs for more information");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
