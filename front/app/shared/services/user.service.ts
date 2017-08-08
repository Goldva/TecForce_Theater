import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../entities/user';
import {Observable} from "rxjs";
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'

@Injectable()
export class UserService {
    private apiUrl = 'users';

    constructor(private http: Http) { }

    getAll(): Observable<User[]> {
        return this.http.get(this.apiUrl, this.jwt())
            .map(res => res.json())
            .catch(this.handleError);
    }

    getById(id: number): Observable<User> {
        return this.http.get(this.apiUrl + '/' + id, this.jwt())
            .map(res => res.json())
            .catch(this.handleError);
    }

    create(user: User): Observable<User> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        console.log(user);
        return this.http.post(this.apiUrl, user, options)
            .catch(this.handleError);

    }

    update(user: User): Observable<User> {
        return this.http.put(this.apiUrl + '/' + user.id, user, this.jwt())
            .catch(this.handleError);
    }

    delete(id: number): Observable<User> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        return this.http.delete(this.apiUrl + '/' + id, options)
            .catch(this.handleError);
    }

    private jwt() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser) {
            let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
            return new RequestOptions({ headers: headers });
        }
    }

    private handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error)
    }

}