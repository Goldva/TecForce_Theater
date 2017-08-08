import {Component, DoCheck, OnChanges, OnInit} from '@angular/core';
import {EditorReloadService} from "../../../../shared/services/editors/editor.reload.service";
import {Session} from "../../../../shared/entities/session";
import {SessionsService} from "../../../../shared/services/session.service";
import {Film} from "../../../../shared/entities/film";
import {HallService} from "../../../../shared/services/hall.service";
import {Hall} from "../../../../shared/entities/hall";
import {DatePipe} from "@angular/common";
import {DateFormatter} from "@angular/common/src/pipes/intl";

@Component({
    selector: 'sessions-editor',
    templateUrl: 'sessions.editor.component.html',
    styleUrls: ['sessions.editor.component.css']
})
export class SessionsEditorComponent implements OnChanges,OnInit{
    model: any = {};
    selectedSession: Session;
    editorSession: Session;

    halls: Hall[];
    selectedHalls = new Set<Hall>();

    constructor(private editorReloadService: EditorReloadService,
                private hallService: HallService,
                private sessionsService: SessionsService
    ){}

    ngOnInit(){
        this.editorSession = new Session();
        this.reload();
    }

    reload(){
        // this.halls = this.hallService.getHallTest();
        this.hallService.getHall().subscribe(halls => {this.halls = halls});
    }

    ngOnChanges(){
        this.editorSession = new Session();
        if (this.selectedSession){
            this.editorSession = this.selectedSession;
        }
    }

    selectFilm(film: Film){
        this.selectedSession.filmId = film.id;
    }

    selectSession(session: Session){
        this.selectedSession = session;
        this.selectedHalls = new Set(this.selectedSession.halls);
        this.ngOnChanges();
    }

    selectHalls(hall: Hall){
        if (this.selectedHalls.has(hall)){
            this.selectedHalls.delete(hall)
        } else {
            this.selectedHalls.add(hall);
        }
        console.log(this.editorSession.halls);
        console.log(this.selectedHalls);

    }


    onSubmit(){
        this.editorSession.halls = Array.from(this.selectedHalls);
        if (this.editorSession.time.length === 5){
            this.editorSession.time += ':00';
        }
        if (this.model.createButton){
            console.log(this.editorSession);
            this.sessionsService.create(this.editorSession).subscribe(res => {
                this.editorReloadService.reloadSessions();
            });
        } else if (this.model.editorButton){
            this.sessionsService.update(this.editorSession).subscribe(res => {
                this.editorReloadService.reloadSessions();
            });
        }

        this.selectedHalls.clear();
        this.editorSession = new Session();
        this.model.createButton = false;
        this.model.editorButton = false;
    }

    onDelete(){

        this.sessionsService.delete(this.selectedSession).subscribe(res => {
            this.editorReloadService.reloadSessions();
        });
        this.selectedHalls.clear();
        this.selectedSession = null;
    }
}