class CCampo {
    constructor(){
        this.campo = new Array();
        this.tempo = 0;
        this.bombe = 0;
        this.bandiere = 0;
    }

    generaCampo(){
        let x = 0;
        let y = 0;

        for(let i = 0; i < 80; i++){
            if(x == 8){
                y++;
                x = 0;
            }
            let cel = "<div class='cella' value='" + "div-" + x + "-" + y + "'></div>"
            $("#gioc").append(cel);
            x++;
        }
    }

    aggiornaStat(){

    }

    rifai(){

    }
}