import {Component, Input, OnChanges} from '@angular/core';
import {Film} from "../../../shared/entities/film";
import {EditorReloadService} from "../../../shared/services/editors/editor.reload.service";
import {FilmsService} from "../../../shared/services/films.service";
import {Hall} from "../../../shared/entities/hall";
import {Place} from "../../../shared/entities/place";
import {HallService} from "../../../shared/services/hall.service";

@Component({
    selector: 'hall-editor',
    templateUrl: 'halls.editor.component.html',
    styleUrls: ['halls.editor.component.css']
})
export class HallsEditorComponent implements OnChanges{
    model: any = {};
    @Input() selectedHall: Hall;
    editorHall: Hall;

    constructor(private editorReloadService: EditorReloadService,
                private hallService: HallService
    ){}

    ngOnChanges(){
        this.editorHall = new Hall();
        this.model.countPlaces = '';
        if (this.selectedHall){
            this.editorHall = this.selectedHall;
            this.model.countPlaces = this.editorHall.places.length;
        }

    }

    selectPlace(place: Place){
        place.vipPlace = !place.vipPlace;
    }

    onSubmit(){
        if (this.model.createButton){
            this.hallService.create(this.editorHall).subscribe(res => {
                this.editorReloadService.reloadHalls();
            });
        } else if (this.model.editorButton){
            this.hallService.update(this.editorHall).subscribe(res => {
                this.editorReloadService.reloadHalls();
            });
        }

        this.editorHall = new Hall();
        this.model.createButton = false;
        this.model.editorButton = false;
    }

    onSubmitCountPlaces(){
        let places = new Set<Place>();
        for (let i = 0; i < this.model.countPlaces; i++){
            if (this.editorHall.places && this.editorHall.places.length > i){
                places.add(this.editorHall.places[i])
            } else {
                let place = new Place();
                place.place = i + 1;
                place.hallId = this.editorHall.id;
                place.vipPlace = false;
                places.add(place)
            }
        }
        this.editorHall.places = Array.from(places);
    }

    onDelete(){
        this.hallService.delete(this.selectedHall).subscribe(res => {
            this.editorReloadService.reloadHalls();
        });
    }
}