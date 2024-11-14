import { Component, Input, OnInit } from '@angular/core';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { heroUsers, heroUser } from '@ng-icons/heroicons/outline';
import { ButtonText, ButtonType, Variant, IconName } from './button.types';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [NgIconComponent],
  providers: [provideIcons({ heroUsers, heroUser })],
  templateUrl: './button.component.html',
  styleUrl: './button.component.scss',
})
export class ButtonComponent implements OnInit {
  @Input() text?: ButtonText;
  @Input() iconName?: IconName;
  @Input() type: ButtonType = 'button';
  @Input() variant: Variant = 'pill';

  buttonClasses!: string;

  ngOnInit() {
    this.buttonClasses = `app-button ${this.variant}`;
  }
}
