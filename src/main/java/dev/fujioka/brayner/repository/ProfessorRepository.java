package dev.fujioka.brayner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.brayner.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	public List<Professor> findProductByNome(String name);

}
