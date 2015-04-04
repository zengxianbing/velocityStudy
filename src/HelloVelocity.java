

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
		p.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");//设置资源加载器器为ClasspathResourceLoader，这段可以写到配置文件中
		//初始化并取得Velocity引擎

		VelocityEngine ve = new VelocityEngine();

		ve.init();
		//ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		//ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

		Template t = ve.getTemplate("./src/hellovelocity.vm");

		//取得velocity的上下文context

		VelocityContext context = new VelocityContext();

		//把数据填入上下文

		context.put("name", "Liang");

		context.put("date", (new Date()).toString());

		//为后面的展示，提前输入List数值

		List temp = new ArrayList();

		temp.add("1");

		temp.add("2");

		context.put("list", temp);

		//输出流

		StringWriter writer = new StringWriter();

		//转换输出

		t.merge(context, writer);

		System.out.println(writer.toString());
	}
}
