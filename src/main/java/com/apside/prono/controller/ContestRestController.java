package com.apside.prono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apside.prono.model.Contest;
import com.apside.prono.model.Player;
import com.apside.prono.service.ContestService;

@RestController
@RequestMapping(value="/contest")
public class ContestRestController {
	
	@Autowired
	private ContestService contestService;

	@GetMapping(produces = "application/json", path="/allcontest")
	public Iterable<Contest> getAllContest() {
		
	return  contestService.getAllContest();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json", path="/newcontest")
	public Contest create(@RequestBody Contest contest) {
	
	return contestService.createContest(contest);
	}
	
	@GetMapping(produces = "application/json", path="/{id}")
	public Contest getContestById(@PathVariable Long id) {
		
	return contestService.getContestById(id);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json", path="/modifycontest")
	public Contest contestPlayer(@RequestBody Contest contest)  {
		return contestService.modifyContest(contest);
	}

	@DeleteMapping(path="/deletecontest")
	public void deleteContest(@RequestBody Contest contest)  {
		contestService.deleteContest(contest);
	}
}






