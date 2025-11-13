package model;

public class JavaBeans {
	private String idcpf;
	private String nome;
	private String email ;
	private String dataNasc;
	private String telefone;
	private String 	endereco;
	
	
	public JavaBeans() {
		super();
	}
	
	
	public JavaBeans(String idcpf, String nome, String email, String dataNasc, String telefone, String endereco) {
		super();
		this.idcpf = idcpf;
		this.nome = nome;
		this.email = email;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	public String getIdcpf() {
		return idcpf;
	}
	public void setIdcpf(String idcpf) {
		this.idcpf = idcpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
