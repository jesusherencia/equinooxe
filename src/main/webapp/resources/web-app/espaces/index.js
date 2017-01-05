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
                    console.log($("#goptions").data("goptions"));
                    Vue.component('my-component', {
                        template: '<div>A custom component!</div>'
                    });
                    var cmp = {
                        el: "#e1",
                        // template: `
                        //  <div>
                        //  <b v-on:click="sayHi">Click {{batiment.nom}} </b><br>
                        //  <li v-for="etage in batiment.etages" title=" etage.description  "> 
                        // 				     {{ etage.nom }} <my-component></my-component>
                        // 				     <form  method="post"  name="removeFormModel">
                        // 					      <input type="hidden" name="id" value=" etage.id  "/>
                        // 					      <input type="hidden" name="redirectTo" value=""/>
                        // 					     <button >Supprimer</button>
                        // 					     <b v-on:click="sayHi">Click</b>
                        // 					 </form>
                        // 				    </li> 
                        // </div> `,
                        methods: {
                            sayHi: function () {
                                alert('hi' + this.batiment.nom + " <-");
                                console.log(this.batiment.id);
                            }
                        },
                        data: function () {
                            var _data = this;
                            return {
                                // batiment: $("#goptions").data("goptions"),
                                batiment: JSON.parse($("#Model").text())
                            };
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