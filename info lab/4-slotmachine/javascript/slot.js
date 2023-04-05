class CSlotMachine{
    constructor(){
        this.crediti = 10;
        this.sl1 = 0;
        this.sl2 = 0;
        this.sl3 = 0;
        let im = new CImmagini();
    }

    startSlot(){
        if(this.crediti != 0){
            this.crediti--;

            let tmp = Math.floor(Math.random() * 20) + 10;
            for(let i = 0; i < tmp; i++) {
                this.im.randomNum(this.sl1, this.sl2, this.sl3);
            }

            if(this.sl1 == this.sl2 && this.sl1 == this.sl3){

            }
            if(this.sl1 == this.sl2 || this.sl2 == this.sl3){

            }
            if(this.sl1 == this.sl3){

            }

            document.getElementById("crediti").innerHTML = "Crediti: " + this.crediti;
        } if(this.crediti == 0){
            document.getElementById("crediti").innerHTML = "Crediti terminati";
            document.getElementById("crediti").style.color = "red";
        }
    }

    cancella(){
        this.crediti = 10;
        this.sl1 = 0;
        this.sl2 = 0;
        this.sl3 = 0;
        document.getElementById("crediti").style.color = "black";
        document.getElementById("crediti").innerHTML = "Crediti: " + this.crediti;
        this.reset();
        this.im.reset();
    }
}