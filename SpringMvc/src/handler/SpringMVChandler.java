package handler;

import entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("handler")
public class SpringMVChandler {
    @RequestMapping(value="welcome",method = RequestMethod.POST)//映射  可以控制访问的条件
    public String welcome(){
        return "success";
    }


    //REST风格 软件编程风格
    @RequestMapping(value="testget",method=RequestMethod.GET)
     public String testget(){

        System.out.println("testget");
        return "success";

     }

     @RequestMapping(value = "testpost",method = RequestMethod.POST)
    public String testpost(){

         System.out.println("testpost");
        return "success";
     }

     //    <input type="hidden" name="_method" value="DELETE" />  如果请求方式要变成DELETE或者PUT 需要加隐藏域  且提交方式是POST 才回将post改成DELETE|PUT
    @RequestMapping(value = "testdelete",method = RequestMethod.DELETE)
    public String testdelete(){

        System.out.println("testdelete");
        return "success";
    }

    @RequestMapping(value = "testput/{string}",method = RequestMethod.PUT)
    public String testput(@PathVariable("string") String s){

        System.out.println("testput"+s);
        return "success";
    }

    @RequestMapping(value = "testParam",method = RequestMethod.POST)  //如果服务端需要接受两个值 但是客服端只传来一个  可以用required = false
    public String testParam(@RequestParam("uname") String s,@RequestParam(value = "age",required = false,defaultValue = "23") int a){
        System.out.println("testParam"+s+a);
        return "success";
    }

    @RequestMapping(value = "testRequestHeader")
    //获取请求头信息
    public String testRequestHeader(@RequestHeader("Accept") String s){
        System.out.println(s);
        return "success";
    }

    @RequestMapping(value = "testCookieValue")
    //获取CookieValue
    public String testCookieValue(@CookieValue("JSESSIONID") String s){
        System.out.println("JSESSIONID:"+s);
        return "success";
    }

    @RequestMapping("testObjectProperties")
    public String testObjectProperties(Student student){
        System.out.println(student);
        return "success";
    }
}
