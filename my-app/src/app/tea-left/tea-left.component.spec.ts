import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeaLeftComponent } from './tea-left.component';

describe('TeaLeftComponent', () => {
  let component: TeaLeftComponent;
  let fixture: ComponentFixture<TeaLeftComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeaLeftComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeaLeftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
