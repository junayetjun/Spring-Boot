import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { Caregiver } from '../../model/caregiver.model';
import { Education } from '../../model/education';
import { Experience } from '../../model/experience';
import { Skill } from '../../model/skill';
import { Language } from '../../model/language';
import { Hobby } from '../../model/hobby';
import { Reference } from '../../model/reference';

@Component({
  selector: 'app-viewdetails',
  standalone: false,
  templateUrl: './viewdetails.html',
  styleUrl: './viewdetails.css'
})
export class Viewdetails  {

   @Input() caregiver!: Caregiver;
  @Input() educations: Education[] = [];
  @Input() experiences: Experience[] = [];
  @Input() skills: Skill[] = [];
  @Input() languages: Language[] = [];
  @Input() hobbies: Hobby[] = [];
  @Input() references: Reference[] = [];

}
