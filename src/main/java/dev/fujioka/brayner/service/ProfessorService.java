package dev.fujioka.brayner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.brayner.domain.Professor;
import dev.fujioka.brayner.repository.ProfessorRepository;
import dev.fujioka.java.avancado.web.service.CrudInterface;

@Service
public class ProfessorService implements CrudInterface<Professor> {
	
	@Autowired
    private ProfessorRepository professorRepository;

	@Override
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	@Override
	public Optional<Professor> save(Professor entity) {
		return Optional.of(professorRepository.save(entity));
	}

	@Override
	public Optional<Professor> findById(long id) {
		return professorRepository.findById(id);
	}

	@Override
	public void delete(Professor entity) {
		professorRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		professorRepository.deleteById(id);
	}

	@Override
	public long count() {
		return professorRepository.count();
	}


}
