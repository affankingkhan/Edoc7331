/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    // let min = -1 * 2 ** 30
    let max = 2 **31 -1;
    
    let arr = [];
    
    let isNeg = false;
    if(x<0){
        isNeg = true;
        x *= -1;
    }
    
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
        '9': 9,
        
    }
    
    let ret = 0;
    let multiplier = 1;
    
    let str = x.toString();
    let length = str.length;
    
    for(let i=0 ; i<str.length; i++){
        let val = map[str.charAt(i)] * multiplier;
        multiplier *= 10;
        ret += val;
        if(ret > max){
            return 0;
        }
    }
    
    return isNeg ? -1*ret : ret
    
};