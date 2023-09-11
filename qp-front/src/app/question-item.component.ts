import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
    selector: 'question-item',
    templateUrl: './question-item.component.html',
    styleUrls: ['./question-item.component.css']
})
export class QuestionItemComponent{
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