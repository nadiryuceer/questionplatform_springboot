import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class UserService{
    constructor(private http: HttpClient){}

    register(item: any){
        this.http.post('http://localhost:9000/users', item).subscribe()
    }

}