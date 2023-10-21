import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, throwError } from "rxjs";

@Injectable()
export class QuestionService{
    questionList = [{}]

    constructor(private http: HttpClient){}

    getAll(){
        return this.http.get<QuestionItemResponse>('http://localhost:9000/questions')
        .pipe(catchError(this.handleError));
    }

    get(id: number){
        return this.http.get<QuestionDetailsItem>(`http://localhost:9000/questions/${id}`)
    }

    add(item: QuestionAddItem){
        item.tags = []
        return this.http.post('http://localhost:9000/questions', item)
    }
    private handleError(error: HttpErrorResponse){
        console.log(error.message)
        return throwError('Backend issue!')
    }
}

interface QuestionDetailsItem{
    title: string,
    description: string,
    tags: string[],
    publishdate: string,
    username: string,
    votes: number,
    views: number
    comments: CommentItem[]
    answers: AnswerItem[]
}

interface CommentItem{
    id: number,
    text: string,
    publishdate: string,
    votes: number,
    username: string
}

interface AnswerItem extends CommentItem{
    comments: CommentItem[]
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

interface QuestionAddItem{
    title: string,
    description: string,
    username: string,
    tags: string[]
}