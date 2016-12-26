System.register(['./menu'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var menu_1;
    var EqApp, h;
    return {
        setters:[
            function (menu_1_1) {
                menu_1 = menu_1_1;
            }],
        execute: function() {
            $('body').addClass('bg-green');
            EqApp = (function () {
                function EqApp() {
                    console.log("TS system fro web-app is up _/\\_ ");
                    var m = new menu_1.LeftMenu();
                }
                return EqApp;
            }());
            exports_1("EqApp", EqApp);
            h = new EqApp();
        }
    }
});
//# sourceMappingURL=index.js.map