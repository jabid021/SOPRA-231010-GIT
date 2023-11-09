
import { config } from "./config.js"


const BASE_URL = config.api_base_url
const API_KEY = config.api_key

console.log(API_KEY);

export async function getPopularMovies(page = 1 ) {
    let data = []
    try {
        const response = await fetch(`${BASE_URL}movie/popular?api_key=${API_KEY}&page=${page}`)
        const responseData = await response.json()
        data = responseData?.results
    } catch (error) {

    }
    return data
}

export async function getTopRatedMovies(page = 1) {
    let data = []
    try {
        const response = await fetch(`${BASE_URL}movie/top_rated?api_key=${API_KEY}&page=${page}`)
        const responseData = await response.json()
        data = responseData?.results
    } catch (error) {

    }
    return data
}


export async function FilterMovies(sort = vote_average.desc) {
    let data = []
    try {
        const response = await fetch(`${BASE_URL}discover/movie?api_key=${API_KEY}&include_adult=false&include_video=false&language=en-US&page=1&sort_by=${sort}`)
        const responseData = await response.json()
        console.log(responseData)
        data = responseData?.results
    } catch (error) {
        console.error(error)
    }
    return data
}


// const options = {
//     method: 'GET',
//     headers: {
//       accept: 'application/json',
//       Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5NjBlZWFkZmU1OGU4YzBlZjZlNmVjYjZjNGZkZmQ1YSIsInN1YiI6IjY1MDc2MGQ5MTA5ZGVjMDE0ZjQxNjY3MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.yDSWoMbLHTfxrxM1tpPRD_WXUVw1gK0Tj8jL8qinZ4I'
//     }
//   };

//   fetch('https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=vote_average.desc', options)
//     .then(response => response.json())
//     .then(response => console.log(response))
//     .catch(err => console.error(err));