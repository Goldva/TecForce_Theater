import {Film} from "./film";
import {Session} from "./session";
import {Hall} from "./hall";
import {Place} from "./place";
export class Ticket{
    userId: number;
    sessionId: number;
    hallId: number;
    placeId: number;
    price: number;
    is6ThTicket: boolean;
    is10ThTicket: boolean;
    stocksList: String[];

    film: Film;
    session: Session;
    hall: Hall;
    place: Place;
}