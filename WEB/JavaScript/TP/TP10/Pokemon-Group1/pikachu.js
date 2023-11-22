
//1) saisir le nom du pokemon et valider avec le bouton ou avec Enter (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var mouvement=30;
var pokemon="pikachu";
var direction="Down";
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");





inputName.oninput = function() {
  if(inputName.value != ""){
    btnStart.disabled = false;
  } else {
    btnStart.disabled = true;
  }
}

// btnStart.onclick = function(){
//   formStart.style.display = "none";
//   grass.style.display = "block";
// }

inputName.onkeydown= lancerJeue;
btnStart.onclick = lancerJeue;


function lancerJeue(event){
  console.log(event)
  if (event.key == "Enter" || event.type=="click"){
    formStart.style.display = "none";
    grass.style.display = "block";
  }
}





console.log(pikachu);
document.onkeydown = deplacement;


function deplacement(event)
{
  console.log("movement!")
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    posY += mouvement;
    direction = "Down";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    posX += mouvement;
    direction = "Right";
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    posX -= mouvement;
    direction = "Left";
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    posY -= mouvement;
    direction = "Up";
  }
  console.log(posY);

  console.log(event.key)
  if (event.key == " "){
     eclair.style.opacity=1;
    triggerThunder();
    effetEclair.style.filter = "brightness(0.3)";
     setTimeout(function(){
      eclair.style.opacity = 0;
      eclairRandom.style.opacity = 0;
      eclairRandom2.style.opacity = 0;
      effetEclair.style.filter = "brightness(1)";
     }
     , 500)

    //  eclair.style.display= "block";
    }

  if(posX < 0){posX = 0}
  if(posY < 0){posY = 0}
  if(posX > 660){posX = 660}
  if(posY > 660){posY = 660}


  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

}


console.log(  posX= Math.random()* 700)

function triggerThunder(){
  document.getElementById("thunder1").play();
  setTimeout(function(){
    document.getElementById("thunder1").pause();
    document.getElementById("thunder1").currentTime = 0;
  }, 2000)

  posX2= Math.random()* 700-200;
  posY2= Math.random()* 700-200;
  posX3= Math.random()* 700-200;
  posY3= Math.random()* 700-200;
  console.log(posY2);
  eclairRandom.style.top = posX2;
  eclairRandom.style.left = posY2;
  eclairRandom.style.opacity = 1;
  eclairRandom2.style.top = posX3;
  eclairRandom2.style.left = posY3;
  eclairRandom2.style.opacity = 1;
}