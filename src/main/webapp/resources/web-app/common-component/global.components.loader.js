System.register(['./dates.component', './ListNotification.Component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var dates_component_1, ListNotification_Component_1;
    var datesComponent, notificationsComponent;
    return {
        setters:[
            function (dates_component_1_1) {
                dates_component_1 = dates_component_1_1;
            },
            function (ListNotification_Component_1_1) {
                ListNotification_Component_1 = ListNotification_Component_1_1;
            }],
        execute: function() {
            datesComponent = new dates_component_1.DatesComponent();
            notificationsComponent = new ListNotification_Component_1.ListNotificationComponent();
        }
    }
});
//# sourceMappingURL=global.components.loader.js.map