load data 
infile 'C:\\0.ITStudy\\2.java\\forexdb\\usdkrw.csv' 
replace into table usdkrw
fields terminated by ','
OPTIONALLY ENCLOSED BY '"'
(TIME, now, changes, changespercent, daymin, daymax, yearmin, yearmax)