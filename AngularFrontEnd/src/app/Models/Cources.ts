export interface Cources {
    id:number,
    name: string;
	mentorId: number;
	mentorName: string;
	isCompleted: boolean;
	skills: [{
        id:number,
        name:string,
    }];
}