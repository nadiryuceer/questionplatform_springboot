import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { QuestionService } from "../../question.service";
import { Router } from "@angular/router";

@Component({
    selector: 'new-question',
    templateUrl: './new-question.html'
})
export class NewQuestionComponent implements OnInit{
    form: FormGroup = new FormGroup('');

    constructor(private questionService: QuestionService, private router: Router){}

    ngOnInit(): void {
        this.form = new FormGroup({
            title: new FormControl('', Validators.required),
            description: new FormControl('',Validators.required),
            username: new FormControl('',Validators.required)
        })
    }

    onSubmit(questionItem: any){
        this.questionService.add(questionItem).subscribe(id => {
            this.router.navigateByUrl(`/questions/${id}/details`)
        });
    }
}