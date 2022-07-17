package com.lyq.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.sql.Connection;

public class TestUtils {
    private static SqlSessionFactory sqlSessionFactory = null;

    // 静态初始化
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        }catch (Exception e){
            e.printStackTrace();
            // 初始化异常
            throw new ExceptionInInitializerError(e);
        }finally {

        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
