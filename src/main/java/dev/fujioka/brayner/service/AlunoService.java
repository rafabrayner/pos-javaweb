package dev.fujioka.brayner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.brayner.domain.Aluno;
import dev.fujioka.brayner.repository.AlunoRepository;
import dev.fujioka.java.avancado.web.service.CrudInterface;

@Service
public class AlunoService implements CrudInterface<Aluno> {
	
	@Autowired
    private AlunoRepository alunoRepository;

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Optional<Aluno> save(Aluno entity) {
		return Optional.of(alunoRepository.save(entity));
	}

	@Override
	public Optional<Aluno> findById(long id) {
		return alunoRepository.findById(id);
	}

	@Override
	public void delete(Aluno entity) {
		alunoRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		alunoRepository.deleteById(id);
	}

	@Override
	public long count() {
		return alunoRepository.count();
	}

}
