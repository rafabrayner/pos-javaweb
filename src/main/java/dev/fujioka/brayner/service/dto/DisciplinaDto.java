package dev.fujioka.brayner.service.dto;

import java.util.Date;
import java.util.Objects;

import dev.fujioka.brayner.domain.Disciplina;

public class DisciplinaDto {
	
	private Long id;
	private String nome;
	private String descricao;
	private int cargaHoraria;
	private Date dtCreation;
	private Date dtUpdate;
	
	public DisciplinaDto(Disciplina disciplina) {
		super();
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
		this.descricao = disciplina.getDescricao();
		this.cargaHoraria = disciplina.getCargaHoraria();
		this.dtCreation = disciplina.getDtCreation();
		this.dtUpdate = disciplina.getDtUpdate();
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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
        DisciplinaDto disciplinaDto = (DisciplinaDto) o;
        return Objects.equals(id, disciplinaDto.id) &&
                Objects.equals(nome, disciplinaDto.nome) &&
                Objects.equals(descricao, disciplinaDto.descricao) &&
                Objects.equals(cargaHoraria, disciplinaDto.cargaHoraria) &&
                Objects.equals(dtCreation, disciplinaDto.dtCreation) &&
                Objects.equals(dtUpdate, disciplinaDto.dtUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, cargaHoraria, dtCreation, dtUpdate);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cargaHoraria='" + cargaHoraria + '\'' +
                ", dtCreation=" + dtCreation +
                ", dtUpdate=" + dtUpdate +
                '}';
    }
	
	

}
