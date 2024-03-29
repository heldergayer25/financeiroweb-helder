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
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Acesso generated by hbm2java
 */
@Entity
@Table(name = "acesso", catalog = "financeiroweb")
public class Acesso implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "login", nullable = false, length = 20)
	private String login;
	
	@Column(name = "senha", nullable = false, length = 32)
	private String senha;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "acesso")
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Acesso() {
	}

	public Acesso(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Acesso(String login, String senha, Set<Usuario> usuarios) {
		this.login = login;
		this.senha = senha;
		this.usuarios = usuarios;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
