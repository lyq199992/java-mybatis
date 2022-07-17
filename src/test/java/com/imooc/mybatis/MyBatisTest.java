package com.imooc.mybatis;

import com.lyq.mybatis.dto.GoodsDto;
import com.lyq.mybatis.entity.Category;
import com.lyq.mybatis.entity.Goods;
import com.lyq.mybatis.entity.Users;
import com.lyq.mybatis.utils.MyBatisUtils;
import com.lyq.mybatis.utils.TestUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 单元测试类
public class MyBatisTest {
//    @Test
//    public void test() throws Exception {
//        SqlSession sqlSession = null;
//
//        try {
//            sqlSession = TestUtils.getSqlSession();
//            Users users = sqlSession.selectOne("user.selectOne", 1);
//            System.out.println(users);
//        }catch (Exception e) {
//            throw e;
//        }finally {
//            TestUtils.closeSqlSession(sqlSession);
//        }
//
//    }
//    @Test
//    public void testSqlSessionFactory() throws IOException {
//        // 利用 Reader 加载 classpath 下的 mybatis-config-xml 核心配置文件
//        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
//        // 初始化 SqlSessionFactory 对象，同时解析 mybatis-config-xml 文件
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
//        // 创建 SqlSession 对象，SqlSession 是 JDBC 拓展类，用于数据库交互
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = sqlSessionFactory.openSession();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if(sqlSession != null){
//                sqlSession.close();
//            }
//        }
//        // 创建数据库连接
//    }
//    @Test
//    public void testMybatisUtils() throws Exception {
//        SqlSession sqlSession = null;
//       try {
//           sqlSession= MyBatisUtils.openSession();
//           Connection connection = sqlSession.getConnection();
//           System.out.println(connection);
//
//       }catch (Exception e){
//            throw e;
//       }finally {
//           MyBatisUtils.closeSession(sqlSession);
//       }
//    }
//    @Test
//    public void test02() throws Exception {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtils.openSession();
//            List<Goods> objects = sqlSession.selectList("goods.selectAll");
//            System.out.println(objects);
//            // sqlSession.selectOne() // 返回一条
//            for (Goods g : objects){
//                System.out.println(g.getGoodsId() + g.getGoodsName());
//            }
//        }catch (Exception e) {
//            throw e;
//        }finally {
//            MyBatisUtils.closeSession(sqlSession);
//        }
//    }
//
//    @Test
//    public void test03() throws Exception {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtils.openSession();
//            Goods goods = sqlSession.selectOne("goods.selectId", 1);
//            System.out.println(goods.getGoodsId() + goods.getGoodsName());
//            // sqlSession.selectOne() // 返回一条
////            for (Goods g : objects){
////                System.out.println(g.getGoodsId() + g.getGoodsName());
////            }
//        }catch (Exception e) {
//            throw e;
//        }finally {
//            MyBatisUtils.closeSession(sqlSession);
//        }
//    }
//
//@Test
//public void test04() throws Exception {
//    SqlSession sqlSession = null;
//    try {
//        sqlSession = MyBatisUtils.openSession();
//        Map param = new HashMap();
//        param.put("min", 1);
//        param.put("max", 3);
//        List<Goods> list = sqlSession.selectList("goods.selectByPriceRange", param);
//        // sqlSession.selectOne() // 返回一条
//        for (Goods g : list){
//            System.out.println(g.getGoodsId() + g.getGoodsName());
//        }
//    }catch (Exception e) {
//        throw e;
//    }finally {
//        MyBatisUtils.closeSession(sqlSession);
//    }
//}
//}
    @Test
    public void test05() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            List<Map> list = sqlSession.selectList("goods.selectGoodsMap");

            // sqlSession.selectOne() // 返回一条
            for (Map m : list){
                System.out.println(m);
            }
        }catch (Exception e) {
            throw e;
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

//    @Test
//    public void testSelectGoodsResultMap() throws Exception{
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtils.openSession();
//            List<GoodsDto> objects = sqlSession.selectList("goods.selectGoodsDTO");
//
//            for (GoodsDto goodsDto : objects) {
//                System.out.println(goodsDto.getGoods().getGoodsId());
//                System.out.println(goodsDto.getGoods().getGoodsName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            MyBatisUtils.closeSession(sqlSession);
//        }
//
//    }
    @Test
    public void testInsert() throws Exception{
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Goods goods = new Goods();
            goods.setGoodsName("大大大瓜");
            goods.setCategoryId(2);
            int insert = sqlSession.insert("goods.insertGoods", goods);
            sqlSession.commit();
            System.out.println(goods.getGoodsId());
        } catch (Exception e) {
            if(sqlSession != null)
                    sqlSession.rollback();
            e.printStackTrace();
        }finally {
            MyBatisUtils.closeSession(sqlSession);
        }

    }

    @Test
    public void test8(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Goods goods = sqlSession.selectOne("goods.selectId", 1);
            goods.setGoodsName("更新后的Name");
            int update = sqlSession.update("goods.updateGoods", goods);
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession != null)
                sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test9(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            int num = sqlSession.delete("goods.deleteGoods", 1);
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession != null)
                sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDynamicSQL(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            Map param = new HashMap();
            param.put("categoryId", 1);
//            param.put("categoryName", "黄瓜");
            List<Category> goods = sqlSession.selectList("goods.dynamicSQL", param);
            for (Category g : goods) {
                System.out.println(g.getCategoryName() + g.getCategoryId());
            }

        } catch (Exception e) {
            if(sqlSession != null)
                sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}