import { Component, Input } from "@angular/core";


@Component({
    selector: "answer-item",
    templateUrl: "./answer.html"
})
export class AnswerComponent{
    @Input() answer = {
        id: 0,
        text: '',
        publishdate: '',
        votes: '',
        username: '',
        comments: []
    }
}