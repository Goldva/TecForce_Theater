import { Component, OnInit } from '@angular/core';

import { Film } from  '../shared/film';
import { FilmsService } from '../shared/films.service';

@Component({
    selector: 'table-film',
    templateUrl: 'table-films.component.html',
    styleUrls: ['table-films.component.css']
})
export class TableFilmsComponent implements OnInit{
    films: Film[];

    constructor(private filmsService: FilmsService){
        this.films = [];
    }

    ngOnInit(){
        // this.films = this.filmsService.getFilmsTest();
        this.filmsService.getFilms().subscribe(films => {
            this.films = films});
    }
}