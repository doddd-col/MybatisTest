import entity.Person;
import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Testmybatis {
    public static void addstudent() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        String statement="addstudent";
        Student student = new Student(2, "ls", 23);
        int count = sqlSession.insert(statement,student);
        sqlSession.commit();//手动提交
        System.out.println("增加了"+count+"个学生");
        sqlSession.close();
    }

    public static void querystudentall() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        String statement="querystudentall";
        List<Student> students = sqlSession.selectList(statement);
        System.out.println(students);
        sqlSession.close();
    }

    public static void updatestudent() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        String statement="updatestudent";
        Student student = new Student();
        student.setSno(2);
        student.setName("lxs");
        student.setAge(44);
        sqlSession.update(statement,student);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void deletestudent() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        String statement="deletestudent";
        int delete = sqlSession.delete(statement, 2);
        sqlSession.commit();
        System.out.println("删除了"+delete+"个学生");
        sqlSession.close();
    }



    public static void mybatis_student() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        String statement="querystudentBySno";
        Student student = sqlSession.selectOne(statement,1);
        System.out.println(student);
    }

    public static void main(String[] args) throws IOException {
        //加载mybatis配置文件  获取一个缓冲流
//        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
//        String statement="querypersonById";

//        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
//            //session - connection
////            Person mapper = sqlSession.getMapper(Person.class);
////            mapper.
//            Person person = sqlSession.selectOne(statement,1);
//            System.out.println(person);
//            sqlSession.close();
//        }

//        mybatis_student();
        querystudentall();
//        addstudent();
//        updatestudent();
        deletestudent();
        querystudentall();
    }
}
