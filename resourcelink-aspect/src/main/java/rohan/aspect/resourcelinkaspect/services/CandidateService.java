package rohan.aspect.resourcelinkaspect.services;

import org.springframework.hateoas.Resource;

import rohan.aspect.resourcelinkaspect.model.Candidate;

public interface CandidateService {

	Candidate getCandidate();
	
	Resource<Candidate> getCandidateResource();
}
