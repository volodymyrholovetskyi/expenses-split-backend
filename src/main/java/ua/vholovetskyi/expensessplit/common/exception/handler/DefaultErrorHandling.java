package ua.vholovetskyi.expensessplit.common.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.vholovetskyi.expensessplit.common.exception.BusinessException;
import ua.vholovetskyi.expensessplit.common.exception.RequestValidationException;
import ua.vholovetskyi.expensessplit.common.validation.field.model.BrokenField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class DefaultErrorHandling {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<DefaultErrorDto> handleBusinessException(BusinessException e, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new DefaultErrorDto(
                        new Date(),
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        Collections.singletonList(e.getMessage()),
                        request.getRequestURI()
                ));
    }

//    @ExceptionHandler({RequestValidationException.class})
//    public ResponseEntity<DefaultErrorDto> handleAnotherException(RequestValidationException e, HttpServletRequest request) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new DefaultErrorDto(
//                        new Date(),
//                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
//                        List.of(e.getBrokenFields()),
//                        request.getRequestURI()
//                ));
//    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<DefaultErrorDto> handleAnotherException(Exception e, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new DefaultErrorDto(
                        new Date(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        Collections.singletonList(e.getMessage()),
                        request.getRequestURI()
                ));
    }
}
