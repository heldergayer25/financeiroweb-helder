package br.com.financeiroweb.pojo;
// default package
// Generated 28/09/2014 14:04:16 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PlanoDeContas generated by hbm2java
 */
@Entity
@Table(name = "plano_de_contas", catalog = "financeiroweb")
public class PlanoDeContas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private PlanoDeContas planoDeContas;
	private ContaContabil contaContabil;
	private String descricao;
	private Set<PlanoDeContas> planoDeContases = new HashSet<PlanoDeContas>(0);
	private Set<Empresa> empresas = new HashSet<Empresa>(0);

	public PlanoDeContas() {
	}

	public PlanoDeContas(PlanoDeContas planoDeContas,
			ContaContabil contaContabil, String descricao) {
		this.planoDeContas = planoDeContas;
		this.contaContabil = contaContabil;
		this.descricao = descricao;
	}

	public PlanoDeContas(PlanoDeContas planoDeContas,
			ContaContabil contaContabil, String descricao,
			Set<PlanoDeContas> planoDeContases, Set<Empresa> empresas) {
		this.planoDeContas = planoDeContas;
		this.contaContabil = contaContabil;
		this.descricao = descricao;
		this.planoDeContases = planoDeContases;
		this.empresas = empresas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plano_de_contas_id", nullable = false)
	public PlanoDeContas getPlanoDeContas() {
		return this.planoDeContas;
	}

	public void setPlanoDeContas(PlanoDeContas planoDeContas) {
		this.planoDeContas = planoDeContas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_contabil_id", nullable = false)
	public ContaContabil getContaContabil() {
		return this.contaContabil;
	}

	public void setContaContabil(ContaContabil contaContabil) {
		this.contaContabil = contaContabil;
	}

	@Column(name = "descricao", nullable = false, length = 100)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planoDeContas")
	public Set<PlanoDeContas> getPlanoDeContases() {
		return this.planoDeContases;
	}

	public void setPlanoDeContases(Set<PlanoDeContas> planoDeContases) {
		this.planoDeContases = planoDeContases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planoDeContas")
	public Set<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

}
