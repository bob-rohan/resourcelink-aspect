package rohan.aspect.resourcelinkaspect.services;

import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import rohan.aspect.resourcelinkaspect.model.Candidate;

@Service	
public class CandidateServiceImpl implements CandidateService{

	public Resource<Candidate> getCandidateResource(){
		
		Candidate candidate = new Candidate();
		candidate.setName("Joe B");
		return new Resource<>(candidate);
	}
	
	public Candidate getCandidate(){
		
		Candidate candidate = new Candidate();
		candidate.setName("Jessica R");
		return candidate;
	}
	
}
