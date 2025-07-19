package kr.co.bidworks.review3_myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloWorlController {

	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World!";
	}

	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String sayHelloHTML() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("");
		stringBuffer.append("<html>");
		stringBuffer.append("<head>");
		stringBuffer.append("<title> My First HTML Page - Changed</title>");
		stringBuffer.append("</head>");
		stringBuffer.append("<body>");
		stringBuffer.append("My first html page with body - Changed");
		stringBuffer.append("</body>");
		stringBuffer.append("</html>");
		return stringBuffer.toString();
	}

	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
