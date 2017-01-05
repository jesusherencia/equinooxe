
export class Index {
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
                deleteEtage: function (evt: Event, etageId: number) {
                    evt.preventDefault();
                    this.batiment.etages.forEach(etage => {
                        if (etage.id == etageId) {
                            console.log("Start deleting", etage.id);
                            axios.delete("/api/etage/delete/" + etage.id).then(
                                function (res) {
                                    alert(res.data);
                                    this.batiment.etages = this.batiment.etages.filter(function (obj) {
                                        return  etage.id  === etageId;
                                    });
                                }
                            )
                        }
                    })
                }
            },
            data: function () {
                let _data = this;
                return {
                    batiment: JSON.parse($("#Model").text())
                };
            }
        };
        let v1: vuejs.Vue = new Vue(cmp);


    }
}



let app = new Index();
