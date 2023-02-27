//LEETCODE: 733

/*An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.*/

class Solution {

    public void dfs(int[][]image, int sr, int sc, int color, int prevcolor, int r, int c){

      //if it is not of prevcolor or having color already
        if(sr>=r || sr<0 || sc>=c || sc<0 || image[sr][sc]==color || image[sr][sc]!=prevcolor){
            return;
        }
        //make it colourful
        image[sr][sc]=color;
        
      //go in 4-direction
        dfs(image, sr+1, sc, color, prevcolor, r, c);
        dfs(image, sr, sc-1, color, prevcolor, r, c);
        dfs(image, sr-1, sc, color, prevcolor, r, c);
        dfs(image, sr, sc+1, color, prevcolor, r, c);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc]==color){
            return image;
        }

         dfs(image, sr, sc, color, image[sr][sc], image.length, image[0].length);

         return image;
    }

}
