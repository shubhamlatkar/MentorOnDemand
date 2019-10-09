export interface Trainings
 {
    id: number,
    name: string,
    mentorId: number,
    mentorName: string,
    skills:[{
        id:number,
        name:string,
    }],
    completed:boolean
}