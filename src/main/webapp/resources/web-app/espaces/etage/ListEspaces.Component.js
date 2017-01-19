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
                    this.template = "\n    <table class=\"table smaller\">\n                            <caption class=\"smaller\">Espaces du:{{etage.nom }}</caption>\n                            <tr>\n                              <th># </th>\n                              <th>Nom </th>\n                              <th>Ajout </th>\n                            </th>\n                            <tr v-for=\"(espace,index) in etage.espaces\" class=\"as-tr\" title=\"epspace.description\">\n                                    <td>  {{ espace.id}}       </td>\n                                    <td>  {{ espace.nom }}   </td>\n                                    <td>  <fr-datetime :frdate=\"espace.createdDate\" ></fr-datetime> </td>\n                                    <td>\n                                    <div class=\"dropdown pull-right\">\n                                        <a href=\"#\" class=\"dropdown-toggle card-drop\" title=\"Options\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n                                            <i class=\"zmdi zmdi-more-vert\"></i>\n                                        </a>\n                                        <ul class=\"dropdown-menu\" role=\"menu\">\n                                            <li>\n                                                <form  method=\"post\" name=\"removeFormModel\">\n                                                    <input type=\"hidden\" name=\"id\" value=\"espace.id\"/>\n                                                    <input type=\"hidden\" name=\"redirectTo\" value=\"\"/>\n                                                    <button v-on:click=\"deleteEspace($event,espace.id)\" class=\"as-link\">Supprimer</button>\n                                                </form>\n                                            </li>\n                                        </ul>\n                                    </div>\n                                  </td>\n                            </tr>\n     </table> \n    \n    ";
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