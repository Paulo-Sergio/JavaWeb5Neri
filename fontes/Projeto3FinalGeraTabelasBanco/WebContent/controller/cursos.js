var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller('cursosController', function ($scope) {

    $scope.professores = [
        {
            id: 1,
            nome: 'Paulo França',
            email: 'paulo@gmail.com',
            telefone: '81 98882-4977'
        },
        {
            id: 2,
            nome: 'Jose Silva',
            email: 'josesilva@gmail.com',
            telefone: '81 12345-4567'
        },
        {
            id: 3,
            nome: 'Izabelly Silva',
            email: 'izabelly@gmail.com',
            telefone: '81 98868-0609'
        }
    ];

    $scope.cursos = [
        {
            id: 1,
            nome: 'Java para web',
            diashorarios: 'Segundas e Quartas, 19 hrs',
            professor:
            {
                id: 1,
                nome: 'Paulo França',
                email: 'paulo@gmail.com',
                telefone: '81 98882-4977'
            }
        },
        {
            id: 2,
            nome: 'DELPHI',
            diashorarios: 'Terças e Quintas, 20 hrs',
            professor:
            {
                id: 2,
                nome: 'Jose Silva',
                email: 'josesilva@gmail.com',
                telefone: '81 12345-4567'
            }
        },
        {
            id: 3,
            nome: 'PHP',
            diashorarios: 'Sabados 9 hrs',
            professor:
            {
                id: 3,
                nome: 'Izabelly Silva',
                email: 'izabelly@gmail.com',
                telefone: '81 98868-0609'
            }
        }
    ];

    $scope.selecionarCurso = function (cursoSelecionado) {
        $scope.curso = cursoSelecionado;
    };

    $scope.limparCampos = function () {
        $scope.curso = null;
    };

    $scope.salvar = function () {
        $scope.cursos.push($scope.curso);
        $scope.limparCampos();
    }

    $scope.excluir = function () {
        $scope.cursos.splice($scope.cursos.indexOf($scope.curso), 1);
        $scope.limparCampos();
    }

});