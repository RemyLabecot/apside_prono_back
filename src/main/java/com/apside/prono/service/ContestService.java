package com.apside.prono.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apside.prono.model.Contest;
import com.apside.prono.repository.ContestRepository;

@Service

public class ContestService {
	
	@Autowired 
	private ContestRepository contestRepository;
	
	public Iterable <Contest> getAllContest() {
		return contestRepository.findAll();
	}
	
	@Transactional
	public Contest createContest(Contest contest) {
		return contestRepository.save(contest);
	}
	
	public Contest getContestById(Long id) {
		return contestRepository.findById(id).get();
	}
	
	@Transactional
	public Contest modifyContest(Contest contest) {
		Contest contestModif = getContestById(contest.getId());

		contestModif.setId(contest.getId());
		contestModif.setLabel(contest.getLabel());
		
		return contestModif;
	}
	
	@Transactional
	public void deleteContest(Contest contest) {
		contestRepository.delete(contest);
	}
}

