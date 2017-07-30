import {Component, Output, EventEmitter, Input} from "@angular/core";

import {Place} from "../../shared/place";

@Component({
    selector: 'places-list',
    templateUrl: 'places-list.component.html',
    styleUrls: ['places-list.component.css']
})

export class PlacesListComponent{
    @Output() selectPlace = new EventEmitter();
    @Input() places: Place[];

    selectedPlaces = new Set<Place>();

    onSelect(place: Place){
        if (this.selectedPlaces.has(place)){
            this.selectedPlaces.delete(place)
        } else {
            this.selectedPlaces.add(place);
        }
        this.selectPlace.emit(place);
    }
}