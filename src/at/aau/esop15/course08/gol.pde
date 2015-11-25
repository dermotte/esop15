boolean[][] grid, ngrid, tgrid;
float wstep, hstep;
int mysize = 800;
int gridSize = 398;
boolean isRunning = true;
boolean debug = false;

void setup() {
  size(mysize,mysize);
  grid = new boolean[gridSize][gridSize];
  ngrid = new boolean[gridSize][gridSize];
  initGrid();
  wstep = mysize / (float) (gridSize+2);
  hstep = mysize / (float) (gridSize+2);
  frameRate(30);
}

void draw() {
  // draw
  background(0);
  fill(155);
  stroke(200);
  for (int i=0;i<grid.length;i++) {
    for (int j=0; j<grid[i].length;j++) {
      if (grid[i][j]) 
        rect((i+1)*wstep, (j+1)*hstep, wstep, hstep);
        if (debug) {
          fill(0);
          text(numNeighbours(i,j), (i+1)*wstep+14, (j+1)*hstep+14);
          fill(155);
        }
    }
  }  
  // compute

  if (isRunning) {  
    for (int i=0;i<grid.length;i++) {
      for (int j=0; j<grid[i].length;j++) {
        ngrid[i][j] = grid[i][j];
      }
    }
    for (int i=0;i<grid.length;i++) {
      for (int j=0; j<grid[i].length;j++) {
        if (ngrid[i][j]) {
          // rule 1:
          if (numNeighbours(i,j)<2) grid[i][j] = false;
          // rule 3:
          if (numNeighbours(i,j)>3) grid[i][j] = false;
        } else {
          // rule 4:
          if (numNeighbours(i,j)==3) grid[i][j] = true;
        }
      }
    } 
  }
}

void initGrid() {
  for (int i=0;i<grid.length;i++) {
    for (int j=0; j<grid[i].length;j++) {
      if(Math.random()<0.5) {
        grid[i][j] = false;
        ngrid[i][j] = false;
      } else {
        grid[i][j] = true;
        ngrid[i][j] = true;
      }
    }
  }
}

int numNeighbours(int i, int j) {
  int count = 0;
  for (int x=-1; x<=1; x++) {
    for(int y=-1; y<=1; y++) {
      if (!(x==0 && y==0) && ngrid[(i+x+gridSize)%gridSize][(j+y+gridSize)%gridSize]) count++;
    }
  }
  return count;
}

void mouseClicked() {
  isRunning = false;
  initGrid();
  isRunning = true;
}
