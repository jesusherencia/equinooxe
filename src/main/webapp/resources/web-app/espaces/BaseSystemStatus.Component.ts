
export class BaseSystemStatusComponent {
    public static mainView: vuejs.Vue;
    public static elementSelector: string;
    public static dataSelector: string;

    constructor(elementSelector: string, dataSelector: string) {
        console.log('... BaseSystemStatusComponent ...');
        BaseSystemStatusComponent.elementSelector=elementSelector ;
        BaseSystemStatusComponent.dataSelector=dataSelector ;
        let cmpOptions: IComponentOptions = new ComponentOptionsImpl();
        BaseSystemStatusComponent.mainView = new Vue(cmpOptions);
    }
}

interface IComponentOptions extends vuejs.ComponentOption {
    data(): DataModelHolder;
}

class ComponentOptionsImpl implements IComponentOptions {
  
    public el=BaseSystemStatusComponent.elementSelector;

    constructor() {
        
    }
    public data(): DataModelHolder {
        return new DataModelHolder(this);
    }

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
              <fr-datetime :frdate="entityData.lastModifiedDate"></fr-datetime> 
              <since :frdate="entityData.lastModifiedDate"></since>
            </td>
            <td>  {{ entityData.createdBy|capitalize }} </td>
            <td v-bind:class="{ archived: entityData.archived }">  {{ entityData.archived? 'Oui': 'Non' }} </td>
            <td v-bind:class="{ deleted : entityData.deleted }">   {{ entityData.deleted?  'Oui': 'Non' }} </td>
            </td>
        <tr>
      </table>
     </div>
     `;
}

class DataModelHolder {
    public entityData: any
    constructor(parent: IComponentOptions) {
        this.entityData = JSON.parse($(BaseSystemStatusComponent.dataSelector).text());
    }
}
