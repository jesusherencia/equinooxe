System.register(['./menu'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var menu_1;
    var Hello, h;
    return {
        setters:[
            function (menu_1_1) {
                menu_1 = menu_1_1;
            }],
        execute: function() {
            $('body').addClass('bg-green');
            Hello = (function () {
                function Hello() {
                    console.log("TS system app is up _/\_ ");
                    var m = new menu_1.Menu();
                }
                return Hello;
            }());
            exports_1("Hello", Hello);
            h = new Hello();
        }
    }
});
//# sourceMappingURL=index.js.map