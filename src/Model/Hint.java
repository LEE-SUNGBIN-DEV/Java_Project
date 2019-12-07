package Model;


public class Hint implements Runnable
{
   
   TileGrid grid;
   

   public Hint(TileGrid grid)
   {
      this.grid = grid;
   }
   
   public static boolean validCheck(int col, int row) {
      if( 1<=col&&col<=8&&1<=row&&row<=6 ) { return true; }
      else { return false; }
   }
   
   public static boolean equalCheck(int c1, int r1, int c2, int r2, int c3, int r3, TileGrid grid) {
      if(grid.GetTile(c1, r1).getType()==grid.GetTile(c2, r2).getType()&&grid.GetTile(c2, r2).getType()==grid.GetTile(c3, r3).getType()) {return true;}
      else { return false; }
   }
   
   
   public static boolean leftCheck(int c, int r, TileGrid grid) {
      return ((validCheck(c,r-3) && equalCheck(c,r,c,r-2,c,r-3, grid))||
            (validCheck(c-1,r-1) && validCheck(c+1,r-1) && equalCheck(c,r,c-1,r-1,c+1,r-1, grid))||
            (validCheck(c-2,r-1) && equalCheck(c,r,c-1,r-1,c-2,r-1, grid))||
            (validCheck(c+2,r-1) && equalCheck(c,r,c+1,r-1,c+2,r-1, grid)));
            
   }
   
   public static boolean rightCheck(int c, int r, TileGrid grid) {
      return ((validCheck(c,r+3) && equalCheck(c,r,c,r+2,c,r+3, grid))||
            (validCheck(c-1,r+1) && validCheck(c+1,r+1) && equalCheck(c,r,c-1,r+1,c+1,r+1, grid))||
            (validCheck(c-2,r+1) && equalCheck(c,r,c-1,r+1,c-2,r+1, grid))||
            (validCheck(c+2,r+1) && equalCheck(c,r,c+1,r+1,c+2,r+1, grid)));
            
   }
   
   public static boolean downCheck(int c, int r, TileGrid grid) {
      return ((validCheck(c-3,r) && equalCheck(c,r,c-2,r,c-3,r, grid))||
            (validCheck(c-1,r-1) && validCheck(c-1,r+1) && equalCheck(c,r,c-1,r-1,c-1,r+1, grid))||
            (validCheck(c-1,r-2) && equalCheck(c,r,c-1,r-1,c-1,r-2, grid))||
            (validCheck(c-1,r+2) && equalCheck(c,r,c-1,r+1,c-1,r+2, grid)));
   }
   
   public static boolean upCheck(int c, int r, TileGrid grid) {
      return ((validCheck(c+3,r) && equalCheck(c,r,c+2,r,c+3,r, grid))||
            (validCheck(c+1,r-1) && validCheck(c+1,r+1) && equalCheck(c,r,c+1,r-1,c+1,r+1, grid))||
            (validCheck(c+1,r-2) && equalCheck(c,r,c+1,r-1,c+1,r-2, grid))||
            (validCheck(c+1,r+2) && equalCheck(c,r,c+1,r+1,c+1,r+2, grid)));
   }
   

   @SuppressWarnings("unused")
   public void run()
   {
      while(true)
      {
         
         //if() , timer 가져오기  , 5초 이상 시 힌트 찾기
         
         for (int j = 1; j <= 6; j++) {
            for (int i = 1; i <= 8; i++) {   
               System.out.println(grid.GetTile(i, j).getType());
               // 위, 아래, 왼, 오  swap시  match되는  tile 탐색, 첫번쨰  tile 발견 후 break   
               if (leftCheck(i,j, grid)||rightCheck(i,j, grid)||upCheck(i,j, grid)||downCheck(i,j, grid)) {
                  System.out.println(i);
                  System.out.println(j);
                  
               }   
            }   
         }
         
         try {
            Thread.sleep(200);
         } catch(InterruptedException e) {
            System.out.println(e);
         }
         
       }
   }
   
   
}