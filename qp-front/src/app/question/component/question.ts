import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
    selector: 'question-item',
    templateUrl: './question.html',
    styleUrls: ['./question.css']
})
export class QuestionComponent{
    @Input() questionItem = {
        id: 0,
        title: '',
        description: '',
        tags: [''],
        publishdate: '',
        askedby: '',
        answercount: 0,
        votes: 0
    };

    @Output() delete = new EventEmitter();

    onDelete(){
        console.log('Delete clicked');
        this.delete.emit(this.questionItem);
    }
}