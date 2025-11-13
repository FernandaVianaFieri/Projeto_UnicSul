/**
 * Validador fe formulários
 * @author Fernanda Viana Fieri
 */

function validar(){
	//alert("teste")
	let cpf= frmCliente.cpf.value
	let nome= frmCliente.nome.value
	let email= frmCliente.email.value
	let dtaNasc= frmCliente.dtaNasc.value
	let telefone= frmCliente.telefone.value
	let endereco= frmCliente.endereco.value
	if(cpf===""){
		alert("Preencha o campo CPF")
		frmCliente.cpf.focus()
		return false
	}else if(nome===""){
		alert("Preencha o campo Nome")
				frmCliente.nome.focus()
				return false
	}else if(email===""){
	alert("Preencha o campo Email")
	frmCliente.email.focus()
	return false
	}else if(dtaNasc===""){
	alert("Preencha o campo Data de Nascimento")
	frmCliente.dtaNasc.focus()
	return false
}else if(telefone===""){
	alert("Preencha o campo Telefone")
		frmCliente.telefone.focus()
}else{
	document.forms["frmCliente"].submit()
}
}