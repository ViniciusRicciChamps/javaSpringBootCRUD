package br.com.springboot.curso_SpringBoot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/*	efine um gerador de chave primária que pode ser referenciado por nome quando um elemento
 *  gerador é especificado para a GeneratedValue anotação. Um gerador de sequência pode ser
 *   especificado na classe de entidade ou no campo ou propriedade da chave primária. O escopo 
 *   do nome do gerador é global para a unidade de persistência (em todos os tipos de gerador).
 */

@Entity
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id_usuario;
	
	private String nome_usuario;
	
	private int idade_usuario;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public int getIdade_usuario() {
		return idade_usuario;
	}

	public void setIdade_usuario(int idade_usuario) {
		this.idade_usuario = idade_usuario;
	}

}
