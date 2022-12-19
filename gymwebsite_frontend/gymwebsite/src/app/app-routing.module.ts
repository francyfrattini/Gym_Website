import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlessandroComponent } from './pages/alessandro/alessandro.component';
import { ChiSiamoComponent } from './pages/chi-siamo/chi-siamo.component';
import { ClaudioComponent } from './pages/claudio/claudio.component';
import { ContattiComponent } from './pages/contatti/contatti.component';
import { DieteComponent } from './pages/calendario/diete.component';
import { FrancescaComponent } from './pages/francesca/francesca.component';
import { HomeComponent } from './pages/home/home.component';
import { LogInComponent } from './pages/log-in/log-in.component';
import { MicheleComponent } from './pages/michele/michele.component';
import { ServiziComponent } from './pages/servizi/servizi.component';
import { SignupComponent } from './pages/signup/signup.component';
import { CalendarioComponent } from './pages/calendario/calendario.component';
import { CalendarionologComponent } from './pages/calendarionolog/calendarionolog.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'chi-siamo', component:ChiSiamoComponent},
  {path:'contatti', component:ContattiComponent},
  {path:'diete', component:DieteComponent},
  {path:'log-in', component:LogInComponent},
  {path:'servizi', component:ServiziComponent},
  {path:'alessandro', component:AlessandroComponent},
  {path:'claudio', component:ClaudioComponent},
  {path:'francesca', component:FrancescaComponent},
  {path:'michele', component:MicheleComponent},
  {path:'signup', component:SignupComponent},
  {path:'calendario', component:CalendarioComponent},
  {path:'calendarionolog', component:CalendarionologComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
