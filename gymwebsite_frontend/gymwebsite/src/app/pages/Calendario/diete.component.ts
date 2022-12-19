import { Component, OnInit, ViewChild } from '@angular/core';
import {
    Notifications,
    setOptions,
    localeIt
} from '@mobiscroll/angular';

setOptions({
    locale: localeIt,
    theme: 'ios',
    themeVariant: 'dark'
});

@Component({
    selector: 'diete-root',
    templateUrl: './diete.component.html',
    providers: [Notifications]
})
export class DieteComponent implements OnInit {
    constructor() {}
  ngOnInit(): void {
  }
}