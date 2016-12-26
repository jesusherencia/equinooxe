
export class LeftMenu {
    static SUB_MENU_MAIN_SELECTOR =".has_sub";
    static OPEN_SUB_SELECTOR=".open_sub_menu";
    constructor() {
        console.log('Menu load *()* ');
        this.bindSubMenu();
        this.bindInitSubMenu();
    }

    public bindInitSubMenu():void {
        console.log("Open on init");
       this.openSubMenu( $(LeftMenu.OPEN_SUB_SELECTOR) );
    }
   
    /**
     * Bind sub menu so it listen to click events
     * @memberOf LeftMenu
     */
    public bindSubMenu():void {
        $(LeftMenu.SUB_MENU_MAIN_SELECTOR).click(e => {
            /** target may be the element or one of its children so scan parents */
            let elm = $(e.target).is('li') ? $(e.target) : $(e.target).closest('li');
            if (elm.find("ul.list-unstyled").is(":visible")) {
                this.closeSubMenu(elm);
            }
            else {
                this.openSubMenu(elm);
            }
        });
    }
    public closeSubMenu(targetElement: JQuery): void {
        targetElement.find("ul.list-unstyled").css("display", "none");
    }
    public openSubMenu(targetElement: JQuery): void {
        targetElement.find("ul.list-unstyled").show();
    }
}

