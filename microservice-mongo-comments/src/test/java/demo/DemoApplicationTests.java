package demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.paradigma.demo.mongodb.CommentsDemoMongoApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CommentsDemoMongoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
	}

}
