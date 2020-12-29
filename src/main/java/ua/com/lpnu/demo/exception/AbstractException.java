package ua.com.lpnu.demo.exception;

import ua.com.lpnu.demo.model.enums.ErrorCode;
import ua.com.lpnu.demo.model.enums.ErrorType;

public abstract class AbstractException extends RuntimeException {

  public AbstractException(String message) {
    super(message);
  }

  public AbstractException(String message, Throwable cause) {
    super(message, cause);
  }

  public ErrorCode getErrorCode() {
    return ErrorCode.APPLICATION_ERROR_CODE;
  }

  public ErrorType getErrorType() {
    return ErrorType.FATAL_ERROR_TYPE;
  }

}
