import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpCpfService {

  url = 'http://localhost:8080/consultacpf'

  constructor(
    private http: HttpClient
  ) { }

  getRequest(cpf: string): Observable<any> {
    return this.http.get(`${this.url}/${cpf}`)
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
