function nb_aleatoire(min, max) {
    let nb = min + (max - min + 1) * Math.random();
    return Math.floor(nb);
}

let p = document.getElementById("rep");
let p2 = document.getElementById("rep2");


let nb = nb_aleatoire(1, 100);
console.log(nb);
let compte = 0;

let b = 0;

function valenter() {
    let num = parseInt(document.getElementById("surface").value);
    if (num > nb && compte < 5) {
        p.innerHTML = " c'est moins ";
        p2.innerHTML = compte++;

    } else if (num < nb && compte < 5) {
        p.innerHTML = " c'est plus ";
        p2.innerHTML = compte++;
    } else if (num == nb && compte < 5) {
        p.innerHTML = "";
        p2.innerHTML = "Bravo tu as trouver le nombre qui était " + nb;
    } else {
        p.innerHTML = "";
        p2.innerHTML = "Perdu tu as pas trouver le nombre qui était " + nb;
    }




    //p2.innerHTML = "perdu";

}