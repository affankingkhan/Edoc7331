public static int Shape(String[] arr,int n,int m)
{
    char[][] cArr = new char[n][m];
    for(int i = 0; i< n; i++){
        cArr[i] = arr[i].toCharArray();
    }
    boolean[][] aux = new boolean[n][m];
    int count = 0;
    
  for(int i = 0; i<n; i++){
      for(int j = 0; j<m; j++){
          if(cArr[i][j] == 'X' && !aux[i][j]){
              count++;
              dfs(aux,cArr,i,j,n,m);
          }
      }
  }
 
  return count;
   
}

private static void dfs(boolean[][] visited, char[][] arr, int i, int j,int n, int m){
    if(i<0 ||j<0 || i>=n || j>=m){
        return;
    }
    if(visited[i][j] || arr[i][j] == 'O'){
        return;
    }
    visited[i][j] = true;
    dfs(visited, arr,i+1,j,n,m);
    dfs(visited, arr,i-1,j,n,m);
    dfs(visited, arr,i,j-1,n,m);
    dfs(visited, arr,i,j+1,n,m);
    
}