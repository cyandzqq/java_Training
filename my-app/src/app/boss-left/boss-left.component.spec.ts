import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BossLeftComponent } from './boss-left.component';

describe('BossLeftComponent', () => {
  let component: BossLeftComponent;
  let fixture: ComponentFixture<BossLeftComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BossLeftComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BossLeftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
