System.register(['./../BaseSystemStatus.Component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __extends = (this && this.__extends) || function (d, b) {
        for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
    var BaseSystemStatus_Component_1;
    var EtageSystemStatusComponent;
    return {
        setters:[
            function (BaseSystemStatus_Component_1_1) {
                BaseSystemStatus_Component_1 = BaseSystemStatus_Component_1_1;
            }],
        execute: function() {
            EtageSystemStatusComponent = (function (_super) {
                __extends(EtageSystemStatusComponent, _super);
                function EtageSystemStatusComponent() {
                    _super.call(this, "#EtageSystemStatus", "#EtageEntity");
                    console.log('...>> EtageSystemStatusComponent <<...');
                }
                return EtageSystemStatusComponent;
            }(BaseSystemStatus_Component_1.BaseSystemStatusComponent));
            exports_1("EtageSystemStatusComponent", EtageSystemStatusComponent);
        }
    }
});
//# sourceMappingURL=EtageSystemStatus.Component.js.map