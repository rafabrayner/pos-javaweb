package dev.fujioka.brayner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.brayner.domain.Instituicao;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
	
	public List<Instituicao> findProductByNome(String name);

}
