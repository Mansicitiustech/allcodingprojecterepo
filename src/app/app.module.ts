import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DefaultComponent } from './shared/default/default.component';
import { Routes, RouterModule } from '@angular/router';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
// import { UserModule } from 'src/app/user/user.module';
import { UserModule } from './user/user.module';


const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
    children: [
      {
        path: 'nurse',

        loadChildren: () =>
          import('./nurse/nurse.module').then((m) => m.NurseModule),
      },
      {
        path: 'patient',

        loadChildren: () =>
          import('src/app/patient/patient.module').then((m) => m.PatientModule),
      },

      {
        path: 'shared',
        loadChildren: () =>
          import('./shared/shared.module').then((m) => m.SharedModule),
      },
      {
        path: 'doctor',
        loadChildren: () =>
          import('./doctor/doctor.module').then((m) => m.DoctorModule),
      },
      {
        path: 'scheduling',
        loadChildren: () =>
          import('src/app/scheduling/scheduling.module').then(
            (m) => m.SchedulingModule
          ),
      },
      {
        path: 'admin',
        loadChildren: () =>
          import('./admin/admin.module').then((m) => m.AdminModule),
      },
      {
        path: 'user',
        loadChildren: () =>
          import('src/app/user/user.module').then((m) => m.UserModule),
      },
    ],
  },
];

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
    UserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
=======
>>>>>>> 97be0521fc24c70d1891d419f71c687dec3219ae
>>>>>>> 83160e3ff6de1d6654831e4d81bd50eb82f100c4

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { RouterModule, Routes } from '@angular/router';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';
import { FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
// import { SideNavComponent } from './side-nav/side-nav.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDividerModule } from '@angular/material/divider';
import { MatMenuModule } from '@angular/material/menu';
// import { DashboardComponent } from './dashboard/dashboard.component';
import { FlexLayoutModule } from '@angular/flex-layout';

import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { TagsComponent } from './tags/tags.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { FoodpageComponent } from './foodpage/foodpage.component';
import { NotFoundComponent } from './not-found/not-found.component';
//import { MatRadioModule } from '@angular/material/radio
//import {RatingModule} from 'ng-starrating';
//import {StarRatingModule} from 'angular-star-rating';
//import { NgxStarRatingModule } from 'ngx-star-rating';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SearchComponent,
    TagsComponent,
    CartPageComponent,
    FoodpageComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule, MatIconModule,
    AppRoutingModule,
    BrowserAnimationsModule, MatToolbarModule,
    MatButtonModule, FlexLayoutModule, MatCardModule,
    MatSidenavModule, MatFormFieldModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 193508d28b130649fceef342a3d6417927463787
>>>>>>> 97be0521fc24c70d1891d419f71c687dec3219ae
>>>>>>> 83160e3ff6de1d6654831e4d81bd50eb82f100c4
