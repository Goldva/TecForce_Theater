import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    apiUrl = 'authenticate';
    constructor(private http: Http) { }

    login(username: string, password: string) {
        return this.http.post(this.apiUrl, JSON.stringify({ username: username, password: password }))
            .map((response: Response) => {
                let user = response.json();
                if (user ) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            });
    }

    logout() {
        localStorage.removeItem('currentUser');
    }
}