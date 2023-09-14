import { Component, OnInit } from "@angular/core";
import { QuestionService } from "../../question.service";
import { AppRoutingModule } from "src/app/app-routing.module";
import { ActivatedRoute } from '@angular/router';
import { FormControl, FormGroup } from "@angular/forms";
import { AnswerService } from "../../answer.service";

@Component({
    selector: 'question-details',
    templateUrl: './question-details.html'
})
export class QuestionDetailsComponent implements OnInit{
    question: any
    form: FormGroup = new FormGroup('')

    constructor(private questionService: QuestionService, 
                private route: ActivatedRoute,
                private answerService: AnswerService){}

    
    ngOnInit(): void {
        let id = this.route.snapshot.params['id'];
        this.form = new FormGroup({
            text: new FormControl('')
        })
        this.questionService.get(id)
        .subscribe(question => {
                this.question = question
            }
        );
    }

    addAnswer(text:string){
        let item = {
            text: text,
            username: 'Terminator'
        }
        this.answerService.add(item, this.question.id)
        window.location.reload()
    }
}