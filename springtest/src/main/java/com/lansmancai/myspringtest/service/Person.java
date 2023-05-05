package com.lansmancai.myspringtest.service;

public class Person
{
	private Axe axe;
	// 设值注入所需的setter方法
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	public void useAxe()
	{
		System.out.println("我打算去砍点柴火！");
		// 调用axe的chop()方法，
		// 表明Person对象依赖于axe对象
		System.out.println(axe.chop());
	}
}
