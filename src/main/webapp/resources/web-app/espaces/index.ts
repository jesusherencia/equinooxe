 
export class Index {
    constructor() {
        console.log('Espaces Index');
        console.log($("#goptions").data("goptions"));
        Vue.component('my-component', {
        template: '<div>A custom component!</div>'
        })

        let cmp: vuejs.ComponentOption = {
            el: "#e1",
            // template: `
            //  <div>
            //  <b v-on:click="sayHi">Click {{batiment.nom}} </b><br>
            //  <li v-for="etage in batiment.etages" title=" etage.description  "> 
    		// 				     {{ etage.nom }} <my-component></my-component>
    		// 				     <form  method="post"  name="removeFormModel">
        	// 					      <input type="hidden" name="id" value=" etage.id  "/>
        	// 					      <input type="hidden" name="redirectTo" value=""/>
        	// 					     <button >Supprimer</button>
        	// 					     <b v-on:click="sayHi">Click</b>
        	// 					 </form>
    		// 				    </li> 
            // </div> `,

            methods: {
                sayHi: function () {
                    alert('hi' + this.batiment.nom + " <-");
                    console.log(this.batiment.id);
                }
            },
            data: function () {
                let _data=this;
                return {
                    // batiment: $("#goptions").data("goptions"),
                    batiment: JSON.parse($("#Model").text())
                        // axios({
                        //     method: 'get',
                        //     url: '/api/batiment/'+$("#batimentId").data("idbatiment")
                        // }).then(res => {
                        //     _data.batiment= res.data;
                        // })
                    
                };
            }
        };
        let v1: vuejs.Vue = new Vue(cmp);
        

    }
}

let app = new Index();
