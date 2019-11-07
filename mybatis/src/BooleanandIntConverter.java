import com.sun.jdi.BooleanType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TypeHandler<java类型>
//先写接口  然后进行配置
public class BooleanandIntConverter extends BaseTypeHandler<Boolean> {
    @Override

        /*
    preparedStatement:操作对象
    i:对象操作的参数位置
    aBoolean:java值
    jdbctype:数据库类型
     */
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
         if(aBoolean){
            preparedStatement.setInt(i,1);
        }else {
            preparedStatement.setInt(i,2);
        }
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if(resultSet.getObject(s)==null){
            return null;
        }else{
            return resultSet.getInt(s)==1?true:false;
        }

    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if(resultSet.getObject(i)==null){
            return null;
        }else{
            return resultSet.getInt(i)==1?true:false;
        }
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

            return callableStatement.getInt(i)==1?true:false;

    }



}
