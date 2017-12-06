package initialize.springfeaturesnew.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySources({
  @PropertySource("classpath:application.properties"),
 
})
public class ReactTestController {

	@Autowired
	private Environment env;

	@RequestMapping(value = "sayReact", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String sayHello() throws IOException {
		System.out.println("Welcome to React World, Happy Learning");
		//return env.getProperty("spring.datasource.driver-class-name")+ "Welcome to React World, Happy Learning1";
		/*Map<String, Object> map = new HashMap();
		for (Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext();) {
			PropertySource propertySource = (PropertySource) it.next();
			if (propertySource instanceof MapPropertySource) {
				map.putAll(((MapPropertySource) propertySource).getSource());
			}
		}*/
		/*Map<String, Object> map = new HashMap();
		PropertySource propertySource = ((AbstractEnvironment) env).getPropertySources().get("applicationConfig: [classpath:/application1.properties]");
		if (propertySource instanceof MapPropertySource) {
					map.putAll(((MapPropertySource) propertySource).getSource());
				}
		return map;*/
		Properties prop = new Properties();
		InputStream is = ReactTestController.class.getResourceAsStream("/application1.properties");
		prop.load(is);
		return prop.getProperty("server.context-path-testing");
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

}
