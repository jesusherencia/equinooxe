System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var LeftMenu;
    return {
        setters:[],
        execute: function() {
            /**
             * Contorle left menu
             *
             * @export
             * @class LeftMenu
             */
            LeftMenu = (function () {
                function LeftMenu() {
                    this.bindSubMenu();
                    this.initSubMenu();
                }
                /**
                 * Open sub menu on init if the selector is present in the parent element of menu
                 * if only on mode widescreen
                 * @memberOf LeftMenu
                 */
                LeftMenu.prototype.initSubMenu = function () {
                    if ($("body").hasClass("widescreen")) {
                        this.openSubMenuBySelector($(LeftMenu.OPEN_SUB_SELECTOR));
                    }
                };
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
                            _this.openSubMenuBySelector(elm);
                        }
                    });
                };
                LeftMenu.prototype.closeSubMenu = function (targetElement) {
                    targetElement.find("ul.list-unstyled").css("display", "none");
                };
                LeftMenu.prototype.openSubMenuBySelector = function (targetElement) {
                    targetElement.find("ul.list-unstyled").show();
                };
                LeftMenu.SUB_MENU_MAIN_SELECTOR = ".has_sub";
                LeftMenu.OPEN_SUB_SELECTOR = ".open_sub_menu";
                return LeftMenu;
            }());
            exports_1("LeftMenu", LeftMenu);
        }
    }
});
//# sourceMappingURL=menu.js.map