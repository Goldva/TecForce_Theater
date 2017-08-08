import {Component, OnInit} from '@angular/core';
import {User} from "../../../shared/entities/user";
import {UserService} from "../../../shared/services/user.service";

@Component({
    selector: 'users-list',
    templateUrl: 'users.list.component.html',
    styleUrls: ['users.list.component.css']
})
export class UsersListComponent implements OnInit{
    users: User[];

    constructor(private userService: UserService){}

    ngOnInit(){
        this.userService.getAll().subscribe(users => {
            this.users = users;
        })
    }

    onSubmit(){
    }
}