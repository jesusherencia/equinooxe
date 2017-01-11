System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var BatimentSystemStatusComponent, ComponentOptionsImpl, DataModelHolder;
    return {
        setters:[],
        execute: function() {
            BatimentSystemStatusComponent = (function () {
                function BatimentSystemStatusComponent() {
                    console.log('... BatimentSystemStatusComponent ...');
                    var cmpOptions = new ComponentOptionsImpl();
                    BatimentSystemStatusComponent.mainView = new Vue(cmpOptions);
                }
                return BatimentSystemStatusComponent;
            }());
            exports_1("BatimentSystemStatusComponent", BatimentSystemStatusComponent);
            ComponentOptionsImpl = (function () {
                function ComponentOptionsImpl() {
                    this.el = "#BatimentSystemStatus";
                    this.template = " \n     <div>\n      <caption style=\"color:#F44336;\">Syst\u00E8me</caption>\n      <table class=\"table\">\n        <tr>\n            <th> Derni\u00E8re mise \u00E0 jour </th>\n            <th> Par </th>\n            <th> Archive </th>\n            <th> Suppression </th>\n        </tr>\n        <tr>\n            <td>\n              <fr-datetime :frdate=\"batiment.lastModifiedDate\"></fr-datetime> \n              <since :frdate=\"batiment.lastModifiedDate\"></since>\n            </td>\n            <td>  {{ batiment.createdBy }} </td>\n            <td>  {{ batiment.archived  }} </td>\n            <td>  {{ batiment.deleted   }} </td>\n            </td>\n        <tr>\n      </table>\n     </div>\n     ";
                }
                ComponentOptionsImpl.prototype.data = function () {
                    return new DataModelHolder(this);
                };
                return ComponentOptionsImpl;
            }());
            DataModelHolder = (function () {
                function DataModelHolder(parent) {
                    this.batiment = JSON.parse($("#BatimentEntity").text());
                }
                return DataModelHolder;
            }());
        }
    }
});
//# sourceMappingURL=BatimentSystemStatus.Component.js.map