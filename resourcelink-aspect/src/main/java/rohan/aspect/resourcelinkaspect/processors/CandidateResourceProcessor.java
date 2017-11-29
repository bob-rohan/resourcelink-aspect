package rohan.aspect.resourcelinkaspect.processors;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import rohan.aspect.resourcelinkaspect.model.Candidate;

@Component
public class CandidateResourceProcessor implements ResourceProcessor<Resource<Candidate>>{

	@Override
	public Resource<Candidate> process(Resource<Candidate> resource) {

		resource.add(new Link("href"));
		
		return resource;
	}

}
