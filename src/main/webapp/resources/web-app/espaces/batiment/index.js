System.register(['./ListEtages.Component', './BatimentSystemStatus.Component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var ListEtages_Component_1, BatimentSystemStatus_Component_1;
    var listEtagesComponent, batimentSystemStatus;
    return {
        setters:[
            function (ListEtages_Component_1_1) {
                ListEtages_Component_1 = ListEtages_Component_1_1;
            },
            function (BatimentSystemStatus_Component_1_1) {
                BatimentSystemStatus_Component_1 = BatimentSystemStatus_Component_1_1;
            }],
        execute: function() {
            listEtagesComponent = new ListEtages_Component_1.ListEtagesComponent();
            batimentSystemStatus = new BatimentSystemStatus_Component_1.BatimentSystemStatusComponent();
        }
    }
});
//# sourceMappingURL=index.js.map