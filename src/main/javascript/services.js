var services = angular.module('services', ['ngResource']);

services.factory('TaskPaper', ['$resource',
                           function ($resource) {
                               return $resource('service/home', {}, {
                                   query: {method: 'GET', params: {}, isArray: false}
                               });
                           }]);