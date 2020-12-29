package ua.com.lpnu.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.com.lpnu.demo.model.enums.ErrorCode;
import ua.com.lpnu.demo.model.enums.ErrorType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {

  private String message;
  private ErrorCode errorCode;
  private ErrorType errorType;
  private LocalDateTime dateTime;

}
