package com.illiaherman.model

/**
 * Created by illia.herman on 14.08.2019
 */
object Data {
    val footballClubList = ArrayList<FootballClub>()

    init {
        footballClubList.addAll(
            arrayListOf(
                FootballClub(
                    id = 0,
                    name = "Barcelona",
                    foundedYear = 1899,
                    logo = "https://www.imglicensing.com/media/1118/fcbarcelona.png"
                ),
                FootballClub(
                    id = 1,
                    name = "Manchester United",
                    foundedYear = 1902,
                    logo = "https://www.pinclipart.com/picdir/big/390-3902672_manchester-united-logo-clipart-manchester-united-logo-man.png"
                ),
                FootballClub(
                    id = 2,
                    name = "Juventus",
                    foundedYear = 1897,
                    logo = "https://worldsportlogos.com/wp-content/uploads/2018/01/Juventus-logo-600x338.png"
                ),
                FootballClub(
                    id = 3,
                    name = "Borussia Dortmund",
                    foundedYear = 1909,
                    logo = "https://cdn.freebiesupply.com/images/large/2x/borussia-dortmund-logo-png-transparent.png"
                ),
                FootballClub(
                    id = 4,
                    name = "Dynamo Kyiv",
                    foundedYear = 1927,
                    logo = "https://pngimage.net/wp-content/uploads/2018/05/dinamo-kiev-logo-png-7.png"
                )
            )
        )
    }
}