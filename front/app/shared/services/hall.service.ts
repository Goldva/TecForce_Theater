import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';

import { Hall } from '../hall';
import { halls } from '../datatest/data-halls';

import { Observable } from 'rxjs';
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'
import {Session} from "../session";

@Injectable()
export class HallService{
    private apiUrl = 'getHalls';
    halls: Hall[] = halls;

    constructor(private http: Http){}

    getHall(): Observable<Hall[]>{
        return this.http.get(this.apiUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    postSearchHallsForSession(session: Session): Observable<Hall[]>{
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers});

        let body = JSON.stringify({"session": session, "user": localStorage.getItem('currentUser')});

        return this.http.post(this.apiUrl, body, options)
            .map(res => res.json())
            .catch(this.handleError);
    }


    getHallTest(): Hall[]{
        return this.halls;
    }

    private handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error)
    }
}