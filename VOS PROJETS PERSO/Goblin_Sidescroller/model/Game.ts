import { CANVAS_HEIGHT, CANVAS_WIDTH } from "../const/const";
import { Background } from "./Background";
import { Enemy } from "./Enemy";
import { InputHandler } from "./InputHandler";
import { Player } from "./Player";
// import "../scripts/require.js";

export class Game {
  input: InputHandler;
  background: Background;
  player: Player;
  height: number;
  width: number;
  lastTime: number;
  enemyInterval: number;
  randomEnemyInterval: number;
  enemyTimer: number;
  enemies: Enemy[];
  context: any;
  debug: boolean;
  score: number;
  speed: number;
  gameOver: boolean;
  victory: boolean;
  spanScore: HTMLSpanElement;
  spanVictory: HTMLSpanElement;
  pVictory: HTMLElement;

  constructor(context) {
    this.context = context;
    this.height = CANVAS_HEIGHT;
    this.width = CANVAS_WIDTH;
    this.lastTime = 0;
    this.enemyInterval = 1000;
    this.randomEnemyInterval = Math.random() * 1000 + 500;
    this.enemyTimer = 0;
    this.enemies = [];
    this.input = new InputHandler(this);
    this.background = new Background();
    this.player = new Player(this);
    this.debug = false;
    this.score = 0;
    this.speed = 1;
    this.gameOver = false;
    this.victory = false;
    this.spanScore = document.getElementById("spanScore");
    this.spanVictory = document.getElementById("spanVictory");
    this.pVictory = document.getElementById("pVictory");

  }

  handleEnemies(deltaTime) {
    if (this.enemyTimer > this.enemyInterval + this.randomEnemyInterval) {
      this.enemies.push(new Enemy(this));
      this.randomEnemyInterval = Math.random() * 1000;
      this.enemyTimer = 0;
    } else {
      this.enemyTimer += deltaTime;
    }
    this.enemies.forEach((enemy) => {
      enemy.draw(this.context);
      enemy.update(deltaTime);
      this.enemies = this.enemies.filter((enemy) => !enemy.markedForDeletion);
    });
  }

  handleVictory() {
    if (this.score >= 20) {
      document.body.style.color = "green";
      const message = "Bravo !";
      this.spanVictory.innerHTML = message;
    }
    else {
      this.grayscaleCanvas();
      document.body.style.color = "darkred";
      this.pVictory.style.top = "27%";
      this.pVictory.style.fontSize = "80px";
      const message = "WASTED";
      this.spanVictory.innerHTML = message;
    }
  }

  grayscaleCanvas() {
    const imageData = this.context.getImageData(0, 0, this.width, this.height);
    const data = imageData.data;
    for (let i = 0; i < data.length; i += 4) {
        const luminance = (0.299 * data[i] + 0.587 * data[i + 1] + 0.114 * data[i + 2]);
        data[i] = luminance;
        data[i + 1] = luminance;
        data[i + 2] = luminance;
    }
    this.context.putImageData(imageData, 0, 0);
}

  animate = (timeStamp) => {
    const deltaTime = timeStamp - this.lastTime;
    this.lastTime = timeStamp;

    this.context.clearRect(0, 0, this.width, this.height);
    this.background.draw(this.context);
    this.background.update();
    this.player.draw(this.context);
    this.player.update(this.input, deltaTime);
    
    this.handleEnemies(deltaTime);
    this.displayStatusText();
    if (this.gameOver) {  
      this.handleVictory();
    } else requestAnimationFrame(this.animate);
  };

  displayStatusText() {
    this.spanScore.innerHTML = this.score.toString();
  }
}
