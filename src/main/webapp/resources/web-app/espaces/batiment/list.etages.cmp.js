System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var ListEtagesComponent, ComponentOptionsImpl, DataModelHolder, EtageDeleteService;
    return {
        setters:[],
        execute: function() {
            /**
             * Main
             *
             * @export
             * @class Index
             */
            ListEtagesComponent = (function () {
                function ListEtagesComponent() {
                    console.log('Espaces Index');
                    var cmpOptions = new ComponentOptionsImpl();
                    ListEtagesComponent.mainView = new Vue(cmpOptions);
                }
                return ListEtagesComponent;
            }());
            exports_1("ListEtagesComponent", ListEtagesComponent);
            ComponentOptionsImpl = (function () {
                function ComponentOptionsImpl() {
                    this.methods = {
                        deleteEtage: EtageDeleteService,
                    };
                    this.el = "#ListEtagesComponent";
                    this.template = "<ul class=\"no-style\">\n                            <li v-for=\"etage in batiment.etages\" title=\"etage.description\">\n                                {{ etage.nom }} \n                                <div class=\"dropdown pull-right\">\n                                    <a href=\"#\" class=\"dropdown-toggle card-drop\" title=\"Options\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n                                        <i class=\"zmdi zmdi-more-vert\"></i>\n                                    </a>\n                                    <ul class=\"dropdown-menu\" role=\"menu\">\n                                        <li>\n                                            <form  method=\"post\" name=\"removeFormModel\">\n                                                <input type=\"hidden\" name=\"id\" value=\"etage.id\"/>\n                                                <input type=\"hidden\" name=\"redirectTo\" value=\"\"/>\n                                                <button v-on:click=\"deleteEtage($event,etage.id)\" class=\"as-link\">Supprimer</button>\n                                            </form>\n                                        </li>\n                                    </ul>\n                                </div>\n                            </li>\n                      </ul> \n                      ";
                }
                ComponentOptionsImpl.prototype.data = function () {
                    return new DataModelHolder(this);
                };
                return ComponentOptionsImpl;
            }());
            /**
             *
             *
             * @export
             * @class DataModelHolder
             */
            DataModelHolder = (function () {
                function DataModelHolder(parent) {
                    this.batiment = JSON.parse($("#ListEtages").text());
                    console.log('data ctor', "parent: ", parent);
                }
                return DataModelHolder;
            }());
            /**
             * Bound to a view method
             *
             * @class EtageDeleteService
             */
            EtageDeleteService = (function () {
                function EtageDeleteService(evt, etageId) {
                    var data = ListEtagesComponent.mainView['batiment'];
                    evt.preventDefault();
                    data.etages.forEach(function (etage) {
                        if (etage.id == etageId) {
                            console.log("Start deleting", etage.id);
                            axios.delete("/api/etage/delete/" + etage.id).then(function (res) {
                                alert(res.data);
                                data.etages = data.etages.filter(function (e) {
                                    return e.id !== etageId;
                                });
                            });
                        }
                    });
                }
                return EtageDeleteService;
            }());
        }
    }
});
//# sourceMappingURL=list.etages.cmp.js.map