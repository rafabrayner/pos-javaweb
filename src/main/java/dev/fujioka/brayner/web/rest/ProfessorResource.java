package dev.fujioka.brayner.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.brayner.domain.Professor;
import dev.fujioka.brayner.service.ProfessorService;
import dev.fujioka.brayner.service.dto.ProfessorDto;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;

@RestController
@RequestMapping("/api")
public class ProfessorResource {

	@Autowired
	private ProfessorService professorService;

	@GetMapping("/professor")
	public List<Professor> getProfessors() {
		return professorService.findAll();
	}

	@GetMapping("/professor/{id}")
	public ResponseEntity<ProfessorDto> getProfessor(Long id) {
		ProfessorDto dto = new ProfessorDto(professorService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Professor", "id", id.toString())));
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/professor")
	public ResponseEntity<ProfessorDto> save(@Valid @RequestBody Professor professor) {
		ProfessorDto professorDto = new ProfessorDto(professorService.save(professor).orElseThrow(
				() -> new EntityPersistUpdateFindException("Professor", "Not save", professor.toString())));
		return ResponseEntity.ok(professorDto);
	}

	@PutMapping("/professor")
	public ResponseEntity<ProfessorDto> update(@Valid @RequestBody Professor professor) {
		if (professor.getId() != null) {
			ProfessorDto professorDto = new ProfessorDto(professorService.save(professor).orElseThrow(
					() -> new EntityPersistUpdateFindException("Professor", "Not Update", professor.toString())));
			return ResponseEntity.ok(professorDto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/professor")
	public ResponseEntity delete(@Valid @RequestBody Professor professor) {
		professorService.delete(professor);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/professor/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		Professor professorDelete = professorService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Professor", "id", id.toString()));
		professorService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
