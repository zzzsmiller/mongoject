use study

db.grades.aggregate([
	{$match:{class_id:2} }
]);


