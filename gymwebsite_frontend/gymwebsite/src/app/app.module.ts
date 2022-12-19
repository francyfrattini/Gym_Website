import { MbscModule } from '@mobiscroll/angular';
import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './sharepage/footer/footer.component';
import { ChiSiamoComponent } from './pages/chi-siamo/chi-siamo.component';
import { ServiziComponent } from './pages/servizi/servizi.component';
import { ContattiComponent } from './pages/contatti/contatti.component';
import { LogInComponent } from './pages/log-in/log-in.component';
import { AlessandroComponent } from './pages/alessandro/alessandro.component';
import { ClaudioComponent } from './pages/claudio/claudio.component';
import { FrancescaComponent } from './pages/francesca/francesca.component';
import { MicheleComponent } from './pages/michele/michele.component';
import { DieteComponent } from './pages/Calendario/diete.component';
import { NavbarComponent } from './sharepage/navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './pages/signup/signup.component';


@NgModule({
    declarations: [
        AppComponent,
        FooterComponent,
        NavbarComponent,
        ChiSiamoComponent,
        ServiziComponent,
        ContattiComponent,
        DieteComponent,
        LogInComponent,
        AlessandroComponent,
        ClaudioComponent,
        FrancescaComponent,
        MicheleComponent,
        SignupComponent,
    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [ 
    MbscModule,
        BrowserModule,
        AppRoutingModule,
        NgbModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        HttpClientJsonpModule,
        BrowserModule,
    ],
    schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
