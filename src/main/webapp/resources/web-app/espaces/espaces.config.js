System.config({
    baseURL: '/resources/web-app/espaces/',
    defaultJSExtensions: true,
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
System.import('index.js');
console.log('espaces.config louded!');
