import { BaseSystemStatusComponent } from './../BaseSystemStatus.Component';
export class BatimentSystemStatusComponent extends BaseSystemStatusComponent  {
    public static mainView: vuejs.Vue;
    constructor() {
        super("#BatimentSystemStatus","#BatimentEntity")
        console.log('...>> BatimentSystemStatusComponent <<...');
    }
}
