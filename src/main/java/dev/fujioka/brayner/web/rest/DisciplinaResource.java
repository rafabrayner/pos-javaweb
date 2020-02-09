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

import dev.fujioka.brayner.domain.Disciplina;
import dev.fujioka.brayner.service.DisciplinaService;
import dev.fujioka.brayner.service.dto.DisciplinaDto;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;

@RestController
@RequestMapping("/api")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping("/disciplina")
	public List<Disciplina> getDisciplinas() {
		return disciplinaService.findAll();
	}

	@GetMapping("/disciplina/{id}")
	public ResponseEntity<DisciplinaDto> getDisciplina(Long id) {
		DisciplinaDto dto = new DisciplinaDto(disciplinaService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Disciplina", "id", id.toString())));
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/disciplina")
	public ResponseEntity<DisciplinaDto> save(@Valid @RequestBody Disciplina disciplina) {
		DisciplinaDto disciplinaDto = new DisciplinaDto(disciplinaService.save(disciplina).orElseThrow(
				() -> new EntityPersistUpdateFindException("Disciplina", "Not save", disciplina.toString())));
		return ResponseEntity.ok(disciplinaDto);
	}

	@PutMapping("/disciplina")
	public ResponseEntity<DisciplinaDto> update(@Valid @RequestBody Disciplina disciplina) {
		if (disciplina.getId() != null) {
			DisciplinaDto disciplinaDto = new DisciplinaDto(disciplinaService.save(disciplina).orElseThrow(
					() -> new EntityPersistUpdateFindException("Disciplina", "Not Update", disciplina.toString())));
			return ResponseEntity.ok(disciplinaDto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/disciplina")
	public ResponseEntity delete(@Valid @RequestBody Disciplina disciplina) {
		disciplinaService.delete(disciplina);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/disciplina/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		Disciplina disciplinaDelete = disciplinaService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Disciplina", "id", id.toString()));
		disciplinaService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
