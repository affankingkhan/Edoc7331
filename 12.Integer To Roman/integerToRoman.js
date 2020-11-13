/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    let str = '';
    let cNum = num;
    while(cNum>0){
        if(cNum >= 1000){
            str += 'M'
            cNum -= 1000;
        }
        else if(cNum >= 900){
            str += 'CM';
            cNum -= 900;
        }
        else if (cNum >= 500){
            str += 'D';
            cNum -= 500;
        }
        else if (cNum >= 400){
            str += 'CD';
            cNum -= 400;
        }
        else if (cNum >= 100){
            str += 'C';
            cNum -= 100;
        }
        else if (cNum >= 90){
            str += 'XC';
            cNum -= 90;
        }
        else if (cNum >= 50){
            str += 'L';
            cNum -= 50;
        }
        else if (cNum >= 40){
            str += 'XL';
            cNum -= 40;
        }
        else if (cNum >= 10){
            str += 'X';
            cNum -= 10;
        }
        else if (cNum >= 9){
            str += 'IX';
            cNum -= 9;
        }
        else if (cNum >= 5){
            str += 'V';
            cNum -= 5;
        }
        else if (cNum >= 4){
            str += 'IV';
            cNum -= 4;
        }
        else{
            str += 'I';
            cNum -= 1;
        }
    }
    return str;
};