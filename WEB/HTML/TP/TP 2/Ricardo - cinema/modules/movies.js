const moviesDiv = document.getElementById("movies")

import { getPopularMovies } from "./api.js";
import { getTopRatedMovies } from "./api.js";
import { config } from "./config.js";

export async function renderMovies() {
    // const movies = await getPopularMovies()
    for (let page = 1; page <= 1 ; page++){
        const movies = await getTopRatedMovies(page)
        console.log(movies)
        moviesDiv.innerHTML = moviesDiv.innerHTML  + movies?.map(movie => renderSingleMovie(movie)).join("")
        // console.log(moviesDiv.innerHTML)
    }
}


function renderSingleMovie(movie) {
    return (
        // AS TABLE ROW
        `
        <tr>
            <td>
                <img src="${config.image_base_url + movie?.poster_path}" width= 250px class="img-fluid" >
            </td>
            <td>
                ${movie?.title}
                ${movie?.original_title == movie?.title ? "" : "<br>" + movie?.original_title }
            </td>
            <td>
                ${movie?.overview}
            </td>
            <td>
            ${movie?.vote_average} <br> (${movie?.vote_count})
            </td>
            <td>
            ${movie?.release_date}
            </td>
            <td>
            ${movie?.original_language}
            </td>
        </tr>
        `

// adult: false
// backdrop_path: "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg"
// genre_ids: [18, 80] (2)
// original_language: "en"
// popularity: 147.845


    )
}