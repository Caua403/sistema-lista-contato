package ListaContato;

public class Contato {
	private String nome;
	private Telefone tel;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Telefone getTel() {
		return tel;
	}
	public void setTel(Telefone tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
	String s = "";
	s+= "Nome: " + nome +";";
	s+= " Telefone: " + tel.getDdd() + tel.getNum() + ";";
	s+= " Email: " + email + ".";
	s+= "";
	return s;
	}
}
