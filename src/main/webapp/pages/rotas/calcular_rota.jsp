<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logística</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="rotaApp" class="ng-cloak">

	<div class="generic-container" ng-controller="RotaController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Logística - Cálculo de Rotas</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="mapa">Mapa</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.mapa.mapa" id="mapa" class="form-control input-sm text-uppercase" placeholder="Mapa, exemplo: SP" required ng-minlength="2" ng-maxlength="2">
								<div class="has-error" ng-model="myForm.$dirty">
									<span ng-show="myForm.mapa.$error.required">Campo obrigatório</span> 
									<span ng-show="myForm.mapa.$error.minlength">Tamanho mínimo 2</span>
									<span ng-show="myForm.mapa.$error.maxlength">Tamanho mínimo 2</span>  
									<span ng-show="myForm.mapa.$invalid">Campo inválido</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="origem">Origem</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.mapa.origem" id="origem" class="form-control input-sm text-uppercase" placeholder="Nome da Origem" required ng-minlength="1">
								<div class="has-error" ng-model="myForm.$dirty">
									<span ng-show="myForm.origem.$error.required">Campo obrigatório</span> 
									<span ng-show="myForm.origem.$error.minlength">Tamanho mínimo 3</span> 
									<span ng-show="myForm.origem.$invalid">Campo inválido</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="destino">Destino</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.mapa.destino" id="destino" class="form-control input-sm text-uppercase" placeholder="Nome do Destino" required ng-minlength="1">
								<div class="has-error" ng-model="myForm.$dirty">
									<span ng-show="myForm.destino.$error.required">Campo obrigatório</span> 
									<span ng-show="myForm.destino.$error.minlength">Tamanho mínimo 3</span> 
									<span ng-show="myForm.destino.$invalid">Campo inválido</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="autonomia">Autonomia</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.mapa.autonomia" id="autonomia" class="form-control input-sm" placeholder="Coloque a autonomia separando os números com pontos: 12.3" required ng-minlength="1" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01">
								<div class="has-error" ng-model="myForm.$dirty">
									<span ng-show="myForm.autonomia.$error.required">Campo obrigatório</span> 
									<span ng-show="myForm.autonomia.$error.minlength">Tamanho mínimo 3</span> 
									<span ng-show="myForm.autonomia.$invalid">Campo inválido</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="valorCombustivel">Valor Combustível</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.mapa.valorCombustivel" id="valorCombustivel" class="form-control input-sm" placeholder="Coloque o valor do combustível separando os números com pontos: 12.3" required ng-minlength="1" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01">
								<div class="has-error" ng-model="myForm.$dirty">
									<span ng-show="myForm.valorCombustivel.$error.required">Campo obrigatório</span> 
									<span ng-show="myForm.valorCombustivel.$error.minlength">Tamanho mínimo 3</span> 
									<span ng-show="myForm.valorCombustivel.$invalid">Campo inválido</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Calcular Rota" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpar Formulário</button>
							<a class="btn btn-primary btn-sm" href="<c:url value='/pages/initial/index.jsp' />">Cadastro</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Lista</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Mapa</th>
							<th>Origem</th>
							<th>Destino</th>
							<th>Autonomia</th>
							<th>Distância Total</th>
							<th>Valor Combustível</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="map in ctrl.mapas">
							<td><span class="text-uppercase" ng-bind="map.mapa"></span></td>
							<td><span class="text-uppercase" ng-bind="map.origem"></span></td>
							<td><span class="text-uppercase" ng-bind="map.destino"></span></td>
							<td><span ng-bind="map.autonomia"></span></td>
							<td><span ng-bind="map.distanciaTotal"></span></td>
							<td><span ng-bind="map.gastoTotal"></span></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="<c:url value='/js/angular.js' />"></script>
	<script type="text/javascript" src="<c:url value='/js/ui-bootstrap-tpls-1.2.4.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/js/rotaApp.js' />"></script>
	<script type="text/javascript" src="<c:url value='/js/rota_service.js' />"></script>
	<script type="text/javascript" src="<c:url value='/js/rota_controller.js' />"></script>
</body>
</html>