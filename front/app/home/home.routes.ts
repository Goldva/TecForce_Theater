import { Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./regitration/registration.component";
import {PosterComponent} from "../poster/poster.component";
import {AdminComponent} from "./admin/admin.component";
import {FilmsEditorComponent} from "./admin/editors/films/films.editor.component";
import {HallsEditorComponent} from "./admin/editors/halls/halls.editor.component";
import {UsersListComponent} from "./admin/users/users.list.component";
import {SessionsEditorComponent} from "./admin/editors/sessions/sessions.editor.component";

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
        path: 'admin',
        component: AdminComponent,
        children:[
            {
                path: 'filmEditor',
                component: FilmsEditorComponent
            },
            {
                path: 'hallEditor',
                component: HallsEditorComponent
            },
            {
                path: 'sessionsEditor',
                component: SessionsEditorComponent
            },
            {
                path: 'usersList',
                component: UsersListComponent
            }
        ]
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
