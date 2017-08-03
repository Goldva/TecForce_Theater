import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ListWithDataComponent } from './list.with.data.component'

import { TableFilmsComponent } from './films/table-films.component'
import { SessionsListComponent } from './sessions/sessions-list.component'
import { HallComponent } from './halls/hall.component'
import {PlacesListComponent} from "./places/places-list.component";
import {SelectedTicketsComponent} from "./tickets/selected.tickets.component";


@NgModule({
    imports: [BrowserModule],
    declarations: [
        ListWithDataComponent,
        TableFilmsComponent,
        SessionsListComponent,
        HallComponent,
        PlacesListComponent,
        SelectedTicketsComponent
    ],
    exports: [
        TableFilmsComponent,
        SessionsListComponent,
        HallComponent,
        PlacesListComponent,
        SelectedTicketsComponent
    ]
})

export class ListWithDataModule{}
