(function() {
    'use strict';

    angular
        .module('equinooxeApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('register', {
            parent: 'account',
            url: '/register',
            data: {
                authorities: [],
                pageTitle: 'Registration'
            },
            views: {
                'content@': {
                    templateUrl: '/resources/app/account/register/register.html',
                    controller: 'RegisterController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();