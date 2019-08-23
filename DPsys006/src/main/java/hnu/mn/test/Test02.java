package hnu.mn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac);
	}
}
