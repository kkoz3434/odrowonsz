import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllUserGroupsComponent } from './all-user-groups.component';

describe('AllUserGroupsComponent', () => {
  let component: AllUserGroupsComponent;
  let fixture: ComponentFixture<AllUserGroupsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllUserGroupsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllUserGroupsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
