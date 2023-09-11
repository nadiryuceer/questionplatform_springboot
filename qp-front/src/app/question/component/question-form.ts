import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { QuestionService } from "../question-service";

@Component({
    selector: 'question-form',
    templateUrl: './question-form.html'
})
export class QuestionFormComponent implements OnInit{
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