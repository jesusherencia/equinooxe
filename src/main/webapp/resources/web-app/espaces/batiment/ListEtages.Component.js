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
                    console.log('ListEtagesComponent');
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
                    this.template = "<table class=\"table smaller\">\n                            <caption class=\"smaller\">Etages du:{{batiment.nom }}</caption>\n                            <tr>\n                              <th># </th>\n                              <th>Nom </th>\n                              <th>Ajout </th>\n                            </th>\n                            <tr v-for=\"(etage,index) in batiment.etages\" class=\"as-tr\" title=\"etage.description\">\n                                    <td>  {{ etage.id}}       </td>\n                                    <td>  {{ etage.nom }}   </td>\n                                    <td>  <fr-datetime :frdate=\"etage.createdDate\" ></fr-datetime> </td>\n                                    <td>\n                                    <div class=\"dropdown pull-right\">\n                                        <a href=\"#\" class=\"dropdown-toggle card-drop\" title=\"Options\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n                                            <i class=\"zmdi zmdi-more-vert\"></i>\n                                        </a>\n                                        <ul class=\"dropdown-menu\" role=\"menu\">\n                                            <li>\n                                                <form  method=\"post\" name=\"removeFormModel\">\n                                                    <input type=\"hidden\" name=\"id\" value=\"etage.id\"/>\n                                                    <input type=\"hidden\" name=\"redirectTo\" value=\"\"/>\n                                                    <button v-on:click=\"deleteEtage($event,etage.id)\" class=\"as-link\">Supprimer</button>\n                                                </form>\n                                            </li>\n                                        </ul>\n                                    </div>\n                                  </td>\n                            </tr>\n                      </table> \n                      ";
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
                    this.batiment = JSON.parse($("#BatimentEntity").text());
                    // console.log('data ctor', "parent: ", parent);
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
//# sourceMappingURL=ListEtages.Component.js.map