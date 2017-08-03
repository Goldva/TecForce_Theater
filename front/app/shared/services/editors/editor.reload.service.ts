import { Injectable } from '@angular/core';
import {Subject} from "rxjs";

@Injectable()
export class EditorReloadService {
    private filmListReload = new Subject<string>();
    private hallListReload = new Subject<string>();
    private sessionListReload = new Subject<string>();
    private placeListReload = new Subject<string>();

    filmReload$ = this.filmListReload.asObservable();
    hallReload$ = this.hallListReload.asObservable();
    sessionReload$ = this.sessionListReload.asObservable();
    placeReload$ = this.placeListReload.asObservable();

    reloadFilms() {
        this.filmListReload.next();
    }

    reloadHalls(){
        this.hallListReload.next();
    }

    reloadSessions(){
        this.sessionListReload.next();
    }

    reloadPlace(){
        this.placeListReload.next();
    }
}
