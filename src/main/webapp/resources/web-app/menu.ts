
/**
 * Contorle left menu
 * 
 * @export
 * @class LeftMenu
 */
export class LeftMenu {
    static SUB_MENU_MAIN_SELECTOR = ".has_sub";
    static OPEN_SUB_SELECTOR = ".open_sub_menu";
    constructor() {
        this.bindSubMenu();
        this.initSubMenu();
        
    }

    /**
     * Open sub menu on init if the selector is present in the parent element of menu
     * if only on mode widescreen
     * @memberOf LeftMenu
     */
    public initSubMenu(): void {
        if ($("body").hasClass("widescreen")) {
            this.openSubMenuBySelector($(LeftMenu.OPEN_SUB_SELECTOR));
        }

    }

    /**
     * Bind sub menu so it listen to click events
     * @memberOf LeftMenu
     */
    public bindSubMenu(): void {
        $(LeftMenu.SUB_MENU_MAIN_SELECTOR).click(e => {
            /** target may be the element or one of its children so scan parents */
            let elm = $(e.target).is('li') ? $(e.target) : $(e.target).closest('li');
            if (elm.find("ul.list-unstyled").is(":visible")) {
                this.closeSubMenu(elm);
            }
            else {
                this.openSubMenuBySelector(elm);
            }
        });
    }
    public closeSubMenu(targetElement: JQuery): void {
        targetElement.find("ul.list-unstyled").css("display", "none");
    }
    public openSubMenuBySelector(targetElement: JQuery): void {
        targetElement.find("ul.list-unstyled").show();
    }
}

