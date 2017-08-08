import { Component, OnInit } from '@angular/core';
import {User} from "../../shared/entities/user";
import {UserService} from "../../shared/services/user.service";
import {Router} from "@angular/router";


@Component({
    templateUrl: 'registration.component.html',
    styleUrls: ['registration.component.css']
})

export class RegistrationComponent {
    user: User = new User();
    loading = false;
    returnUrl: string;

    constructor(
        private userService: UserService,
        private router: Router
    ) {}


    registration() {
        this.user.roleId = 2;
        this.userService.create(this.user).subscribe();
        this.router.navigate(["/"]);
    }

}
