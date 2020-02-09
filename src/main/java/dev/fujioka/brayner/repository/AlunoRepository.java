package dev.fujioka.brayner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.brayner.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	public List<Aluno> findProductByNome(String name);

}
