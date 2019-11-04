package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class handler {
    @RequestMapping("welcome")
    public String welcome(){
        return "success";
    }
}
