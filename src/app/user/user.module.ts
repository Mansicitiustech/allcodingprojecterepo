import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientRegistrationComponent } from './patient-registration/patient-registration.component';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';

import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { DesignComponent } from './design/design.component';
import { MatCardModule } from '@angular/material/card';
import { LoginregistrationHomepageComponent } from './loginregistration-homepage/loginregistration-homepage.component';
import { RouterModule, Routes } from '@angular/router';
import { SavedialogComponent } from './savedialog/savedialog.component';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AfterRegLendingPageComponent } from './after-reg-lending-page/after-reg-lending-page.component';
import { DefaultComponent } from './default/default.component';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { AuthGuard } from '../auth.guard';

const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
  },
  {
    path: 'patient-registration',
    component: PatientRegistrationComponent,
  },
  {
    path: 'design/:email',
    component: DesignComponent,
  },
  {
    path: 'loginregistration-homepage',
    component: LoginregistrationHomepageComponent,
    
  },
  {
    path: 'afterreg-lendingpage',
    component: AfterRegLendingPageComponent,
  },
  {
    path: 'forget',
    component: ForgetpasswordComponent,
  },
  { path: 'shared/', redirectTo: '/shared', pathMatch: 'full' },
  {
    path: 'shared',
    canActivate:[AuthGuard],
    loadChildren: () =>
      import('src/app/shared/shared.module').then((m) => m.SharedModule),
  },
];

@NgModule({
  declarations: [
    PatientRegistrationComponent,
    DesignComponent,
    LoginregistrationHomepageComponent,
    SavedialogComponent,
    AfterRegLendingPageComponent,
    DefaultComponent,
    ForgetpasswordComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    FlexLayoutModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatCardModule,
    MatDialogModule,
    MatIconModule,
    MatToolbarModule,
    RouterModule.forChild(routes),
    MatButtonModule,
  ],
  exports: [
    PatientRegistrationComponent,
    DesignComponent,
    LoginregistrationHomepageComponent,
    SavedialogComponent,
    AfterRegLendingPageComponent,
  ],
})
export class UserModule {}
