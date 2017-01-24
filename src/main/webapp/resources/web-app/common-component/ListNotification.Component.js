System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var ListNotificationComponent, ComponentOptionsImpl, DataModelHolder, NotificationDeleteService;
    return {
        setters:[],
        execute: function() {
            /**
             * Main
             *
             * @export
             * @class Index
             */
            ListNotificationComponent = (function () {
                function ListNotificationComponent() {
                    console.log('..ListNotificationComponent..');
                    var cmpOptions = new ComponentOptionsImpl();
                    ListNotificationComponent.mainView = new Vue(cmpOptions);
                }
                return ListNotificationComponent;
            }());
            exports_1("ListNotificationComponent", ListNotificationComponent);
            ComponentOptionsImpl = (function () {
                function ComponentOptionsImpl() {
                    this.methods = {
                        deleteNotification: NotificationDeleteService,
                    };
                    this.el = "#ListNotificationComponent";
                    this.template = "\n    <ul class=\"list-group list-no-border user-list\">\n          <li v-for=\"(notif,index) in notifications\" class=\"list-group-item\">\n                <a href=\"#\" class=\"user-list-item\">\n                    <div class=\"icon bg-info\">\n                        <i class=\"zmdi zmdi-account\"></i>\n                    </div>\n                    <div class=\"user-desc\">\n                        <span class=\"name\">{{notif.title}}</span>\n                        <span class=\"desc\">{{notif.message}}</span>\n                        <span class=\"time\"> \n                            <since :frdate=\"notif.addAt\"></since>\n                        </span>\n                    </div>\n                </a>\n            </li>\n    </ul>\n     ";
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
                    var _this = this;
                    this.notifications = [];
                    axios.get("/api/notification/all").then(function (res) {
                        _this.notifications = res.data;
                        console.log(res.data);
                    });
                }
                return DataModelHolder;
            }());
            /**
             * Bound to a view method
             *
             * @class EtageDeleteService
             */
            NotificationDeleteService = (function () {
                function NotificationDeleteService(evt, notifId) {
                    var data = ListNotificationComponent.mainView['notifications'];
                    evt.preventDefault();
                }
                return NotificationDeleteService;
            }());
        }
    }
});
//# sourceMappingURL=ListNotification.Component.js.map