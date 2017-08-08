import { Component, Input, Output, OnChanges, EventEmitter } from '@angular/core';

import { Session } from '../../shared/entities/session'
import {SessionsService} from "../../shared/services/session.service";
import {Film} from "../../shared/entities/film";
import {EditorReloadService} from "../../shared/services/editors/editor.reload.service";

@Component({
    selector: 'sessions-list',
    templateUrl: "sessions-list.component.html",
    styleUrls: ['sessions-list.component.css']
})

export class SessionsListComponent implements OnChanges{
    title = "Сеансы";
    @Output() selectSession = new EventEmitter();
    sessions: Session[];
    @Input() film: Film;
    selectedSession: Session;

    constructor(private sessionService: SessionsService,
                private editorReloadService: EditorReloadService
    ){}

    ngOnInit(){
        this.editorReloadService.sessionReload$.subscribe(session => {
            this.reload();
        });
        this.reload();
    }

    ngOnChanges(){
        this.reload();
    }

    reload(){
        // this.sessions = this.sessionService.getFilmSessionsTest();
        if (this.film) {
            this.sessionService.postSearchSessionsForFilm(this.film).subscribe(sessions => {this.sessions = sessions});
        } else {
            this.sessionService.getSessions().subscribe(sessions => {this.sessions = sessions})
        }
    }


    onSelect(session: Session){
        if (this.selectedSession === session) {
            this.selectedSession = undefined;
        } else {
            this.selectedSession = session;
        }
        this.selectSession.emit(this.selectedSession);
    }


}