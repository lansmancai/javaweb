

import domain.*;

/**
 */
// 定义Mapper接口（DAO接口），该接口由MyBatis负责提供实现类
public interface NewsMapper
{
	// 下面这些方法的方法名必须与NewsMapper.xml文件中SQL语句的id对应
	// 下面这些方法的参数需要与NewsMapper.xml文件中SQL语句的参数对应
	int saveNews(News news);

	int updateNews(News news);

	int deleteNews(int a);

	News getNews(int a);
}