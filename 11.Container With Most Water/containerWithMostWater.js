/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let left = 0;
    let right = height.length - 1;
    let max = 0;
    while (left < right) {
        max = Math.max((right - left) * Math.min(height[left], height[right]), max);
        if (height[left] <= height[right]) left++;
        else right--;
    }
    return max;
};


/**Because the width is always decreasing. The only way to get a larger area is to increase the height of the rectangle.  And since the height is determined by the shorter end, you move the shorter end in the hope of increasing the height of the rectangle.
**/