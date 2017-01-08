
/**
 * All dates transformations
 * 
 * @export
 * @class CommonDateComponent
 */
export class DatesComponent {
    constructor() {
        Vue.component('fr-datetime', {
            template: '<span> {{frDatetime}}</span>',
            props: ['frdate'],
            computed: {
                frDatetime: function () {
                    console.log("..Compute date ..", this.frdate)
                    return _.capitalize(moment(this.frdate).format('DD-MM-YYYY [à] HH[h]'));
                }
            }
        })
    }
}