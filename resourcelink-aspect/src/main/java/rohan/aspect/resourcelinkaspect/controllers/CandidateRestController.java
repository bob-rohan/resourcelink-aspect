package rohan.aspect.resourcelinkaspect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rohan.aspect.resourcelinkaspect.model.Candidate;
import rohan.aspect.resourcelinkaspect.services.CandidateService;

@RestController
public class CandidateRestController {

	@Autowired
	private CandidateService candidateService;
	
	@GetMapping(path = "/getCandidate", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Candidate> getCandidate(){
		
		// should invoke aspect
		Resource<Candidate> candidateResource = candidateService.getCandidateResource();
		
		// should not invoke aspect
		Candidate candidate = candidateService.getCandidate(); 
		
		return candidateResource;
	}
	
}
