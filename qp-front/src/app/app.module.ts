import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuestionItemComponent } from './question-item.component';
import { QuestionItemListComponent } from './question-item-list.component';
import { QuestionItemFormComponent } from './question-item-form.component';
import { QuestionService } from 'src/service/question-service';

@NgModule({
  declarations: [
    AppComponent,
    QuestionItemComponent,
    QuestionItemListComponent,
    QuestionItemFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    QuestionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
