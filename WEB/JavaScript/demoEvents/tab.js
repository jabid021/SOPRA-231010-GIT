btnAjouter.onclick=ajouterTableau;

inputPrenom.onkeyup = function(event)
{
  var prenom = inputPrenom.value;
  if(prenom=="")
  {
    btnAjouter.disabled=true;
    loginStatut.style.backgroundColor="red";
  }
  else
  {
    btnAjouter.disabled=false;
    loginStatut.style.backgroundColor="green";
    if(event.key=="Enter")
    {
      ajouterTableau();
    }
  }
}



function ajouterTableau()
{
  var prenom = inputPrenom.value;
  corpTableau.innerHTML+=`<tr><td>${prenom}</td></tr>`
  inputPrenom.value="";
  btnAjouter.disabled=true;
  loginStatut.style.backgroundColor="red";
}
