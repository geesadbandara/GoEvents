import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrontendCliComponent } from './frontend-cli.component';

describe('FrontendCliComponent', () => {
  let component: FrontendCliComponent;
  let fixture: ComponentFixture<FrontendCliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FrontendCliComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FrontendCliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
