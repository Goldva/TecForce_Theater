import {Hall} from "./hall";
import DateTimeFormat = Intl.DateTimeFormat;
export class Session{
    public id: number;
    public filmId: number;
    public time: string;
    public halls: Hall[];
}