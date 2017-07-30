import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { PosterComponent } from './poster.component'

import { TableFilmsComponent } from './films/table-films.component'
import { SessionsListComponent } from './sessions/sessions-list.component'
import { HallComponent } from './halls/hall.component'
import {PlacesListComponent} from "./places/places-list.component";
import {SelectedTicketsComponent} from "./tickets/selected.tickets.component";


import { FilmsService } from '../shared/services/films.service'
import { SessionsService } from '../shared/services/session.service'
import { HallService } from '../shared/services/hall.service'
import {PlaceService} from "../shared/services/place.service";
import {TicketService} from "../shared/services/ticket.service";

@NgModule({
    imports: [BrowserModule],
    declarations: [
        PosterComponent,
        TableFilmsComponent,
        SessionsListComponent,
        HallComponent,
        PlacesListComponent,
        SelectedTicketsComponent
    ],
    providers: [
        FilmsService,
        SessionsService,
        HallService,
        PlaceService,
        TicketService
    ]
})

export class PosterModule{}
