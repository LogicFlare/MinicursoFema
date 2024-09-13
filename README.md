endpoints para testar


ENDPOINT DOS PROFISSIONAIS =>

	------ Cadastrar Profissional ------

	url: http://localhost:8080/profissional/cadastrar

	{
		"nome": "Bart Simpson",
		"contato": "18 997949908",
		"email": "bart@gmail.com",
		"horariosDisponiveis": [
			"2024-09-13T09:09:00",
			"2024-09-13T09:10:00",
			"2024-09-13T09:11:00"
		]
	}

	------ Listar Profissionais ------

	url: http://localhost:8080/profissional/all

	------ Lista Profissional pelo ID ------

	http://localhost:8080/profissional/coloque-o-id-aqui

	------ Atualizar Profissional ------

	http://localhost:8080/profissional/atualizar/coloque-o-id-aqui

	------ Deletar Profissional ------

	http://localhost:8080/profissional/deletar/coloque-o-id-aqui



ENDPOINT DOS PRODUTOS =>

	------ Cadastrar Produto ------

	url: http://localhost:8080/produto/cadastrar

	{
		"nome": "Bart Simpson",
		"contato": "18 997949908",
		"email": "bart@gmail.com",
		"horariosDisponiveis": [
			"2024-09-13T09:09:00",
			"2024-09-13T09:10:00",
			"2024-09-13T09:11:00"
		]
	}

	------ Listar Produtos ------

	url: http://localhost:8080/produto/all

	------ Lista Produto pelo ID ------

	http://localhost:8080/produto/coloque-o-id-aqui

	------ Atualizar Produto ------

	http://localhost:8080/produto/atualizar/coloque-o-id-aqui

	------ Deletar Produto ------

	http://localhost:8080/produto/deletar/coloque-o-id-aqui
