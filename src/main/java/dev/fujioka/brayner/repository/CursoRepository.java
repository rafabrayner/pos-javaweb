package dev.fujioka.brayner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.brayner.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	public List<Curso> findProductByNome(String name);

}
