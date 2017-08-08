export  const sessions = [
    {
        "id":1,
        "filmId":2,
        "time":"19:10:00",
        "halls":[{
            "id":1,
            "hallName":"Hall_1",
            "ratioOrdinaryPlace": 1.1,
            "ratioVipPlace": 1.5,
            "vipPrice":36,
            "ordinaryPrice":77,
            "places":[{id: 1, place: 1, hallId: 1, vipPlace: false}, {id: 10, place: 10, hallId: 1, vipPlace: false}],
            "sessions":[{"id":2,"filmId":3,"time":"04:14:14","halls":[{"id":3,"hallName":"HallName2","ratioOrdinaryPlace":1.1,"ratioVipPlace":1.5,"places":[{id: 1, place: 1, hallId: 1, vipPlace: false}, {id: 10, place: 10, hallId: 1, vipPlace: false}],"vipPrice":0.0,"ordinaryPrice":0.0}]}]
        }]
    },
    {
        "id":2,
        "filmId":1,
        "time":"12:38:31",
        "halls":[]
    },
    {
        "id":3,
        "filmId":2,
        "time":"09:38:00",
        "halls":[]
    }
];