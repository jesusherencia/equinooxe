System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var DatesComponent;
    return {
        setters:[],
        execute: function() {
            /**
             * All dates transformations
             *
             * @export
             * @class CommonDateComponent
             */
            DatesComponent = (function () {
                function DatesComponent() {
                    // To register a global component, you can use Vue.component(tagName, options). For example:
                    Vue.component('fr-datetime', {
                        template: '<span>D: {{frDatetime}}</span>',
                        props: ['frdate'],
                        computed: {
                            frDatetime: function () {
                                console.log("..Compute date ..", this.frdate);
                                return moment(this.frdate).format('ddd MM  YYYY, HH[h]');
                            }
                        }
                    });
                }
                return DatesComponent;
            }());
            exports_1("DatesComponent", DatesComponent);
        }
    }
});
//# sourceMappingURL=dates.component.js.map