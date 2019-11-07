import entity.Student;
import org.springframework.core.convert.converter.Converter;

public class MyConverter implements Converter<String,Student> {
    @Override
    public Student convert(String s) {//source:2-ls
        String[] info=s.split("-");
        Student student=new Student();

        student.setId(Integer.parseInt(info[0]));
        student.setName(info[1]);
        return student;
    }
}
