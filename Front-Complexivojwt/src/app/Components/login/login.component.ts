import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Models/usuario';
import { UsuarioService } from 'src/app/Services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario: Usuario;

  formLogin = new FormGroup({
    username : new FormControl('',Validators.required),
    contrasena: new FormControl('', Validators.required)
  });

  constructor(private loginService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    
  }

  iniciarSesion(){
    const {username, contrasena} = this.formLogin.value;
    
    if(this.formLogin.valid){
      this.loginService.login(username, contrasena).subscribe(
        (data) => {
          this.usuario = data;
          console.log(this.usuario);
          localStorage.setItem('token',this.usuario.token);
          this.router.navigate(['/listar']);
      });
    }else{
      alert("Llene todos los campos! >:v")  
    }
       
  }
}
