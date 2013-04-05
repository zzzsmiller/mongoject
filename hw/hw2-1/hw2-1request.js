use students;

db.grades.aggregate(
    {'$match':{'type':'exam'}},
    {'$match':{'score':{'$gte':65}}},
    {'$sort':{'score':1}},
    {'$limit':1}
);

db.getLastError();