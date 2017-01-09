System.register(['./batiment/list.etages.cmp', './batiment/BatimentSystemStatus.Component', './../common-component/dates.component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var list_etages_cmp_1, BatimentSystemStatus_Component_1, dates_component_1;
    var datesComponent, listEtagesComponent, batimentSystemStatus;
    return {
        setters:[
            function (list_etages_cmp_1_1) {
                list_etages_cmp_1 = list_etages_cmp_1_1;
            },
            function (BatimentSystemStatus_Component_1_1) {
                BatimentSystemStatus_Component_1 = BatimentSystemStatus_Component_1_1;
            },
            function (dates_component_1_1) {
                dates_component_1 = dates_component_1_1;
            }],
        execute: function() {
            /**
             * Resister components
             */
            datesComponent = new dates_component_1.DatesComponent();
            listEtagesComponent = new list_etages_cmp_1.ListEtagesComponent();
            batimentSystemStatus = new BatimentSystemStatus_Component_1.BatimentSystemStatusComponent();
        }
    }
});
//# sourceMappingURL=index.js.map