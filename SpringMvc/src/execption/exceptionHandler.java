package execption;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

//@ControllerAdvice//可以捕获不同类的异常
public class exceptionHandler {
    @ExceptionHandler(Exception.class)
    public String excptioncontroller(Exception e,Model m){
        m.addAttribute("e",e);
        System.out.println(e);
        return "error";
    }

}
