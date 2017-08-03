import { Component } from '@angular/core';

import { Film } from '../shared/entities/film';
import {Session} from "../shared/entities/session";
import {Hall} from "../shared/entities/hall";
import {Place} from "../shared/entities/place";
import {Ticket} from "../shared/entities/ticket";
import {TicketService} from "../shared/services/ticket.service";
import {SessionsService} from "../shared/services/session.service";
import {HallService} from "../shared/services/hall.service";
import {PlaceService} from "../shared/services/place.service";
import {halls} from "../shared/datatest/data-halls";
import {List} from "lodash";
import LinkedList from "typescript-collections/dist/lib/LinkedList";
import {sessions} from "../shared/datatest/data-sessions";
import {places} from "../shared/datatest/data-places";
import {User} from "../shared/entities/user";
import {tick} from "@angular/core/testing";
import {EditorReloadService} from "../shared/services/index";

@Component({
    selector: 'poster',
    templateUrl: 'poster.component.html',
    styleUrls: ['poster.component.css']
})

export class PosterComponent {
    title: string = 'Poster';

    constructor(private ticketService: TicketService){}

    film: Film;
    session: Session;
    hall: Hall;
    user: User;


    ticket: Ticket = new Ticket;

    tickets = new Map<number, Ticket>();

    selectFilm(film: Film){
        this.film = undefined;
        this.session = undefined;
        this.hall = undefined;
        if(film) {
            console.log(film);
            this.film = film;
            this.ticket.film = film;
        }
    }

    selectSession(session: Session){
        this.session = undefined;
        this.hall = undefined;
        if(session) {
            this.session = session;
            this.ticket.session = session;
            this.ticket.sessionId = session.id;
        }
    }

    selectHall(hall: Hall){
        this.hall = undefined;
        if(hall) {
            this.hall = hall;
            this.ticket.hall = hall;
            this.ticket.hallId = hall.id;
        }
    }

    selectPlace(place: Place){
        this.ticket.place = place;
        this.ticket.placeId = place.id;
        this.user = JSON.parse(localStorage.getItem("currentUser"));
        if(this.user) {
            this.ticket.userId = this.user.id;
        }else {
            this.ticket.userId = -1;
        }
        if (this.tickets.has(place.id)){
            this.tickets.delete(place.id)
        }else {
            this.ticketService.postSelectionTicket(this.ticket).subscribe(ticket => {
                this.tickets.set(place.id, ticket);
            });
        }
    }


}