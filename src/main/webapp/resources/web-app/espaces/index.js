System.register(['./batiment/ListEtages.Component', './batiment/BatimentSystemStatus.Component', './../common-component/dates.component', './../menu'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var ListEtages_Component_1, BatimentSystemStatus_Component_1, dates_component_1, menu_1;
    var datesComponent, listEtagesComponent, batimentSystemStatus, leftMenu;
    return {
        setters:[
            function (ListEtages_Component_1_1) {
                ListEtages_Component_1 = ListEtages_Component_1_1;
            },
            function (BatimentSystemStatus_Component_1_1) {
                BatimentSystemStatus_Component_1 = BatimentSystemStatus_Component_1_1;
            },
            function (dates_component_1_1) {
                dates_component_1 = dates_component_1_1;
            },
            function (menu_1_1) {
                menu_1 = menu_1_1;
            }],
        execute: function() {
            /**
             * Resister components
             */
            datesComponent = new dates_component_1.DatesComponent();
            listEtagesComponent = new ListEtages_Component_1.ListEtagesComponent();
            batimentSystemStatus = new BatimentSystemStatus_Component_1.BatimentSystemStatusComponent();
            leftMenu = new menu_1.LeftMenu();
        }
    }
});
//# sourceMappingURL=index.js.map