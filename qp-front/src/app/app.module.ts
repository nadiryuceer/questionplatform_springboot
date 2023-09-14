import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuestionComponent } from './question/component/all/question';
import { QuestionListComponent } from './question/component/all/question-list';
import { QuestionService } from 'src/app/question/question.service';
import { UserRegisterComponent } from './user/component/user-register';
import { UserService } from './user/user-service';
import { QuestionDetailsComponent } from './question/component/onewithdetails/question-details';
import { AnswerComponent } from './question/component/onewithdetails/answer';
import { CommentComponent } from './question/component/onewithdetails/comment';
import { NewQuestionComponent } from './question/component/new/new-question';
import { AnswerService } from './question/answer.service';

@NgModule({
  declarations: [
    AppComponent,
    QuestionComponent,
    QuestionListComponent,
    UserRegisterComponent,
    QuestionDetailsComponent,
    AnswerComponent,
    CommentComponent,
    NewQuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    QuestionService,
    UserService,
    AnswerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
