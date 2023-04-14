import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Tuit } from '../interfaces/tuit-interface';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class FeedService {
  private url: string = 'http://localhost:8080/api';
  constructor(private http: HttpClient) {}

  obtenerTuits(): Observable<Tuit[]> {
    const url = this.url + '/tuits';
    console.log(url);
    return this.http.get<Tuit[]>(url);
  }

  crearTuit(contenido: string, idUsuario: number) {
    const url = this.url + '/tuit';
    const tuit: Tuit = {
      id: undefined,
      contenido: contenido,
      usuario: {
        id: idUsuario,
      },
    };
    return this.http.post<any>(url, tuit);
  }
}
