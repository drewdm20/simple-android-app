package com.example.retrofitapplication

object Helper {

    fun defineDatas(): ArrayList<Persons> {
        val a = ArrayList<Persons>()

        a.add(Persons("Adidas (gray)", R.drawable.adidas))
        a.add(Persons("Nike (black)", R.drawable.nike))
        a.add(Persons("Palladium (black)", R.drawable.palladium))
        a.add(Persons("All Star (white)", R.drawable.allstar))
        a.add(Persons("Reebok (white)", R.drawable.reebok2))
        a.add(Persons("Adidas (maroon)", R.drawable.adidas1))
        a.add(Persons("Puma (maroon)", R.drawable.puma1))
        a.add(Persons("Nike (gray)", R.drawable.nike2))
        a.add(Persons("Reebok (black)", R.drawable.reebok))
        a.add(Persons("Adidas (green)", R.drawable.reebok1))
        a.add(Persons("Adidas (pink)", R.drawable.adidas2))
        a.add(Persons("Puma (pink)", R.drawable.puma))
        a.add(Persons("Reebok (mustard)", R.drawable.reebok3))
        a.add(Persons("Le Coq (white)", R.drawable.lecoq))
        a.add(Persons("New Balance (olive)", R.drawable.newbalance))
        a.add(Persons("Reebok (black)", R.drawable.reebok4))
//        a.add(Persons("baba", R.drawable.a6))
//        a.add(Persons("gaga", R.drawable.a1))
//        a.add(Persons("tata", R.drawable.a3))
//        a.add(Persons("haha", R.drawable.a7))
//        a.add(Persons("caca", R.drawable.a4))


        return a
    }
}