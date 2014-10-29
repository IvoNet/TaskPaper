var app = angular.module('app', [
    'ngRoute',
    'controllers',
    'services'
]);

app.config(['$routeProvider',
            function ($routeProvider) {
                $routeProvider.when('/', {
                    templateUrl: 'partials/home.html',
                    controller: 'HomeController'
                }).otherwise({
                                 redirectTo: '/'
                             });
            }]);