import { Routes } from '@angular/router';
import { PosterComponent } from './poster/poster.component'
import {LoginComponent} from "./login/login.component";
import {AdminComponent} from "./admin/admin.component";
import {RegistrationComponent} from "./login/registration.component";

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'registration',
        component: RegistrationComponent
    },
    {
        path: 'poster',
        component: PosterComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: '**',
        redirectTo: '/'
    }

];
