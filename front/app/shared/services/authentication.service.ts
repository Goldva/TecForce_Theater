import { Injectable } from '@angular/core';
import {Http, RequestOptions, Response, Headers} from '@angular/http';
import 'rxjs/add/operator/map'
import {User} from "../entities/user";
import { users } from '../datatest/data-users';

@Injectable()
export class AuthenticationService {
    apiUrl = 'authenticate';
    constructor(private http: Http) { }
    users: User[] = users;

    loginTest(username: string){
        if(username === '1'){
            localStorage.setItem('currentUser', JSON.stringify(this.users[0]));
        }
        if(username === '2'){
            localStorage.setItem('currentUser', JSON.stringify(this.users[1]));
        }
    }


    login(username: string, password: string) {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        let body = JSON.stringify({ username: username, password: password });
        return this.http.post(this.apiUrl, body, options)
            .map((response: Response) => {
                let user = response.json();
                if (user) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                console.log(user);
                return user;
            });
    }

    logout() {
        localStorage.removeItem('currentUser');
    }
}