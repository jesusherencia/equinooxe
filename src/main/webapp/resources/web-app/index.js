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
                    this.v = "v";
                    console.log("TS system fro web-app is up _/\\_ ");
                    var m = new menu_1.Menu();
                    $(".has_sub").click(function () {
                        if ($(this).find("ul.list-unstyled").is(":visible")) {
                            $(this).find("ul.list-unstyled").css("display", "none");
                            $(this).find(".ti-angle-down").hide();
                            $(this).find(".ti-angle-right").show();
                            console.log('Element visible so hide *-* ');
                        }
                        else {
                            $(this).find("ul.list-unstyled").show();
                            $(this).find(".ti-angle-down").show();
                            $(this).find(".ti-angle-right").hide();
                            // $(this).find(".list-unstyled").css("display", "block");
                            // $(this).find("ul").css("display", "block");
                            console.log('Element is hide so show grr');
                        }
                    });
                }
                return Hello;
            }());
            exports_1("Hello", Hello);
            h = new Hello();
        }
    }
});
//# sourceMappingURL=index.js.map