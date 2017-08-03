import { Injectable } from '@angular/core';
import {Http, RequestOptions, Headers} from '@angular/http';

import {films} from '../datatest/data-films';

import { Film } from '../entities/film';
import {Observable} from 'rxjs';
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'

@Injectable()
export class FilmsService {
    private apiUrl = 'editorFilm';
    films: Film[] = films;

    constructor(private http: Http){}

    getFilms(): Observable<Film[]> {
        return this.http.get(this.apiUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    create(film: Film): Observable<Film> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        return this.http.post(this.apiUrl, film, options)
            .catch(this.handleError);
    }

    update(film: Film): Observable<Film> {
        return this.http.put(this.apiUrl, film)
            .catch(this.handleError);
    }

    delete(film: Film): Observable<Film> {
        let headers = new Headers({'Content-Type': 'application/json;charset=UTF-8'});
        let options = new RequestOptions({headers});
        return this.http.delete(this.apiUrl + "/" + film.id, options)
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