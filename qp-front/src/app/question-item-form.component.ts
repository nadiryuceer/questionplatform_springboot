import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { QuestionItemComponent } from "./question-item.component";
import { QuestionService } from "src/service/question-service";

@Component({
    selector: 'question-form',
    templateUrl: './question-item-form.component.html'
})
export class QuestionItemFormComponent implements OnInit{
    form: FormGroup = new FormGroup('');

    constructor(private questionService: QuestionService){}

    ngOnInit(): void {
        this.form = new FormGroup({
            title: new FormControl('', Validators.required),
            description: new FormControl('',Validators.required),
            username: new FormControl('',Validators.required)
        })
    }

    onSubmit(questionItem: any){
        this.questionService.add(questionItem);
    }
}