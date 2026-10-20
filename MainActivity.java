package com.suraj.personalai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private LinearLayout messages;
    private EditText input;
    private ScrollView scroll;
    private int dp(int v) { return (int)(v * getResources().getDisplayMetrics().density + 0.5f); }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(19,31,48));
        getWindow().setNavigationBarColor(Color.rgb(19,31,48));
        LinearLayout root = new LinearLayout(this); root.setOrientation(1); root.setPadding(dp(16),dp(12),dp(16),dp(12)); root.setBackgroundColor(Color.rgb(245,247,250));
        TextView title = new TextView(this); title.setText("Suraj Personal AI"); title.setTextSize(24); title.setTextColor(Color.rgb(22,43,70)); root.addView(title);
        TextView sub = new TextView(this); sub.setText("मराठी • हिंदी | पहिली चाचणी आवृत्ती"); sub.setTextSize(14); root.addView(sub);
        scroll = new ScrollView(this); messages = new LinearLayout(this); messages.setOrientation(1); messages.setPadding(0,dp(12),0,dp(12)); scroll.addView(messages); root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));
        addMessage("Suraj Personal AI","नमस्कार! हा तुमच्या अॅपचा पहिला नमुना आहे. सध्या ऑनलाइन AI आणि offline GGUF मॉडेल जोडलेले नाही.");
        LinearLayout bottom = new LinearLayout(this); bottom.setOrientation(0); input = new EditText(this); input.setHint("इथे संदेश लिहा…"); input.setTextSize(16); bottom.addView(input,new LinearLayout.LayoutParams(0,-2,1));
        Button send = new Button(this); send.setText("पाठवा"); bottom.addView(send); send.setOnClickListener(v -> sendMessage()); root.addView(bottom); setContentView(root);
    }
    private void sendMessage() {
        String text = input.getText().toString().trim(); if (text.isEmpty()) return;
        addMessage("तुम्ही",text); input.setText("");
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(input.getWindowToken(),0);
        String l=text.toLowerCase(); String answer;
        if (l.contains("नमस्कार") || l.contains("hello") || l.equals("hi")) answer="नमस्कार! मी Suraj Personal AI ची चाचणी आवृत्ती आहे.";
        else if (l.contains("तू कोण") || l.contains("who are you")) answer="मी Suraj Personal AI अॅपचा सुरुवातीचा नमुना आहे. अजून खरे AI मॉडेल जोडलेले नाही.";
        else answer="तुमचा संदेश मिळाला. ही चाचणी आवृत्ती आहे; खरे AI उत्तर मिळण्यासाठी ऑनलाइन सेवा किंवा offline मॉडेल जोडणे बाकी आहे.";
        addMessage("Suraj Personal AI",answer);
    }
    private void addMessage(String who,String text) {
        TextView bubble=new TextView(this); bubble.setText(who+"
"+text); bubble.setTextSize(16); bubble.setTextColor(Color.rgb(35,45,58)); bubble.setPadding(dp(12),dp(10),dp(12),dp(10)); bubble.setBackgroundColor(who.equals("तुम्ही")?Color.rgb(220,235,255):Color.WHITE);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2); lp.setMargins(0,0,0,dp(10)); messages.addView(bubble,lp); scroll.post(() -> scroll.fullScroll(View.FOCUS_DOWN));
    }
}
