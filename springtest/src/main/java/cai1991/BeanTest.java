package cai1991;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lansmancai.myspringtest.service.*;

public class BeanTest
{
	public static void main(String[] args) throws Exception
	{
		// 创建Spring容器
		var ctx = new ClassPathXmlApplicationContext("beans.xml");
		// 获取id为person的Bean
		var p = ctx.getBean("person", Person.class);
		// 调用useAxe()方法
		p.useAxe();
	}
}
