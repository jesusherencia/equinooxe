
/**
 * All dates transformations
 * 
 * @export
 * @class CommonDateComponent
 */
export class DatesComponent {
    constructor() {

        Vue.component('fr-datetime', {
            template: '<span>{{frDatetime}}</span>',
            props: ['frdate'],
            computed: {
                frDatetime: function () {
                    return _.capitalize(moment(this.frdate).format('DD-MM-YYYY [à] HH[h]'));
                }
            }
        });
        
         Vue.component('since', {
            template: '<small>({{frDatetime}})</small>',
            props: ['frdate'],
            computed: {
                frDatetime: function () {
                    return moment(this.frdate, "YYYYMMDD").fromNow(); 
                }
            }
        });

    }
}