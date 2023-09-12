import { Component, OnInit } from "@angular/core";
import { QuestionService } from "../question-service";
import { AppRoutingModule } from "src/app/app-routing.module";
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'question-details',
    templateUrl: './question-details.html'
})
export class QuestionDetailsComponent implements OnInit{
    question: any

    constructor(private questionService: QuestionService, private route: ActivatedRoute){}

    ngOnInit(): void {
        let id = this.route.snapshot.params['id'];
        this.questionService.get(id)
        .subscribe(question => {
                this.question = question
            }
        );
    }
}