
/**
 * All dates transformations
 * 
 * @export
 * @class CommonDateComponent
 */
export class DatesComponent {
    constructor() {
        // To register a global component, you can use Vue.component(tagName, options). For example:
        Vue.component('fr-datetime', {
            template: '<span>D: {{frDatetime}}</span>',
            props: ['frdate'],
            computed: {
                frDatetime: function () {
                    console.log("..Compute date ..", this.frdate)
                    return moment(this.frdate).format('ddd MM  YYYY, HH[h]');
                }
            }
        })
    }
}