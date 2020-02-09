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

import dev.fujioka.brayner.domain.Aluno;
import dev.fujioka.brayner.service.AlunoService;
import dev.fujioka.brayner.service.dto.AlunoDto;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;

@RestController
@RequestMapping("/api")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/aluno")
	public List<Aluno> getAlunos() {
		return alunoService.findAll();
	}

	@GetMapping("/aluno/{id}")
	public ResponseEntity<AlunoDto> getAluno(Long id) {
		AlunoDto dto = new AlunoDto(alunoService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Aluno", "id", id.toString())));
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/aluno")
	public ResponseEntity<AlunoDto> save(@Valid @RequestBody Aluno aluno) {
		AlunoDto alunoDto = new AlunoDto(alunoService.save(aluno)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Aluno", "Not save", aluno.toString())));
		return ResponseEntity.ok(alunoDto);
	}

	@PutMapping("/aluno")
	public ResponseEntity<AlunoDto> update(@Valid @RequestBody Aluno aluno) {
		if (aluno.getId() != null) {
			AlunoDto alunoDto = new AlunoDto(alunoService.save(aluno)
					.orElseThrow(() -> new EntityPersistUpdateFindException("Aluno", "Not Update", aluno.toString())));
			return ResponseEntity.ok(alunoDto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/aluno")
	public ResponseEntity delete(@Valid @RequestBody Aluno aluno) {
		alunoService.delete(aluno);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/aluno/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		Aluno alunoDelete = alunoService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Aluno", "id", id.toString()));
		alunoService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
