import { Location } from './location';

export class Fare {
    amount:Number;
    currency:string;
    origin:string;
    destination:string;
    originLocation:Location;
    destLocation:Location;
}