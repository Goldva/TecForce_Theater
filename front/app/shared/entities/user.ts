import {Role} from "./Role";
export class User{
    public id: number;
    public username: string;
    public password: string;
    public birthday: string;
    public roleId: number;
    public role: Role;
}