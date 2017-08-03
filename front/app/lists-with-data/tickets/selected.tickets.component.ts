import { Component, Input, Output, EventEmitter } from '@angular/core';

import {Ticket} from "../../shared/entities/ticket";
import {User} from "../../shared/entities/user";
import {TicketService} from "../../shared/services/ticket.service";

@Component({
    selector: 'ticket-table',
    templateUrl: "selected.tickets.component.html",
    styleUrls: ['selected.tickets.component.css']
})

export class SelectedTicketsComponent{
    @Input() tickets: Map<number, Ticket>;
    user: User = JSON.parse(localStorage.getItem('currentUser')) as User;

    constructor(private ticketService: TicketService ){}

    buyTickets(){
        if (this.user) {
            this.ticketService.postBuyTickets(Array.from(this.tickets.values())).subscribe();
        }
        this.tickets.clear();
    }
}