import { Injectable } from '@angular/core'
import {Http, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import 'rxjs/operator/map'
import 'rxjs/operator/catch'
import 'rxjs/Observable/throw'

import {Ticket} from "../ticket";

@Injectable()
export class TicketService{

    constructor(private http: Http){}

    postSelectionTicket(ticket: Ticket): Observable<Ticket>{
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers});
        return this.http.post('ticketsSelection', ticket, options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    postBuyTickets(tickets: Ticket[]): Observable<Ticket>{
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers});
        return this.http.post('buyTicket', tickets, options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    private handleError(error: any){
        console.error('Error', error);
        return Observable.throw(error.message || error)
    }

}