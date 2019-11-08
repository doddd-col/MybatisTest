package execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "数学异常")
public class ExceptionStatus extends Exception{
    //这个类就是自定义异常
}
