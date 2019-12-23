import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {


  @Output() searchEmitter: any;
  searchString: string ="";
  
  constructor() { 
    this.searchEmitter = new EventEmitter();  
  }

  ngOnInit() {
  }

  filterData() {
    this.searchEmitter.emit(this.searchString);
  }
}


