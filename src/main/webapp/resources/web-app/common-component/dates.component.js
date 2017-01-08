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
                    Vue.component('fr-datetime', {
                        template: '<span> {{frDatetime}}</span>',
                        props: ['frdate'],
                        computed: {
                            frDatetime: function () {
                                console.log("..Compute date ..", this.frdate);
                                return _.capitalize(moment(this.frdate).format('DD-MM-YYYY [à] HH[h]'));
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