/**
 * 
 */
'use strict';

App.factory('RotaService', [ '$http', '$q', function($http, $q) {

	return {
		listaRotas : function(mapa) {
			return $http.post('http://localhost:8080/rest/calcular/rotas', mapa).then(function(response) {
				return response.data;
			}, function(errResponse) {
				return $q.reject(errResponse);
			});
		}
	};

}]);