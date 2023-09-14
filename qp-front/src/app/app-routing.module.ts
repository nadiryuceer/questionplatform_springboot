import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRegisterComponent } from './user/component/user-register';
import { QuestionListComponent } from './question/component/all/question-list';
import { QuestionDetailsComponent } from './question/component/onewithdetails/question-details';
import { NewQuestionComponent } from './question/component/new/new-question';

const routes: Routes = [
  { path: 'register', component: UserRegisterComponent },
  { path: 'questions/add', component: NewQuestionComponent },
  { path: 'questions/all' , component: QuestionListComponent },
  { path: 'questions/:id/details', component: QuestionDetailsComponent},
  { path: '', redirectTo: 'questions/all', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  static getRoutes(){
    return routes;
  }
}
