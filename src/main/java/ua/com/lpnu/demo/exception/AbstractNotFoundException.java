package ua.com.lpnu.demo.exception;

import ua.com.lpnu.demo.model.enums.ErrorCode;
import ua.com.lpnu.demo.model.enums.ErrorType;

public class AbstractNotFoundException extends AbstractException{

    public AbstractNotFoundException(String message) {
        super(message);
    }

    public AbstractNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_FOUND;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
