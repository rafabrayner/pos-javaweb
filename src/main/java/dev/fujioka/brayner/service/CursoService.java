package dev.fujioka.brayner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.brayner.domain.Curso;
import dev.fujioka.brayner.repository.CursoRepository;
import dev.fujioka.java.avancado.web.service.CrudInterface;

@Service
public class CursoService implements CrudInterface<Curso> {

	@Autowired
    private CursoRepository cursoRepository;

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Optional<Curso> save(Curso entity) {
		return Optional.of(cursoRepository.save(entity));
	}

	@Override
	public Optional<Curso> findById(long id) {
		return cursoRepository.findById(id);
	}

	@Override
	public void delete(Curso entity) {
		cursoRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		cursoRepository.deleteById(id);
	}

	@Override
	public long count() {
		return cursoRepository.count();
	}

}
