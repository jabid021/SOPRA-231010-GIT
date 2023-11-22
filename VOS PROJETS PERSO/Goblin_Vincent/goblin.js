var posX = 100;
var posY = 0;
var step = 10;
let lastFacing;
var animation = "still2";
var animationInProgress = false;
var imgGob = document.getElementById("imgGob");
var imgBackgrounds = document.getElementsByClassName("imgBG");

document.body.onkeydown = move;
document.body.onkeyup = stopAnimation;
document.onmousemove = function(e){
  var x = e.pageX;
  var y = e.pageY;
  e.target.title = "X is "+x+" and Y is "+y;
  };

function move(event) {
  if (event.key == "q" || event.key == "ArrowLeft") {
    if (lastFacing == "left") {
        if(posX + step < 760) {  
          posX += step;
          if(!animationInProgress) {startAnimation("running2", 2400);}
        }
        else {
          if(!animationInProgress) {startAnimation("running2", 2400);}
          moveBackground(step);
        }
    }
    lastFacing = facing("left");
  } else if (event.key == "d" || event.key == "ArrowRight") {
    if (lastFacing == "right") {
      if(posX - step > 100) {
        posX -= step;
        if(!animationInProgress) {startAnimation("running2", 2400);}
      }
      else {
        if(!animationInProgress) {startAnimation("running2", 2400);}
        moveBackground(-step);
      }
    }
    lastFacing = facing("right");
  } else if (event.key == "a") {
    startAnimation("attacking2", 480);
  }
  goblin.style.right = posX;
  console.log("posX :>> ", posX);
  console.log("goblin :>> ", goblin);
  console.log("event :>> ", event);
  console.log("lastFacing :>> ", lastFacing);
  console.log("event.key :>> ", event.key);
}

function facing(direction) {
  if (direction == "left") {
    goblin.style.transform = "scaleX(-1)";
  } else if (direction == "right") {
    goblin.style.transform = "scaleX(1)";
  }

  return direction;
}

function startAnimation(newAnimation, duration) {
  animationInProgress = true; 
  changeAnimation(newAnimation, duration);
  setTimeout(() => {
    animationInProgress = false;
  }, duration);
}

function changeAnimation(newAnimation, duration) {
  imgGob.setAttribute("src", `assets/goblin/goblin_${newAnimation}.gif`);
  setTimeout(() => {
    imgGob.setAttribute("src", `assets/goblin/goblin_still2.gif`);
  }, duration);
}

function stopAnimation() {
  setTimeout(() => {
    imgGob.setAttribute("src", `assets/goblin/goblin_still2.gif`);
  }, 500  );
}

function moveBackground(step) {
  imgBackgrounds = document.getElementsByClassName("imgBackground");
  console.log('imgBackgrounds :>> ', imgBackgrounds);
  for(c of imgBackgrounds) {
    console.log(parseInt(c.style.getPropertyValue("right")));
  }
}
/*
function parallaxBackground(direction) {
  imgBackgrounds.forEach((img, index) => {
    var speed = 0.5 * (index + 1) * direction;
    var newPosition = posX * speed;
    img.style.right = `${newPosition}px`;
  });
}
*/