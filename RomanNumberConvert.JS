function convertToRoman(num) {
  let m = ["", "M", "MM", "MMM"];
    let c = ["", "C", "CC", "CCC", "CD", "D",
                        "DC", "DCC", "DCCC", "CM"];
    let x = ["", "X", "XX", "XXX", "XL", "L",
                        "LX", "LXX", "LXXX", "XC"];
    let i = ["", "I", "II", "III", "IV", "V",
                        "VI", "VII", "VIII", "IX"];
         
    // Converting to roman
    let thousands = m[Math.floor(num/1000)];
    let hundereds = c[Math.floor((num%1000)/100)];
    let tens = x[Math.floor((num%100)/10)];
    let ones = i[num%10];
         
    let ans = thousands + hundereds + tens + ones;
         
    return ans;
}

convertToRoman(36);
console.log(convertToRoman(375));