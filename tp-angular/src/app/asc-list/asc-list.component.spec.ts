import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AscListComponent } from './asc-list.component';

describe('AscListComponent', () => {
  let component: AscListComponent;
  let fixture: ComponentFixture<AscListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AscListComponent]
    });
    fixture = TestBed.createComponent(AscListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
