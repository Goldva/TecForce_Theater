import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'

import { sessions } from '../datatest/data-sessions';
import { Session } from '../entities/session';
import {Film} from "../entities/film";

@Injectable()
export class SessionsService{
    private apiUrl = 'getFilmSessions';
    sessinons: Session[] = sessions;

    constructor(private http: Http){}

    getFilmSessions(): Observable<Session[]>{
        return this.http.get(this.apiUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    postSearchSessionsForFilm(film: Film): Observable<Session[]>{
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers});
        return this.http.post(this.apiUrl, film, options)
            .map(res => res.json())
            .catch(this.handleError);
    }


    getFilmSessionsTest(): Session[]{
        return this.sessinons;
    }

    private handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error)
    }
}