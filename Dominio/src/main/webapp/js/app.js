angular.module("CarmenSandiego", ["ngRoute"])

.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        redirectTo: "/resolverMisterio"
    })
    .when("/resolverMisterio", {
        templateUrl: "pages/resolverMisterio.html",
        controller: "ResolverMisterioController"
    })
    .when("/mapamundi", {
        templateUrl: "pages/mapamundi.html",
        controller: "MapamundiController"
    })
    .when("/expedientes", {
        templateUrl: "pages/expedientes.html",
        controller: "ExpedientesController"
    })
    .otherwise({
		redirectTo: '/'
	})
});

var handleError = function(error) {
    if(error == null) {
        alert("Se produjo un error");
    }
    else { alert(error) };
}