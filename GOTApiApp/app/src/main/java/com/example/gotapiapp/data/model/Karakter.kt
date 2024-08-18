package com.example.gotapiapp.data.model

import java.io.Serializable

data class Karakter(var id:Int,
                    var firstName:String?,
                    var lastName:String?,
                    var fullName:String?,
                    var title:String?,
                    var family:String?,
                    var image:String?,
                    var imageUrl:String?) :Serializable {
}