package dev.fujioka.brayner.service.dto;

import java.util.Date;
import java.util.Objects;

import dev.fujioka.brayner.domain.Curso;

public class CursoDto {

	private Long id;
    private String nome;
    private String descricao;
    private Date dtCreation;
    private Date dtUpdate;
    
    public CursoDto(Curso curso) {
    	this.id = curso.getId();
    	this.nome = curso.getNome();
    	this.descricao = curso.getDescricao();
    	this.dtCreation = curso.getDtCreation();
    	this.dtUpdate = curso.getDtUpdate();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

	public Date getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(Date dtUpdate) {
		this.dtUpdate = dtUpdate;
	}
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoDto cursoDto = (CursoDto) o;
        return Objects.equals(id, cursoDto.id) &&
                Objects.equals(nome, cursoDto.nome) &&
                Objects.equals(descricao, cursoDto.descricao) &&
                Objects.equals(dtCreation, cursoDto.dtCreation) &&
                Objects.equals(dtUpdate, cursoDto.dtUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, dtCreation, dtUpdate);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + descricao + '\'' +
                ", dtCreation=" + dtCreation +
                ", dtUpdate=" + dtUpdate +
                '}';
    }

}
