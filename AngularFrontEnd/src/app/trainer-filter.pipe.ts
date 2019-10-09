import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trainerFilter'
})
export class TrainerFilterPipe implements PipeTransform {

  transform(trainers: any[], searchTerm: any): any[] {
    if(!trainers || !searchTerm) {
      return trainers;
    }
    // return trainers.filter(trainer => trainer.name.toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);    
    return trainers.filter(trainers => trainers.expertArea.toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);
  }

}
