import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { FormModel } from './cadastro/formmodel';

@Injectable({
  providedIn: 'root'
})
export class HttpMeiService {

  url:string = environment.urlViabilidadeMei

  constructor(
    private http: HttpClient
  ) { }

  putRequest(body: FormModel): Observable<any>{
    return this.http.put(`${this.url}/${body.id}`, body)
    .pipe(
      catchError(this.handleError)
    );
  }

  postRequest(body: FormModel): Observable<any> {
    return this.http.post(`${this.url}`, body)
    .pipe(
      catchError(this.handleError)
    );
  }

  handleError(error: HttpErrorResponse) {
    if(error.error instanceof ErrorEvent){  //tratemento de erro relacionado ao client-side ou internet
      console.error('Ocorreu um erro: ' + error.error.message);      
    } else {
      console.error(
        `Backend retornou o codigo ${error.status},` +
        `Body: ${error.error}`
      );
    }
    return throwError(()=> new Error('Algo errado aconteceu, por favor tente novamente depois.'))
  } 

}
