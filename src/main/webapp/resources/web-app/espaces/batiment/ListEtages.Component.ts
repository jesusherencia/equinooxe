import { BatimentEntity } from './batiment.entity';

/**
 * Main
 * 
 * @export
 * @class Index
 */
export class ListEtagesComponent {
    public static mainView: vuejs.Vue;
    constructor() {
        console.log('Espaces Index');
        let cmpOptions: IComponentOptions = new ComponentOptionsImpl();
        ListEtagesComponent.mainView = new Vue(cmpOptions);
    }
}

interface IComponentOptions extends vuejs.ComponentOption {
    methods: { deleteEtage: Function };
    data():DataModelHolder;
    
}

class ComponentOptionsImpl implements IComponentOptions {
    public data(): DataModelHolder {
        return new DataModelHolder(this);
    }
    public methods = {
        deleteEtage: EtageDeleteService,
    }
    public el = "#ListEtagesComponent";
    public template = `<table class="table smaller">
                            <caption class="smaller">Etages du:{{batiment.nom }}</caption>
                            <tr>
                              <th># </th>
                              <th>Nom </th>
                              <th>Ajout </th>
                            </th>
                            <tr v-for="(etage,index) in batiment.etages" class="as-tr" title="etage.description">
                                    <td>  {{ etage.id}}       </td>
                                    <td>  {{ etage.nom }}   </td>
                                    <td>  <fr-datetime :frdate="etage.createdDate" ></fr-datetime> </td>
                                    <td>
                                    <div class="dropdown pull-right">
                                        <a href="#" class="dropdown-toggle card-drop" title="Options" data-toggle="dropdown" aria-expanded="false">
                                            <i class="zmdi zmdi-more-vert"></i>
                                        </a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li>
                                                <form  method="post" name="removeFormModel">
                                                    <input type="hidden" name="id" value="etage.id"/>
                                                    <input type="hidden" name="redirectTo" value=""/>
                                                    <button v-on:click="deleteEtage($event,etage.id)" class="as-link">Supprimer</button>
                                                </form>
                                            </li>
                                        </ul>
                                    </div>
                                  </td>
                            </tr>
                      </table> 
                      `;
}

/**
 * 
 * 
 * @export
 * @class DataModelHolder
 */
class DataModelHolder {
    public batiment: BatimentEntity = JSON.parse($("#BatimentEntity").text());
    constructor(parent: IComponentOptions) {
        console.log('data ctor', "parent: ", parent);
    }
}

/**
 * Bound to a view method
 * 
 * @class EtageDeleteService
 */
class EtageDeleteService {
    constructor(evt: Event, etageId: number) {
        let data = <BatimentEntity>ListEtagesComponent.mainView['batiment'];
        evt.preventDefault();
        data.etages.forEach(etage => {
            if (etage.id == etageId) {
                console.log("Start deleting", etage.id);
                axios.delete("/api/etage/delete/" + etage.id).then(
                    res => {
                        alert(res.data);
                        data.etages = data.etages.filter(e => {
                            return e.id !== etageId;
                        });
                    }
                )
            }
        })
    }
}


