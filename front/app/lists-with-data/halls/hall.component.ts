import {Component, Output, EventEmitter, Input, OnInit, OnChanges} from '@angular/core';

import { Hall } from '../../shared/entities/hall';
import {HallService} from "../../shared/services/hall.service";
import {Session} from "../../shared/entities/session";
import {EditorReloadService} from "../../shared/services/editors/editor.reload.service";

@Component({
    selector: 'hall-list',
    templateUrl: 'hall.component.html',
    styleUrls: ['hall.component.css']
})

export class HallComponent implements OnInit, OnChanges{
    title = "Залы";
    @Output() selectHall = new EventEmitter();
    @Input() session: Session;
    halls: Hall[];
    selectedHall: Hall;

    constructor(
        private hallService: HallService,
        private editorReloadService: EditorReloadService
    ){
        this.halls = [];
    }

    ngOnInit(){
        this.editorReloadService.hallReload$.subscribe(film => {
            this.reload();
        });
        this.reload();
    }

    ngOnChanges(){
        this.reload();
    }

    reload(){
        // this.halls = this.hallService.getHallTest();
        if (this.session) {
            this.hallService.postSearchHallsForSession(this.session).subscribe(halls => {this.halls = halls});
        }else {
            this.hallService.getHall().subscribe(halls => {this.halls = halls});
        }
    }

    onSelect(hall: Hall){
        if (this.selectedHall === hall) {
            this.selectedHall = undefined;
        } else {
            this.selectedHall = hall;
        }
        this.selectHall.emit(this.selectedHall);
    }

}