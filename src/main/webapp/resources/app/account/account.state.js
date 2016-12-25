(function() {
    'use strict';

    angular
        .module('equinooxeApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('account', {
            abstract: true,
            parent: 'app'
        });
    }
})();
