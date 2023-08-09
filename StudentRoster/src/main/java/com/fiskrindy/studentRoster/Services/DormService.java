package com.fiskrindy.studentRoster.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiskrindy.studentRoster.Models.Dorm;
import com.fiskrindy.studentRoster.Repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dormRepo;
	
	public DormService(DormRepository dormRepo) {
		this.dormRepo = dormRepo;
	}
	
	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}
	
	public Dorm addDorm(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormRepo.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		}
		else {
			return null;
		}
	}
}
