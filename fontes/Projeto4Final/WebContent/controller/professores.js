var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller('professoresController', function ($scope, $http) {

    var urlProfessores = 'http://localhost:8080/Projeto4Final/rest/professores';
	
    $scope.listarProfessores = function() {
		$http.get(urlProfessores).then(function(response) {
			$scope.professores = response.data;
			
		}).catch(function(err) {
			console.log(err);
		});
	};
	
	// executa funcao para listagem
	$scope.listarProfessores();
	
	$scope.selecionarProfessor = function(professorSelecionado){
		$scope.professor = professorSelecionado;
	}
	
	$scope.limparCampos = function(){
		$scope.professor = null;
	}
	
	// salvar ou atualiza
	$scope.salvar = function(){
		if($scope.professor.id == null || $scope.professor.id == undefined){
			$http.post(urlProfessores, $scope.professor).then(function(response){
				// $scope.professores.push($scope.professor);
				$scope.listarProfessores();
				$scope.limparCampos();
				
			}).catch(function(err){
				console.log(err);
			});
		} else {
			$http.put(urlProfessores, $scope.professor).then(function(response){
				$scope.listarProfessores();
				$scope.limparCampos();
				
			}).catch(function(err){
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
			$http.delete(urlProfessores + '/' + $scope.professor.id).then(function(){
				$scope.listarProfessores();
				$scope.limparCampos();
			}).catch(function(err) {
				console.log(err);
			});
		}
	}

});