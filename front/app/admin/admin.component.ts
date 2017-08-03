import { Component } from '@angular/core';
import {Film} from "../shared/entities/film";
import {EditorReloadService} from "../shared/services/editors/editor.reload.service";
import {Hall} from "../shared/entities/hall";

@Component({
    selector: 'admin',
    templateUrl: 'admin.component.html',
    styleUrls: ['admin.component.css']
})
export class AdminComponent {
    film: Film;
    hall: Hall;

    selectFilm(film: Film){
        this.film = film;
    }

    selectHall(hall: Hall){
        this.hall = hall;
    }

}