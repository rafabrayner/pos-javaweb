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

import dev.fujioka.brayner.domain.Curso;
import dev.fujioka.brayner.service.CursoService;
import dev.fujioka.brayner.service.dto.CursoDto;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;

@RestController
@RequestMapping("/api")
public class CursoResource {
	
	@Autowired
    private CursoService cursoService;
	
	@GetMapping("/curso")
	public List<Curso> getCursos() {
		return cursoService.findAll();
	}

	@GetMapping("/curso/{id}")
	public ResponseEntity<CursoDto> getCurso(Long id) {
		CursoDto dto = new CursoDto(cursoService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Curso", "id", id.toString())));
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/curso")
	public ResponseEntity<CursoDto> save(@Valid @RequestBody Curso curso) {
		CursoDto cursoDto = new CursoDto(cursoService.save(curso)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Curso", "Not save", curso.toString())));
		return ResponseEntity.ok(cursoDto);
	}

	@PutMapping("/curso")
	public ResponseEntity<CursoDto> update(@Valid @RequestBody Curso curso) {
		if (curso.getId() != null) {
			CursoDto cursoDto = new CursoDto(cursoService.save(curso)
					.orElseThrow(() -> new EntityPersistUpdateFindException("Curso", "Not Update", curso.toString())));
			return ResponseEntity.ok(cursoDto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/curso")
	public ResponseEntity delete(@Valid @RequestBody Curso curso) {
		cursoService.delete(curso);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/curso/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		Curso cursoDelete = cursoService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Curso", "id", id.toString()));
		cursoService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
