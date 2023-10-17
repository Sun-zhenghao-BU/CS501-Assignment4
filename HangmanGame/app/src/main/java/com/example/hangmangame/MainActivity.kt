package com.example.hangmangame

import androidx.appcompat.app.AppCompatActivity
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.hangmangame.ui.theme.HangmanTheme
import com.example.hangmangame.databinding.ActivityMainBinding
import com.example.hangmangame.databinding.ActivityMainHoriBinding

import kotlin.random.Random

class MainActivity : ComponentActivity() {


    lateinit var I_gallows: ImageView
    lateinit var t_word: TextView
    lateinit var b_start: Button
    lateinit var b_hint: Button
    lateinit var b_restart: Button
    lateinit var b_a: Button
    lateinit var b_b: Button
    lateinit var b_c: Button
    lateinit var b_d: Button
    lateinit var b_e: Button
    lateinit var b_f: Button
    lateinit var b_g: Button
    lateinit var b_h: Button
    lateinit var b_i: Button
    lateinit var b_j: Button
    lateinit var b_k: Button
    lateinit var b_l: Button
    lateinit var b_m: Button
    lateinit var b_n: Button
    lateinit var b_o: Button
    lateinit var b_p: Button
    lateinit var b_q: Button
    lateinit var b_r: Button
    lateinit var b_s: Button
    lateinit var b_t: Button
    lateinit var b_u: Button
    lateinit var b_v: Button
    lateinit var b_w: Button
    lateinit var b_x: Button
    lateinit var b_y: Button
    lateinit var b_z: Button

