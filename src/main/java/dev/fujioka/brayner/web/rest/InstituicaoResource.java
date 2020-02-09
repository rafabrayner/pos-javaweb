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

import dev.fujioka.brayner.domain.Instituicao;
import dev.fujioka.brayner.service.InstituicaoService;
import dev.fujioka.brayner.service.dto.InstituicaoDto;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;

@RestController
@RequestMapping("/api")
public class InstituicaoResource {
	
	@Autowired
    private InstituicaoService instituicaoService;
	
	@GetMapping("/instituicao")
	public List<Instituicao> getInstituicaos() {
		return instituicaoService.findAll();
	}

	@GetMapping("/instituicao/{id}")
	public ResponseEntity<InstituicaoDto> getInstituicao(Long id) {
		InstituicaoDto dto = new InstituicaoDto(instituicaoService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Instituicao", "id", id.toString())));
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/instituicao")
	public ResponseEntity<InstituicaoDto> save(@Valid @RequestBody Instituicao instituicao) {
		InstituicaoDto instituicaoDto = new InstituicaoDto(instituicaoService.save(instituicao)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Instituicao", "Not save", instituicao.toString())));
		return ResponseEntity.ok(instituicaoDto);
	}

	@PutMapping("/instituicao")
	public ResponseEntity<InstituicaoDto> update(@Valid @RequestBody Instituicao instituicao) {
		if (instituicao.getId() != null) {
			InstituicaoDto instituicaoDto = new InstituicaoDto(instituicaoService.save(instituicao)
					.orElseThrow(() -> new EntityPersistUpdateFindException("Instituicao", "Not Update", instituicao.toString())));
			return ResponseEntity.ok(instituicaoDto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/instituicao")
	public ResponseEntity delete(@Valid @RequestBody Instituicao instituicao) {
		instituicaoService.delete(instituicao);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/instituicao/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		Instituicao instituicaoDelete = instituicaoService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Instituicao", "id", id.toString()));
		instituicaoService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
