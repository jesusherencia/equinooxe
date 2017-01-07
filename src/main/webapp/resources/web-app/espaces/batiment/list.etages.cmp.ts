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
    public el = "#e1";
    public template = `<ul class="no-style">
                        <li v-for="etage in batiment.etages" title="etage.description">
                            {{ etage.nom }} 
                            <form  method="post" name="removeFormModel">
                                <input type="hidden" name="id" value="etage.id"/>
                                <input type="hidden" name="redirectTo" value=""/>
                                <button v-on:click="deleteEtage($event,etage.id)" class="btn-gray">Supprimer</button>
                            </form>
                        </li>
                        </ul> 
                      `;
}

/**
 * 
 * 
 * @export
 * @class DataModelHolder
 */
class DataModelHolder {
    public batiment: BatimentEntity = JSON.parse($("#Model").text());
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


