import { Component, OnInit } from "@angular/core";
import { QuestionService } from "../question-service";

@Component({
    selector: 'question-item-list',
    templateUrl: './question-list.html'
})
export class QuestionListComponent implements OnInit{
    questionList: any;

    constructor(private questionService: QuestionService){};

    ngOnInit(){
        this.questionService.get()
        .subscribe(questionList => {
            this.questionList = questionList
        });
        console.log(this.questionList)
    }
}