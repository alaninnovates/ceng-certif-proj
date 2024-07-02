noStroke();
background(187, 232, 99);

var x = -120;
var draw = function () {
  // road
  fill(51, 51, 51);
  rect(0, 212, width, 200);

  // lane
  fill(255, 225, 0);
  for (var i = 0; i < 10; ++i) {
    rect(i * 60, 300, 40, 10);
  }
  // car
  fill(255, 10, 10);
  rect(x, 315, 100, 25);
  rect(20 + x, 290, 60, 30);

  fill(0, 0, 0);
  ellipse(30 + x, 340, 25, 25);
  ellipse(70 + x, 340, 25, 25);
  if (mouseIsPressed) {
    x--;
    if (x < -120) {
      x = width;
    }
  } else {
    x++;
    if (x > width) {
      x = -120;
    }
  }
};
