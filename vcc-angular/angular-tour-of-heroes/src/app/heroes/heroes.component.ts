import { Component } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})

export class HeroesComponent {

  heroes: Hero[] = [];

  // Functions.
  constructor(private heroService: HeroService, private messageService: MessageService) {

  }

  ngOnInit(): void {
    this.getHeroes();
  }

  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => {
      h !== hero
    });
    this.heroService.deleteHero(hero.id).subscribe();
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }

    this.heroService.addHero({ name } as Hero)
      .subscribe(hero => {
        this.heroes.push(hero);
      });
  }

  getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(heroes => {
        this.heroes = heroes
      });
  }
}