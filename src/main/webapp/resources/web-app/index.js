System.register(['./menu'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var menu_1;
    var EqApp, eqApp;
    return {
        setters:[
            function (menu_1_1) {
                menu_1 = menu_1_1;
            }],
        execute: function() {
            /**
             * a js equivalent of  public static void main(String[] args)!
             *
             * @export
             * @class EqApp
             */
            EqApp = (function () {
                function EqApp() {
                    var menu = new menu_1.LeftMenu();
                }
                return EqApp;
            }());
            exports_1("EqApp", EqApp);
            /** Run the app! */
            eqApp = new EqApp();
        }
    }
});
//# sourceMappingURL=index.js.map