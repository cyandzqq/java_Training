import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StuLeftComponent } from './stu-left.component';

describe('StuLeftComponent', () => {
  let component: StuLeftComponent;
  let fixture: ComponentFixture<StuLeftComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StuLeftComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StuLeftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
