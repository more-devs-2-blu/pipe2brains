import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IptuViabilidadeModel } from './cadastro/iptuviabilidade';

@Injectable({
  providedIn: 'root'
})
export class HttpIptuService {

  url:string = environment.urlConsultaIptu

  constructor(
    private http: HttpClient
  ) { }

  getRequest(cadIPTU: string,): Observable<any> {
    return this.http.get(`${this.url}/${cadIPTU}`)
    .pipe(
      catchError(this.handleError)
    );
  }

  postRequest(body: IptuViabilidadeModel): Observable<any> {
    return this.http.post(`${this.url}/`, body)
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
