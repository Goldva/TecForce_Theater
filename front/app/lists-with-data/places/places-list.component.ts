import {Component, Output, OnChanges, EventEmitter, Input, DoCheck, AfterContentChecked} from "@angular/core";

import {Place} from "../../shared/entities/place";
import {PlaceService} from "../../shared/services/place.service";
import {Hall} from "../../shared/entities/hall";

@Component({
    selector: 'places-list',
    templateUrl: 'places-list.component.html',
    styleUrls: ['places-list.component.css']
})

export class PlacesListComponent implements DoCheck{
    title = "Места";
    @Output() selectPlace = new EventEmitter();
    @Input() hall: Hall;
    places: Place[];

    selectedPlaces = new Set<Place>();

    constructor(){
        this.places = [];
    }

    ngDoCheck(){
        this.reload();
    }

    reload(){
        this.places = this.hall.places;
    }

    onSelect(place: Place){
        if (this.selectedPlaces.has(place)){
            this.selectedPlaces.delete(place)
        } else {
            this.selectedPlaces.add(place);
        }
        this.selectPlace.emit(place);
    }
}