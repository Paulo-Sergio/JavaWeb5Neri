var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller('cursosController', function ($scope, $http) {

	var urlProfessores = 'http://localhost:8080/Projeto4Final/rest/professores';
	var urlCursos = 'http://localhost:8080/Projeto4Final/rest/cursos';
	
    $scope.listarCursos = function() {
		$http.get(urlCursos).then(function(response) {
			$scope.cursos = response.data;
			
		}).catch(function(err) {
			console.log(err);
		});
	};
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessores).then(function(response) {
			$scope.professores = response.data;
			
		}).catch(function(err) {
			console.log(err);
		});
	};
	
	// executa funcao para listagem
	$scope.listarCursos();
	$scope.listarProfessores();
	
	$scope.selecionarCurso = function(cursoSelecionado){
		$scope.curso = cursoSelecionado;
	}
	
	$scope.limparCampos = function(){
		$scope.curso = null;
	}
	
	// salvar ou atualiza
	$scope.salvar = function(){
		if($scope.curso.id == null || $scope.curso.id == undefined){
			$http.post(urlCursos, $scope.curso).then(function(response){
				// $scope.cursos.push($scope.curso);
				$scope.listarCursos();
				$scope.limparCampos();
				
			}).catch(function(err){
				console.log(err);
			});
		} else {
			$http.put(urlCursos, $scope.curso).then(function(response){
				$scope.listarCursos();
				$scope.limparCampos();
				
			}).catch(function(err){
				console.log(err);
			});
		}
	}
	
	// excluir
	$scope.excluir = function(){
		if($scope.curso.id == null || $scope.curso.id == undefined){
			console.log("Fazer selecionar um registro para efetuar a exclusão");
		} else {
			$http.delete(urlCursos + '/' + $scope.curso.id).then(function(){
				$scope.listarCursos();
				$scope.limparCampos();
			}).catch(function(err) {
				console.log(err);
			});
		}
	}

});