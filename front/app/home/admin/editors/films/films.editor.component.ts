import {Component, DoCheck, OnChanges, OnInit} from '@angular/core';
import {Film} from "../../../../shared/entities/film";
import {EditorReloadService} from "../../../../shared/services/editors/editor.reload.service";
import {FilmsService} from "../../../../shared/services/films.service";

@Component({
    selector: 'film-editor',
    templateUrl: 'films.editor.component.html',
    styleUrls: ['films.editor.component.css']
})
export class FilmsEditorComponent implements OnChanges,OnInit{
    model: any = {};
    selectedFilm: Film;
    editorFilm: Film;

    constructor(private editorReloadService: EditorReloadService,
                private filmsService: FilmsService
    ){}

    ngOnInit(){
        this.editorFilm = new Film();
    }

    ngOnChanges(){
        this.editorFilm = new Film();
        if (this.selectedFilm){
            this.editorFilm = this.selectedFilm;
        }

    }

    selectFilm(film: Film){
        this.selectedFilm = film;
        this.ngOnChanges();
    }

    onSubmit(){
        if (this.model.createButton){
            this.filmsService.create(this.editorFilm).subscribe(res => {
                this.editorReloadService.reloadFilms();
            });
        } else if (this.model.editorButton){
            this.filmsService.update(this.editorFilm).subscribe(res => {
                this.editorReloadService.reloadFilms();
            });
        }

        this.editorFilm = new Film();
        this.model.createButton = false;
        this.model.editorButton = false;
    }

    onDelete(){
        this.filmsService.delete(this.selectedFilm).subscribe(res => {
            this.editorReloadService.reloadFilms();
            this.selectedFilm = null;
        });
    }
}