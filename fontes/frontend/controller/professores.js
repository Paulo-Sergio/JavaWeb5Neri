var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller('professoresController', function ($scope) {

    $scope.professores = [
        { id: 1, nome: 'Paulo França', email: 'paulo@gmail.com', telefone: '81 98882-4977' },
        { id: 2, nome: 'Jose Silva', email: 'josesilva@gmail.com', telefone: '81 12345-4567' },
        { id: 3, nome: 'Izabelly Silva', email: 'izabelly@gmail.com', telefone: '81 98868-0609' }
    ];

    $scope.selecionarProfessor = function (professorSelecionado) {
        $scope.professor = professorSelecionado;
    };

    $scope.limparCampos = function(){
        $scope.professor = "";
    }

});