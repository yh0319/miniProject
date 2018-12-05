load data 
infile 'C:\\0.ITStudy\\2.java\\forexdb\\forex.csv' 
replace into table forex
fields terminated by ','
OPTIONALLY ENCLOSED BY '"'
(TIME, USDKRW, KRWEUR, EURCNY, KRWJPY, KRWCNY, EURKRW, GBPEUR, JPYKRW, GBPUSD)