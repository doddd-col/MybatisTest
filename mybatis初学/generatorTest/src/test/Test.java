package test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException, XMLParserException, SQLException, InterruptedException, InvalidConfigurationException {
        File file=new File("src/generator.xml");//配置文件

        List<String> warnings=new ArrayList<>();
        ConfigurationParser cp=new ConfigurationParser(warnings);

        Configuration configuration= cp.parseConfiguration(file);


        DefaultShellCallback callback=new DefaultShellCallback(true);
        //逆向工程核心类
        MyBatisGenerator generator=new MyBatisGenerator(configuration,callback,warnings);
        generator.generate(null);
    }

}
