package dev.fujioka.brayner.service.dto;

import java.util.Date;
import java.util.Objects;

import dev.fujioka.brayner.domain.Aluno;

public class AlunoDto {
	
	private Long id;
	private String nome;
	private String matricula;
	private double cra;
	private Date dtCreation;
	private Date dtUpdate;
	
	public AlunoDto(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.matricula = aluno.getMatricula();
		this.cra = aluno.getCra();
		this.dtCreation = aluno.getDtCreation();
		this.dtUpdate = aluno.getDtUpdate();
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getCra() {
		return cra;
	}

	public void setCra(double cra) {
		this.cra = cra;
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
        AlunoDto alunoDto = (AlunoDto) o;
        return Objects.equals(id, alunoDto.id) &&
                Objects.equals(nome, alunoDto.nome) &&
                Objects.equals(matricula, alunoDto.matricula) &&
                Objects.equals(cra, alunoDto.cra) &&
                Objects.equals(dtCreation, alunoDto.dtCreation) &&
                Objects.equals(dtUpdate, alunoDto.dtUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, matricula, cra, dtCreation, dtUpdate);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cra='" + cra + '\'' +
                ", dtCreation=" + dtCreation +
                ", dtUpdate=" + dtUpdate +
                '}';
    }

}
