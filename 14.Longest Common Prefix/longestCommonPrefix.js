/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    let prefix = '';
    let minLength = Number.MAX_SAFE_INTEGER;
    if(strs.length < 1){
        return prefix;
    }
    strs.forEach((str)=>{
        minLength = Math.min(minLength, str.length);
    })
    
    for(let i=0; i<minLength; i++){
        let char = strs[0].charAt(i);
        for(let j = 1; j<strs.length; j++){
            if(strs[j].charAt(i) !== char){
                return prefix;
            }
        }
        prefix += char;
    }
    return prefix
};