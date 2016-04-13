/**
 * 
 */
'use strict';

App.factory('MapaService', [ '$http', '$q', function($http, $q) {

	return {
		listaMapas : function() {
			return $http.get('http://localhost:8080/rest/cadastrar/mapas').then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		},
		salvarMapa : function(mapa) {
			return $http.post('http://localhost:8080/rest/cadastrar/mapa', mapa).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		},
		atualizarMapa : function(mapa, id) {
			return $http.put('http://localhost:8080/rest/cadastrar/mapa/'+mapa.id, mapa).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		},
		excluirMapa : function(id) {
			return $http.delete('http://localhost:8080/rest/cadastrar/mapa/'+id).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		}
	};

}]);