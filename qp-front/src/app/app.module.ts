import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuestionComponent } from './question/component/question';
import { QuestionListComponent } from './question/component/question-list';
import { QuestionFormComponent } from './question/component/question-form';
import { QuestionService } from 'src/app/question/question-service';
import { UserRegisterComponent } from './user/component/user-register';
import { RouterModule } from '@angular/router';
import { UserService } from './user/user-service';

@NgModule({
  declarations: [
    AppComponent,
    QuestionComponent,
    QuestionListComponent,
    QuestionFormComponent,
    UserRegisterComponent,
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
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
