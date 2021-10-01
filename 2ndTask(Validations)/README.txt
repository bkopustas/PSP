Dauguma unit testų buvo sunkiai suprantami ir nekorektiški. 
Jie naudojo Junit 4.12 sintaksę, kuri negalioja Junit 5 versijoje, tad nemažai testų perrašiau į man suprantamesnius. 
Senieji testai liko užkomentuoti.
Mano nuomone daug kodo buvo parašyta per sudėtingai tai stengiausi jį supaprastinti.
Gauti testai netikrino kai įvestis yra tuščia arba null.
Taip pat senieji testai naudoja daug custom exception'ų, manau būtų buvę galima apseiti ir be jų, tačiau juos susikūriau ir naudojau.
