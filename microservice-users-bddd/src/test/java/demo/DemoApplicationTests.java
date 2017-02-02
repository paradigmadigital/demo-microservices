package demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = UsersDemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
	}

}
