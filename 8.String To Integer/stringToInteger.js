/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    
    const INT_MIN = -1 * 2**31;
    const INT_MAX = 2**31 - 1;
    str = str.trim();
    let sign = 1;
    
    let map = {
        '0': 0,
        '1': 1,
        '2': 2,
        '3': 3,
        '4': 4,
        '5': 5,
        '6': 6,
        '7': 7,
        '8': 8,
        '9': 9
    }
    
    let ret = 0;
    let i = 0;
    
    if(i< str.length && (str.charAt(i) === '+' || str.charAt(i) === '-')){
        sign = (str.charAt(i++) === '-') ? -1 : 1;
    }
    
    while(i<str.length){
        let char = str.charAt(i++);
        if(sign === 1){
            if(ret > INT_MAX){
            return INT_MAX;
            }
        }
        else if(sign === -1){
            if(sign * ret < INT_MIN){
                return INT_MIN;
            }
        }
        if (char in map){
            ret = ret * 10 + map[char];  
        }
        else{
            return ret * sign;
        }
    }
    if(ret > INT_MAX){
        return (sign === 1) ? INT_MAX : INT_MIN;
    }
    return sign * ret;
};