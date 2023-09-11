import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, throwError } from "rxjs";

@Injectable()
export class QuestionService{
    questionList = [{}]

    constructor(private http: HttpClient){}

    get(){
        return this.http.get<QuestionItemResponse>('http://localhost:9000/questions')
        .pipe(catchError(this.handleError));
    }

    add(item: any){
        item.tags = []
        return this.http.post('http://localhost:9000/questions', item).subscribe()
    }
    private handleError(error: HttpErrorResponse){
        console.log(error.message)
        return throwError('Backend issue!')
    }
}

interface QuestionItem{
    id: number,
    title: string,
    description: string,
    tags: string[],
    publishdate: string,
    askedby: string,
    answercount: number,
    votes: number
}

interface QuestionItemResponse{
    questionList: QuestionItem[] 
}