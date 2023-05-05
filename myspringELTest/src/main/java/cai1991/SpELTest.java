package cai1991;

import org.springframework.expression.*;
import org.springframework.expression.spel.standard.*;
import org.springframework.expression.spel.support.*;

import java.util.*;

import com.lansmancai.myspringELTest.domain.*;

public class SpELTest
{
	public static void main(String[] args)
	{
		// 创建一个ExpressionParser对象，用于解析表达式
		var parser = new SpelExpressionParser();
		// 最简单的字符串表达式
		var exp = parser.parseExpression("'HelloWorld'");
		System.out.println("'HelloWorld'的结果： " + exp.getValue());
		// 调用方法的表达式
		exp = parser.parseExpression("'HelloWorld'.concat('!')");
		System.out.println("'HelloWorld'.concat('!')的结果： "
			+ exp.getValue());
		// 调用对象的getter方法
		exp = parser.parseExpression("'HelloWorld'.bytes");
		System.out.println("'HelloWorld'.bytes的结果： "
			+ exp.getValue());
		// 访问对象的属性(d相当于HelloWorld.getBytes().length)
		exp = parser.parseExpression("'HelloWorld'.bytes.length");
		System.out.println("'HelloWorld'.bytes.length的结果："
			+ exp.getValue());
		// 使用构造器来创建对象
		exp = parser.parseExpression("new String('helloworld')"
			+ ".toUpperCase()");
		System.out.println("new String('helloworld')"
			+ ".toUpperCase()的结果是： "
			+ exp.getValue(String.class));
		var person = new Person(1, "孙悟空", new Date());
		exp = parser.parseExpression("name");
		// 以指定对象作为root来计算表达式的值
		// 相当于调用person.name表达式的值
		System.out.println("以persn为root，name表达式的值是： "
			+ exp.getValue(person, String.class));
		exp = parser.parseExpression("name=='孙悟空'");
		var ctx = new StandardEvaluationContext();
		// 将person设为Context的root对象
		ctx.setRootObject(person);
		// 以指定Context来计算表达式的值
		System.out.println(exp.getValue(ctx, Boolean.class));
		var list = new ArrayList<Boolean>();
		list.add(true);
		var ctx2 = new StandardEvaluationContext();
		// 将list设置成EvaluationContext的一个变量
		ctx2.setVariable("list", list);
		// 修改list变量的第一个元素的值
		parser.parseExpression("#list[0]").setValue(ctx2, "false");
		// list集合的第一个元素被改变
		System.out.println("list集合的第一个元素为："
			+ parser.parseExpression("#list[0]").getValue(ctx2));
	}
}