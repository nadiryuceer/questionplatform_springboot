import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class AnswerService{

    constructor(private http: HttpClient){}

    add(answer:any, qid:any){
        this.http.post(`http://localhost:9000/questions/${qid}/answers`, answer).subscribe()
    }
}