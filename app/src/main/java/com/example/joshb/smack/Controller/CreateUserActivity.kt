package com.example.joshb.smack.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.joshb.smack.R
import com.example.joshb.smack.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvater = "profileDefault"
    var avaterColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View) {
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        if (color == 0) {
            userAvater = "light$avatar"
        } else {
            userAvater = "dark$avatar"
        }
        val resourceID = resources.getIdentifier(userAvater, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceID)
    }

    fun generateColorClicked(view: View) {
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avaterColor = "[$savedR, $savedG, $savedB, 1]"
    }

    fun createUserClicked(view: View) {
        AuthService.registerUser(this, "j@j.com", "123456") { complete ->
            if (complete) {

            }
        }
    }
}
