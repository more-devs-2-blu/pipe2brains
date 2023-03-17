import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelarecaptchaComponent } from './telarecaptcha.component';

describe('TelarecaptchaComponent', () => {
  let component: TelarecaptchaComponent;
  let fixture: ComponentFixture<TelarecaptchaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelarecaptchaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TelarecaptchaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
