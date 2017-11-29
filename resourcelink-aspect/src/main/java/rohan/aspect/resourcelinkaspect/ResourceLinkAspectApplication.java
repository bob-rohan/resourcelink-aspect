package rohan.aspect.resourcelinkaspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class ResourceLinkAspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceLinkAspectApplication.class, args);
	}

}