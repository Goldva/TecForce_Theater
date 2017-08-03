import { NgModule }      from '@angular/core';
import {ListWithDataModule} from "../../../lists-with-data/list.with.data.module";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HallsEditorComponent} from "./halls.editor.component";



@NgModule({
    imports: [
        BrowserModule,
        ListWithDataModule,
        FormsModule
    ],
    declarations: [
        HallsEditorComponent
    ],
    exports: [
        HallsEditorComponent
    ]

})

export class HallsEditorModule{}
