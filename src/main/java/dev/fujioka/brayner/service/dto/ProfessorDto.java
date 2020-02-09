package dev.fujioka.brayner.service.dto;

import java.util.Date;
import java.util.Objects;

import dev.fujioka.brayner.domain.Professor;

public class ProfessorDto {
	
	private Long id;
	private String nome;
	private String titulacao;
	private String areaPesquisa;
	private double salario;
	private Date dtCreation;
	private Date dtUpdate;
	
	public ProfessorDto(Professor professor) {
		this.id = professor.getId();
		this.nome = professor.getNome();
		this.titulacao = professor.getTitulacao();
		this.areaPesquisa = professor.getAreaPesquisa();
		this.salario = professor.getSalario();
		this.dtCreation = professor.getDtCreation();
		this.dtUpdate = professor.getDtUpdate();
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

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getAreaPesquisa() {
		return areaPesquisa;
	}

	public void setAreaPesquisa(String areaPesquisa) {
		this.areaPesquisa = areaPesquisa;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
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
        ProfessorDto professorDto = (ProfessorDto) o;
        return Objects.equals(id, professorDto.id) &&
                Objects.equals(nome, professorDto.nome) &&
                Objects.equals(titulacao, professorDto.titulacao) &&
                Objects.equals(areaPesquisa, professorDto.areaPesquisa) &&
                Objects.equals(dtCreation, professorDto.dtCreation) &&
                Objects.equals(dtUpdate, professorDto.dtUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, titulacao, areaPesquisa, dtCreation, dtUpdate);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", titulacao='" + titulacao + '\'' +
                ", areaPesquisa='" + areaPesquisa + '\'' +
                ", dtCreation=" + dtCreation +
                ", dtUpdate=" + dtUpdate +
                '}';
    }
	
	

}
