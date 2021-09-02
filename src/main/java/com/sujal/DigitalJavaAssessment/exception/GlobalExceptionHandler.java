package com.sujal.DigitalJavaAssessment.exception;

import com.sujal.DigitalJavaAssessment.util.StringConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @description Handle NullPointer Exception
     *
     * @param exception
     * @return ExceptionResponseDto
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ExceptionResponseDto handleNullPointerExceptions(NullPointerException exception) {
        String defaultMessage = exception.getMessage();
        return new ExceptionResponseDto(StringConstant.NO_ELEMENT_FOUND, defaultMessage);
    }

    /**
     * @description Handle JwtSecurityException
     *
     * @param exception
     * @return ExceptionResponseDto
     */
    @ExceptionHandler(JwtSecurityException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ExceptionResponseDto handleJwtSecurityExceptions(JwtSecurityException exception) {
        String defaultMessage = exception.getMessage();
        logger.info("error "+defaultMessage);
        return new ExceptionResponseDto(StringConstant.INTERNAL_SERVER_ERROR, defaultMessage);
    }

    /**
     * @description Handle MethodArgumentNotValidException
     *
     * @param exception
     * @return ExceptionResponseDto
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponseDto handleValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        logger.info(defaultMessage);
        return new ExceptionResponseDto(StringConstant.VALIDATION_FAILED, defaultMessage);
    }

    /**
     * @description Handle Runtime Exception
     *
     * @param exception
     * @return ExceptionResponseDto
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ExceptionResponseDto handleAllRuntimeExceptions(RuntimeException exception) {
        String defaultMessage = exception.getMessage();
        return new ExceptionResponseDto(StringConstant.INTERNAL_SERVER_ERROR, defaultMessage);
    }

    /**
     * @description Handle All Exception
     *
     * @param exception
     * @return ExceptionResponseDto
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ExceptionResponseDto handleAllExceptions(Exception exception) {
        String defaultMessage = exception.getMessage();
        return new ExceptionResponseDto(StringConstant.INTERNAL_SERVER_ERROR, defaultMessage);
    }
}
