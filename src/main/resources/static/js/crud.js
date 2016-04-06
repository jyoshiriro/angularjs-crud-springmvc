var app = angular.module("app", [])

app.controller("Filtros", function($scope, $http) {
	
	$scope.filtros = {
		idestado:null,
		qestado:null,
		idcidade:null,
		qcidade:null,
		qbairro:null
	};
	
	$http.get('http://localhost:8080/estados').success(function(data) {
		$scope.estados = data;
	});
	
	$scope.filtrarCidades = function() {
		$http.get('http://localhost:8080/filtrarCidades/'+$scope.filtros.idestado).success(function(data) {
			$scope.cidades = data;
		});
    }
	
	$scope.filtrarBairros = function() {
		$http.get('http://localhost:8080/filtrarBairros/'+$scope.filtros.idcidade).success(function(data) {
			$scope.bairros = data;
		});
	}

});