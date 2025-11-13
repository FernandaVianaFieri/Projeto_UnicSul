package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAO {
	/* Módulo de conexão **/
// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcafeteria?useTimeZone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Fer1234@";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Teste de conexão
	public void testeConexão() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD CREATE **/
	public void inserirCliente(JavaBeans cliente) {
		String create = "insert into clientes (cpf,nome,email,dataNasc,telefone,endereco)values (?,?,?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();

			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, cliente.getIdcpf());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getDataNasc());
			pst.setString(5, cliente.getTelefone());
			pst.setString(6, cliente.getEndereco());

			// Executar a query
			pst.executeUpdate();

			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
				

	/** CRUd Read **/
	public ArrayList<JavaBeans> ListarClientes() {
		// Criando um objeto para acessar a clase JavaBeans
		ArrayList<JavaBeans> clientes = new ArrayList<>();
		String read = "select*from clientes order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo será executado enquanto huver clientes
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String idcpf = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String dtaNasc = rs.getString(4);
				String telefone = rs.getString(5);
				String endereco = rs.getString(6);
				// populando o ArrayList
				clientes.add(new JavaBeans(idcpf, nome, email, dtaNasc, telefone, endereco));
			}
			con.close();
			return clientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	/** CRUD CREATE **/
	public void inserirProduto(Produto produto) {
		String create = "insert into produtos (idProd,nome,preço)values (?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();

			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setInt(1, produto.getIdProd());
			pst.setString(2, produto.getNome());
			pst.setDouble(3, produto.getPreco());
			

			// Executar a query
			pst.executeUpdate();

			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
