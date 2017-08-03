import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {User} from "./shared/entities/user";

@Component({
    selector: 'app',
    templateUrl: 'app.component.html',
    styleUrls: ['app.component.css']
})
export class AppComponent {
    title: string = 'TecForce theater';
    user = JSON.parse(localStorage.getItem('currentUser')) as User;
    constructor(private router: Router){}

    onSelect(){
        this.router.navigate(["poster"])
    }
}