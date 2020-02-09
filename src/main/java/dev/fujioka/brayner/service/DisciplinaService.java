package dev.fujioka.brayner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.brayner.domain.Disciplina;
import dev.fujioka.brayner.repository.DisciplinaRepository;
import dev.fujioka.java.avancado.web.service.CrudInterface;

@Service
public class DisciplinaService implements CrudInterface<Disciplina> {

	@Autowired
    private DisciplinaRepository disciplinaRepository;

	@Override
	public List<Disciplina> findAll() {
		return disciplinaRepository.findAll();
	}

	@Override
	public Optional<Disciplina> save(Disciplina entity) {
		return Optional.of(disciplinaRepository.save(entity));
	}

	@Override
	public Optional<Disciplina> findById(long id) {
		return disciplinaRepository.findById(id);
	}

	@Override
	public void delete(Disciplina entity) {
		disciplinaRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		disciplinaRepository.deleteById(id);
	}

	@Override
	public long count() {
		return disciplinaRepository.count();
	}
}
