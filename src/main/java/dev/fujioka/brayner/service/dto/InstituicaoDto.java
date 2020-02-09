package dev.fujioka.brayner.service.dto;

import java.util.Date;
import java.util.Objects;

import dev.fujioka.brayner.domain.Instituicao;

public class InstituicaoDto {

	private Long id;
	private String nome;
	private String endereco;
	private double numero;
	private Date dtCreation;
	private Date dtUpdate;
	
	public InstituicaoDto(Instituicao instituicao) {
		super();
		this.id = instituicao.getId();
		this.nome = instituicao.getEndereco();
		this.endereco = instituicao.getEndereco();
		this.numero = instituicao.getNumero();
		this.dtCreation = instituicao.getDtCreation();
		this.dtUpdate = instituicao.getDtUpdate();
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
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
        InstituicaoDto instituicaoDto = (InstituicaoDto) o;
        return Objects.equals(id, instituicaoDto.id) &&
                Objects.equals(nome, instituicaoDto.nome) &&
                Objects.equals(endereco, instituicaoDto.endereco) &&
                Objects.equals(numero, instituicaoDto.numero) &&
                Objects.equals(dtCreation, instituicaoDto.dtCreation) &&
                Objects.equals(dtUpdate, instituicaoDto.dtUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, numero, dtCreation, dtUpdate);
    }

    @Override
    public String toString() {
        return "Instituicao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", dtCreation=" + dtCreation +
                ", dtUpdate=" + dtUpdate +
                '}';
    }
	
	
}
