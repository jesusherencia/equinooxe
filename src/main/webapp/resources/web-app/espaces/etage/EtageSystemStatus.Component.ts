import { BaseSystemStatusComponent } from './../BaseSystemStatus.Component';
export class EtageSystemStatusComponent extends BaseSystemStatusComponent  {
    public static mainView: vuejs.Vue;
    constructor() {
        super("#EtageSystemStatus","#EtageEntity")
        console.log('...>> EtageSystemStatusComponent <<...');
    }
}
