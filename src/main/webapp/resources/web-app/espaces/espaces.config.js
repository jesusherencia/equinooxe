System.config({
    baseURL: '/resources/web-app/espaces/',
    defaultJSExtensions: true,
    // map: {
    //     'moment': '/resources/node_modules/moment/moment.js',
    // },
    packages: {
        '.': {
            defaultExtension: 'js'
        }
    },
    meta: {
        '*': {
            format: 'register'
        }
    },
});

