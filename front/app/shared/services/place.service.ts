import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from "rxjs";
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'

import {Place} from "../place";
import {places} from "../datatest/data-places";
import {Hall} from "../hall";

@Injectable()
export class PlaceService{
    apiUrl = 'getPlaces';
    places: Place[] = places;

    constructor(private http: Http){}

    getPlaces(): Observable<Place[]>{
        return this.http.get(this.apiUrl)
            .map(res => res.json())
            .catch(this.handleError);
    }

    postSearchPlacesForHall(hall: Hall): Observable<Place[]>{
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers});
        return this.http.post(this.apiUrl, hall, options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    getPlacesTest(): Place[]{
        return this.places;
    }



    handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error);
    }
}