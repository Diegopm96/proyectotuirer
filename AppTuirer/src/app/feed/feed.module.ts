import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TuitCrearComponent } from './components/tuit/tuit-crear/tuit-crear.component';
import { TuitMostrarComponent } from './components/tuit/tuit-mostrar/tuit-mostrar.component';
// PrimeNg
import { InputTextareaModule } from 'primeng/inputtextarea';
import { ButtonModule } from 'primeng/button';
@NgModule({
  declarations: [TuitCrearComponent, TuitMostrarComponent],
  imports: [
    CommonModule,
    FormsModule,
    // PrimeNg
    InputTextareaModule,
    ButtonModule,
  ],
  exports: [TuitCrearComponent],
})
export class FeedModule {}
