import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Film } from  '../../shared/film';
import { FilmsService } from '../../shared/services/films.service';

@Component({
    selector: 'table-film',
    templateUrl: 'table-films.component.html',
    styleUrls: ['table-films.component.css']
})
export class TableFilmsComponent implements OnInit{
    films: Film[];
    @Output() selectFilm = new EventEmitter();
    selectedFilm: Film;

    constructor(private filmsService: FilmsService){
        this.films = [];
    }

    ngOnInit(){
        this.films = this.filmsService.getFilmsTest();
        this.filmsService.getFilms().subscribe(films => {
            this.films = films});
    }

    onSelect(film: Film){
        this.selectedFilm = film;
        this.selectFilm.emit(film);

    }
}