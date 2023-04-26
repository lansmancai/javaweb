package lee;

import java.io.*;
import java.util.*;

import org.apache.ibatis.session.*;
import org.apache.ibatis.io.Resources;

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
		updateTest(sqlSession);
	}
	public static void insertTest(SqlSession sqlSession)
	{
		// 创建消息实例
		var news = new HashMap<String, String>();
		// 设置消息标题和消息内容
		news.put("title", "李刚的公众号");
		news.put("content", "大家可关注李刚老师的公众号：fkbooks");
		// 调用insert方法执行SQL语句
		var n = sqlSession.insert("NewsMapper.saveNews", news);
		System.out.printf("插入了%d条数据%n", n);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}

	public static void updateTest(SqlSession sqlSession)
	{
		// 创建消息实例
		var news = new HashMap<String, String>();
		// 设置消息标题和消息内容
		news.put("id", "1");
		news.put("title", "Java 13来了");
		news.put("content", "Java 13新增了块字符串，用起来更爽了");
		// 调用update方法执行SQL语句
		var n = sqlSession.update("NewsMapper.updateNews", news);
		System.out.printf("更新了%d条数据%n", n);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}

	public static void deleteTest(SqlSession sqlSession)
	{
		// 故意调用insert方法执行delete SQL语句
		// 证明SqlSession的insert、update、delete方法的功能几乎相同
		var n = sqlSession.insert("NewsMapper.deleteNews", 2);
		System.out.printf("删除了%d条数据%n", n);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}

	public static void selectTest(SqlSession sqlSession)
	{
		// 调用selectOne方法执行select SQL语句
		var news = sqlSession.selectOne("NewsMapper.getNews", 1);
		System.out.println("查询得到的记录为：" + news);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}
}
