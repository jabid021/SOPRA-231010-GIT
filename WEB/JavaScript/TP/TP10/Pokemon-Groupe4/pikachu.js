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
const son = document.getElementById("son");
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

inputName.onkeyup = function(event)
{
  var prenom = inputName.value;
  if(prenom=="")
  {
    btnStart.disabled=true;
  }
  else
  {
    btnStart.disabled=false;
    pikachu.title=prenom;
    if(event.key=="Enter")
    {
      entrerJeux();
    }
  }
}

btnStart.onclick=entrerJeux;

function jouerSon()
{
  var sound = getRandomSound();
  son.setAttribute("src", `assets/audio/${sound}.mp3`)
  son.currentTime = 0; // Réinitialise la piste audio pour permettre une lecture répétée
  son.play();
}

/*function imageMick()
{
  mickPika1.setAttribute("style","display:block")
  mickPika2.setAttribute("style","display:block")
  setTimeOut(()=>
  {
    mickPika1.setAttribute("style","display:none")
    mickPika2.setAttribute("style","display:none")
  },500);
}*/

function getRandomSound() {
  michaelSounds = ["Hee_Hee", "1", "2", "3","4"];
  var r = Math.floor(Math.random() * michaelSounds.length);
  return michaelSounds[r];
}


function entrerJeux(event)
{
  grass.setAttribute("style","display:block");
  formStart.style.display="none";
  document.body.onkeydown = deplacement;
}

function deplacement(event)
{
  if(event.key=="ArrowUp" || event.key=="z")
  {
    if(posY>0)
    {
      posY -= mouvement;
    }
    direction="Up";
  }
  else if(event.key=="ArrowDown" || event.key=="s" )
  {
    if(posY<grass.clientHeight-40)
    {
      posY += mouvement;
    }
    direction="Down";
  }
  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    if(posX>0)
    {
      posX -= mouvement;
      jouerSon();
      //imageMick;
    }
    direction="Right";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    if(posX<grass.clientWidth-40)
    {
      posX += mouvement;
      jouerSon();
      //imageMick();
    }
    direction="Left";
  }

  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

}
