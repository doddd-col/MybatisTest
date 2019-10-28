import entity.Person;
import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;




public class Testmybatis {
    public static void mybatis_student() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("conf.xml");
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

        mybatis_student();

    }
}
