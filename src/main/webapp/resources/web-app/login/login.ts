///
export class LoginApp {
    // j_username: string;
    // j_password: string;
    // "remember-me": boolean;
    baseUrl:string=null;
    constructor() {
        console.log('Login APP STARTED! ');
        $("#loginBtn").click(e=> {
            console.log('clicked!');
            this.login();
        })
        this.baseUrl= $('#baseUrl').text();
        console.log('baseUrl: '+this.baseUrl);
    }

    public login() {
        console.log('Login clicked: start to login')
        axios.post(this.baseUrl+"?cacheBuster=1496259856252", this.getLoginObj()).then(
            res => this.loginSuccess,
            err => {
                console.log('Error login', err)
            }
        )
    }

    private getLoginObj() {
        let obj = {
            "j_username" : $("#j_username").val(),
            "j_password ": $("#j_password").val(),
            "remember-me": true
        }
        console.log('Auth obj: ', obj);
        return obj;
    }

    private loginSuccess(res: any) {
        console.log("Login success", " SHOULD redirect resp:"+ res);
    }
}


let loginApp = new LoginApp();