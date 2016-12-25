$('body').addClass('bg-green');

import { Menu } from './menu'
export class Hello {
    v: string = "v";
    constructor() {
        console.log("TS system fro web-app is up _/\\_ ");
        let m = new Menu();
        $(".has_sub").click(function () {
            if ($(this).find("ul.list-unstyled").is(":visible")) {
                $(this).find("ul.list-unstyled").css("display", "none");
                 $(this).find(".ti-angle-down").hide();
                 $(this).find(".ti-angle-right").show();
                console.log('Element visible so hide *-* ');
            }
            else {
                $(this).find("ul.list-unstyled").show();
                $(this).find(".ti-angle-down").show();
                 $(this).find(".ti-angle-right").hide();
                
                // $(this).find(".list-unstyled").css("display", "block");
                // $(this).find("ul").css("display", "block");
                console.log('Element is hide so show grr');
            }



        });
    }
}

let h = new Hello();
