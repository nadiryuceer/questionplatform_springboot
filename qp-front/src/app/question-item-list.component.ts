import { Component, OnInit } from "@angular/core";
import { QuestionService } from "src/service/question-service";

@Component({
    selector: 'question-item-list',
    templateUrl: './question-item-list.component.html'
})
export class QuestionItemListComponent implements OnInit{
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