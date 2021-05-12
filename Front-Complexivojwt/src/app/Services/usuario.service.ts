import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../Models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  URL = "http://localhost:9898/"
  httpHeader: any;
  constructor(private httpClient: HttpClient) {
    this.httpHeader = new HttpHeaders({
      Authorization: localStorage.getItem('token')
    });
  }

  login(username: string, password: string): Observable<Usuario>{
    return this.httpClient.get<Usuario>(this.URL+'login/'+username+'/'+password);
  }

  getUsuarios(): Observable<Usuario[]>{
    return this.httpClient.get<Usuario[]>(this.URL + "listar-usuarios", {headers: this.httpHeader});
  }
}
