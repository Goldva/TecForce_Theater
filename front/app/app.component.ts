import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app',
    templateUrl: 'app.component.html',
    styleUrls: ['app.component.css']
})
export class AppComponent {
    title: string = 'TecForce theater';

    constructor(private router: Router){}

    onSelect(){
        this.router.navigate(["poster"])
    }
}