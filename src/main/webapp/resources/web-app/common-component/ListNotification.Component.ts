import { NotificationEntity } from './Notification.Entity';

/**
 * Main
 * 
 * @export
 * @class Index
 */
export class ListNotificationComponent {
    public static mainView: vuejs.Vue;
    constructor() {
        console.log('..ListNotificationComponent..');
        let cmpOptions: IComponentOptions = new ComponentOptionsImpl();
        ListNotificationComponent.mainView = new Vue(cmpOptions);
    }
}

interface IComponentOptions extends vuejs.ComponentOption {
    methods: { deleteNotification: Function };
    data():DataModelHolder;
    
}

class ComponentOptionsImpl implements IComponentOptions {
    public data(): DataModelHolder {
        return new DataModelHolder(this);
    }
    public methods = {
        deleteNotification: NotificationDeleteService,
    }
    public el = "#ListNotificationComponent";
    public template = `
    <ul class="list-group list-no-border user-list">
          <li v-for="(notif,index) in notifications" class="list-group-item">
                <a href="#" class="user-list-item">
                    <div class="icon bg-info">
                        <i class="zmdi zmdi-account"></i>
                    </div>
                    <div class="user-desc">
                        <span class="name">{{notif.title}}</span>
                        <span class="desc">{{notif.message}}</span>
                        <span class="time"> 
                            <since :frdate="notif.addAt"></since>
                        </span>
                    </div>
                </a>
            </li>
    </ul>
     `;
}

/**
 * 
 * 
 * @export
 * @class DataModelHolder
 */
class DataModelHolder {
    public notifications: Array<NotificationEntity>=[];
    constructor(parent: IComponentOptions) {
         axios.get("/api/notification/all").then(
                    res => {
                          this.notifications=<any>res.data;
                          console.log(res.data);
                        }
        );
               
    }
}

/**
 * Bound to a view method
 * 
 * @class EtageDeleteService
 */
class NotificationDeleteService {
    constructor(evt: Event, notifId: number) {
        let data = <NotificationEntity>ListNotificationComponent.mainView['notifications'];
        evt.preventDefault();
        
    }
}


