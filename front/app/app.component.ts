import {Component, DoCheck} from '@angular/core';
import {User} from "./shared/entities/user";

@Component({
    selector: 'app',
    templateUrl: 'app.component.html',
    styleUrls: ['app.component.css']
})
export class AppComponent implements DoCheck{
    title: string = 'TecForce theater';
    user: User;
    ngDoCheck(){
        this.user = JSON.parse(localStorage.getItem('currentUser')) as User;
    }
}