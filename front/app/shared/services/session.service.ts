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
    private apiUrl = 'editorSessions';
    // sessinons: Session[] = sessions;

    constructor(private http: Http){}
    getSessions(): Observable<Session[]> {
        return this.http.get(this.apiUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    create(session: Session): Observable<Session> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        return this.http.post(this.apiUrl, session, options)
            .catch(this.handleError);
    }

    update(session: Session): Observable<Session> {
        return this.http.put(this.apiUrl, session)
            .catch(this.handleError);
    }

    delete(session: Session): Observable<Session> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        return this.http.delete(this.apiUrl + "/" + session.id, options)
            .catch(this.handleError);
    }

    postSearchSessionsForFilm(film: Film): Observable<Session[]>{
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers});
        return this.http.post(this.apiUrl + "/" +  "filmId=" + film.id, film, options)
            .map(res => res.json())
            .catch(this.handleError);
    }


    // getFilmSessionsTest(): Session[]{
    //     return this.sessinons;
    // }

    private handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error)
    }
}