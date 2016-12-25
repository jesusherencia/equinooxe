(function() {
    'use strict';

    angular
        .module('equinooxeApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('sessions', {
            parent: 'account',
            url: '/sessions',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Sessions'
            },
            views: {
                'content@': {
                    templateUrl: '/resources/app/account/sessions/sessions.html',
                    controller: 'SessionsController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
