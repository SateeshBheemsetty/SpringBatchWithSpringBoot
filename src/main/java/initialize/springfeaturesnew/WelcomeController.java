package initialize.springfeaturesnew;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/sayHello")
	public String sayHello(){
		return "Hello, Welcome to Spring Boot World";
	}
}
