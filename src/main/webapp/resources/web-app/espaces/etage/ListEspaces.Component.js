//   /espaces/etage/{etageId}/espace/new
System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var ListEspacesComponent, ComponentOptionsImp, DataModelHolder;
    return {
        setters:[],
        execute: function() {
            ListEspacesComponent = (function () {
                function ListEspacesComponent() {
                    console.log("...ListEspacesComponent...");
                    var componentOptions = new ComponentOptionsImp();
                    ListEspacesComponent.mainView = new Vue(componentOptions);
                }
                return ListEspacesComponent;
            }());
            exports_1("ListEspacesComponent", ListEspacesComponent);
            ComponentOptionsImp = (function () {
                function ComponentOptionsImp() {
                    this.methods = {
                        deleteEspace: function () { },
                    };
                    this.el = "#ListEspacesComponent";
                    this.template = "<h1> ListEspacesComponent </h1> ";
                }
                ComponentOptionsImp.prototype.data = function () {
                    return new DataModelHolder(this);
                };
                return ComponentOptionsImp;
            }());
            DataModelHolder = (function () {
                function DataModelHolder(parent) {
                    this.etage = JSON.parse($("#EtageEntity").text());
                    // console.log('data ctor', "parent: ", parent);
                }
                return DataModelHolder;
            }());
        }
    }
});
//# sourceMappingURL=ListEspaces.Component.js.map