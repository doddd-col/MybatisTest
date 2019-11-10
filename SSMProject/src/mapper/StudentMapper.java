package mapper;

import entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {
    void Create(Student student);
}
