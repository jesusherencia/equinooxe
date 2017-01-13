System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var BaseSystemStatusComponent, ComponentOptionsImpl, DataModelHolder;
    return {
        setters:[],
        execute: function() {
            BaseSystemStatusComponent = (function () {
                function BaseSystemStatusComponent(elementSelector, dataSelector) {
                    console.log('... BaseSystemStatusComponent ...');
                    BaseSystemStatusComponent.elementSelector = elementSelector;
                    BaseSystemStatusComponent.dataSelector = dataSelector;
                    var cmpOptions = new ComponentOptionsImpl();
                    BaseSystemStatusComponent.mainView = new Vue(cmpOptions);
                }
                return BaseSystemStatusComponent;
            }());
            exports_1("BaseSystemStatusComponent", BaseSystemStatusComponent);
            ComponentOptionsImpl = (function () {
                function ComponentOptionsImpl() {
                    this.el = BaseSystemStatusComponent.elementSelector;
                    this.template = " \n     <div>\n      <caption style=\"color:#F44336;\">Syst\u00E8me</caption>\n      <table class=\"table\">\n        <tr>\n            <th> Derni\u00E8re mise \u00E0 jour </th>\n            <th> Par </th>\n            <th> Archive </th>\n            <th> Suppression </th>\n        </tr>\n        <tr>\n            <td>\n              <fr-datetime :frdate=\"entityData.lastModifiedDate\"></fr-datetime> \n              <since :frdate=\"entityData.lastModifiedDate\"></since>\n            </td>\n            <td>  {{ entityData.createdBy|capitalize }} </td>\n            <td v-bind:class=\"{ archived: entityData.archived }\">  {{ entityData.archived? 'Oui': 'Non' }} </td>\n            <td v-bind:class=\"{ deleted : entityData.deleted }\">   {{ entityData.deleted?  'Oui': 'Non' }} </td>\n            </td>\n        <tr>\n      </table>\n     </div>\n     ";
                }
                ComponentOptionsImpl.prototype.data = function () {
                    return new DataModelHolder(this);
                };
                return ComponentOptionsImpl;
            }());
            DataModelHolder = (function () {
                function DataModelHolder(parent) {
                    this.entityData = JSON.parse($(BaseSystemStatusComponent.dataSelector).text());
                }
                return DataModelHolder;
            }());
        }
    }
});
//# sourceMappingURL=BaseSystemStatus.Component.js.map