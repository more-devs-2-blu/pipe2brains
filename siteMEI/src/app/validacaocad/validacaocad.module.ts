import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ValidacaocadRoutingModule } from "./validacaocad-routing.module";
import { ValidacaocadComponent } from "./validacaocad.component";


@NgModule({
    declarations: [
        ValidacaocadComponent
    ],
    imports: [
        ValidacaocadRoutingModule,
        CommonModule      
    ]
})
export class ValidacaocadModule { }
