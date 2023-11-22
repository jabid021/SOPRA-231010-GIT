//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var posX2=660;
var posY2=660;
var mouvement=30;
var pokemon="pikachu";
var pokemon2="coincoin";
var direction="Down";
var namepoke;
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

//1) Valider avec le bouton quand l'input dans la barre n'est pas vide
  /*setInterval(checkinput,500);
  function checkinput(){
    //name = document.getElementById("inputName").value;
    namepoke = inputName.value;
    console.log(namepoke);

    if(!(namepoke=="")){
      btnStart.disabled=false;
    } else{
      btnStart.disabled=true;
    }
  }*/

  inputName.onkeyup = function(event)
  {
  var namepoke = inputName.value;
    if(namepoke=="")
    {
      btnStart.disabled=true;
    }
  else
    {
    btnStart.disabled=false;
  if(event.key=="Enter")
    {
    afficherGrass();
    }
    }
  }


//2) Afficher la grass et pikachu
  btnStart.onclick = afficherGrass;
  function afficherGrass() {
    formStart.style.display = "none";
    grass.style.display ="inline-block";
    pikachu.setAttribute("title",namepoke);
    //themePokemon.play();
    document.body.onkeydown = deplacement;
  }

  function deplacement(event)
  {
    /*var pikachuElement = document.getElementById('imgPikachu');
    // Récupérer la hauteur définie en CSS pour cet élément
    var hauteurCSSPika = parseInt(window.getComputedStyle(pikachuElement).height);
    // Récupérer l'élément avec l'ID "grass"
    var grassElement = document.getElementById('grass');
    // Récupérer la hauteur définie en CSS pour cet élément
    var hauteurCSS = parseInt(window.getComputedStyle(grassElement).height);

    console.log("grass:"+hauteurCSS);
    console.log("pika:"+hauteurCSSPika);
    console.log("soustracton:"+(hauteurCSS-hauteurCSSPika));*/

    if(event.key=="ArrowDown" || event.key=="s" )
    {
      if(posY+mouvement<670){
      posY += mouvement;
    }
      direction="Down";
    }
    else if(event.key=="ArrowRight" || event.key=="d" )
    {
      if(posX+mouvement<670){
      posX += mouvement;
    }
      direction="Right";
    }

    else if(event.key=="ArrowLeft" || event.key=="q")
    {
      if(posX-mouvement>=0){
        posX -= mouvement;
      }
      direction="Left";
    }

    else if(event.key=="ArrowUp" || event.key=="z")
    {
      if(posY-mouvement>=0){
      posY -= mouvement;
    }
      direction="Up";
    }
    pikachu.style.top=posY+"px";
    console.log("pikachuY"+posY);
    pikachu.style.left=posX+"px";
    console.log("pikachuX"+posX);
    imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");


    if(event.key=="5" )
    {
      if(posY2+mouvement<690){
      posY2 += mouvement;
    }
      direction2="Down";
    }
    else if(event.key=="6" )
    {
      if(posX2+mouvement<690){
      posX2 += mouvement;
    }
      direction2="Right";
    }

    else if(event.key=="4")
    {
      if(posX2-mouvement>=0){
        posX2 -= mouvement;
      }
      direction2="Left";
    }

    else if(event.key=="8")
    {
      if(posY2-mouvement>=0){
      posY2 -= mouvement;
    }
      direction2="Up";
    }
    coincoin.style.top=posY2+"px";
    console.log("coincoinY"+posY2);
    coincoin.style.left=posX2+"px";
    console.log("coincoinX"+posX2);
    imgCoincoin.setAttribute("src","assets/img/"+pokemon2+direction2+".png");

    if(posY==posY2 && posX==posX2){
      alert("COMBAT!!!");
      themedanger.play();
    }

  }
