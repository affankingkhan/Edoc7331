/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    
    dp = new Array(s.length+1);
    
    //generate the dp
    //first generate rows of s
    //then generate columns of p
    for(let i = 0 ; i< dp.length;i++){
        dp[i] = new Array(p.length+1);
        if(i == 0){
            dp[i].fill(0);
            dp[0][0] = 1;
        }else{
            dp[i][0] = 0;
        }
    }
    // check 2 back in the first row: "" is pattern match for a* or a*b*
    for(let k=2; k<dp[0].length; k++){
        if(p.charAt(k-1) === '*'){
            dp[0][k] = dp[0][k-2]
        }
    }
    
    for(let i = 1; i<dp.length; i++){
        let sChar = s.charAt(i-1);
        for(let j = 1; j<dp[0].length; j++){
            let pChar = p.charAt(j-1);
            //if the chars are the same or the pattern char is .
            if(pChar == sChar || pChar === '.'){
                dp[i][j] = dp[i-1][j-1];
            }
            // if the pattern char is a *
            else if(pChar === '*'){
                //0 occurences of the previous character
                if(dp[i][j-2] === 1){
                    dp[i][j] = 1;
                }
                //1 or more occurrences of the previous char
                else{
                    if(sChar == p.charAt(j-2) || p.charAt(j-2) == "."){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
            //if the chars are not the same
            else{
                dp[i][j] = 0;
            }
        }
    }
    
    return dp[s.length][p.length] === 1
    
};