System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var LeftMenu;
    return {
        setters:[],
        execute: function() {
            LeftMenu = (function () {
                function LeftMenu() {
                    console.log('Menu load *()* ');
                    this.bindSubMenu();
                }
                /**
                 * Bind sub menu so it listen to click events
                 * @memberOf LeftMenu
                 */
                LeftMenu.prototype.bindSubMenu = function () {
                    var _this = this;
                    $(LeftMenu.SUB_MENU_MAIN_SELECTOR).click(function (e) {
                        /** target may be the element or one of its children so scan parents */
                        var elm = $(e.target).is('li') ? $(e.target) : $(e.target).closest('li');
                        if (elm.find("ul.list-unstyled").is(":visible")) {
                            _this.closeSubMenu(elm);
                        }
                        else {
                            _this.openSubMenu(elm);
                        }
                    });
                };
                LeftMenu.prototype.closeSubMenu = function (targetElement) {
                    targetElement.find("ul.list-unstyled").css("display", "none");
                };
                LeftMenu.prototype.openSubMenu = function (targetElement) {
                    targetElement.find("ul.list-unstyled").show();
                };
                LeftMenu.SUB_MENU_MAIN_SELECTOR = ".has_sub";
                return LeftMenu;
            }());
            exports_1("LeftMenu", LeftMenu);
        }
    }
});
//# sourceMappingURL=menu.js.map