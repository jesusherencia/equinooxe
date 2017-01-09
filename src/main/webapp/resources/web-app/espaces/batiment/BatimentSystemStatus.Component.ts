import { BatimentEntity } from './batiment.entity';
export class BatimentSystemStatusComponent {
    public static mainView: vuejs.Vue;
    constructor() {
        console.log('... BatimentSystemStatusComponent ...');
        let cmpOptions: IComponentOptions = new ComponentOptionsImpl();
        BatimentSystemStatusComponent.mainView = new Vue(cmpOptions);
    }
}

interface IComponentOptions extends vuejs.ComponentOption {
    data(): DataModelHolder;
}

class ComponentOptionsImpl implements IComponentOptions {
    public data(): DataModelHolder {
        return new DataModelHolder(this);
    }

    public el = "#BatimentSystemStatus";
    public template = ` 
     <div>
      <caption style="color:#F44336;">Système</caption>
      <table class="table">
        <tr>
            <th> Dernière mise à jour </th>
            <th> Par </th>
            <th> Archive </th>
            <th> Suppression </th>
        </tr>
        <tr>
            <td>
              <fr-datetime :frdate="batiment.lastModifiedDate"></fr-datetime> 
              <since :frdate="batiment.lastModifiedDate"></since>
            </td>
            <td>  {{ batiment.createdBy }} </td>
            <td>  {{ batiment.archived  }} </td>
            <td>  {{ batiment.deleted   }} </td>
            </td>
        <tr>
      </table>
     </div>
     `;
}

class DataModelHolder {
    public batiment: BatimentEntity = JSON.parse($("#ListEtages").text());
    constructor(parent: IComponentOptions) { }
}
