package ua.vholovetskyi.expensessplit.common.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class DefaultErrorDto {
    private Date timestamp;
    private int status;
    private String error;
    private List<Object> message;
    private String path;

}
