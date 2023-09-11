import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { UserService } from "../user-service";

@Component({
    selector: 'user-register',
    templateUrl: './user-register.html'
})
export class UserRegisterComponent implements OnInit{
    form: FormGroup = new FormGroup('')

    constructor(private userService: UserService){}

    ngOnInit(): void {
        this.form = new FormGroup({
            username: new FormControl('', Validators.required),
            email: new FormControl('', Validators.email),
            firstname: new FormControl('', Validators.required),
            lastname: new FormControl('', Validators.required),
            passwd: new FormControl('', Validators.required),
            passwdvalidation: new FormControl('', Validators.required) 
        })
    }

    onSubmit(item: any){
        this.userService.register(item)
    }
}