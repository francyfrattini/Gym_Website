import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  type: string = "pasword";
  isText: boolean = false;
  eyeIcon: string = "bi-eye-slash-fill";

  signupForm!: FormGroup
  constructor(private formBuilder: FormBuilder, private _http: HttpClient, private router: Router) { }


  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      name: [''],
      surname: [''],
      phone: [''],
      email: [''],
      password: [''],
      cpassword: [''],
    })
  }

  //----------------------------------- NASCONDI PASSWORD --------------------------------------

  hideShowPass() {
    this.isText = !this.isText;
    this.isText ? this.eyeIcon = "bi-eye" : this.eyeIcon = "bi-eye-slash-fill";
    this.isText ? this.type = "text" : this.type = "password";
  }

  //----------------------------------- CREA USER --------------------------------------

  signUp() {
    this._http.post<any>("http://localhost:3000/signup", this.signupForm.value).subscribe(res => {
      alert("Benvenuto in W.I.P. !!!");
      this.signupForm.reset();
      this.router.navigate(['/login']);
    }, err => {
      alert("Mi dispiace, non sei stato registrato")
    }
    )
  }
}
