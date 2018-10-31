import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterMComponent } from './register-m.component';

describe('RegisterMComponent', () => {
  let component: RegisterMComponent;
  let fixture: ComponentFixture<RegisterMComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterMComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterMComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
