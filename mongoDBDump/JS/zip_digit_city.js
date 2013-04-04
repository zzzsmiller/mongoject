use mail

db.zips.aggregate([
	{$project: {first_char:{$substr:["$city",0,1]} ,
		    city:1,
		    zip:"$_id",
		    pop:1 
		   }
	},
	{$match: {first_char:{$in:["0","1","2","3","4","5","6","7","8","9"]}}}	
	,{$group: {_id:null, pop_sum:{$sum:"$pop"} } }
]);
