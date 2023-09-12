import { Component } from '@angular/core';

@Component({
  selector: 'askdev-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'askdev-front';

  firstQuestion = {
    id: 1,
    title: 'question 1',
    description: 'simple description',
    votes: 5
  }

  onQuestionDelete(event=''){
    console.log("Questiondelete from app-component")
  }
}
