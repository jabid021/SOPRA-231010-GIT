const moviesDiv = document.getElementById("movies")


export async function renderMovies() {

    let onAppear = document.querySelectorAll(".row");
    // console.log(onAppear);
    // backdrop animation
    window.addEventListener("scroll", function() {
        onAppear.forEach(function(elem) {
            // console.log(elem)
            var animationArray = [
                "10s backdrop_animation1 forwards",
                "10s backdrop_animation2 forwards",
                "10s backdrop_animation3 forwards",
                "10s backdrop_animation4 forwards",
                "20s backdrop_animation1 forwards",
                "20s backdrop_animation2 forwards",
                "20s backdrop_animation3 forwards",
                "20s backdrop_animation4 forwards",
            ];
            var randomNumber = Math.floor(Math.random()*animationArray.length);
            // console.log(randomNumber);
            console.log(elem.nextSibling);
            // elem.nextSibling.style.animation=animationArray[randomNumber];
            elem.querySelector(".film_backdrop").style.animation=animationArray[randomNumber];
        })
    },{once: true})

    window.addEventListener("scroll", function() {
        onAppear.forEach(function(elem) {
            // console.log(elem)
            var vwTop = window.scrollY;
            var vwBottom = (window.scrollY + window.innerHeight);
            var elemTop = elem.offsetTop;
            var elemBottom = elem.offsetTop + elem.offsetHeight;
            var elemHeight = elem.offsetHeight;
            var sensitivity = 170;
            // console.log("VW top = " + vwTop);
            // console.log("VW bottom = " + vwBottom);
            if (vwBottom > elemTop && ((vwTop - elemHeight) < elemTop -sensitivity)) {
            elem.classList.remove("faded_row");
            elem.classList.add("focus_row");
            // elem.nextSibling.style.display="block";
            elem.querySelector(".film_backdrop").style.display="block";
            }
            else {
            elem.classList.add("faded_row");
            elem.classList.remove("focus_row");
            // elem.nextSibling.style.display="none";
            elem.querySelector(".film_backdrop").style.display="none";
            }
            if (vwBottom  < elemTop+ elemHeight + sensitivity) {
                elem.classList.add("faded_row");
                elem.classList.remove("focus_row");
                // elem.nextSibling.style.display="none";
                elem.querySelector(".film_backdrop").style.display="none";
            }
        });
        }, false);
}
