class CToDo {
    constructor(){
        this.vet = new Array();
        this.nEl = 0;
        this.eliminati = 0;
    }

    aggiungi(){
        if(this.nEl < 10){
            const tab = document.getElementsByTagName("tr");
            const cella = {
                testo: document.getElementById('txt1').value,
                tr: tab[this.nEl + 1],
                data: undefined,
                visibile: false,
                check: false,

                aggiornaTesto: function(txt) {
                    if(txt == undefined){
                        this.tr.getElementsByTagName("p")[0].innerHTML = this.testo;
                    } else {
                        this.testo = txt;
                        this.tr.getElementsByTagName("p")[0].innerHTML = this.testo;
                    }
                },

                aggiornaVisibile: function(bol) {
                    if(bol == true){
                        this.visibile = true;
                        this.tr.style.display = "block";
                    }
                    if(bol == false){
                        this.visibile = false;
                        this.tr.style.display = "none";
                    }
                },

                aggiornaColori: function() {
                    if(this.check == false){
                        this.tr.getElementsByTagName("button")[0].style.backgroundColor = "#f38b8b"
                        this.tr.getElementsByTagName("input")[0].style.backgroundColor = "#f8cbba"
                        this.tr.getElementsByTagName("p")[0].style.backgroundColor = "#5e8a8c"
                        this.check = true;
                        return;
                    }
                    if(this.check == true){
                        this.tr.getElementsByTagName("button")[0].style.backgroundColor = "#EC4D4D"
                        this.tr.getElementsByTagName("input")[0].style.backgroundColor = "#F19574"
                        this.tr.getElementsByTagName("p")[0].style.backgroundColor = "#B3CBCC"
                        this.check = false;
                        return;
                    }
                }
            };

            this.vet[this.nEl] = cella;
            this.vet[this.nEl].aggiornaTesto();
            this.vet[this.nEl].aggiornaVisibile(true);

            this.nEl++;
        }
    }

    elimina(pos){
        pos = pos - this.eliminati;
        if(this.nEl < 10 && this.nEl >=0){
            if(pos != (this.nel - 1)){
                let n = (this.nEl - 1) - pos;
                this.vet[pos].aggiornaVisibile(false);
                if(this.vet[pos].check == true) { this.vet[pos].aggiornaColori(); }

                for(let i = pos; i < n; i++){
                    this.vet[i] = this.vet[i+1];
                }
            } 

            this.vet.pop();
            this.nEl--;
            this.eliminati++;
        }
    }

    chekkata(pos){
        this.vet[pos].aggiornaColori();
    }
}