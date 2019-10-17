package com.tence.admob

import android.content.Context
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

object AdMob {

    fun initialize(context: Context){
        MobileAds.initialize(context, BuildConfig.ADMOB_APP_ID)
    }

    class Interstitial(context: Context){

        private val mAdListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                ad.loadAd(AdRequest.Builder().build())
            }
        }

        val ad: InterstitialAd by lazy{
            InterstitialAd(context).apply{
                adUnitId = BuildConfig.ADMOB_INTERSTITIAL_ID
                adListener = mAdListener
            }
        }

        init {
            ad.loadAd(AdRequest.Builder().build())
//        adView.loadAd(AdRequest.Builder().build())
        }
    }
}