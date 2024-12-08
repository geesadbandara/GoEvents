import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideMenueBarComponent } from './side-menue-bar.component';

describe('SideMenueBarComponent', () => {
  let component: SideMenueBarComponent;
  let fixture: ComponentFixture<SideMenueBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SideMenueBarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SideMenueBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
