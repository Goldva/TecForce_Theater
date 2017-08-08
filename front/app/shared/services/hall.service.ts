import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';

import { Hall } from '../entities/hall';
// import { halls } from '../datatest/data-halls';

import { Observable } from 'rxjs';
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'
import {Session} from "../entities/session";
import {User} from "../entities/user";

@Injectable()
export class HallService{
    private apiUrl = 'editorHalls';
    // halls: Hall[] = halls;

    user: User;

    constructor(private http: Http){}

    getHall(): Observable<Hall[]>{
        return this.http.get(this.apiUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    postSearchHallsForSession(session: Session): Observable<Hall[]>{
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers});

        this.user = JSON.parse(localStorage.getItem('currentUser'));
        if (!this.user){
            console.log(this.user);
            this.user = new User();
            this.user.id = -1;
        }
        let body = JSON.stringify({"user": this.user});

        return this.http.post(this.apiUrl + "/sessionId=" + session.id, body, options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    create(hall: Hall): Observable<Hall> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        return this.http.post(this.apiUrl, hall, options)
            .catch(this.handleError);
    }

    update(hall: Hall): Observable<Hall> {
        console.log(hall);
        return this.http.put(this.apiUrl, hall)
            .catch(this.handleError);
    }

    delete(hall: Hall): Observable<Hall> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        return this.http.delete(this.apiUrl + "/" + hall.id, options)
            .catch(this.handleError);
    }


    // getHallTest(): Hall[]{
    //     return this.halls;
    // }

    private handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error)
    }
}