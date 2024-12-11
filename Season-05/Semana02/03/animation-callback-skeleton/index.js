const box = document.querySelector("#box");
const container = document.querySelector("#container");

let interval;
let direction = 1; // 1: move right, -1: move left


/**
 * Moves the box within the container by updating its `left` style property.
 * The box changes direction when it hits the boundaries of the container.
 */
function move() {
    // Get the computed styles for the box and container
    const boxStyle = getComputedStyle(box);
    const containerStyle = getComputedStyle(container);

    // Parse the current left position of the box and the dimensions of the container and box
    const boxLeft = parseInt(boxStyle.left);
    const containerWidth = parseInt(containerStyle.width);
    const boxWidth = parseInt(boxStyle.width);

    // Calculate new left position by moving the box by 1px in the current direction
    // Move the box by 1px in the current direction
    const newLeft = boxLeft + direction;

    // Check if the box has hit the right boundary
    // Check boundaries
    if (newLeft + boxWidth > containerWidth) {
        direction = -1; // Change direction to left
    } 
    // Check if the box has hit the left boundary
    else if (newLeft < 0) {
    } else if (newLeft < 0) {
        direction = 1; // Change direction to right
    }

    // Update the left position of the box
    box.style.left = newLeft + "px";
}

// Start the movement on click
box.addEventListener("click", () => {
    if (interval) return; // Prevent multiple intervals
    interval = setInterval(move, 10);
});