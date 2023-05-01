class CCampo {
    constructor(){
        this.campo = new Array();
        this.tempo = 0;
        this.bombe = 0;
        this.bandiere = 10;
    }

    generaCampo(){
        let x = 0;
        let y = 0;

        for(let i = 0; i < 80; i++){
            if(x == 8){
                y++;
                x = 0;
            }
            //onclick='campo.cliccato()'
            //let cel = "<div class='cella' data-row='" + x + "' data-col='" + y + "'><button class='bcella'>d</button></div>";
            let cel = $("<div>").addClass("cella").attr("data-row", x).attr("data-col", y).text("d");
            cel.on("mousedown", this.cliccato);
            $("#gioc").append(cel);
            x++;
        }
    }

    cliccato(event){
        document.addEventListener('contextmenu', event => event.preventDefault());
        var row = $(event.target).closest('.cella').data('row');
        var col = $(event.target).closest('.cella').data('col');
        if (event.which === 1) {
            $(event.target).css("background-color", "red");
        } else if (event.which === 3) {
            $(event.target).css("background-color", "blue");
            band--;
        }
        
        this.aggiornaStat();
    }

    aggiornaStat(){
        $("#bandrim").text("Bandiere: " + this.bandiere);
    }

    rifai(){

    }
}