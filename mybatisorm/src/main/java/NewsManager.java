

import java.io.*;
import java.util.*;

import org.apache.ibatis.session.*;
import org.apache.ibatis.io.Resources;

import domain.News;


/**
mybatistest
 */
public class NewsManager
{
	private static SqlSessionFactory sqlSessionFactory;
	public static void main(String[] args) throws Exception
	{
		var resource = "mybatis-config.xml";
		// 使用Resources工具从类加载路径下加载指定文件
		var inputStream = Resources.getResourceAsStream(resource);
		// 构建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream);
		// 打开Session
		var sqlSession = sqlSessionFactory.openSession();
		selectTest(sqlSession);
	}
	public static void insertTest(SqlSession sqlSession)
	{
		// 创建消息实例
		var news = new News();
		// 设置消息标题和消息内容
		news.setTitle("李刚的公众号");
		news.setContent("大家可关注李刚老师的公众号：fkbooks");
		// 获取Mapper对象
		var newsMapper = sqlSession.getMapper(NewsMapper.class);
		// 调用Mapper对象的方法执行持久化操作
		var n = newsMapper.saveNews(news);
		System.out.printf("插入了%d条数据%n", n);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}

	public static void updateTest(SqlSession sqlSession)
	{
		// 创建消息实例
		var news = new News();
		// 设置消息标题和消息内容
		news.setId(1);
		news.setTitle("Java 13来了");
		news.setContent("Java 13新增了块字符串，用起来更爽了");
		// 获取Mapper对象
		var newsMapper = sqlSession.getMapper(NewsMapper.class);
		// 调用Mapper对象的方法执行持久化操作
		var n = newsMapper.updateNews(news);
		System.out.printf("更新了%d条数据%n", n);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}

	public static void deleteTest(SqlSession sqlSession)
	{
		// 获取Mapper对象
		var newsMapper = sqlSession.getMapper(NewsMapper.class);
		// 调用Mapper对象的方法执行持久化操作
		var n = newsMapper.deleteNews(1);
		System.out.printf("删除了%d条数据%n", n);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}

	public static void selectTest(SqlSession sqlSession)
	{
		// 获取Mapper对象
		var newsMapper = sqlSession.getMapper(NewsMapper.class);
		System.out.println(newsMapper.getClass());
		// 调用Mapper对象的方法执行持久化操作
		var news = newsMapper.getNews(1);
		System.out.println("查询得到的记录为：" + news);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}
}
