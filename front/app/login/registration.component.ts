import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {AuthenticationService} from "../shared/services/authentication.service";
import {AlertService} from "../shared/services/alert.service";
import {User} from "../shared/entities/user";
import {UserService} from "../shared/services/user.service";


@Component({
    templateUrl: 'registration.component.html'
})

export class RegistrationComponent {
    user: User = new User();
    loading = false;
    returnUrl: string;

    constructor(private userService: UserService) {}


    registration() {
        this.user.roleId = 2;
        this.userService.create(this.user).subscribe();
    }

}
