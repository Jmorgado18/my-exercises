const box = document.querySelector("#box");

function move({ target }) {
  const actualPosition = parseInt(getComputedStyle(target).left);
  target.style.left = actualPosition + 1 + "px";
}

box.addEventListener("click", (e) => {
  move(e);
});
