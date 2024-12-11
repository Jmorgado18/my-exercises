const box = document.querySelector("#box");
const container = document.querySelector("#container");

let interval;
let direction = 1; // 1: move right, -1: move left

/**
 * Move the box by 1px in the current direction.
 *
 * @returns {void}
 */
function moveBox() {
    const boxStyle = getComputedStyle(box);
    const containerStyle = getComputedStyle(container);

    // Get the current position of the box and the width of the box and the container
    const boxLeft = parseInt(boxStyle.left);
    const containerWidth = parseInt(containerStyle.width);
    const boxWidth = parseInt(boxStyle.width);

    // Move the box by 1px in the current direction
    const newLeft = boxLeft + direction;

    // Check if the box is at the edge of the container and reverse the direction
    // Check boundaries
    if (newLeft + boxWidth > containerWidth) {
        direction = -1; // Change direction to left
    } else if (newLeft < 0) {
        direction = 1; // Change direction to right
    }

    // Update the position of the box
    box.style.left = newLeft + "px";
}


// Start the movement on click
box.addEventListener("click", () => {
    if (interval) return; // Prevent multiple intervals
    interval = setInterval(moveBox, 10);
});
