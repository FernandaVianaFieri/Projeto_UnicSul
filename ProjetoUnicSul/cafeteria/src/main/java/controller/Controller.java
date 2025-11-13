package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;
import model.Produto;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans cliente = new JavaBeans();
	Produto produto2 = new Produto();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// teste de conexão
		// dao.testeConexão();
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			clientes(request, response);
		} else if (action.equals("/insert")) {
			novoCliente(request, response);
		} else if (action.equals("/select")) {
			listarCliente(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

//Listar clientes
	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** response.sendRedirect("cafeteria.jsp"); **/
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.ListarClientes();
		// teste de recebimento da lista
		/**
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdcpf());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getEmail());
		 * System.out.println(lista.get(i).getDataNasc());
		 * System.out.println(lista.get(i).getTelefone());
		 * System.out.println(lista.get(i).getEndereco()); }
		 **/
		// Encaminhar a lista ao documento cafeteria.jsp
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cafeteria.jsp");
		rd.forward(request, response);
	}

	// Novo Cliente
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("cafeteria.jsp");
		/* teste de recebimento dos dados
		System.out.println(request.getParameter("cpf"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("dtaNasc"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("endereco"));
*/
		// Seter as variáveis JavaBeans
		cliente.setIdcpf(request.getParameter("idcpff"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setDataNasc(request.getParameter("dtaNasc"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEndereco(request.getParameter("endereco"));
		
		// invocar o método inserirCliente passando o objeto cliente
		dao.inserirCliente(cliente);
		// redirecionar para o documento cafeteria.jsp
		response.sendRedirect("main");

	}
	// Editar contato
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response) {
		String idcpf= request.getParameter("idcpf");
		
		request.setAttribute("idCpf", cliente.getIdcpf());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("DtaNasc", cliente.getDataNasc());
		request.setAttribute("telefone", cliente.getTelefone());
		request.setAttribute("endereco", cliente.getEndereco());
		
		
		// setar a variavel JavaBeans
		cliente.setIdcpf(idcpf);
	}
	
	
		
	List<Produto> listaProdutos = new ArrayList<>();{
		
    // Adiciona produtos à lista
	

    // Exibe os produtos na lista
    System.out.println("Lista de Produtos:");
    for (Produto produtos : listaProdutos) {
        System.out.println(produtos);
    }
    
    // Exemplo de acesso a um elemento específico (índice 0)
    System.out.println("\nPrimeiro produto: " + listaProdutos.get(0).getNome());

    // Exemplo de remoção de um elemento (índice 1)
    listaProdutos.remove(1);
    System.out.println("\nLista após remover o segundo produto:");
    for (Produto produto : listaProdutos) {
        System.out.println(produto);
    }
    
}}
