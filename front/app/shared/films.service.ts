import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import {films} from "../shared/data-films";

import { Film } from "./film";
import {Observable} from "rxjs";
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'

@Injectable()
export class FilmsService {
    private apiUrl = 'getFilms';
    films: Film[] = films;

    constructor(private http: Http){}
    getFilms(): Observable<Film[]> {
        return this.http.get(this.apiUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    getFilmsTest(): Film[]{
        return this.films;
    }

    private handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error)
    }
}