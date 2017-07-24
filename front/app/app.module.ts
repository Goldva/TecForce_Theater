import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http'

import { AppComponent }   from './app.component';
import { TableFilmsComponent } from './films/table-films.component'
import { FilmsService } from "./shared/films.service"

@NgModule({
    imports:      [
        BrowserModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        AppComponent,
        TableFilmsComponent
    ],
    providers: [FilmsService],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }