package rohan.aspect.resourcelinkaspect.processors;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import rohan.aspect.resourcelinkaspect.model.NonCandidate;

@Component
public class NonCandidateResourceProcessor implements ResourceProcessor<Resource<NonCandidate>>{

	@Override
	public Resource<NonCandidate> process(Resource<NonCandidate> resource) {

		resource.add(new Link("href"));
		
		return resource;
	}

}
