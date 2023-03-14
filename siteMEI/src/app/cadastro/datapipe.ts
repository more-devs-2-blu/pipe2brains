import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'datapipe'})
export class DataPipe implements PipeTransform {
    
    transform(data: string): string {
        var dataCacheArray:string[] = [];
        var dataCache:string;
    for (let i = 0; i < data.length; i++) {
        dataCacheArray.push(data[i])
    }
    dataCache = dataCacheArray[0]+dataCacheArray[1]+'/'+dataCacheArray[2]+dataCacheArray[3]+'/'+dataCacheArray[4]+dataCacheArray[5]+dataCacheArray[6]+dataCacheArray[7]

    return dataCache;
  }
}