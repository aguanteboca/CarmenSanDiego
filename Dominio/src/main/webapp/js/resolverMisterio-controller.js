angular.module("CarmenSandiego")

.controller("ResolverMisterioController", function($scope, $http) {
    var url = "http://localhost:9000";
    $scope.title = "Resolver Misterio";
    $scope.viewData = {};

    //Post iniciar juego
    $http.post(url + "/iniciarJuego")
    .then(function(response, status) {
        $scope.caso = response.data;
        $scope.idCaso = response.data.id;
    })
    .catch(function(error) {
        handleError(error.data);
    })

    //Get villanos
    $http.get(url + "/villanos")
    .then(function(response, status) {
        $scope.villanos = response.data;
        $scope.villanoSeleccionado = response.data[0].id;
    })
    .catch(function(error) {
        handleError(error.data);
    })

    //Post viajar
    $scope.viajar = function() {
        $http({
            method: 'POST',
            url: url + "/viajar",
            data: {"destinoId": $scope.viewData.paisSeleccionado.id, "casoId": $scope.idCaso},
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(response, status) {
            $scope.caso = response.data; //Explota en el try de viajar, revisar por que no viaja y me devuelve un nuevo caso.
            $scope.idCaso = response.data.id;
        })
        .catch(function(error) {
            handleError(error.data);
        })
    }

    //Get pista
    $scope.getPista = function(lugar) {
        $scope.lugarSeleccionado = lugar;
        $http.get(url + "/pistaDelLugar/"+$scope.idCaso+"/"+lugar)
        .then(function(response, status) {
            $scope.pistas = (response.data.pista).split(','); //Obtiene las pistas si el lugar no tiene espacios, sino explota. Averiguar sobre "%20"
            if(response.data.resultadoOrden != null){
                $scope.finalJuego = response.data.resultadoOrden
                $('#modalFinalCaso').modal('show');
            }
            else {$('#modalLugar').modal('show');}
        })
        .catch(function(error) {
            handleError(error.data);
        })
    }

    //Post emitir orden de arresto
    $scope.emitirOrdenArresto = function() {
        $http({
            method: 'POST',
            url: url + "/emitirOrden",
            data: {"villanoId": $scope.villanoSeleccionado, "casoId": $scope.idCaso},
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(response, status) {
            $scope.ordenEmitida = response.data; 
            alert(response.data);
        })
        .catch(function(error) {
            handleError(error.data);
        })
    }
});