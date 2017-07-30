import { Routes } from '@angular/router';
import { PosterComponent } from './poster/poster.component'
import {LoginComponent} from "./login/login.component";

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'poster',
        component: PosterComponent
    },
    {
        path: '**',
        redirectTo: '/'
    }

];
