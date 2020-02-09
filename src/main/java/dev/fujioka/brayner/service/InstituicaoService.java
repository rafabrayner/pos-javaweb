package dev.fujioka.brayner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.brayner.domain.Instituicao;
import dev.fujioka.brayner.repository.InstituicaoRepository;
import dev.fujioka.java.avancado.web.service.CrudInterface;

@Service
public class InstituicaoService implements CrudInterface<Instituicao> {
	
	@Autowired
    private InstituicaoRepository instituicaoRepository;

	@Override
	public List<Instituicao> findAll() {
		return instituicaoRepository.findAll();
	}

	@Override
	public Optional<Instituicao> save(Instituicao entity) {
		return Optional.of(instituicaoRepository.save(entity));
	}

	@Override
	public Optional<Instituicao> findById(long id) {
		return instituicaoRepository.findById(id);
	}

	@Override
	public void delete(Instituicao entity) {
		instituicaoRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		instituicaoRepository.deleteById(id);
	}

	@Override
	public long count() {
		return instituicaoRepository.count();
	}

}
