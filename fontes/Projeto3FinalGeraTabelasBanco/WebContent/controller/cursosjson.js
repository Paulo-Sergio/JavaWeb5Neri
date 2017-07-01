var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller('cursosController', function ($scope, $http) {

    $http.get('controller/cursosjson.json').then(function (response) {
        $scope.cursos = response.data.cursos;
    });

})