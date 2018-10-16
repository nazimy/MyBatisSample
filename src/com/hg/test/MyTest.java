/**
 * 
 */
package com.hg.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hg.dao.UserMapper;
import com.hg.pojo.UserPojo;
import com.hg.pojo.UserPojo1;

/**
 * @author 96458
 *
 */
public class MyTest {
	private static SqlSessionFactory factory=null;
	private static UserMapper dao=null;
	private static SqlSession session=null;
	static {
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(in);
		session= factory.openSession();

		 dao= session.getMapper(UserMapper.class);
	}

	public static void main(String[] args) throws IOException {
		//MyTest.test1();//����selectAll����
		//MyTest.test2();//����selectById����
		//MyTest.test3();//����selectAll1����
		//MyTest.test4();//����selectAll2����
		//MyTest.test5();//����updataUser����
		//MyTest.test6();//����insertUserpojo����
		MyTest.test7();
		session.close();

	}
	public static void test1() 
	{
		// ͨ���½�pojo��������������ݿ�������ͬ
		List<UserPojo> list = dao.selectAll();
		System.out.println("selectAll" + list);
		
	}
	public static void test2() 
	{
		System.out.println(dao.selectById(1).toString());
	}
	public static void test3() 
	{
		/*ͨ���½�pojo��������������ݿ���������ͬ */
		List<UserPojo1> list =dao.selectAll1();
		System.out.println("selectAll1()"+list);
	}
	public static void test4() 
	{
		
		 /*2.ʹ��resultMapָ��ӳ��*/
		 List<UserPojo1> list =dao.selectAll2();
		 System.out.println("selectAll2"+list);
	}
	public static void test5() 
	{
		/* ʹ�ö�̬sql��� */
		
		  UserPojo pojo=new UserPojo(); pojo.setId(1); pojo.setPsw("��������hehe"); int
		  state=dao.updataUser(pojo); System.out.println(state);
		  
		  session.commit(); 
		  /*�м�һ��Ҫ������ύsession.commit()��
		  �������ݿⲻ��ִ�и��²���,���˶Բ�ѯ������
		  ������������иĶ��Ķ���Ҫ session.commit();*/
		 
	}
	public static void test6()
	{
		UserPojo pojo=new UserPojo();
		pojo.setUsername("1������");
		pojo.setPsw("aaaaaaa");
		UserPojo pojo1=new UserPojo();
		pojo1.setUsername("2������");
		pojo1.setPsw("bbbbbb");
		UserPojo pojo2=new UserPojo();
		pojo2.setUsername("3������");
		pojo2.setPsw("cccccc");
		
		List<UserPojo> list=new ArrayList<>();
		list.add(pojo);
		list.add(pojo1);
		list.add(pojo2);
		
		
		System.out.println(dao.insertUserpojo(list));
		session.commit();
	}
	public static void test7()
	{
		UserPojo pojo=dao.selectById2(11, "aaaaaaa");
		System.out.println(pojo.toString());
	}

}
