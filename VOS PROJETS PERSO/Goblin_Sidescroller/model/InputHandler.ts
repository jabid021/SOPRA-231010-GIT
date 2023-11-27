import { Game } from "./Game";

export  class InputHandler {
  keys: any[];
  game: Game;
  constructor(game) {
    this.game = game;
    this.keys = [];

    window.addEventListener("keydown", (e) => {
      if (
        (e.key === "ArrowDown" ||
          e.key === "ArrowUp" ||
          e.key === "ArrowLeft" ||
          e.key === "ArrowRight") &&
        !this.keys.includes(e.key)
      ) {
        this.keys.push(e.key);
      } else if (e.key === "d") {
        this.game.debug = !this.game.debug;
      }
    });

    window.addEventListener("keyup", (e) => {
      if (
        e.key === "ArrowDown" ||
        e.key === "ArrowUp" ||
        e.key === "ArrowLeft" ||
        e.key === "ArrowRight"
      ) {
        this.keys.splice(this.keys.indexOf(e.key), 1);
      }
    });
  }
}