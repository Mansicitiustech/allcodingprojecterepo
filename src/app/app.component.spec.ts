import { TestBed } from '@angular/core/testing';
<<<<<<< HEAD
import { RouterTestingModule } from '@angular/router/testing';
=======
<<<<<<< HEAD
import { RouterTestingModule } from '@angular/router/testing';
=======
<<<<<<< HEAD
=======
import { RouterTestingModule } from '@angular/router/testing';
>>>>>>> 193508d28b130649fceef342a3d6417927463787
>>>>>>> 97be0521fc24c70d1891d419f71c687dec3219ae
>>>>>>> 83160e3ff6de1d6654831e4d81bd50eb82f100c4
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
<<<<<<< HEAD
      imports: [
        RouterTestingModule
      ],
=======
<<<<<<< HEAD
      imports: [
        RouterTestingModule
      ],
=======
<<<<<<< HEAD
=======
      imports: [
        RouterTestingModule
      ],
>>>>>>> 193508d28b130649fceef342a3d6417927463787
>>>>>>> 97be0521fc24c70d1891d419f71c687dec3219ae
>>>>>>> 83160e3ff6de1d6654831e4d81bd50eb82f100c4
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
  it(`should have as title 'CTGeneralHospital'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('CTGeneralHospital');
=======
>>>>>>> 97be0521fc24c70d1891d419f71c687dec3219ae
>>>>>>> 83160e3ff6de1d6654831e4d81bd50eb82f100c4
  it(`should have as title 'foodorder'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('foodorder');
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 193508d28b130649fceef342a3d6417927463787
>>>>>>> 97be0521fc24c70d1891d419f71c687dec3219ae
>>>>>>> 83160e3ff6de1d6654831e4d81bd50eb82f100c4
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
<<<<<<< HEAD
    expect(compiled.querySelector('.content span')?.textContent).toContain('foodorder app is running!');
=======
<<<<<<< HEAD
    expect(compiled.querySelector('.content span')?.textContent).toContain('foodorder app is running!');
=======
<<<<<<< HEAD
    expect(compiled.querySelector('.content span')?.textContent).toContain('CTGeneralHospital app is running!');
=======
    expect(compiled.querySelector('.content span')?.textContent).toContain('foodorder app is running!');
>>>>>>> 193508d28b130649fceef342a3d6417927463787
>>>>>>> 97be0521fc24c70d1891d419f71c687dec3219ae
>>>>>>> 83160e3ff6de1d6654831e4d81bd50eb82f100c4
  });
});
