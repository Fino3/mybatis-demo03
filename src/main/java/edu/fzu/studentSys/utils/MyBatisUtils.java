package edu.fzu.studentSys.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MyBatisUtils {
    static private SqlSessionFactory sqlSessionFactory;
    static public SqlSession getSqlSession() {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
            return sqlSessionFactory.openSession();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
