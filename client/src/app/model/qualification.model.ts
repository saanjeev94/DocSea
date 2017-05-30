/**
 * Created by soni on 5/30/2017.
 */
export class Qualification{
  public id?:number;
  public qualification?:Qualification;


  constructor(id?: number, qualification?: Qualification) {
    this.id = id?id:null;
    this.qualification = qualification?qualification:null;
  }
}
