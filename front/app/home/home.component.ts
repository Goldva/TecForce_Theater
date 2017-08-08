import {Component, DoCheck} from '@angular/core';
import {User} from "../shared/entities/user";
import {AuthenticationService} from "../shared/services/authentication.service";

@Component({
    selector: 'home',
    templateUrl: 'home.component.html',
    styleUrls: ['home.component.css']
})

export class HomeComponent implements DoCheck{
    title: string = 'TecForce theater';
    user: User;
    constructor(private authenticationService: AuthenticationService){}

    ngDoCheck(){
        this.user = JSON.parse(localStorage.getItem('currentUser')) as User;
    }

    logout(){
        this.authenticationService.logout()
    }

}