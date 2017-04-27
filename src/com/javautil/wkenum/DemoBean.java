package com.javautil.wkenum;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DemoBean {
	
	public enum Type implements WKEnumSuper{
		//开始声明类型
		
		teacher("教室",1),
		student("学生",2)
		;
		
		
		/*
		 * 重写构造
		 */
		private Type(String name, int number) {
			this.name = name;
			this.number = number;
		}

		private String name; //子类增加name字段
		private int number; //子类增加number字段
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public int getNumber() {
			return number;
		}
		
	}
	
	/**
	 * id
	 */
	private String id;
	
	/**
	 * 名字
	 */
	private String name;
	
	
	/**
	 * 类型
	 */
	private int type;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "DemoBean [id=" + id + ", name=" + name + ", type=" + type + ", type_text="+WKEnumUtil.getEnum(DemoBean.Type.class, type).getName()+ "]";
	}
	
	
	public static void main(String[] args) {
		//声明张三老师
		DemoBean bean_teacher = new DemoBean();
		bean_teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		bean_teacher.setName("张三");
		bean_teacher.setType(DemoBean.Type.teacher.getNumber());
		
		//声明李四学生
		DemoBean bean_student= new DemoBean();
		bean_student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		bean_student.setName("李四");
		bean_student.setType(DemoBean.Type.student.getNumber());
		
		System.out.println(bean_teacher);
		System.out.println(bean_student);
	
		
		String numberKey = "number";
		String nameKey = "name";
		List<Map<String,Object>> list = WKEnumUtil.toList(DemoBean.Type.class, numberKey, nameKey);
		
		
		for (Map<String, Object> map : list) {
			System.out.println("<option value='"+map.get(numberKey)+"'>"+map.get(nameKey)+"</option>");
		}
		
	}
	
	
}
