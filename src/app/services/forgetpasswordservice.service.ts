import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { catchError, config, Observable, throwError } from 'rxjs';
import { User } from '../entities/user';


@Injectable({
  providedIn: 'root'
})
export class ForgetpasswordService{
  
  userDetails!:User;
  constructor(private httpClient: HttpClient) { }
 
  forgetPassword(data:User):Observable<User>{
   email:data.email
    return this.httpClient.post<User>("http://localhost:9004/password/forgot-password",data).pipe(catchError(this.errorHandler1))
   
  } 
  /*errorHandler(error:HttpErrorResponse){

  return throwError('username might not be correct');
  }*/

////new changes for reference

  // changePassword(user:User):Observable<String>
  // {
  //   return this.httpClient.post<String>("http://localhost:9004/password/change-password",user)
  //   .pipe( catchError(this.errorHandler));
  // }
  errorHandler1(error:any)
  {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
      console.log("hello from serviceup"+errorMessage)

    } else {
      // Get server-side error
      errorMessage = `${error.status}`;
      console.log("hello from servicedown"+errorMessage)
    }
    if(errorMessage==="200")
    {
    window.alert("Password Successfully forget");
    
    }
    else{
      window.alert("username is not correct")
    }
    return throwError(errorMessage);

  }
 }

