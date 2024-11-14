import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormGroupDirective,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ButtonComponent } from '../../../../shared/components/button/button.component';
import { InputComponent } from '../../../../shared/components/input/input.component';

@Component({
  selector: 'app-edit-profile',
  standalone: true,
  imports: [ReactiveFormsModule, ButtonComponent, InputComponent],
  templateUrl: './edit-profile.component.html',
  styleUrl: './edit-profile.component.scss',
})
export class EditProfileComponent {
  userForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.userForm = this.fb.group({
      username: [{ value: '', disabled: true }, Validators.required],
      name: ['', Validators.required],
      surname: ['', Validators.required],
      email: ['', Validators.required],
    });
  }

  inputError(controlName: string, form: FormGroupDirective): boolean {
    const control = this.userForm.get(controlName);
    return control
      ? control.invalid && (control.touched || form.submitted)
      : false;
  }

  onChangePassword(event: Event) {
    event.preventDefault();
    console.log('Change password');
  }

  onSubmit() {
    console.log(this.userForm.value);
  }
}
