import { NgModule } from '@angular/core';
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
import { DieteComponent } from './pages/diete/diete.component';
import { NavbarComponent } from './sharepage/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

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
        DieteComponent,
    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgbModule,
        FormsModule,
        HttpClientModule
    ]
})
export class AppModule { }
