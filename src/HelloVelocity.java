

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class HelloVelocity {

	public static void main(String[] args) throws Exception {

		
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");//������Դ��������ΪClasspathResourceLoader����ο���д�������ļ���
		//��ʼ����ȡ��Velocity����

		VelocityEngine ve = new VelocityEngine();

		ve.init();
		//ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		//ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

		Template t = ve.getTemplate("./src/hellovelocity.vm");

		//ȡ��velocity��������context

		VelocityContext context = new VelocityContext();

		//����������������

		context.put("name", "Liang");

		context.put("date", (new Date()).toString());

		//Ϊ�����չʾ����ǰ����List��ֵ

		List temp = new ArrayList();

		temp.add("1");

		temp.add("2");

		context.put("list", temp);

		//�����

		StringWriter writer = new StringWriter();

		//ת�����

		t.merge(context, writer);

		System.out.println(writer.toString());
	}
}
