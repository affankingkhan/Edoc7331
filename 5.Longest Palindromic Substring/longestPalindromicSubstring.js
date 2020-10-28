/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    if (s == null ||s.length === 0) return "";
    if (s.length == 1) return s;
    
    let max = s[0];
    
    for(let i = 0.5 ; i<s.length-1; i += 0.5){
        let left;
        let right;
        let currMax = 0;
        if(!Number.isInteger(i)){
            left = Math.floor(i);
            right = Math.ceil(i);
        }else{
            left = i - 1;
            right = i + 1;
            currMax = 1; 
        }
        
        while(left >= 0 && right <s.length){
            if(s.charAt(left) !== s.charAt(right)){
                break;
            }
            currMax += 2;
            max = (currMax > max.length) ? s.slice(left, right + 1) : max;
            left--;
            right++;
        }
    }
    
    return max
};