class CImmagini {
    constructor(){
        this.img = ["img/img1.png", "img/img2.png", "img/img3.png", "img/img4.png", "img/img5.png", "img/img6.png", "img/img7.png", "img/img8.png", "img/img9.png", "img/img10.png"]
    }

    randomNum(sl1, sl2, sl3) {
        sl1 = Math.floor(Math.random() * 9) + 0;
        sl2 = Math.floor(Math.random() * 9) + 0;
        sl3 = Math.floor(Math.random() * 9) + 0;
        document.getElementById("im1").src = this.img[sl1];
        document.getElementById("im2").src = this.img[sl2];
        document.getElementById("im3").src = this.img[sl3];
    }

    reset(){
        document.getElementById("im1").src = this.img[6];
        document.getElementById("im2").src = this.img[6];
        document.getElementById("im3").src = this.img[6];
    }
}