load data 
infile 'C:\\0.ITStudy\\2.java\\forexdb\\instant2.csv' 
append 
into table usdkrw
fields terminated by ','
OPTIONALLY ENCLOSED BY '"'
(TIME, now, changes, changespercent, daymin, daymax, yearmin, yearmax)