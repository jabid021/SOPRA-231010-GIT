//1) saisir le nom du pokemon et valider avec le bouton ou avec Enter (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX = 0;
var posY = 0;
var mouvement = 30;
var pokemon = "pikachu";
var direction = "Down";
imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");

pierre.style.top = "300px";
pierre.style.left = "300px";


setTimeout(function(){themePokemon.play();},2000);



function buttonStart() {
  formStart.style.display = "none";;
  grass.style.display = "block";
  pikachu.title = inputName.value;
  document.body.onkeydown = deplacement;
}




function verifbtn() {


  if (inputName.value.length > 0) {
    btnStart.disabled = false;
  }
  else {
    btnStart.disabled = true;
  }

}

console.log(grass.style.width)
function deplacement(event) {
  if (event.key == "ArrowDown" || event.key == "s") {

    if (posY + mouvement < grass.clientHeight - 30) {
      direction = "Down";
      posY += mouvement;
    }

  }
  else if (event.key == "ArrowRight" || event.key == "d") {
    if (posX + mouvement < grass.clientWidth - 30) {
      direction = "Right";
      posX += mouvement;
    }
  }

  else if (event.key == "ArrowLeft" || event.key == "q") {
    if (posX - mouvement >= 0) {
      direction = "Left";
      posX -= mouvement;
    }
  }

  else if (event.key == "ArrowUp" || event.key == "z") {
    if (posY - mouvement >= 0) {
      direction = "Up";
      posY -= mouvement;
    }
  }
  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");



  verifPos();
}

function verifPos()
{

  if(pikachu.style.top === pierre.style.top && pikachu.style.left === pierre.style.left)
  {

    pokemon = "magicarpe";
    mouvement = 10;
    pierre.style.display = "none";
  }

}
