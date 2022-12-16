import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/classi/user';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  user: User = new User();

  constructor(private registerService: RegisterService) { }

  ngOnInit(): void {
  }

  userRegister(){
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(data => {
    alert("Benvenuto nel team W.I.P.!")
    },error=>alert("Errore nella registrazione"));
  }
}
