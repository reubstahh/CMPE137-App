package com.example.myapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.ViewGroup.LayoutParams
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * SplashScreen activity displays a centered image on a lime background
 */
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the main container layout
        val containerLayout = ConstraintLayout(this).apply {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
            )
            setBackgroundColor(Color.parseColor("#D9F99D")) // Approximate color for bg-lime-200
        }

        // Create the image view
        val imageView = ImageView(this).apply {
            id = View.generateViewId()
            scaleType = ImageView.ScaleType.FIT_CENTER

            // Apply shadow and rounded corners programmatically
            elevation = 8f // For shadow effect
        }

        // Add the image view to the container with constraints
        containerLayout.addView(imageView)

        // Set constraints to center the image
        val constraints = ConstraintLayout.LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        ).apply {
            // Set aspect ratio to make it square
            dimensionRatio = "1:1"
            // Add margins equivalent to px-14
            val horizontalMargin = resources.displayMetrics.density * 56 // 14dp * 4
            setMargins(horizontalMargin.toInt(), 0, horizontalMargin.toInt(), 0)

            // Center the image
            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        }

        imageView.layoutParams = constraints

        // Load the image with Glide
        Glide.with(this)
            .asBitmap()
            .load("https://cdn.builder.io/api/v1/image/assets/TEMP/3641f77570b8459edf23e1440c333227f9187c4b?placeholderIfAbsent=true&apiKey=eb14ebbf8c384a02b3eef66a221c2c79")
            .centerCrop()
            .into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: android.graphics.Bitmap?) {
                    resource?.let {
                        val roundedDrawable = RoundedBitmapDrawableFactory.create(resources, it)
                        roundedDrawable.cornerRadius = 50f * resources.displayMetrics.density // 50dp rounded corners
                        imageView.setImageDrawable(roundedDrawable)
                    }
                }
            })

        // Set the content view to our layout
        setContentView(containerLayout)

        // Optional: Auto-navigate to main activity after delay
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to main activity
            // startActivity(Intent(this, MainActivity::class.java))
            // finish()
        }, 3000) // 3 seconds delay
    }
}