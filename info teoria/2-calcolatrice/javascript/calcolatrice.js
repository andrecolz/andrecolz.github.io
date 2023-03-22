class CCalcolatrice {
    constructor(){
        this.nCorrente = "";
        this.parziale = "";
        this.operatore = "";
    }

    cancella(){
        this.nCorrente = "";
        this.parziale = "";
        this.operatore = "";
        document.getElementById("risu").innerHTML = "";
    }

    scrivi(valore){
        document.getElementById("risu").innerHTML += valore;
        this.nCorrente += valore;
    }

    scriviS(segno) {
        this.operatore = segno;
        document.getElementById("risu").innerHTML = "";
        this.parizale = this.nCorrente;
        this.nCorrente = "";
    }

    calcola(){
        if(this.operatore == "+"){
            this.parizale = parseInt(this.parizale) + parseInt(this.nCorrente);
        }
        if(this.operatore == "-"){
            this.parizale = parseInt(this.parizale) - parseInt(this.nCorrente);
        }
        if(this.operatore == "*"){
            this.parizale = parseInt(this.parizale) * parseInt(this.nCorrente);
        }
        if(this.operatore == "/"){
            this.parizale = parseInt(this.parizale) / parseInt(this.nCorrente);
        }
        document.getElementById("risu").innerHTML = this.parizale;
        this.nCorrente = this.parizale;
    }
}

let c = new CCalcolatrice();