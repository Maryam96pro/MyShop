package com.example.mydigikala_mac.Utility.ImageView

class ImageSetupImpl:ImageSetup {
    override fun loadImage(imageView: MyImageview, imaAddress: String) {
        if (imageView is MyImageview){
            imageView.setImageURI(imaAddress)
        }
    }
}