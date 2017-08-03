import {Place} from "./place";
export class Hall {
    public id: number;
    public hallName: string;
    public ratioOrdinaryPlace: number;
    public ratioVipPlace: number;
    public vipPrice: number;
    public ordinaryPrice: number;
    public places: Place[];
}
