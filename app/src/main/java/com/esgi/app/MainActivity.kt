package com.esgi.app

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager ? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

     /* layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
       recyclerView.itemAnimator = DefaultItemAnimator()*/



/*
        findViewById<TextView>(R.id.product_barcode).setBoldValue(
            getString(R.string.product_barcode, "1234567")
        )

        findViewById<TextView>(R.id.solde_in).setBoldValue(
            getString(R.string.solde_in, "France, Japon, Suisse")
        )

        findViewById<TextView>(R.id.quantity).setBoldValue(
            getString(R.string.quantity, "400 g (280 g net égoutté)")
        )

        findViewById<TextView>(R.id.ingredients).setBoldValue(
            getString(R.string.ingredients, "Petits pois 66%, eau, garniture 2,8% (salade, oignon grelot), sucre, sel, arôme naturel")
        )

        findViewById<TextView>(R.id.allergenic_substances).setBoldValue(
            getString(R.string.allergenic_substances, "Aucune")
        )

        findViewById<TextView>(R.id.additives).setBoldValue(
            getString(R.string.additives, "Aucun")
        )
        */

    }

   /* fun TextView.setBoldValue(value: String) {
        val index = value.indexOf(':')
        val spannable = SpannableString(value)

        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, index, 0)
        setText(spannable)
    }  */
}



/*Snackbar.make(
    findViewById(android.R.id.content),
    "Hello World",
    Snackbar.LENGTH_INDEFINITE
).apply {
    setAction("Clique-moi dessus", object : View.OnClickListener {
        override fun onClick(p0: View?) {
            // TODO("Not yet implemented")
        }

    })
    show()
}*/

/*if (BuildConfig.DEBUG) {

}*/