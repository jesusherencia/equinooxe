System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var LoginApp, loginApp;
    return {
        setters:[],
        execute: function() {
            ///
            LoginApp = (function () {
                function LoginApp() {
                    var _this = this;
                    // j_username: string;
                    // j_password: string;
                    // "remember-me": boolean;
                    this.baseUrl = null;
                    console.log('Login APP STARTED! ');
                    $("#loginBtn").click(function (e) {
                        console.log('clicked!');
                        _this.login();
                    });
                    this.baseUrl = $('#baseUrl').text();
                    console.log('baseUrl: ' + this.baseUrl);
                }
                LoginApp.prototype.login = function () {
                    var _this = this;
                    console.log('Login clicked: start to login');
                    axios.post(this.baseUrl + "?cacheBuster=1496259856252", this.getLoginObj()).then(function (res) { return _this.loginSuccess; }, function (err) {
                        console.log('Error login', err);
                    });
                };
                LoginApp.prototype.getLoginObj = function () {
                    var obj = {
                        "j_username": $("#j_username").val(),
                        "j_password ": $("#j_password").val(),
                        "remember-me": true
                    };
                    console.log('Auth obj: ', obj);
                    return obj;
                };
                LoginApp.prototype.loginSuccess = function (res) {
                    console.log("Login success", " SHOULD redirect resp:" + res);
                };
                return LoginApp;
            }());
            exports_1("LoginApp", LoginApp);
            loginApp = new LoginApp();
        }
    }
});
//# sourceMappingURL=login.js.map