//   /espaces/etage/{etageId}/espace/new

import { EtageEntity } from './../model/Etage.Entity';
export class ListEspacesComponent {
    public static mainView: vuejs.Vue;
    constructor() {
        console.log("...ListEspacesComponent...");
        let componentOptions: IComponentOptions = new ComponentOptionsImp();
        ListEspacesComponent.mainView = new Vue(componentOptions);
    }
}

interface IComponentOptions extends vuejs.ComponentOption  {
    methods: { deleteEspace: Function };
    data(): DataModelHolder;
}
class ComponentOptionsImp implements IComponentOptions {
    public data(): DataModelHolder {
        return new DataModelHolder(this);
    }
    public methods = {
        deleteEspace: () => { },
    }
    public el = "#ListEspacesComponent";
    public template = `<h1> ListEspacesComponent </h1> `;
}
class DataModelHolder {
    public etage: EtageEntity = JSON.parse($("#EtageEntity").text());
    constructor(parent: IComponentOptions) {
        // console.log('data ctor', "parent: ", parent);
    }
}
