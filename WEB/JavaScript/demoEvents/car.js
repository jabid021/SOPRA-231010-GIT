var posX = 0;
var posY=0;
var deplacement=30;
var couleurVoiture="red";




startCar.onclick=function()
{
  document.body.onkeydown = bougerVoiture;
  resteDeLaPage.style.display="none";
}


voiture.onclick=function()
{
    couleurVoiture = (couleurVoiture=="red") ? "blue": "red";
    imgCar.setAttribute("src",`${couleurVoiture}.gif`);
}


function bougerVoiture(event)
{
  if(event.key=="z" || event.key=="ArrowUp")
  {
    posY += deplacement;
    voiture.style.transform="rotate(90deg)";
  }
  else if(event.key=="s" || event.key=="ArrowDown")
  {
    posY -= deplacement;
    voiture.style.transform="rotate(-90deg)";
  }
 else if(event.key=="q" || event.key=="ArrowLeft")
  {
    posX += deplacement;
    voiture.style.transform="scaleX(1)";
  }
else if(event.key=="d" || event.key=="ArrowRight")
  {
    posX -= deplacement;
    voiture.style.transform="scaleX(-1)";
  }
  voiture.style.right=posX;
  voiture.style.bottom=posY;

}
