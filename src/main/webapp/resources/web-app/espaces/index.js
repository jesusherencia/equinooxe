System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var Index, app;
    return {
        setters:[],
        execute: function() {
            Index = (function () {
                function Index() {
                    console.log('Espaces Index');
                    var cmp = {
                        el: "#e1",
                        template: "\n             <div>\n             <b v-on:click=\"sayHi\">Click {{batiment.nom}} </b><br>\n             <li v-for=\"etage in batiment.etages\" title=\" etage.description  \"> \n    \t\t\t\t\t\t     {{ etage.nom }}\n    \t\t\t\t\t\t     <form  method=\"post\"  name=\"removeFormModel\">\n        \t\t\t\t\t\t      <input type=\"hidden\" name=\"id\" value=\" etage.id  \"/>\n        \t\t\t\t\t\t      <input type=\"hidden\" name=\"redirectTo\" value=\"\"/>\n        \t\t\t\t\t\t     <button >Supprimer</button>\n        \t\t\t\t\t\t     <b v-on:click=\"sayHi\">Click</b>\n        \t\t\t\t\t\t </form>\n    \t\t\t\t\t\t    </li> \n            </div> ",
                        methods: {
                            sayHi: function () {
                                alert('hi' + this.data + " <-");
                                console.log(this.data);
                            }
                        },
                        data: function () {
                            var _data = this;
                            return {
                                batiment: axios({
                                    method: 'get',
                                    url: '/api/batiment/1'
                                }).then(function (res) {
                                    _data.batiment = res.data;
                                })
                            };
                        }
                    };
                    var v1 = new Vue(cmp);
                    axios({
                        method: 'get',
                        url: '/api/batiment/1'
                    }).then(function (res) {
                        console.log('Some res!', res);
                        // v1.$set(v1,"batiment", {nom:"ABCD EFG"});
                        //v1.batiment = res.data;
                        // v1.$data.batiment = res;
                    });
                }
                return Index;
            }());
            exports_1("Index", Index);
            app = new Index();
        }
    }
});
//# sourceMappingURL=index.js.map