import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Film } from  '../../shared/entities/film';
import { FilmsService } from '../../shared/services/films.service';
import {EditorReloadService} from "../../shared/services/editors/editor.reload.service";


@Component({
    selector: 'table-film',
    templateUrl: 'table-films.component.html',
    styleUrls: ['table-films.component.css']
})
export class TableFilmsComponent implements OnInit{
    title = "Фильмы";
    films: Film[];
    @Output() selectFilm = new EventEmitter();
    selectedFilm: Film;

    constructor(private filmsService: FilmsService,
                private editorReloadService: EditorReloadService
    ){
        this.films = [];
    }

    ngOnInit(){
        this.editorReloadService.filmReload$.subscribe(film => {
            this.reload();
        });
        this.reload();
    }

    reload(){
        // this.films = this.filmsService.getFilmsTest();
        this.filmsService.getFilms().subscribe(films => {
            this.films = films});
    }

    onSelect(film: Film){
        if (this.selectedFilm === film) {
            this.selectedFilm = undefined;
        } else {
            this.selectedFilm = film;
        }
        this.selectFilm.emit(this.selectedFilm);

    }
}