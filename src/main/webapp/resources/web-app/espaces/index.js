System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var ViewModelImpl, Index, DataModelHolder, BatimentEntity, EtageDeleteTask, app;
    return {
        setters:[],
        execute: function() {
            ViewModelImpl = (function () {
                function ViewModelImpl() {
                    this.methods = {
                        deleteEtage: EtageDeleteTask,
                    };
                    this.el = "#e1";
                    this.template = "<ul class=\"no-style\">\n                        <li v-for=\"etage in batiment.etages\" title=\"etage.description\">\n                            {{ etage.nom }} \n                            <form  method=\"post\" name=\"removeFormModel\">\n                                <input type=\"hidden\" name=\"id\" value=\"etage.id\"/>\n                                <input type=\"hidden\" name=\"redirectTo\" value=\"\"/>\n                                <button v-on:click=\"deleteEtage($event,etage.id)\" class=\"btn-gray\">Supprimer</button>\n                            </form>\n                        </li>\n                        </ul> \n                      ";
                }
                ViewModelImpl.prototype.data = function () {
                    return new DataModelHolder(this);
                };
                return ViewModelImpl;
            }());
            /**
             * Main
             *
             * @export
             * @class Index
             */
            Index = (function () {
                function Index() {
                    console.log('Espaces Index');
                    var cmp = new ViewModelImpl();
                    Index.mainView = new Vue(cmp);
                }
                return Index;
            }());
            exports_1("Index", Index);
            /**
             *
             *
             * @export
             * @class DataModelHolder
             */
            DataModelHolder = (function () {
                function DataModelHolder(parent) {
                    this.batiment = JSON.parse($("#Model").text());
                    console.log('data ctor', "parent: ", parent);
                }
                return DataModelHolder;
            }());
            exports_1("DataModelHolder", DataModelHolder);
            BatimentEntity = (function () {
                function BatimentEntity() {
                    this.etages = [];
                }
                return BatimentEntity;
            }());
            exports_1("BatimentEntity", BatimentEntity);
            EtageDeleteTask = (function () {
                function EtageDeleteTask(evt, etageId) {
                    var data = Index.mainView['batiment'];
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
                return EtageDeleteTask;
            }());
            exports_1("EtageDeleteTask", EtageDeleteTask);
            app = new Index();
        }
    }
});
//# sourceMappingURL=index.js.map