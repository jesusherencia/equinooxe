System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var Index, app;
    return {
        setters:[],
        execute: function() {
            Index = (function () {
                function Index() {
                    console.log('Index');
                    var cmp = {
                        el: "#e1",
                        methods: {
                            sayHi: function () {
                                alert('hi');
                                console.log(this.data);
                            }
                        }
                    };
                    var v1 = new Vue(cmp);
                }
                return Index;
            }());
            exports_1("Index", Index);
            app = new Index();
        }
    }
});
//# sourceMappingURL=index.js.map