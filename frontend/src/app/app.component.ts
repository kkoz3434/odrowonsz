import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './core/auth/pages/login/login.component';
import { ButtonComponent } from './shared/components/button/button.component';
import { RegisterComponent } from './core/auth/pages/register/register.component';
import { EditProfileComponent } from './features/user/pages/edit-profile/edit-profile.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    LoginComponent,
    ButtonComponent,
    RegisterComponent,
    EditProfileComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'frontend';
}
