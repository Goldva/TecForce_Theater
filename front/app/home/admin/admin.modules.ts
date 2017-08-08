import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {ListWithDataModule} from "../../lists-with-data/list.with.data.module";
import { FormsModule }   from '@angular/forms';
import {HallsEditorModule} from "./editors/halls/halls.editor.modules";

import {AdminComponent} from "./admin.component";
import { FilmsEditorComponent } from './editors/films/films.editor.component'
import {UsersListComponent} from "./users/users.list.component";
import {RouterModule} from "@angular/router";
import {routes} from "../home.routes";
import {SessionsEditorComponent} from "./editors/sessions/sessions.editor.component";


@NgModule({
    imports: [
        BrowserModule,
        ListWithDataModule,
        FormsModule,
        RouterModule.forRoot(routes),
        HallsEditorModule
    ],
    declarations: [
        AdminComponent,
        FilmsEditorComponent,
        SessionsEditorComponent,
        UsersListComponent
    ],
    providers: [
    ],
    exports: [
        AdminComponent
    ]
})

export class AdminModule{}
