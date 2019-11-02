import entity.*;
import mapper.classMapper;
import mapper.studentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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

    public static void querystudentByNameAndAgeWithSqlTag() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student=new Student();
        student.setName("ls");
        student.setAge(21);
        List<Student> student1 = mapper.querystudentByNameAndAgeWithSqlTag(student);
        sqlSession.commit();
        System.out.println(student1);

        sqlSession.close();
    }

    public static void querystudentWithGrade() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        Grade grade=new Grade();
        grade.setStunum(list);

        List<Student> student1 = mapper.querystudentWithGrade(grade);
        sqlSession.commit();
        System.out.println(student1);

        sqlSession.close();
    }

    public static void querystudentWithArray() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);

        int []num={1,2};
        List<Student> student1 = mapper.querystudentWithArray(num);
        sqlSession.commit();
        System.out.println(student1);

        sqlSession.close();
    }

    public static void querystudentWithList() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Student> student1 = mapper.querystudentWithList(list);
        sqlSession.commit();
        System.out.println(student1);

        sqlSession.close();
    }

    public static void querystudentWithStuArray() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        Student student1=new Student();
        student1.setSno(1);
        Student student2=new Student();
        student2.setSno(2);
        Student[] students=new Student[]{student1,student2};
        List<Student> student = mapper.querystudentWithStuArray(students);
        sqlSession.commit();
        System.out.println(student);

        sqlSession.close();
    }

    public static void querystudentByBusiOO() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        int sno=1;
        StudentBusiness student = mapper.querystudentByBusiOO(sno);
        sqlSession.commit();
        System.out.println(student);

        sqlSession.close();
    }

    public static void querystudentBysnoOO() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        int sno=1;
        Student student = mapper.querystudentBysnoOO(sno);

        sqlSession.commit();
        System.out.println(student);

        sqlSession.close();
    }

    public static void queryClassStudent() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        int classid=175;
        StudentClass student = mapper.queryClassStudent(classid);
        sqlSession.commit();
        System.out.println(student);

        sqlSession.close();
    }

    //缓存只对查询有用  一级缓存 commit会清空sqlSession中的缓存   可以减少打开关闭数据库的性能损耗
    public static void query() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        int sno=2;
        StudentCard student = mapper.query(sno);

        //mybatis一级缓存  在同一个sqlSession中
        StudentCard card=mapper.query(sno);

        System.out.println(student);
        System.out.println(card);

        sqlSession.close();
    }

    //mybatis二级缓存    用一个namespace都有效  不管是什么mapper对象 只要调用同一个namespace   如果多个xml文件共享一个namespace也共享二级缓存
    public static void query_twocache() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        int sno=2;
        StudentCard student = mapper.query(sno);
        //一般在 commit的时候将缓存序列化
       sqlSession.commit();
        //在同一个namespace中 调用     记得开启二级缓存          二级缓存需要将类序列化  因为二级缓存需要将缓存序列化存到硬盘中  同一个namespace生成的不同mapper调用时将二级缓存反序列化 变成可查询信息
        studentMapper mapper2 =sqlSession.getMapper(studentMapper.class);

        StudentCard query = mapper2.query(sno);
        studentMapper mapper3 =sqlSession.getMapper(studentMapper.class);

        StudentCard query3 = mapper2.query(sno);
        System.out.println(student);
        System.out.println(query);
        System.out.println(query3);
       //Cache Hit Ratio [mapper.studentMapper]: 0.5  代表缓存命中率  第一次中没有 0.0  第二次查询有 0.5 第三次 0.66666
         sqlSession.close();

    }

    public static void querystudentCardlazyload() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        studentMapper mapper = sqlSession.getMapper(studentMapper.class);
        int sno=2;
        Student student = mapper.querystudentCardlazyload(sno);
        System.out.println(student.getSno()+"----"+student.getAge()+"-----"+student.getName());
        System.out.println(student.getCard().getCardid()+"===="+student.getCard().getCardinfo());
        sqlSession.commit();


        sqlSession.close();
    }

    public static void queryClass() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
        //build第二个参数可以指定运行环境
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();

        classMapper mapper = sqlSession.getMapper(classMapper.class);//接口是什么  就返回什么
        int classid=175;
        StudentClass classidandinfo = mapper.queryClass(classid);

        System.out.println(classidandinfo.getClassid()+"----"+classidandinfo.getClassname());

        for(Student student:classidandinfo.getStudentList()){
            System.out.println(student.getSno()+"==="+student.getName()+"==="+student.getAge());
        }
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
//        deleteStuBysnoWithProceedure();

//        querystudentByNameAndAgeWithSqlTag();
//        querystudentWithGrade();
//        querystudentWithArray();
//        querystudentWithList();
//        querystudentWithStuArray();
//        querystudentByBusiOO();
//        querystudentBysnoOO();
//        queryClassStudent();

//        querystudentCardlazyload();
//        query();
//        queryClass();

        query_twocache();
    }




}
