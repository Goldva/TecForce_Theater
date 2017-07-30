import { Component } from '@angular/core';

import { Film } from '../shared/film';
import {Session} from "../shared/session";
import {Hall} from "../shared/hall";
import {Place} from "../shared/place";
import {Ticket} from "../shared/ticket";
import {TicketService} from "../shared/services/ticket.service";
import {SessionsService} from "../shared/services/session.service";
import {HallService} from "../shared/services/hall.service";
import {PlaceService} from "../shared/services/place.service";
import {halls} from "../shared/datatest/data-halls";
import {List} from "lodash";
import LinkedList from "typescript-collections/dist/lib/LinkedList";
import {sessions} from "../shared/datatest/data-sessions";
import {places} from "../shared/datatest/data-places";

@Component({
    selector: 'poster',
    templateUrl: 'poster.component.html',
    styleUrls: ['poster.component.css']
})

export class PosterComponent {
    title: string = 'Poster';

    constructor(private ticketService: TicketService,
                private sessionService: SessionsService,
                private hallService: HallService,
                private placeService: PlaceService
    ){}

    sessions: Session[];
    halls: Hall[];
    places: Place[];

    ticket: Ticket = new Ticket;

    tickets = new Map<number, Ticket>();

    selectFilm(film: Film){
        this.halls = undefined;
        this.places = undefined;
        this.ticket.film = film;
        // this.sessions = this.sessionService.getFilmSessionsTest();
        this.sessionService.postSearchSessionsForFilm(film).subscribe(sessions => {
            this.sessions = sessions});

    }

    selectSession(session: Session){
        this.ticket.session = session;
        this.ticket.sessionId = session.id;
        this.places = undefined;
        // this.halls = this.hallService.getHallTest();
        this.hallService.postSearchHallsForSession(session).subscribe(halls => {
            this.halls = halls});

    }

    selectHall(hall: Hall){
        this.ticket.hall = hall;
        this.ticket.hallId = hall.id;
        // this.places = this.placeService.getPlacesTest();
        this.placeService.postSearchPlacesForHall(hall).subscribe(places => {
            this.places = places;});
    }

    selectPlace(place: Place){
        this.ticket.place = place;
        this.ticket.placeId = place.id;
        this.ticket.userId = 1;
        if (this.tickets.has(place.id)){
            this.tickets.delete(place.id)
        }else {
            this.ticketService.postSelectionTicket(this.ticket).subscribe(ticket => {
                this.tickets.set(place.id, ticket);
            });
        }
    }


}