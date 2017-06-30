var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller('professoresController', function ($scope, $http) {

    var urlProfessores = 'http://localhost:8080/Projeto2httpJaxRS/rest/professores';
	
    $scope.listarProfessores = function() {
		$http.get(urlProfessores).then(function(response) {
			$scope.professores = response.data;
			
		}).catch(function(err) {
			alert(err);
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
		if($scope.professor.id == ''){
			$http.post(urlProfessores, $scope.professor).then(function(response){
				$scope.professores.push($scope.professor);
				$scope.limparCampos();
				
			}).catch(function(err){
				alert(err);
			});
		} else {
			$http.put(urlProfessores, $scope.professor).then(function(response){
				$scope.listarProfessores();
				$scope.limparCampos();
				
			}).catch(function(err){
				alert(err);
			});
		}
	}

});