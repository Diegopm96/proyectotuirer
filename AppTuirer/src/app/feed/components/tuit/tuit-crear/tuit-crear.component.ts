import { Component } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Tuit } from 'src/app/feed/interfaces/tuit-interface';
import { FeedService } from 'src/app/feed/services/feed.service';

@Component({
  selector: 'app-tuit-crear',
  templateUrl: './tuit-crear.component.html',
  styleUrls: ['./tuit-crear.component.scss'],
})
export class TuitCrearComponent {
  constructor(private fededService: FeedService) {}

  contenido: any = '';

  obtenerTuits(): void {
    this.fededService.obtenerTuits().subscribe((tuits) => {
      console.log(tuits);
    });
  }

  // crearTuit(): void {
  //   console.log(this.contenido);
  //   let tuit:string = String(this.contenido)
  //   console.log(tuit)
  //   console.log(new Date().toLocaleString())
  //   this.fededService.crearTuit(tuit,2,new Date().toLocaleString())
  //   .subscribe()
  // }
  crearTuit() {
    console.log(this.contenido);
    console.log(new Date().toLocaleString());
    this.fededService
      .crearTuit(this.contenido, 2)
      .subscribe((response) => console.log(response));
  }
}
