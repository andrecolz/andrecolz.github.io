const campo = {
    vet: new Array(),
    tempo: 0,
    bombe: 0,
    bandiere: 10
};

function generaCampo(){
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

function cliccato(event){
    document.addEventListener('contextmenu', event => event.preventDefault());
    var row = $(event.target).closest('.cella').data('row');
    var col = $(event.target).closest('.cella').data('col');
    
    if (event.which === 1) {
        $(event.target).css("background-color", "red");
    } else if (event.which === 3) {
        $(event.target).css("background-color", "blue");
        campo.bandiere--;
    }
    
    aggiornaStat();
}

function aggiornaStat(){
    $("#bandrim").text("Bandiere: " + campo.bandiere);
}

function rifai(){
    $("#gioc").empty();
    campo.bandiere = 10;
    campo.tempo = 0;
    campo.bombe = 0;
    campo.vet = new Array();
    aggiornaStat();
    generaCampo();
}