spoil.onmouseover = function()
{
   //var balise = document.getElementById("spoil").getElementsByTagName("span");
   var balise = document.querySelector("#spoil span");
   balise.style.display="inline";
}


spoil.onmouseout = function(event)
{
   var balise = document.querySelector("#spoil span");
   balise.style.display="none";
}


couleurTexte.onchange = function()
{
  paragPrinci.style.color=couleurTexte.value;
}


resetCouleur.onclick = function()
{
    paragPrinci.style.color="black";
    couleurTexte.value="#000000";
}
