
export class Index {
    public static mainView: vuejs.Vue;
    constructor() {
        console.log('Espaces Index');

        Vue.component('my-component', {
            template: '<div>A custom component!</div>'
        })

        let cmp: vuejs.ComponentOption = {
            el: "#e1",
            template:
            `<ul class="no-style">
               <li v-for="etage in batiment.etages" title="etage.description">
                  {{ etage.nom }} 
                  <form  method="post" name="removeFormModel">
                     <input type="hidden" name="id" value="etage.id"/>
                     <input type="hidden" name="redirectTo" value=""/>
                     <button v-on:click="deleteEtage($event,etage.id)" class="btn-gray">Supprimer</button>
                  </form>
               </li>
            </ul> 
            `,
            methods: {
                deleteEtage: EtageDeleteTask,
            },
            data: function () {
                return new DataModelHolder(this);
            }
        };
        Index.mainView = new Vue(cmp);
    }
}
 

export class DataModelHolder {
    public batiment: BatimentEntity = JSON.parse($("#Model").text());
    constructor(parent:any) {
        console.log('data ctor',"parent: ",parent);
    }
}

export class BatimentEntity {
    public nom: string;
    public etages: Array<any> = [];
}

export class EtageDeleteTask {
    constructor(evt: Event, etageId: number) {
        let data = <BatimentEntity>Index.mainView['batiment'];
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

let app = new Index();
