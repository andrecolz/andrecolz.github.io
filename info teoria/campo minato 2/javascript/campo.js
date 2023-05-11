class CCampo {
    constructor(_nMine, _diff){
       this.camp = new Array();
       this.nMine = _nMine;
       this.diff = _diff;
       this.grandezza = 0;
       this.lung = 0;
       this.bandiere = this.nMine;
       this.primoclick = false;
    }

    generaCampo(){
        let x = 0, y = 0, z = 0;

        $("#cont").css({"background-image": "none", "width": "fit-content", "height": "fit-content"}); //una cosa di grafica

        //si stabilisce in base alla difficoltà la dimensione del campo
        if(this.diff == "1") { this.grandezza = 49; $("#cont").css("grid-template-columns", "auto auto auto auto auto auto auto");}
        if(this.diff == "2") { this.grandezza = 64; $("#cont").css("grid-template-columns", "auto auto auto auto auto auto auto auto");}
        if(this.diff == "3") { this.grandezza = 81; $("#cont").css("grid-template-columns", "auto auto auto auto auto auto auto auto auto");}
        this.lung = Math.sqrt(this.grandezza);

        for(let i = 0; i < this.grandezza; i++){    //for per riempire il campo
            if(x == this.lung){
                y++;
                x = 0;
            }

            let cel = $("<div>").addClass("cella").attr("data-z", i).attr("stato", "0").attr("bomba", "0").attr("valcas", "0").attr("bandiera", "0");
            cel.on("click", this.clicksinistro.bind(this, cel));        //in queste 4 righe
            cel.on("contextmenu", this.clickdestro.bind(this, cel));    //creo cella li assegno i click
            $("#cont").append(cel);                                     //e la aggiungo al div centrale

            this.camp[i] = cel;
            x++;
        }
    }

    generaBombe(evita){  
        for(let i = 0; i < this.nMine; i++){
            let pos = Math.floor(Math.random() * this.grandezza);
            do {
                pos = Math.floor(Math.random() * this.grandezza);
            } while (pos == evita || $(this.camp[pos]).attr("bomba") == "1");   //evito di metterle mine sulla stessa posizione e dove il giocatore ha cliccato
            $(this.camp[pos]).attr("stato", "1").removeClass("cella").addClass("cellaBomb").attr("bomba", "1").attr("valcas", "0");

            //si potrebbe semplificare con gli offset ma dovrei guardarli
            //n++ segue la somma dopo aver attribuito un valore (attr) quindi o si usa n + 1 o ++n

            if(pos - 1 >= 0 && this.camp[pos - 1].attr("bomba") != 1){ //un pò di controlli prima di poter mettere il numero
                let n = Number(this.camp[pos - 1].attr("valcas"));
                if(n > 0 && n < 3) { this.camp[pos - 1].attr("valcas", ++n);} else if (n == 0) { //if che incrementa valore cella oppure le lo assegna (1)
                    this.camp[pos - 1].attr("valcas", "1").attr("stato", "3");
                }
            }

            if(pos + 1 < this.grandezza && this.camp[pos + 1].attr("bomba") != 1){
                let n = Number(this.camp[pos + 1].attr("valcas"));
                if(n > 0 && n < 3) { this.camp[pos + 1].attr("valcas", ++n);} else if (n == 0) {
                    this.camp[pos + 1].attr("valcas", "1").attr("stato", "3");
                }
            }

            //------------------------------------------------------------

            if(pos - this.lung >= 0 && this.camp[pos - this.lung].attr("bomba") != 1){
                let n = Number(this.camp[pos - this.lung].attr("valcas"));
                if(n > 0 && n < 3) { this.camp[pos - this.lung].attr("valcas", ++n);} else if (n == 0) {
                    this.camp[pos - this.lung].attr("valcas", "1").attr("stato", "3");
                }
            }

            if(pos + this.lung < this.grandezza && this.camp[pos + this.lung].attr("bomba") != 1){
                let n = Number(this.camp[pos + this.lung].attr("valcas"));
                if(n > 0 && n < 3) { this.camp[pos + this.lung].attr("valcas", ++n);} else if (n == 0) {
                    this.camp[pos + this.lung].attr("valcas", "1").attr("stato", "3");
                }
            }

            //------------------------------------------------------------

            if(pos - this.lung - 1 >= 0 && pos - this.lung + 1 < this.grandezza && this.camp[pos - this.lung - 1].attr("bomba") != 1 && this.camp[this.lung + 1].attr("bomba") != 1){
                let n1 = this.camp[pos - this.lung - 1].attr("valcas");
                if(n1 > 0 && n1 < 3) { this.camp[pos - this.lung - 1].attr("valcas", ++n1);} else if (n1 == 0) {
                    this.camp[pos - this.lung - 1].attr("valcas", "1").attr("stato", "3");
                }

                let n2 = this.camp[pos - this.lung + 1].attr("valcas");
                if(n2 > 0 && n2 < 3) { this.camp[pos - this.lung + 1].attr("valcas", ++n2);} else if (n2 == 0) {
                    this.camp[pos - this.lung + 1].attr("valcas", "1").attr("stato", "3");
                }
            }

            if(pos + this.lung + 1 < this.grandezza && pos + this.lung - 1 >= 0 && this.camp[pos + 1 + this.lung].attr("bomba") != 1 && this.camp[pos + this.lung - 1].attr("bomba") != 1){
                let n1 = this.camp[pos + 1 + this.lung].attr("valcas");
                if(n1 > 0 && n1 < 3) { this.camp[pos + 1 + this.lung].attr("valcas", ++n1);} else if (n1 == 0) {
                    this.camp[pos + 1 + this.lung].attr("valcas", "1").attr("stato", "3");
                }

                let n2 = this.camp[pos + this.lung - 1].attr("valcas");
                if(n2 > 0 && n2 < 3) { this.camp[pos + this.lung - 1].attr("valcas", ++n2);} else if (n2 == 0) {
                    this.camp[pos + this.lung - 1].attr("valcas", "1").attr("stato", "3");
                }
            }

            /* if che assegnano numeri caselli e li incrementano
                1 1 2 1 1
                1 * 2 * 1
                1 1 2 1 1
            */
        }
        /*
        stato = 0 --> casella nulla (cancellabile)
        stato = 1 --> casella con bomba
        stato = 3 --> casella con numeri 
        */
    }

    clicksinistro(cel){
        if(this.primoclick == false){ //il giocatore non cliccerà mai sulla mina come prima volta
            this.primoclick = true;
            this.generaBombe($(cel).attr("data-z"))
        } 
        if(this.primoclick == true) {
            if($(cel).attr("stato") == "3"){
                if($(cel).attr("valcas") == "1") { $(cel).removeClass("cella").addClass("cella1"); }
                if($(cel).attr("valcas") == "2") { $(cel).removeClass("cella").addClass("cella2"); }
                if($(cel).attr("valcas") == "3") { $(cel).removeClass("cella").addClass("cella3"); }
                if($(cel).attr("valcas") == "4") { $(cel).removeClass("cella").addClass("cella4"); }
            }
            if($(cel).attr("stato") == "0"){
                $(cel).removeClass("cella").addClass("cellaVuota");
            }
            if($(cel).attr("stato") == "1"){
                $(".cellaBomb").css("background-image", "url('../img/bomba.png')");
                alert("hai perso");
            }
        }
    }

    clickdestro(cel){       //da sistemare
        event.preventDefault();
        if(this.primoclick == true){
            if($(cel).attr("stato") == 0 || $(cel).attr("stato") == 1 && $(cel).attr("bandiera") != 1){
                if(this.bandiere > 0){
                    $(cel).attr("bandiera", "1");
                    //elimina classe cella band e fai css da qua
                    this.bandiere--;
                }
            } else if($(cel).attr("bandiera") == 1){

                this.bandiere++;
            }
            this.aggiornaStat();
            this.controllaBombe();
        }
    }

    aggiornaStat(){
        $("#rimBand").html("Bandiere: " + this.bandiere); //aggiorna le bandiere disponbili
    }

    controllaBombe(){
        let vinto = true;
        let primaCella = $(".cellaBomb").first().attr("bandiera");

        $(".cellaBomb").each(function() {   //confronto che tutte le bombe abbiano la bandierina
            var tmp = $(this).attr("bandiera");
            if (tmp !== primaCella) {
                vinto = false;
                return false; // esce dalla funzione each()
            }
        });

        if(vinto == true) { alert("Hai vinto"); } //in caso hai vinto
    }
}
