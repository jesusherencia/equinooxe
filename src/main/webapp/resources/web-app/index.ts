import { LeftMenu } from './menu'
/**
 * a js equivalent of  public static void main(String[] args)! 
 * 
 * @export
 * @class EqApp
 */
export class EqApp {
    constructor() {
        let menu = new LeftMenu();
    }
}

/** Run the app! */
let eqApp = new EqApp();
