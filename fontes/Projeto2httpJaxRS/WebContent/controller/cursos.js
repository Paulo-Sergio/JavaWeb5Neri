var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller('cursosModulo', function ($scope, $http) {

    var urlCursos = 'http://localhost:8080/Projeto2httpJaxRS/rest/professores';
	
    $scope.listarCursos = function() {
		$http.get(urlCursos).then(function(response) {
			$scope.professores = response.data;
			
		}).catch(function(err) {
			alert(err);
			console.log(err);
		});
	};
	
	// executa funcao para listagem
	$scope.listarCursos();
	
	$scope.selecionarProfessor = function(professorSelecionado){
		$scope.professor = professorSelecionado;
	}
	
	$scope.limparCampos = function(){
		$scope.professor = null;
	}
	
	// salvar ou atualiza
	$scope.salvar = function(){
		if($scope.professor.id == null || $scope.professor.id == undefined){
			$http.post(urlCursos, $scope.professor).then(function(response){
				$scope.professores.push($scope.professor);
				$scope.limparCampos();
				
			}).catch(function(err){
				alert(err);
				console.log(err);
			});
		} else {
			$http.put(urlCursos, $scope.professor).then(function(response){
				$scope.listarCursos();
				$scope.limparCampos();
				
			}).catch(function(err){
				alert(err);
				console.log(err);
			});
		}
	}
	
	// excluir
	$scope.excluir = function(){
		if($scope.professor.id == null || $scope.professor.id == undefined){
			alert("Fazer selecionar um registro para efetuar a exclusão");
			console.log("Fazer selecionar um registro para efetuar a exclusão");
		} else {
			$http.delete(urlCursos + '/' + $scope.professor.id).then(function(){
				$scope.listarCursos();
				$scope.limparCampos();
			}).catch(function(err) {
				alert(err);
				console.log(err);
			});
		}
	}

});