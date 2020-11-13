/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    const lookup = {
    M: 1000,
    CM: 900,
    D: 500,
    CD: 400,
    C: 100,
    XC: 90,
    L: 50,
    XL: 40,
    X: 10,
    IX: 9,
    V: 5,
    IV: 4,
    I: 1
  }
  let result = 0
  
  while(s.length) {
      const firstTwoLetters = s[0] + s[1]
      if(lookup[firstTwoLetters]) {
          result += lookup[firstTwoLetters]
          s = s.slice(2)
      } else {
          const firstOneLetter = s[0]
          result += lookup[firstOneLetter]
          s = s.slice(1)
      }
  }
    
  return result
};