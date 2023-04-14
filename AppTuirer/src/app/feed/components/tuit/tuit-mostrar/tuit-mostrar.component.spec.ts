import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TuitMostrarComponent } from './tuit-mostrar.component';

describe('TuitMostrarComponent', () => {
  let component: TuitMostrarComponent;
  let fixture: ComponentFixture<TuitMostrarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TuitMostrarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TuitMostrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
