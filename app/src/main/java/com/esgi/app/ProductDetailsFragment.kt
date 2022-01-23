package com.esgi.app

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_details.*


class ProductDetailsFragment : Fragment(){
    private val args:ProductDetailsFragmentArgs by navArgs()
    private lateinit var product : Product
    override fun onCreateView(
        inflater: LayoutInflater, main_content: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, main_content, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        //  NavigationUI.setupWithNavController(product_details_bottom_nav,navHostFragment.navController)
        val navController = navHostFragment.navController

        navController.setGraph(R.navigation.tab_nav, arguments)
        var productDetailsSummary = ProductDetailsSummaryFragment()
        productDetailsSummary.arguments = arguments
        var productDetailsNutrition = ProductDetailsNutritionFragment()
        productDetailsNutrition.arguments = arguments
        var productDetailsNutritionalTab = ProductDetailsTabFragment()
        productDetailsNutritionalTab.arguments = arguments

        val productDetailsSummaryFragment : View = view.findViewById(R.id.productDetailsSummaryFragment)
        val productDetailsNutritionFragment : View = view.findViewById(R.id.productDetailsNutritionFragment)
        val productDetailsNutritionalTabFragment : View = view.findViewById(R.id.productDetailsTabFragment)
        productDetailsSummaryFragment.setBackgroundResource(R.color.toolbar_gradient_end)

        product_details_bottom_nav.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.productDetailsSummaryFragment -> productDetailsSummaryFragment.setBackgroundResource(
                    R.color.toolbar_gradient_end)
                R.id.productDetailsNutritionFragment -> productDetailsNutritionFragment.setBackgroundResource(
                    R.color.toolbar_gradient_end)
                R.id.productDetailsTabFragment -> productDetailsNutritionalTabFragment.setBackgroundResource(
                    R.color.toolbar_gradient_end)
                else -> throw Exception()
            }
            if(R.id.productDetailsSummaryFragment != menu.itemId){
                productDetailsSummaryFragment.setBackgroundColor(Color.WHITE)
            }
            if(R.id.productDetailsNutritionFragment != menu.itemId){
                productDetailsNutritionFragment.setBackgroundColor(Color.WHITE)
            }
            if(R.id.productDetailsTabFragment != menu.itemId){
                productDetailsNutritionalTabFragment.setBackgroundColor(Color.WHITE)
            }

            childFragmentManager.beginTransaction()
                .replace(
                    R.id.product_details_nav_host,
                    when (menu.itemId) {
                        R.id.productDetailsSummaryFragment -> productDetailsSummary
                        R.id.productDetailsNutritionFragment -> productDetailsNutrition
                        R.id.productDetailsTabFragment -> productDetailsNutritionalTab
                        else -> throw Exception()
                    },
                    when (menu.itemId) {
                        R.id.productDetailsSummaryFragment -> productDetailsSummary.tag
                        R.id.productDetailsNutritionFragment -> productDetailsNutrition.tag
                        R.id.productDetailsTabFragment -> productDetailsNutritionalTab.tag
                        else -> throw Exception()
                    }
                )
                .commitAllowingStateLoss()
            true
        }

    }
}