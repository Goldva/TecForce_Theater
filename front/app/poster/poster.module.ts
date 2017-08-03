import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { PosterComponent } from './poster.component'
import { ListWithDataModule } from '../lists-with-data/list.with.data.module'
import { EditorReloadService } from "../shared/services/editors/editor.reload.service"

import { FilmsService, SessionsService, HallService, PlaceService, TicketService} from '../shared/services/index'

@NgModule({
    imports: [
        BrowserModule,
        ListWithDataModule
    ],
    declarations: [
        PosterComponent
    ],
    providers: [
        FilmsService,
        SessionsService,
        HallService,
        PlaceService,
        TicketService,
        EditorReloadService
    ]
})

export class PosterModule{}
