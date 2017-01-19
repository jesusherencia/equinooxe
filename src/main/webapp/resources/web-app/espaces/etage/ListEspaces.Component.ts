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
    public template = `
    <table class="table smaller">
                            <caption class="smaller">Espaces du:{{etage.nom }}</caption>
                            <tr>
                              <th># </th>
                              <th>Nom </th>
                              <th>Ajout </th>
                            </th>
                            <tr v-for="(espace,index) in etage.espaces" class="as-tr" title="epspace.description">
                                    <td>  {{ espace.id}}       </td>
                                    <td>  {{ espace.nom }}   </td>
                                    <td>  <fr-datetime :frdate="espace.createdDate" ></fr-datetime> </td>
                                    <td>
                                    <div class="dropdown pull-right">
                                        <a href="#" class="dropdown-toggle card-drop" title="Options" data-toggle="dropdown" aria-expanded="false">
                                            <i class="zmdi zmdi-more-vert"></i>
                                        </a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li>
                                                <form  method="post" name="removeFormModel">
                                                    <input type="hidden" name="id" value="espace.id"/>
                                                    <input type="hidden" name="redirectTo" value=""/>
                                                    <button v-on:click="deleteEspace($event,espace.id)" class="as-link">Supprimer</button>
                                                </form>
                                            </li>
                                        </ul>
                                    </div>
                                  </td>
                            </tr>
     </table> 
    
    `;
}
class DataModelHolder {
    public etage: EtageEntity = JSON.parse($("#EtageEntity").text());
    constructor(parent: IComponentOptions) {
        // console.log('data ctor', "parent: ", parent);
    }
}
