import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AdminModule} from "./admin/admin.modules";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";

import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./regitration/registration.component";
import {HomeComponent} from "./home.component";
import {routes} from "./home.routes";


@NgModule({
    imports: [
        FormsModule,
        BrowserModule,
        RouterModule.forRoot(routes),
        AdminModule
    ],
    declarations: [
        HomeComponent,
        LoginComponent,
        RegistrationComponent
    ],
    exports: [
        HomeComponent
    ]
})

export class HomeModule{}
