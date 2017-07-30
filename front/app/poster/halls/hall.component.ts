import {Component, Output, EventEmitter, Input} from '@angular/core';

import { Hall } from '../../shared/hall';

@Component({
    selector: 'hall-list',
    templateUrl: 'hall.component.html',
    styleUrls: ['hall.component.css']
})

export class HallComponent {
    @Output() selectHall = new EventEmitter();
    @Input() halls: Hall[];
    selectedHall: Hall;

    onSelect(hall: Hall){
        this.selectedHall = hall;
        this.selectHall.emit(hall);
    }

}