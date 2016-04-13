/**
 * 
 */
'user strict';

App.controller('RotaController', [ '$scope', 'RotaService',
		function($scope, RotaService) {
			var self = this;
			self.mapa = {
				id : null,
				mapa : '',
				origem : '',
				destino : '',
				distancia : '',
				autonomia : '',
				valorCombustivel : '',
				distanciaTotal : '',
				gastoTotal : ''
			};
			self.mapas = [];
			self.alerts = [];

			self.listaRotas = function(mapa) {
				RotaService.listaRotas(mapa).then(function(d) {
					self.mapas = d;
					
				}, function(errResponse) {
					console.error('Erro ao listar as rotas');
				});
			};

			self.submit = function() {
				self.listaRotas(self.mapa);
				self.reset();
			};

			self.reset = function() {
				self.mapa = {
					id : null,
					mapa : '',
					origem : '',
					destino : '',
					distancia : '',
					autonomia : '',
					valorCombustivel : '',
					distanciaTotal : '',
					gastoTotal : ''
				};
				$scope.myForm.$setPristine();
			};
			
			self.mensagem = function(msg, type){
				self.alerts.push({msg : msg, type : type});
			}
			
			self.limparMensagem = function(index){
				self.alerts.splice(index, 1);
			}

		} ]);