    val vowels=arrayOf('a','e','i','o','u')
    val vowelsLocations=arrayOf(0,4,8,14,20)
    var hint_times=0
    lateinit var word: String
    var err_num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val binding_hori: ActivityMainHoriBinding =ActivityMainHoriBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(binding_hori.root)
        } else {
            setContentView(binding.root)
        }
        I_gallows = findViewById(R.id.gallows)
        t_word = findViewById(R.id.the_word)
        b_start = findViewById(R.id.Button_Start)
        b_hint = findViewById(R.id.Button_Hint)
        b_restart = findViewById(R.id.Button_Restart)
        b_a = findViewById(R.id.Button_A)
        b_b = findViewById(R.id.Button_B)
        b_c = findViewById(R.id.Button_C)
        b_d = findViewById(R.id.Button_D)
        b_e = findViewById(R.id.Button_E)
        b_f = findViewById(R.id.Button_F)
        b_g = findViewById(R.id.Button_G)
        b_h = findViewById(R.id.Button_H)
        b_i = findViewById(R.id.Button_I)
        b_j = findViewById(R.id.Button_J)
        b_k = findViewById(R.id.Button_K)
        b_l = findViewById(R.id.Button_L)
        b_m = findViewById(R.id.Button_M)
        b_n = findViewById(R.id.Button_N)
        b_o = findViewById(R.id.Button_O)
        b_p = findViewById(R.id.Button_P)
        b_q = findViewById(R.id.Button_Q)
        b_r = findViewById(R.id.Button_R)
        b_s = findViewById(R.id.Button_S)
        b_t = findViewById(R.id.Button_T)
        b_u = findViewById(R.id.Button_U)
        b_v = findViewById(R.id.Button_V)
        b_w = findViewById(R.id.Button_W)
        b_x = findViewById(R.id.Button_X)
        b_y = findViewById(R.id.Button_Y)
        b_z = findViewById(R.id.Button_Z)
        val library = arrayOf("happy", "hello", "world")
        val buttons = listOf(
            b_a, b_b, b_c, b_d, b_e, b_f, b_g, b_h, b_i, b_j, b_k, b_l, b_m, b_n, b_o, b_p, b_q,
            b_r, b_s, b_t, b_u, b_v, b_w, b_x, b_y, b_z
        )


        if(savedInstanceState==null) {
            word=library[0]
            b_restart.isEnabled = false
            b_hint.isEnabled = false
            b_a.isEnabled = false
            b_b.isEnabled = false
            b_c.isEnabled = false
            b_d.isEnabled = false
            b_e.isEnabled = false
            b_f.isEnabled = false
            b_g.isEnabled = false
            b_h.isEnabled = false
            b_i.isEnabled = false
            b_j.isEnabled = false
            b_k.isEnabled = false
            b_l.isEnabled = false
            b_m.isEnabled = false
            b_n.isEnabled = false
            b_o.isEnabled = false
            b_p.isEnabled = false
            b_q.isEnabled = false
            b_r.isEnabled = false
            b_s.isEnabled = false
            b_t.isEnabled = false
            b_u.isEnabled = false
            b_v.isEnabled = false
            b_w.isEnabled = false
            b_x.isEnabled = false
            b_y.isEnabled = false
            b_z.isEnabled = false
        }
        else {
            hint_times = savedInstanceState.getInt("hint_times")
            err_num = savedInstanceState.getInt("err_num")
            word = savedInstanceState.getString("word").toString()
            t_word.text = savedInstanceState.getString("t_word")
            b_start.isEnabled = savedInstanceState.getBoolean("b_start_IsEnable")
            b_hint.isEnabled = savedInstanceState.getBoolean("b_hint_IsEnable")
            b_restart.isEnabled = savedInstanceState.getBoolean("b_restart_IsEnable")
            b_a.isEnabled = savedInstanceState.getBoolean("b_a_IsEnable")
            b_b.isEnabled = savedInstanceState.getBoolean("b_b_IsEnable")
            b_c.isEnabled = savedInstanceState.getBoolean("b_c_IsEnable")
            b_d.isEnabled = savedInstanceState.getBoolean("b_d_IsEnable")
            b_e.isEnabled = savedInstanceState.getBoolean("b_e_IsEnable")
            b_f.isEnabled = savedInstanceState.getBoolean("b_f_IsEnable")
            b_g.isEnabled = savedInstanceState.getBoolean("b_g_IsEnable")
            b_h.isEnabled = savedInstanceState.getBoolean("b_h_IsEnable")
            b_i.isEnabled = savedInstanceState.getBoolean("b_i_IsEnable")
            b_j.isEnabled = savedInstanceState.getBoolean("b_j_IsEnable")
            b_k.isEnabled = savedInstanceState.getBoolean("b_k_IsEnable")
            b_l.isEnabled = savedInstanceState.getBoolean("b_l_IsEnable")
            b_m.isEnabled = savedInstanceState.getBoolean("b_m_IsEnable")
            b_n.isEnabled = savedInstanceState.getBoolean("b_n_IsEnable")
            b_o.isEnabled = savedInstanceState.getBoolean("b_o_IsEnable")
            b_p.isEnabled = savedInstanceState.getBoolean("b_p_IsEnable")
            b_q.isEnabled = savedInstanceState.getBoolean("b_q_IsEnable")
            b_r.isEnabled = savedInstanceState.getBoolean("b_r_IsEnable")
            b_s.isEnabled = savedInstanceState.getBoolean("b_s_IsEnable")
            b_t.isEnabled = savedInstanceState.getBoolean("b_t_IsEnable")
            b_u.isEnabled = savedInstanceState.getBoolean("b_u_IsEnable")
            b_v.isEnabled = savedInstanceState.getBoolean("b_v_IsEnable")
            b_w.isEnabled = savedInstanceState.getBoolean("b_w_IsEnable")
            b_x.isEnabled = savedInstanceState.getBoolean("b_x_IsEnable")
            b_y.isEnabled = savedInstanceState.getBoolean("b_y_IsEnable")
            b_z.isEnabled = savedInstanceState.getBoolean("b_z_IsEnable")
            when (err_num) {
                1 -> I_gallows.setImageResource(R.drawable.error1)
                2 -> I_gallows.setImageResource(R.drawable.error2)
                3 -> I_gallows.setImageResource(R.drawable.error3)
                4 -> I_gallows.setImageResource(R.drawable.error4)
                5 -> I_gallows.setImageResource(R.drawable.error5)
                6 -> I_gallows.setImageResource(R.drawable.error6)
                else -> {
                    I_gallows.setImageResource(R.drawable.error0)
                }
            }
        }

        b_start.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                I_gallows.setImageResource(R.drawable.error0)
                var randomIndex = Random.nextInt(library.size)
                word = library[randomIndex]
                b_restart.isEnabled = true
                b_start.isEnabled = false
                b_hint.isEnabled = true
                b_a.isEnabled = true
                b_b.isEnabled = true
                b_c.isEnabled = true
                b_d.isEnabled = true
                b_e.isEnabled = true
                b_f.isEnabled = true
                b_g.isEnabled = true
                b_h.isEnabled = true
                b_i.isEnabled = true
                b_j.isEnabled = true
                b_k.isEnabled = true
                b_l.isEnabled = true
                b_m.isEnabled = true
                b_n.isEnabled = true
                b_o.isEnabled = true
                b_p.isEnabled = true
                b_q.isEnabled = true
                b_r.isEnabled = true
                b_s.isEnabled = true
                b_t.isEnabled = true
                b_u.isEnabled = true
                b_v.isEnabled = true
                b_w.isEnabled = true
                b_x.isEnabled = true
                b_y.isEnabled = true
                b_z.isEnabled = true
                val wordLength = word.length
                val underscoreString = "_ "
                val hiddenWord = underscoreString.repeat(wordLength)
                val toast = Toast.makeText(applicationContext, word, Toast.LENGTH_SHORT)
                toast.show()
                t_word.text = hiddenWord
            }
        } as View.OnClickListener)


        fun restart_game(){
            I_gallows.setImageResource(R.drawable.error0)
            reset()
        }

        fun hint_me(hint_time:Int) {
            when (hint_time) {
                1 -> {
                    var my_hint = " "
                    for (i in 0 until word.length - 1) {
                        if (!(t_word.text.toString()).contains(word[i])) {
                            my_hint = "Why not try -> " + word[i]
                            break
                        }
                    }
                    val toast = Toast.makeText(applicationContext, my_hint, Toast.LENGTH_SHORT)
                    toast.show()
                }

                2 -> {
                    err_num += 1
                    changeImage(err_num)
                    var white_b_num = 0
                    for (i in 0 until buttons.size - 1) if (buttons[i].isEnabled) white_b_num += 1
                    white_b_num = white_b_num/2
                    for (i in 0 until buttons.size - 1) {
                        if (buttons[i].isEnabled and ! word.contains(buttons[i].text.toString().toLowerCase())) {
                            buttons[i].isEnabled = false
                            white_b_num -= 1
                            if (white_b_num == 0) break
                        }
                    }
                }

                3 ->{
                    err_num += 1
                    changeImage(err_num)
                    for(i in 0 until vowels.size){
                        if(word.contains(vowels[i])){
                            buttons[vowelsLocations[i]].performClick()
                        }
                        else buttons[vowelsLocations[i]].isEnabled=false
                    }
                }
                4 -> {
                    val temp=word
                    reset()
                    t_word.text=temp
                    I_gallows.setImageResource(R.drawable.error6)
                }
            }
        }

        b_restart.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                restart_game()
            }
        } as View.OnClickListener)

        b_hint.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                hint_times+=1
                hint_me(hint_times)
            }
        } as View.OnClickListener)

        b_a.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_a.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='a'){
                        if_correct=true
                        temp[2*i]='a'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_b.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_b.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='b'){
                        if_correct=true
                        temp[2*i]='b'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_c.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_c.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='c'){
                        if_correct=true
                        temp[2*i]='c'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_d.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_d.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='d'){
                        if_correct=true
                        temp[2*i]='d'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_e.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_e.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='e'){
                        if_correct=true
                        temp[2*i]='e'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_f.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_f.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='f'){
                        if_correct=true
                        temp[2*i]='f'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_g.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_g.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='g'){
                        if_correct=true
                        temp[2*i]='g'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_h.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_h.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='h'){
                        if_correct=true
                        temp[2*i]='h'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_i.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_i.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='i'){
                        if_correct=true
                        temp[2*i]='i'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_j.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_j.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='j'){
                        if_correct=true
                        temp[2*i]='j'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_k.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_k.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='k'){
                        if_correct=true
                        temp[2*i]='k'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_l.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_l.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='l'){
                        if_correct=true
                        temp[2*i]='l'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_m.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_m.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='m'){
                        if_correct=true
                        temp[2*i]='m'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_n.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_n.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='n'){
                        if_correct=true
                        temp[2*i]='n'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_o.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_o.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='o'){
                        if_correct=true
                        temp[2*i]='o'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_p.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_p.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='p'){
                        if_correct=true
                        temp[2*i]='p'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_q.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_q.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='q'){
                        if_correct=true
                        temp[2*i]='q'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_r.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_r.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='r'){
                        if_correct=true
                        temp[2*i]='r'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_s.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_s.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='s'){
                        if_correct=true
                        temp[2*i]='s'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_t.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_t.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='t'){
                        if_correct=true
                        temp[2*i]='t'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_u.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_u.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='u'){
                        if_correct=true
                        temp[2*i]='u'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_v.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_v.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='v'){
                        if_correct=true
                        temp[2*i]='v'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_w.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_w.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='w'){
                        if_correct=true
                        temp[2*i]='w'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_x.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_x.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='x'){
                        if_correct=true
                        temp[2*i]='x'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_y.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_y.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='y'){
                        if_correct=true
                        temp[2*i]='y'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)

        b_z.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                b_z.isEnabled=false
                var temp=StringBuilder(t_word.text.toString())
                var if_correct=false
                for(i in 0 until word.length){
                    if(word[i]=='z'){
                        if_correct=true
                        temp[2*i]='z'
                    }
                }
                if(if_correct) {
                    t_word.text=temp
                    if(! temp.contains("_")){
                        I_gallows.setImageResource(R.drawable.win)
                        reset()
                    }
                } else {
                    err_num+=1
                    changeImage(err_num)
                }
            }
        } as View.OnClickListener)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("hint_times", hint_times)
        outState.putInt("err_num", err_num)
        outState.putString("word", word)
        outState.putString("t_word", t_word.text.toString())
        outState.putBoolean("b_start_IsEnable", b_start.isEnabled)
        outState.putBoolean("b_hint_IsEnable", b_hint.isEnabled)
        outState.putBoolean("b_restart_IsEnable", b_restart.isEnabled)
        outState.putBoolean("b_a_IsEnable", b_a.isEnabled)
        outState.putBoolean("b_b_IsEnable", b_b.isEnabled)
        outState.putBoolean("b_c_IsEnable", b_c.isEnabled)
        outState.putBoolean("b_d_IsEnable", b_d.isEnabled)
        outState.putBoolean("b_e_IsEnable", b_e.isEnabled)
        outState.putBoolean("b_f_IsEnable", b_f.isEnabled)
        outState.putBoolean("b_g_IsEnable", b_g.isEnabled)
        outState.putBoolean("b_h_IsEnable", b_h.isEnabled)
        outState.putBoolean("b_i_IsEnable", b_i.isEnabled)
        outState.putBoolean("b_j_IsEnable", b_j.isEnabled)
        outState.putBoolean("b_k_IsEnable", b_k.isEnabled)
        outState.putBoolean("b_l_IsEnable", b_l.isEnabled)
        outState.putBoolean("b_m_IsEnable", b_m.isEnabled)
        outState.putBoolean("b_n_IsEnable", b_n.isEnabled)
        outState.putBoolean("b_o_IsEnable", b_o.isEnabled)
        outState.putBoolean("b_p_IsEnable", b_p.isEnabled)
        outState.putBoolean("b_q_IsEnable", b_q.isEnabled)
        outState.putBoolean("b_r_IsEnable", b_r.isEnabled)
        outState.putBoolean("b_s_IsEnable", b_s.isEnabled)
        outState.putBoolean("b_t_IsEnable", b_t.isEnabled)
        outState.putBoolean("b_u_IsEnable", b_u.isEnabled)
        outState.putBoolean("b_v_IsEnable", b_v.isEnabled)
        outState.putBoolean("b_w_IsEnable", b_w.isEnabled)
        outState.putBoolean("b_x_IsEnable", b_x.isEnabled)
        outState.putBoolean("b_y_IsEnable", b_y.isEnabled)
        outState.putBoolean("b_z_IsEnable", b_z.isEnabled)
    }
    fun reset(){
        hint_times=0
        err_num=0
        b_restart.isEnabled = false
        b_start.isEnabled = true
        b_hint.isEnabled = false
        t_word.text=""
        b_a.isEnabled = false
        b_b.isEnabled = false
        b_c.isEnabled = false
        b_d.isEnabled = false
        b_e.isEnabled = false
        b_f.isEnabled = false
        b_g.isEnabled = false
        b_h.isEnabled = false
        b_i.isEnabled = false
        b_j.isEnabled = false
        b_k.isEnabled = false
        b_l.isEnabled = false
        b_m.isEnabled = false
        b_n.isEnabled = false
        b_o.isEnabled = false
        b_p.isEnabled = false
        b_q.isEnabled = false
        b_r.isEnabled = false
        b_s.isEnabled = false
        b_t.isEnabled = false
        b_u.isEnabled = false
        b_v.isEnabled = false
        b_w.isEnabled = false
        b_x.isEnabled = false
        b_y.isEnabled = false
        b_z.isEnabled = false
    }

    fun changeImage(errNum:Int){
        if(errNum==6) {
            reset()
        }
        when (errNum) {
            1 -> I_gallows.setImageResource(R.drawable.error1)
            2 -> I_gallows.setImageResource(R.drawable.error2)
            3 -> I_gallows.setImageResource(R.drawable.error3)
            4 -> I_gallows.setImageResource(R.drawable.error4)
            5 -> I_gallows.setImageResource(R.drawable.error5)
            6 -> I_gallows.setImageResource(R.drawable.error6)
            else -> {
                I_gallows.setImageResource(R.drawable.error0)
            }
        }
    }

}
