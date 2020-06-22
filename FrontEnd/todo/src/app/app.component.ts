import { Component } from '@angular/core';

@Component({
  selector: 'app-root',//<app-root></app-root> is in the index.html
  templateUrl: './app.component.html',//where is the location of this specific component
  styleUrls: ['./app.component.css']//where the style of this component
})
export class AppComponent {
  title = 'todo';//in the app.component.ts it's written {{title}} interpolation
  message = 'welcome to my little project';
  //that is called binding - writing data in the component and showing it it the view (html)
}
