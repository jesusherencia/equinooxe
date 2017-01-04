
export class Index {
    constructor() {
        console.log('Index');
        let cmp: vuejs.ComponentOption = {
            el: "#e1",
            methods: {
                sayHi: function () {
                    alert('hi');
                    console.log(this.data);
                }
            }
        };
        let v1 = new Vue(cmp);
    }
}

let app=new Index();
