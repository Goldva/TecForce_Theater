import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';
import {RouterModule} from '@angular/router';

import { routes } from './app.routes'
import { AppComponent }   from './app.component';
import { PosterModule} from './poster/poster.module';
import {HomeModule} from "./home/home.module";

import { AlertComponent } from './alerts/alert.component';
import { AuthGuard } from './shared/services/guard/auth.guard';
import { AlertService, AuthenticationService, UserService } from './shared/services/index';


@NgModule({
    imports:      [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(routes),
        PosterModule,
        HomeModule
    ],
    declarations: [
        AppComponent,
        AlertComponent
    ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService
    ],
    bootstrap:    [
        AppComponent
    ]
})
export class AppModule { }