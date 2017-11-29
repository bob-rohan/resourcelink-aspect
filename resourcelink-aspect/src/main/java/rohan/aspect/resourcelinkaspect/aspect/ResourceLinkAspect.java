package rohan.aspect.resourcelinkaspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class ResourceLinkAspect {

	@AfterReturning(pointcut = "execution(* rohan.aspect.resourcelinkaspect.services..*(..))", returning = "returnValue")
	public void runAfter(JoinPoint joinPoint, Resource<?> returnValue) throws Throwable {

		returnValue.add(new Link("href"));

	}

}
