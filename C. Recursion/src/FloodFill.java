public class FloodFill {
    //  Time Complexity : O(m*n)
    //  Auxiliary Space : O(m*n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor) {
            floodFillUtil(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    public void floodFillUtil(int[][] image, int sr, int sc, int prevColor, int newColor) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length) {
            return;
        }
        if(image[sr][sc]!=prevColor) {
            return;
        }
        image[sr][sc] = newColor;
        floodFillUtil(image, sr + 1, sc, prevColor, newColor);
        floodFillUtil(image, sr - 1, sc, prevColor, newColor);
        floodFillUtil(image, sr, sc + 1, prevColor, newColor);
        floodFillUtil(image, sr, sc - 1, prevColor, newColor);
    }
}
