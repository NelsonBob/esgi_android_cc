package com.esgi.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        main_content: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.produit_list_fragment,
            main_content,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product1 = Product("Petits pois et carottes", "Cassegrain",
            "3083680085304", "A"
            ,"234kCal"
            ,"https://i.imgur.com/JhYpzdR.jpeg"
            ,"400 g (280 g net égoutté)"
            , arrayOf("France", "Japon", "Suisse")
            , arrayOf("Petits pois 66%", "eau", "garniture 2,8%", "salade", "oignon", "grelot", "sucre", "sel", "arôme naturel")
            , arrayOf("Aucune")
            , arrayOf("Aucune"))

        val product2 = Product("Kebab", "Turc",
            "40593402950", "GROS"
            ,"1000kCal"
            ,"https://i.imgur.com/s2dHXJ6.jpeg"
            ,"400 g (280 g net égoutté)"
            , arrayOf("93", "92", "91")
            , arrayOf("Petits pois 66%", "eau", "garniture 2,8%", "salade", "oignon", "grelot", "sucre", "sel", "arôme naturel")
            , arrayOf("Aucune")
            , arrayOf("Aucune"))
         val products = arrayOf(product1,product2,product1,product2,product1,product2,product1,product2)
        view.findViewById<RecyclerView>(R.id.products_View).run{
            adapter = RecyclerAdapter(
                products,
                listener = object : OnListProductClickListener {
                    override fun onProductClicked(position: Int) {
                        findNavController().navigate(
                            ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment2(
                                products[position]
                            )

                        )
                    }

                }
            )
            layoutManager = GridLayoutManager(requireContext(),1)
        }
    }

}