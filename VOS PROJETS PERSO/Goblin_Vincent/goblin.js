var posX = -700;
var posY = -700;
var step = 10;
let lastFacing;
var animation = "still2";
var animationInProgress = false;
var imgGob = document.getElementById("imgGob");
var imgBackgrounds = document.getElementsByClassName("imgBG");

document.body.onkeydown = move;
document.body.onkeyup = stopAnimation;
document.onmousemove = function (e) {
  var x = e.pageX;
  var y = e.pageY;
  e.target.title = "X is " + x + " and Y is " + y;
};

function move(event) {
  if (event.key == "q" || event.key == "ArrowLeft") {
    if (lastFacing == "left") {
      if (posX + step < -100) {
        posX += step;
        if (!animationInProgress) {
          startAnimation("running2", 1200, "left");
        }
      } else {
        if (!animationInProgress) {
          startAnimation("running2", 1200, "left");
        }
        moveBackground(-step);
      }
    }
    lastFacing = "left";
  } else if (event.key == "d" || event.key == "ArrowRight") {
    if (lastFacing == "right") {
      if (posX - step > -700) {
        posX -= step;
        if (!animationInProgress) {
          startAnimation("running2", 1200, "right");
        }
      } else {
        if (!animationInProgress) {
          startAnimation("running2", 1200, "right");
        }
        moveBackground(step);
      }
    }
    lastFacing = "right";
  } 
  // else if (event.key == "a") {
  //   startAnimation("attacking2", 480, lastFacing);
  // }
  goblin.style.right = posX;
  console.log("posX :>> ", posX);
  console.log("goblin :>> ", goblin);
  console.log("event :>> ", event);
  console.log("lastFacing :>> ", lastFacing);
  console.log("event.key :>> ", event.key);
}

function startAnimation(newAnimation, duration, direction) {
  animationInProgress = true;
  changeAnimation(newAnimation, duration, direction);
  setTimeout(() => {
    animationInProgress = false;
  }, duration);
}

function changeAnimation(newAnimation, duration, direction) {
  imgGob.setAttribute("src", `assets/goblin/goblin_${newAnimation}_${direction}.gif`);
}

function stopAnimation() {
  setTimeout(() => {
    imgGob.setAttribute("src", `assets/goblin/goblin_still2_${lastFacing}.gif`);
  }, 300);
}

function moveBackground(step) {
  imgBackgrounds = document.getElementsByClassName("imgBackground3");
  for (img of imgBackgrounds) {
    currentRight = parseInt(getComputedStyle(img).getPropertyValue("right"));
    if (currentRight === 960 || currentRight === -960) {
      img.style.right = 0;
    } else {
      img.style.right = currentRight + (step*img.dataset.speed);
    }
  }

  imgBackgrounds = document.getElementsByClassName("imgBackground");
  for (img of imgBackgrounds) {
    currentRight = parseInt(getComputedStyle(img).getPropertyValue("right"));
    if (currentRight === 0 || currentRight === -1920) {
      img.style.right = -960;
    } else {
      img.style.right = currentRight + (step*img.dataset.speed);
    }
  }

  imgBackgrounds = document.getElementsByClassName("imgBackground2");
  for (img of imgBackgrounds) {
    currentRight = parseInt(getComputedStyle(img).getPropertyValue("right"));
    if (currentRight === 0 || currentRight === 1920) {
      img.style.right = 960;
    } else {
      img.style.right = currentRight + (step*img.dataset.speed);
      console.log('img.speed :>> ', img.dataset.speed);
      console.log('(step*parseInt(img.dataset.speed)) :>> ', (step*parseInt(img.dataset.speed)));
    }
  }
}


