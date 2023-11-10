import {renderMovies} from './modules/movies_static.js'

function App() {
    renderMovies()
}



App()


////////////////// Color schemes /////////////////////

// Get the root element
var target1 = document.querySelector('h1');
var target2 = document.querySelector('#bg_tint');
// console.log(target2)


// generate number randomly within range
function genRand(min=0 , max=100) {
    // find diff
    let difference = max - min;
    // generate random number
    let rand = Math.random();
    // multiply with difference
    rand = Math.floor( rand * difference);
    // add with min value
    rand = rand + min;
    return rand;
}

//changing background constantly
function bg_continuous(){
    // RANDOM BG ANGLE
    // document.body.style.background = "linear-gradient(" + genRand() + "deg, var(--col-pri-light), var(--col-pri-desat)), var(--bg-texture-1)"
    // RANDOM COLOR
    var new_bg_col = "rgba(" +genRand(0,255) + ", " +genRand(0,255) + ", " + genRand(0,255) + ", 0.5)"
    // console.log(new_bg_col)
    target1.style.color = new_bg_col;
    target2.style.backgroundColor = new_bg_col;
    // RANDOM TRANSITION
    var transition_dur = genRand()*1000/100
    // console.log(transition_dur)
    target1.style.transition = transition_dur + "ms";
    //===== RECURSION =====//
    setTimeout(bg_continuous, transition_dur);
}
bg_continuous();
