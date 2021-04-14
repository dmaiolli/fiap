package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GRUPO_CHALLENGE")
@SequenceGenerator(sequenceName = "SQ_TB_GRUPO_CHALLENGE", name = "grupo", allocationSize = 1)
public class GrupoChallenge {

	@Id
	@Column(name = "cd_grupo")
	@GeneratedValue(generator = "grupo", strategy = GenerationType.SEQUENCE)
	private int cdGrupo;

	@Column(name = "nm_grupo", length = 50, nullable = false)
	private String nomeGrupo;
	
	// Mapear o relacionamento um-para-um
	// mappedBy -> nome do atributo que mapeia a FK
	// mappedBy -> sempre utilizado no bidirecional 
	@OneToOne(mappedBy = "grupo", cascade = CascadeType.ALL)
	private ProjetoChallenge challenge;
	
	// Mapeando relacionamento
	@OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Aluno> alunos;
	
	// Método auxiliar para adicionar um aluno no grupo, para garantir o preenchimento da FK no banco
	// utilizado para cadastrar em cascata ( cadastrar o grupo e o grupo cadastra o aluno )
	// Utilizado apenas no um-para-muitos
	public void addAluno(Aluno aluno) {
		if ( alunos == null) {
			alunos = new ArrayList<>();
		}
		
		alunos.add(aluno);
		
		// setar o grupo do aluno
		aluno.setGrupo(this);
	}

	public GrupoChallenge() {
		super();
	}

	public GrupoChallenge(String nomeGrupo) {
		super();
		this.nomeGrupo = nomeGrupo;
	}

	public GrupoChallenge(int cdGrupo, String nomeGrupo) {
		super();
		this.cdGrupo = cdGrupo;
		this.nomeGrupo = nomeGrupo;
	}

	public int getCdGrupo() {
		return cdGrupo;
	}

	public void setCdGrupo(int cdGrupo) {
		this.cdGrupo = cdGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
