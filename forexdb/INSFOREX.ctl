load data 
infile 'C:\\0.ITStudy\\2.java\\forexdb\\instant1.csv' 
append 
into table forex
fields terminated by ','
OPTIONALLY ENCLOSED BY '"'
(TIME, USDKRW, KRWEUR, EURCNY, KRWJPY, KRWCNY, EURKRW, GBPEUR, JPYKRW, GBPUSD)