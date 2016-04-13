/**
 * 
 */
'user strict';

App.controller('MapaController', [
		'$scope',
		'MapaService',
		function($scope, MapaService) {
			var self = this;
			self.mapa = {
				id : null,
				mapa : '',
				origem : '',
				destino : '',
				distancia : ''
			};
			self.mapas = [];

			self.listaMapas = function() {
				MapaService.listaMapas().then(function(d) {
					self.mapas = d;
				}, function(errResponse) {
					console.error('Erro ao listar as rotas');
				});
			};

			self.salvarMapa = function(mapa) {
				MapaService.salvarMapa(mapa).then(self.listaMapas,
						function(errResponse) {
							console.error('Erro ao salvar a rota');
						});
			};

			self.atualizarMapa = function(mapa, id) {
				MapaService.atualizarMapa(mapa, id).then(self.listaMapas,
						function(errResponse) {
							console.error('Erro ao atualizar a rota');
						});
			};

			self.excluirMapa = function(id) {
				MapaService.excluirMapa(id).then(self.listaMapas,
						function(errResponse) {
							console.error('Erro ao excluir a rota');
						});
			};

			self.listaMapas();

			self.submit = function() {

				if (self.mapa.id === null) {
					self.salvarMapa(self.mapa);
					self.reset();
				} else {
					self.atualizarMapa(self.mapa, self.mapa.id);
					self.reset();
				}
				self.reset;
			};

			self.edit = function(id) {
				for (var i = 0; i < self.mapas.length; i++) {
					if (self.mapas[i].id === id) {
						self.mapa = angular.copy(self.mapas[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				if (self.mapa.id === id) {
					self.reset();
				}
				self.excluirMapa(id);
			};

			self.reset = function() {
				self.mapa = {
					id : null,
					mapa : '',
					origem : '',
					destino : '',
					distancia : ''
				};
				$scope.myForm.$setPristine();
			};

		} ])