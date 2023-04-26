package domain;


/**
 */
public class News
{
	private Integer id;
	private String title;
	private String content;


	// 无参数的构造器
	public News()
	{
	}
	// 初始化全部成员变量的构造器
	public News(Integer id, String title, String content)
	{
		this.id = id;
		this.title = title;
		this.content = content;
	}

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// title的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// content的setter和getter方法
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	@Override
	public String toString()
	{
		return "News[id=" + this.id + ", title="
			+ this.title + ", content=" + this.content + "]";
	}
}