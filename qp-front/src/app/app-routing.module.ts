import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRegisterComponent } from './user/component/user-register';
import { QuestionListComponent } from './question/component/question-list';

const routes: Routes = [
  { path: 'register', component: UserRegisterComponent },
  { path: 'all' , component: QuestionListComponent },
  { path: '', redirectTo: 'all', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
