use study

db.grades.aggregate([
	{$unwind:"$scores"}
,
	{$match: { "scores.type":{$in:["exam", "homework"]} }
	}
,
	{$group:
		{
			_id: {student:"$student_id", clazz:"$class_id"},
			avg_score:{$avg:"$scores.score"}
		}

	}
,
	{$group:
		{
			_id:"$_id.clazz",
			avg_score:{$avg:"$avg_score"}
		}
	}
,
	{$sort: {avg_score:-1} }
,
	{$limit:2}

]);


