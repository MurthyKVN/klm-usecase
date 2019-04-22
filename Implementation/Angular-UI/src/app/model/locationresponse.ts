import { Location } from './location';

export class LocationResponse {
    _embedded:Embedded;
}

class Embedded {
    locations:Location[]
}