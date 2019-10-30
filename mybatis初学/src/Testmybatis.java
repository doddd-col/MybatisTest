import entity.Person;
import entity.Student;
import mapper.studentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testmybatis {
    public static void addstudent() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        Student student = new Student(2, "zs", 3);
        //        String statement="addstudent";
        //        int count = sqlSession.insert(statement,student);

        //接口实现动态代理
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        mapper.addstudent(student);

        sqlSession.commit();//手动提交
        System.out.println("增加了" + 1 + "个学生");
        sqlSession.close();
    }

    public static void querystudentall() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

//        String statement="querystudentall";
//        List<Student> students = sqlSession.selectList(statement);

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        List<Student> querystudentall = mapper.querystudentall();
        System.out.println(querystudentall);
        sqlSession.close();
    }

    public static void updatestudent() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
//        String statement="updatestudent";
//        sqlSession.update(statement,student);
        Student student = new Student();
        student.setSno(2);
        student.setName("lxs");
        student.setAge(44);

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        mapper.updatestudent(student);

        sqlSession.commit();
        sqlSession.close();
    }

    public static void deletestudent() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
//        String statement="deletestudent";
//        int delete = sqlSession.delete(statement, 2);

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        mapper.deletestudent(2);
        sqlSession.commit();
        System.out.println("删除了" + 1 + "个学生");
        sqlSession.close();
    }


    public static void querystudentBySno() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
//        String statement="querystudentBySno";
//        Student student = sqlSession.selectOne(statement,1);
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student = mapper.querystudentBySno(2);
        System.out.println(student);
    }

    public static void querystudentBySnoWithConverter() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student = mapper.querystudentBySno(2);
        System.out.println(student);
    }

    public static void addstudentWithConverter() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        Student student = new Student(5, "ss", 32);

        //接口实现动态代理
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        mapper.addstudent(student);

        sqlSession.commit();//手动提交
        System.out.println("增加了" + 1 + "个学生");
        sqlSession.close();
    }

    public static void querystudentallWithConverter() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        List<Student> querystudentallWithConverter = mapper.querystudentallWithConverter();
        System.out.println(querystudentallWithConverter);
        sqlSession.close();
    }

    public static void querystudentByName() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student = mapper.querystudentByName("ls");
        System.out.println(student);
    }

    public static void querystudentByNameWithHashMap() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        //HashMap key value对
        Map<String, Object> studentmap = new HashMap<>();

        //将值传到map中
        studentmap.put("name", "ls");
        studentmap.put("sno", 4);

        List<Student> student = mapper.querystudentByNameWithHashMap(studentmap);
        System.out.println(student);

    }

    public static void querystudentOrderByColumn() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        List<Student> student = mapper.querystudentOrderByColumn("sno");
        System.out.println(student);
    }

    public static void deleteStuBysnoWithProceedure() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
    //存储过程 无论传入参数是什么类型都用map来传值
        HashMap<String, Object> map = new HashMap<>();
        map.put("ss",2);
        mapper.deleteStuBysnoWithProceedure(map);
        //调用存储过程 用map作为参数   用put传进去  用get取返回值
        sqlSession.commit();
    sqlSession.close();
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
//        querystudentBySnoWithConverter();
//;            querystudentallWithConverter();
//
//        addstudentWithConverter();
//        querystudentallWithConverter();
//        querystudentall();
//        addstudent();
//        updatestudent();
//        deletestudent();
//        querystudentall();
//        querystudentByName();
//        querystudentOrderByColumn();
//        querystudentByNameWithHashMap();
        deleteStuBysnoWithProceedure();
    }
}
