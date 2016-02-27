function validaInputProdutoPesquisa(){
	
	if (document.formulario.id.value =="") {		
		document.getElementById("ldescricao").innerHTML ='Informe o Id';
		document.formulario.id.focus();
		return false;		
	}
	return true;
	
}

function limpaInput(){		
	document.getElementById("ldescricao").innerHTML ='';		
}

function validaInput(){
	
	if (document.formulario.descricao.value=="") {
		
		document.getElementById("descricao").innerHTML = 'Descricao invalida';
		document.formulario.descricao.focus();
		return false;
	}if (document.formulario.quantidade.value=="") {
		
		document.getElementById("quantidade").innerHTML = 'Quantidade invalida';
		document.formulario.quantidade.focus();
		return false;
	}if (document.formulario.valor.value=="") {
		
		document.getElementById("valor").innerHTML = 'Valor invalido';
		document.formulario.valor.focus();
		return false;
	} 

	return true;
	
}

function validaInput2(){
	
	if (document.formulario.id.value=="") {
		
		document.getElementById("id").innerHTML = 'Selecione um produto para dar entrada';
		return false;
		
	}if (document.formulario.descricao.value=="") {
		
		document.getElementById("descricao").innerHTML = 'Selecione um produto para dar entrada';
		return false;
	}
	
	
	if (document.formulario.quantidade.value=="") {
		
		document.getElementById("quantidade").innerHTML = 'Quantidade invalida';
		document.formulario.quantidade.focus();
		return false;
	}
	
 
 
	return true;
}

function validaInput3(){
	
	if (document.formulario.id.value=="") {
		
		document.getElementById("id").innerHTML = 'Selecione um produto para dar baixa';
		return false;
		
	}if (document.formulario.descricao.value=="") {
		
		document.getElementById("descricao").innerHTML = 'Selecione um produto para dar baixa';
		return false;
	}
	
	
	if (document.formulario.quantidade.value=="") {
		
		document.getElementById("quantidade").innerHTML = 'Quantidade invalida';
		document.formulario.quantidade.focus();
		return false;
	}
	
 
 
	return true;
}

 
 
























