//  please watch this: https://www.destroyallsoftware.com/talks/wat

0 == '0'
0 == ''
'' == 0
'' == '0'

false == 'false'
false == '0'

false == undefined
false == null
null == undefined

' \t\r\n' == 0

typeof NaN === 'number'

NaN === NaN
NaN !== NaN

typeof Infinity === 'number'

isNaN(NaN);
isNaN('0');
isNaN('string');

isFinite(NaN);
isFinite(Infinity);
isFinite('0');