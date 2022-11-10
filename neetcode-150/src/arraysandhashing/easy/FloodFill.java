package arraysandhashing.easy;

public class FloodFill {
    class Solution {

        public int[][] floodFill(int[][] image, int sr, int sc, int targetColor) {

            if (indexIsOutOfBounds(image, sr, sc)) {
                return image;
            }

            // sourceColor -> color to be replaced
            int sourceColor = image[sr][sc];

            // targetColor -> new color
            fill(image, sr, sc, targetColor, sourceColor);

            return image;
        }

        private void fill(int[][] image, int sr, int sc, int targetColor, int sourceColor) {

            // if current cell does not need to be filled, exit method
            if (indexIsOutOfBounds(image, sr, sc) ||
                    image[sr][sc] == targetColor ||
                    image[sr][sc] != sourceColor) {
                return;
            }

            // fill current cell
            image[sr][sc] = targetColor;

            // fill up cell
            fill(image, sr + 1, sc, targetColor, sourceColor);

            // fill right cell
            fill(image, sr, sc + 1, targetColor, sourceColor);

            // fill down cell
            fill(image, sr - 1, sc, targetColor, sourceColor);

            // fill left cell
            fill(image, sr, sc - 1, targetColor, sourceColor);

        }

        private boolean indexIsOutOfBounds(int[][] image, int sr, int sc) {
            return sr < 0 || sr >= image.length ||
                    sc < 0 || sc >= image[0].length;
        }

    }
}
