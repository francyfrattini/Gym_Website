import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  type: string = "pasword";
  isText: boolean = false;
  eyeIcon: string = "bi-eye-slash-fill";

  loginForm!: FormGroup;
  constructor( private formBuilder:FormBuilder, private _http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: [''],
      password: [''],
    })
  }

  //----------------------------------- NASCONDI PASSWORD --------------------------------------

  hideShowPass(){
    this.isText = !this.isText;
    this.isText ? this.eyeIcon = "bi-eye" : this.eyeIcon = "bi-eye-slash-fill";
    this.isText ? this.type = "text" : this.type = "password";
  }

  //----------------------------------- LOG IN --------------------------------------

  logIn(){
    this._http.get<any>("http://localhost:3000/signup").subscribe(res =>{
    const user = res.find((a:any)=>{
      return a.email === this.loginForm.value.email && a.password === this.loginForm.value.password;
    })
    if(user){
      alert("E' un piacere rivederti !");
      this.loginForm.reset();
      this.router.navigate(['/calendario']);
    }else{
      alert("Spiacenti, utente non trovato")
    }
  }) 
  }
  
}
