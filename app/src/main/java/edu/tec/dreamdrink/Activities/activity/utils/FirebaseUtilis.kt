package edu.tec.dreamdrink.Activities.activity.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object FirebaseUtilis {

        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val firebaseUser: FirebaseUser? = firebaseAuth.currentUser

}