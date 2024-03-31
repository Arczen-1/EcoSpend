package com.mobdeve.s15.baluyot.arczen.mc_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {
    private lateinit var viewFlipper: ViewFlipper
    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginBtn: Button
    lateinit var user : TextView
    lateinit var addBtn: Button
    lateinit var expBtn: Button
    lateinit var plannerBtn: Button
    lateinit var chatBtn: Button
    lateinit var backBtn: Button
    lateinit var backBtn2: Button
    lateinit var backBtn3: Button
    lateinit var backBtn4: Button
    lateinit var add_balBtn: Button
    lateinit var amount : TextView
    lateinit var wal_name: EditText
    lateinit var wal_bal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewFlipper = findViewById(R.id.view_flipper)
        //login view
        viewFlipper.displayedChild = 2
        usernameInput = findViewById(R.id.edt_Username)
        passwordInput = findViewById(R.id.edt_Password)
        loginBtn = findViewById(R.id.button)


        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            //dummy data for logging in
            if (username == "user" && password == "pass") {
                Toast.makeText(this@MainActivity, "Successfully Logged in", Toast.LENGTH_SHORT).show()

                //home view
                viewFlipper.displayedChild = 6
                amount = findViewById(R.id.amount)
                user = findViewById(R.id.user)
                user.text = "@" + username

                addBtn = findViewById(R.id.add_btn)
                expBtn = findViewById(R.id.expenses_btn)
                plannerBtn = findViewById(R.id.planner_btn)
                chatBtn = findViewById(R.id.chat_btn)
                addBtn.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Add Expenses", Toast.LENGTH_SHORT).show()

                    //add view
                    viewFlipper.displayedChild = 1

                    add_balBtn = findViewById(R.id.add_bal_btn)
                    backBtn = findViewById(R.id.back_btn)
                    user = findViewById(R.id.user)
                    user.text = "@" + username

                    backBtn.setOnClickListener {
                        viewFlipper.displayedChild = 6
                    }

                    add_balBtn.setOnClickListener {
                        wal_bal = findViewById(R.id.add_bal)

                        val amountText = amount.text.toString()
                        val walBalText = wal_bal.text.toString()

                        val curr = amountText.toIntOrNull() ?: 0
                        val balance = walBalText.toIntOrNull() ?: 0

                        val total = curr + balance

                        val addTotal = total.toString()

                        amount.setText(addTotal)

                        viewFlipper.displayedChild = 6

                        Toast.makeText(this@MainActivity, "Successfully Added PHP $addTotal", Toast.LENGTH_SHORT).show()

                    }
                }

                expBtn.setOnClickListener {
                    viewFlipper.displayedChild = 3
                    backBtn2 = findViewById(R.id.back_btn2)
                    backBtn2.setOnClickListener {
                        viewFlipper.displayedChild = 6
                    }
                }
                plannerBtn.setOnClickListener {
                    viewFlipper.displayedChild = 4
                    backBtn3 = findViewById(R.id.back_btn3)
                    backBtn3.setOnClickListener {
                        viewFlipper.displayedChild = 6
                    }
                }
                chatBtn.setOnClickListener {
                    viewFlipper.displayedChild = 5
                    backBtn4 = findViewById(R.id.back_btn4)
                    backBtn4.setOnClickListener {
                        viewFlipper.displayedChild = 6
                        }
                    }
                }
            }
        }
    }

