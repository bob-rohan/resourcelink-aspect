package rohan.aspect.resourcelinkaspect.aspect;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class ResourceLinkAspect {

	private Collection<ResourceProcessor> processors;

	@Autowired
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		processors = new HashSet<>();
		
		Collection<ResourceProcessor> allProcessors = context.getBeansOfType(ResourceProcessor.class).values();

		for (ResourceProcessor<?> processor : allProcessors) {

			Class<?> processorType = ResolvableType.forClass(ResourceProcessor.class, processor.getClass()).getGeneric(0).resolve();

			if (isValidForType(processorType, Resource.class)) {
				processors.add(processor);
			}
		}
	}

	@AfterReturning(pointcut = "execution(* rohan.aspect.resourcelinkaspect.services..*(..))", returning = "resource")
	public void runAfter(JoinPoint joinPoint, Resource<?> resource) throws Throwable {

		for (ResourceProcessor processor : processors) {

			Class<?> resourceProcessorType = ResolvableType.forClass(ResourceProcessor.class, processor.getClass())
			.getGeneric(0).getGeneric(0).resolve();
			
			Class<?> resourceContentType = resource.getContent().getClass();
			
			if (isValidForType(resourceProcessorType, resourceContentType)) {

				processor.process(resource);
			}

		}
	}
	
	private boolean isValidForType(Class<?> left, Class<?> right){
		return left.isAssignableFrom(right);
	}

}
